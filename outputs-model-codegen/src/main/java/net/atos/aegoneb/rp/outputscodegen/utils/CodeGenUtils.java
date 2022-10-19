package net.atos.aegoneb.rp.outputscodegen.utils;

import java.util.HashMap;
import java.util.Map;

public class CodeGenUtils {
	
	private static Map<String, String> dataTypeTextMap = new HashMap<>();
	private static Map<Integer, String> fieldLengthTextMap = new HashMap<>();
	private static Map<String, String> parserTextMap = new HashMap<>();
	private static Map<String, String> defaultValueMap = new HashMap<>();
	
	static 
	{
		dataTypeTextMap.put("Long", "LONG_FORMATE_OF_LENGTH_");
		dataTypeTextMap.put("String", "STRING_FORMATE_OF_LENGTH_");
		dataTypeTextMap.put("BigDecimal", "DECIMAL_FORMATE_WITH_SPACE_OF_LENGTH_");
		dataTypeTextMap.put("Date", "STRING_FORMATE_OF_LENGTH_");
		
		fieldLengthTextMap.put(1, "ONE");
		fieldLengthTextMap.put(2, "TWO");
		fieldLengthTextMap.put(3, "THREE");
		fieldLengthTextMap.put(4, "FOUR");
		fieldLengthTextMap.put(5, "FIVE");
		fieldLengthTextMap.put(6, "SIX");
		fieldLengthTextMap.put(7, "SEVEN");
		fieldLengthTextMap.put(8, "EIGHT");
		fieldLengthTextMap.put(9, "NINE");
		fieldLengthTextMap.put(10, "TEN");
		fieldLengthTextMap.put(12, "TWELVE");
		fieldLengthTextMap.put(14, "FOURTEEN");
		fieldLengthTextMap.put(15, "FIFTEEN");
		fieldLengthTextMap.put(20, "TWENTY");
		fieldLengthTextMap.put(30, "THIRTY");
		fieldLengthTextMap.put(50, "FIFTY");
		
		parserTextMap.put("Long", "Long.valueOf(Objects.toString(");
		parserTextMap.put("String", "Objects.toString(");
		parserTextMap.put("BigDecimal", "Float.parseFloat(Objects.toString(");
		
		defaultValueMap.put("Long", "A_ZERO");
		defaultValueMap.put("String", "EMPTY_STRING");
		defaultValueMap.put("BigDecimal", "A_DECIMAL_ZERO");
		defaultValueMap.put("Date", "EMPTY_STRING");
	}

	public static String getDataTypeText(String dataFormat)
	{
		return dataTypeTextMap.get(dataFormat);
	}
	
	public static String getFieldLengthText(Integer fieldLength)
	{
		return fieldLengthTextMap.get(fieldLength);
	}
	
	public static String getParserText(String parser)
	{
		return parserTextMap.get(parser);
	}

	public static String getDefaultValue(String dataType) 
	{
		return defaultValueMap.get(dataType);
	}
	
}
