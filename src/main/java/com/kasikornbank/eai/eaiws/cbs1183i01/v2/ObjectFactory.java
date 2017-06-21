
package com.kasikornbank.eai.eaiws.cbs1183i01.v2;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kasikornbank.eai.eaiws.cbs1183i01.v2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DoService_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "doService");
    private final static QName _DoServiceResponse_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "doServiceResponse");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountAccrueIntAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "AccrueIntAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountAcctBal_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "AcctBal");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountAcctNameEn_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "AcctNameEn");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountApparentPassbkBal_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "ApparentPassbkBal");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountAvailBal_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "AvailBal");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountAvailENCLimitAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "AvailENCLimitAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountAvailIntradayLimitAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "AvailIntradayLimitAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountAvailLimitAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "AvailLimitAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountAvailODLimitAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "AvailODLimitAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountClearingAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "ClearingAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountClosedDt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "ClosedDt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountENCLimitAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "ENCLimitAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountENCLimitUsed_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "ENCLimitUsed");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountHoldAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "HoldAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountIntradayLimitAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "IntradayLimitAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountIntradayLimitUsed_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "IntradayLimitUsed");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountLastFincDt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "LastFincDt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountLimitAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "LimitAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountLimitUsed_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "LimitUsed");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountSrcSystemFlg_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "SrcSystemFlg");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountODLimitAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "ODLimitAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountODLimitUsed_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "ODLimitUsed");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountRefAcctBal_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "RefAcctBal");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountRefAcctId_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "RefAcctId");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountRefBranchId_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "RefBranchId");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountRefBranchName_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "RefBranchName");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountRefProductCode_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "RefProductCode");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountRefProductDesc_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "RefProductDesc");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountRetentionAmt_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "RetentionAmt");
    private final static QName _DoServiceResponseCBS1183I01ResponseCBSAccountTCBTariffName_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "TCBTariffName");
    private final static QName _DoServiceResponseCBS1183I01ResponseKBankHeaderCorrID_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "corrID");
    private final static QName _DoServiceCBS1183I01KBankHeaderUserLangPref_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "userLangPref");
    private final static QName _DoServiceCBS1183I01KBankHeaderAuthUserId_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "authUserId");
    private final static QName _DoServiceCBS1183I01KBankHeaderAuthLevel_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "authLevel");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kasikornbank.eai.eaiws.cbs1183i01.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DoServiceResponse }
     * 
     */
    public DoServiceResponse createDoServiceResponse() {
        return new DoServiceResponse();
    }

    /**
     * Create an instance of {@link DoServiceResponse.CBS1183I01Response }
     * 
     */
    public DoServiceResponse.CBS1183I01Response createDoServiceResponseCBS1183I01Response() {
        return new DoServiceResponse.CBS1183I01Response();
    }

    /**
     * Create an instance of {@link DoServiceResponse.CBS1183I01Response.KBankHeader }
     * 
     */
    public DoServiceResponse.CBS1183I01Response.KBankHeader createDoServiceResponseCBS1183I01ResponseKBankHeader() {
        return new DoServiceResponse.CBS1183I01Response.KBankHeader();
    }

    /**
     * Create an instance of {@link DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect }
     * 
     */
    public DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect createDoServiceResponseCBS1183I01ResponseKBankHeaderErrorVect() {
        return new DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect();
    }

    /**
     * Create an instance of {@link DoService }
     * 
     */
    public DoService createDoService() {
        return new DoService();
    }

    /**
     * Create an instance of {@link DoService.CBS1183I01 }
     * 
     */
    public DoService.CBS1183I01 createDoServiceCBS1183I01() {
        return new DoService.CBS1183I01();
    }

    /**
     * Create an instance of {@link DoServiceResponse.CBS1183I01Response.CBSAccount }
     * 
     */
    public DoServiceResponse.CBS1183I01Response.CBSAccount createDoServiceResponseCBS1183I01ResponseCBSAccount() {
        return new DoServiceResponse.CBS1183I01Response.CBSAccount();
    }

    /**
     * Create an instance of {@link DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect.Error }
     * 
     */
    public DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect.Error createDoServiceResponseCBS1183I01ResponseKBankHeaderErrorVectError() {
        return new DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect.Error();
    }

    /**
     * Create an instance of {@link DoService.CBS1183I01 .KBankHeader }
     * 
     */
    public DoService.CBS1183I01 .KBankHeader createDoServiceCBS1183I01KBankHeader() {
        return new DoService.CBS1183I01 .KBankHeader();
    }

    /**
     * Create an instance of {@link DoService.CBS1183I01 .CBSAccount }
     * 
     */
    public DoService.CBS1183I01 .CBSAccount createDoServiceCBS1183I01CBSAccount() {
        return new DoService.CBS1183I01 .CBSAccount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "doService")
    public JAXBElement<DoService> createDoService(DoService value) {
        return new JAXBElement<DoService>(_DoService_QNAME, DoService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "doServiceResponse")
    public JAXBElement<DoServiceResponse> createDoServiceResponse(DoServiceResponse value) {
        return new JAXBElement<DoServiceResponse>(_DoServiceResponse_QNAME, DoServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "AccrueIntAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountAccrueIntAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountAccrueIntAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "AcctBal", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountAcctBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountAcctBal_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "AcctNameEn", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<String> createDoServiceResponseCBS1183I01ResponseCBSAccountAcctNameEn(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseCBSAccountAcctNameEn_QNAME, String.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "ApparentPassbkBal", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountApparentPassbkBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountApparentPassbkBal_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "AvailBal", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountAvailBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountAvailBal_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "AvailENCLimitAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountAvailENCLimitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountAvailENCLimitAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "AvailIntradayLimitAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountAvailIntradayLimitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountAvailIntradayLimitAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "AvailLimitAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountAvailLimitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountAvailLimitAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "AvailODLimitAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountAvailODLimitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountAvailODLimitAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "ClearingAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountClearingAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountClearingAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "ClosedDt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<XMLGregorianCalendar> createDoServiceResponseCBS1183I01ResponseCBSAccountClosedDt(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DoServiceResponseCBS1183I01ResponseCBSAccountClosedDt_QNAME, XMLGregorianCalendar.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "ENCLimitAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountENCLimitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountENCLimitAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "ENCLimitUsed", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountENCLimitUsed(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountENCLimitUsed_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "HoldAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountHoldAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountHoldAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "IntradayLimitAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountIntradayLimitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountIntradayLimitAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "IntradayLimitUsed", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountIntradayLimitUsed(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountIntradayLimitUsed_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "LastFincDt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<XMLGregorianCalendar> createDoServiceResponseCBS1183I01ResponseCBSAccountLastFincDt(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DoServiceResponseCBS1183I01ResponseCBSAccountLastFincDt_QNAME, XMLGregorianCalendar.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "LimitAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountLimitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountLimitAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "LimitUsed", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountLimitUsed(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountLimitUsed_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "SrcSystemFlg", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<String> createDoServiceResponseCBS1183I01ResponseCBSAccountSrcSystemFlg(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseCBSAccountSrcSystemFlg_QNAME, String.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }
    
    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "ODLimitAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountODLimitAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountODLimitAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "ODLimitUsed", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountODLimitUsed(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountODLimitUsed_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "RefAcctBal", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountRefAcctBal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountRefAcctBal_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "RefAcctId", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<String> createDoServiceResponseCBS1183I01ResponseCBSAccountRefAcctId(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseCBSAccountRefAcctId_QNAME, String.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "RefBranchId", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<String> createDoServiceResponseCBS1183I01ResponseCBSAccountRefBranchId(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseCBSAccountRefBranchId_QNAME, String.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "RefBranchName", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<String> createDoServiceResponseCBS1183I01ResponseCBSAccountRefBranchName(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseCBSAccountRefBranchName_QNAME, String.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "RefProductCode", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<String> createDoServiceResponseCBS1183I01ResponseCBSAccountRefProductCode(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseCBSAccountRefProductCode_QNAME, String.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "RefProductDesc", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<String> createDoServiceResponseCBS1183I01ResponseCBSAccountRefProductDesc(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseCBSAccountRefProductDesc_QNAME, String.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "RetentionAmt", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<BigDecimal> createDoServiceResponseCBS1183I01ResponseCBSAccountRetentionAmt(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DoServiceResponseCBS1183I01ResponseCBSAccountRetentionAmt_QNAME, BigDecimal.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "TCBTariffName", scope = DoServiceResponse.CBS1183I01Response.CBSAccount.class)
    public JAXBElement<String> createDoServiceResponseCBS1183I01ResponseCBSAccountTCBTariffName(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseCBSAccountTCBTariffName_QNAME, String.class, DoServiceResponse.CBS1183I01Response.CBSAccount.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "corrID", scope = DoServiceResponse.CBS1183I01Response.KBankHeader.class)
    public JAXBElement<String> createDoServiceResponseCBS1183I01ResponseKBankHeaderCorrID(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseKBankHeaderCorrID_QNAME, String.class, DoServiceResponse.CBS1183I01Response.KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "userLangPref", scope = DoService.CBS1183I01 .KBankHeader.class)
    public JAXBElement<String> createDoServiceCBS1183I01KBankHeaderUserLangPref(String value) {
        return new JAXBElement<String>(_DoServiceCBS1183I01KBankHeaderUserLangPref_QNAME, String.class, DoService.CBS1183I01 .KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "corrID", scope = DoService.CBS1183I01 .KBankHeader.class)
    public JAXBElement<String> createDoServiceCBS1183I01KBankHeaderCorrID(String value) {
        return new JAXBElement<String>(_DoServiceResponseCBS1183I01ResponseKBankHeaderCorrID_QNAME, String.class, DoService.CBS1183I01 .KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "authUserId", scope = DoService.CBS1183I01 .KBankHeader.class)
    public JAXBElement<String> createDoServiceCBS1183I01KBankHeaderAuthUserId(String value) {
        return new JAXBElement<String>(_DoServiceCBS1183I01KBankHeaderAuthUserId_QNAME, String.class, DoService.CBS1183I01 .KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", name = "authLevel", scope = DoService.CBS1183I01 .KBankHeader.class)
    public JAXBElement<Integer> createDoServiceCBS1183I01KBankHeaderAuthLevel(Integer value) {
        return new JAXBElement<Integer>(_DoServiceCBS1183I01KBankHeaderAuthLevel_QNAME, Integer.class, DoService.CBS1183I01 .KBankHeader.class, value);
    }

}
