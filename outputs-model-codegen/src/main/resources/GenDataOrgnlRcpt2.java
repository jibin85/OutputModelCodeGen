public class GenDataOrgnlRcpt2 extends OutputSegment implements FixedLengthFormat
{
private String ceOrig2CustRef;
private String ceOrig2Title;
private String ceOrig2Init;
private String ceOrig2Fornm;
private String ceOrig2Surnm;
private String ceOrig2Honor;
private String neOrig2SlltnCode;
private String ceOrig2Role;
private Character ceOrig2Sex;
private String deOrig2BirthDate;
private Character ceOrig2CorpInd;
private String ceOrig2Addr1;
private String ceOrig2Addr2;
private String ceOrig2Addr3;
private String ceOrig2Addr4;
private String ceOrig2Addr5;
private String ceOrig2EmailAddr;
private String ceOrig2FaxNo;
private String ceOrig2EmailAddr;

@Override
public String toFixedLength() {
return new StringBuilder()
.append(String.format(STRING_FORMATE_OF_LENGTH_TEN, Objects.toString(ceOrig2CustRef, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TEN, Objects.toString(ceOrig2Title, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIVE, Objects.toString(ceOrig2Init, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTY, Objects.toString(ceOrig2Fornm, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THIRTY, Objects.toString(ceOrig2Surnm, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_SIX, Objects.toString(ceOrig2Honor, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TWO, Objects.toString(neOrig2SlltnCode, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THREE, Objects.toString(ceOrig2Role, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_ONE, Objects.toString(ceOrig2Sex, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_EIGHT, Objects.toString(deOrig2BirthDate, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_ONE, Objects.toString(ceOrig2CorpInd, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrig2Addr1, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrig2Addr2, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrig2Addr3, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrig2Addr4, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_null, Objects.toString(ceOrig2Addr5, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THIRTY, Objects.toString(ceOrig2EmailAddr, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTEEN, Objects.toString(ceOrig2FaxNo, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THIRTY_WITHOUT_SEMI, Objects.toString(ceOrig2EmailAddr, EMPTY_STRING)))
.append("@@").toString();
}
}