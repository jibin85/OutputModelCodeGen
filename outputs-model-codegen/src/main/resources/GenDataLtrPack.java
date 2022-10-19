public class GenDataLtrPack extends OutputSegment implements FixedLengthFormat
{
private String neDeptCode;
private String neSigTypeCode;
private String ceYourRef;
private String ceOurRef;
private String ceCoUserId;
private String ceCoInit;
private String ceCoFornm;
private String ceCoSurnm;
private String ceCoTitle;
private Character ceCoSex;
private String ceBrchMnmc;
private String ceBrchRef;
private String deLtrDate;
private String cePolNo;
private String ceWopPolNo;
private String neProdVersnNo;
private Character leTrustFlag;
private String ceProdCat;
private String ceBnrText1;
private String ceBnrText2;
private String cePrintUnq;
private String ceSchmeRef;
private String cePrintUnq;

@Override
public String toFixedLength() {
return new StringBuilder()
.append(String.format(STRING_FORMATE_OF_LENGTH_THREE, Objects.toString(neDeptCode, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THREE, Objects.toString(neSigTypeCode, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTEEN, Objects.toString(ceYourRef, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTEEN, Objects.toString(ceOurRef, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TEN, Objects.toString(ceCoUserId, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIVE, Objects.toString(ceCoInit, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTY, Objects.toString(ceCoFornm, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THIRTY, Objects.toString(ceCoSurnm, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TEN, Objects.toString(ceCoTitle, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_ONE, Objects.toString(ceCoSex, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THREE, Objects.toString(ceBrchMnmc, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TEN, Objects.toString(ceBrchRef, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_EIGHT, Objects.toString(deLtrDate, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTEEN, Objects.toString(cePolNo, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTEEN, Objects.toString(ceWopPolNo, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_THREE, Objects.toString(neProdVersnNo, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_ONE, Objects.toString(leTrustFlag, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTY, Objects.toString(ceProdCat, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTY, Objects.toString(ceBnrText1, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_FIFTY, Objects.toString(ceBnrText2, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TWELVE, Objects.toString(cePrintUnq, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TWENTY, Objects.toString(ceSchmeRef, EMPTY_STRING)))
.append(String.format(STRING_FORMATE_OF_LENGTH_TWELVE_WITHOUT_SEMI, Objects.toString(cePrintUnq, EMPTY_STRING)))
.append("@@").toString();
}
}