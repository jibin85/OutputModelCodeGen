package net.atos.aegoneb.rp.outputscodegen.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.text.CaseUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import net.atos.aegoneb.rp.outputscodegen.utils.CodeGenUtils;

@Service
public class CodegenService {
	
	private Path pathToJavaClass = null;
	private String toFixedLengthStartSection = "\n" + "@Override" + "\n" + "public String toFixedLength() {" + "\n" + "return new StringBuilder()" + "\n";
	private String toFixedLengthEndSection = ".append(\"@@\").toString();" + "\n" + "}" + "\n";
	private StringBuilder modelClass;
	private StringBuilder javaClassDeclareSection;
	private StringBuilder fieldsContentSection;
	private StringBuilder toFixedLengthContentSection;

	public void process() throws IOException 
	{
		String excelFilePath = "src\\main\\resources\\dataModels.xlsx";
		FileInputStream file = new FileInputStream(new File(excelFilePath));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet;

		for(int k = 0; k < workbook.getNumberOfSheets(); k++)
		{
			modelClass = new StringBuilder();
			javaClassDeclareSection = new StringBuilder();
			fieldsContentSection = new StringBuilder();
			toFixedLengthContentSection = new StringBuilder();

			sheet = workbook.getSheetAt(k);
			createClassDeclaration(sheet.getSheetName());
			System.out.println("total rows - " + sheet.getPhysicalNumberOfRows());
			int lastRowNum = 0;
			for(int i = 0; i < sheet.getPhysicalNumberOfRows() - 1; i++) 
			{
				Row row = sheet.getRow(i);
				System.out.println("row num - " + i);
				if(!(row.getCell(0).getStringCellValue().equals("EOF")))
				{
					lastRowNum = i-1;
					generateFields(row, false);
				}
				else
					break;
			}
			generateFields(sheet.getRow(lastRowNum), true);
			
			modelClass
			.append(javaClassDeclareSection)
			.append(fieldsContentSection)
			.append(toFixedLengthStartSection)
			.append(toFixedLengthContentSection)
			.append(toFixedLengthEndSection)
			.append("}");
			
			Files.write(pathToJavaClass, modelClass.toString().getBytes());
		}

		workbook.close();
	}

	private void createClassDeclaration(String modelClassName) 
	{
		System.out.println("class name - " + modelClassName);
		pathToJavaClass = Paths.get("src\\main\\resources" + "\\" + modelClassName + ".java");
		javaClassDeclareSection.append("public class ")
		.append(modelClassName)
		.append(" extends OutputSegment implements FixedLengthFormat")
		.append("\n")
		.append("{")
		.append("\n");
	}

	/*	passing 1 row at a time
		col 0 - field
		col 1 - length
		col 2 - datatype
		col 3 - xsd datatype
	 */
	private void generateFields(Row row, boolean isLastRow) 
	{
		String dataType;
		Integer fieldLength;
		String fieldName;

		Cell lastEmptyRow = row.getCell(0);
			Cell xsdDataTypeCol = row.getCell(3);
			if(xsdDataTypeCol.getStringCellValue().isEmpty())
			{
				if(row.getCell(1).getNumericCellValue() == 1)
				{
					fieldsContentSection.append("private Character ").append(toCamelCase(row.getCell(0))).append(";").append("\n");
					dataType = "String";
				}
				else
				{
					fieldsContentSection.append("private String ").append(toCamelCase(row.getCell(0))).append(";").append("\n");
					dataType = "String";
				}

			}
			else
			{
				if(row.getCell(1).getNumericCellValue() == 1)
				{
					fieldsContentSection.append("private Character ").append(toCamelCase(row.getCell(0))).append(";").append("\n");
					dataType = "String";
				}
				else
				{
					dataType = row.getCell(3).getStringCellValue().equals("Decimal") ? "BigDecimal" : row.getCell(3).getStringCellValue();
					fieldsContentSection.append("private ").append(dataType).append(" ").append(toCamelCase(row.getCell(0))).append(";").append("\n");
				}
			}

			fieldLength = (int) row.getCell(1).getNumericCellValue();
			fieldName = toCamelCase(row.getCell(0));
			System.out.println("fieldName - " + fieldName);
			generateToFixedLengthContent(dataType, fieldLength, dataType, fieldName, isLastRow);
	}

	//convert field name from XX-YY or XX_YY to xxYy 
	private String toCamelCase(Cell cell) 
	{
		return CaseUtils.toCamelCase(cell.getStringCellValue(), false, new char[]{'-','_'});
	}

	private void generateToFixedLengthContent(String dataType, Integer fieldLength, String parser, String fieldName, boolean isLastRow) 
	{
		String dataTypeText = CodeGenUtils.getDataTypeText(dataType);
		String fieldLengthText = CodeGenUtils.getFieldLengthText(fieldLength);
		fieldLengthText = isLastRow ? fieldLengthText.concat("_WITHOUT_SEMI") : fieldLengthText;
		String parserText = CodeGenUtils.getParserText(parser);
		String defaultValue = CodeGenUtils.getDefaultValue(dataType);
		String closingParentheses = dataType.equals("String") ? ")))" : "))))";
		if(dataType.equals("Date"))
		{
			toFixedLengthContentSection.append(".append(Objects.isNull(")
			.append(fieldName)
			.append(") ? ")
			.append("String.format(")
			.append(dataTypeText)
			.append(fieldLengthText)
			.append(", ")
			.append(defaultValue)
			.append(") : ")
			.append("String.format(STRING_FORMATE_OF_LENGTH_DATE, ")
			.append(fieldName).append(", ")
			.append(fieldName).append(", ")
			.append(fieldName).append("))")
			.append("\n");
		}
		else
		{
			toFixedLengthContentSection.append(".append(String.format(")
			.append(dataTypeText)
			.append(fieldLengthText)
			.append(", ")
			.append(parserText)
			.append(fieldName)
			.append(", ")
			.append(defaultValue)
			.append(closingParentheses)
			.append("\n");
		}

	}

}
