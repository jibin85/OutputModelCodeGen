public class GenDataOrgnlRcpt extends OutputSegment implements FixedLengthFormat
{
private String ceOrgnlCustRef;
private String ceOrgnlTitle;
private String ceOrgnlInit;
private String ceOrgnlFornm;
private String ceOrgnlSurnm;
private String ceOrgnlHonor;
private String neOrgnlSlltnCode;
private String ceOrgnlRole;
private Character ceOrgnlSex;
private String deOrgnlBirthDate;
private Character ceOrgnlCorpInd;
private String ceOrgnlAddr1;
private String ceOrgnlAddr2;
private String ceOrgnlAddr3;
private String ceOrgnlAddr4;
private String ceOrgnlAddr5;
private String ceOrgnlEmailAddr;
private String ceOrgnlFaxNo;
private String ceOrgnlEmailAddr;

@Override
public String toFixedLength() {
return new StringBuilder()
.append(String.format(STRING_FORMATE_OF_LENGTH_TEN, Objects.toString(ceOrgnlCustRef, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TEN, Objects.toString(ceOrgnlTitle, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIVE, Objects.toString(ceOrgnlInit, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTY, Objects.toString(ceOrgnlFornm, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THIRTY, Objects.toString(ceOrgnlSurnm, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_SIX, Objects.toString(ceOrgnlHonor, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TWO, Objects.toString(neOrgnlSlltnCode, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THREE, Objects.toString(ceOrgnlRole, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_ONE, Objects.toString(ceOrgnlSex, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_EIGHT, Objects.toString(deOrgnlBirthDate, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_ONE, Objects.toString(ceOrgnlCorpInd, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrgnlAddr1, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrgnlAddr2, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrgnlAddr3, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrgnlAddr4, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrgnlAddr5, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THIRTY, Objects.toString(ceOrgnlEmailAddr, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTEEN, Objects.toString(ceOrgnlFaxNo, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THIRTY_WITHOUT_SEMI, Objects.toString(ceOrgnlEmailAddr, EMPTY_STRING)))
.append("@@").toString();
}
}