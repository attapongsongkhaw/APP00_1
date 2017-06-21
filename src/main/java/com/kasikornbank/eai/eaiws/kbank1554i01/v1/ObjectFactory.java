
package com.kasikornbank.eai.eaiws.kbank1554i01.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kasikornbank.eai.eaiws.kbank1554i01.v1 package. 
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

    private final static QName _DoService_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "doService");
    private final static QName _DoServiceResponse_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "doServiceResponse");
    private final static QName _DoServiceResponseKBANK1554I01ResponseCVRSInfoRegulsObjRegulsVectCVRSRegulationSubTypCode_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "subTypCode");
    private final static QName _DoServiceResponseKBANK1554I01ResponseCVRSInfoRegulsObjRegulsVectCVRSRegulationTypCode_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "typCode");
    private final static QName _DoServiceResponseKBANK1554I01ResponseKBankHeaderCorrID_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "corrID");
    private final static QName _DoServiceResponseKBANK1554I01ResponseKBankHeaderReqAuthLevel_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "reqAuthLevel");
    private final static QName _DoServiceResponseKBANK1554I01ResponseKBankHeaderReqAuthUserId_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "reqAuthUserId");
    private final static QName _DoServiceKBANK1554I01KBankHeaderUserLangPref_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "userLangPref");
    private final static QName _DoServiceKBANK1554I01KBankHeaderAuthUserId_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "authUserId");
    private final static QName _DoServiceKBANK1554I01KBankHeaderAuthLevel_QNAME = new QName("http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", "authLevel");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kasikornbank.eai.eaiws.kbank1554i01.v1
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
     * Create an instance of {@link DoServiceResponse.KBANK1554I01Response }
     * 
     */
    public DoServiceResponse.KBANK1554I01Response createDoServiceResponseKBANK1554I01Response() {
        return new DoServiceResponse.KBANK1554I01Response();
    }

    /**
     * Create an instance of {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo }
     * 
     */
    public DoServiceResponse.KBANK1554I01Response.CVRSInfo createDoServiceResponseKBANK1554I01ResponseCVRSInfo() {
        return new DoServiceResponse.KBANK1554I01Response.CVRSInfo();
    }

    /**
     * Create an instance of {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj }
     * 
     */
    public DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj createDoServiceResponseKBANK1554I01ResponseCVRSInfoRegulsObj() {
        return new DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj();
    }

    /**
     * Create an instance of {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect }
     * 
     */
    public DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect createDoServiceResponseKBANK1554I01ResponseCVRSInfoRegulsObjRegulsVect() {
        return new DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect();
    }

    /**
     * Create an instance of {@link DoServiceResponse.KBANK1554I01Response.KBankHeader }
     * 
     */
    public DoServiceResponse.KBANK1554I01Response.KBankHeader createDoServiceResponseKBANK1554I01ResponseKBankHeader() {
        return new DoServiceResponse.KBANK1554I01Response.KBankHeader();
    }

    /**
     * Create an instance of {@link DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect }
     * 
     */
    public DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect createDoServiceResponseKBANK1554I01ResponseKBankHeaderErrorVect() {
        return new DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect();
    }

    /**
     * Create an instance of {@link DoService }
     * 
     */
    public DoService createDoService() {
        return new DoService();
    }

    /**
     * Create an instance of {@link DoService.KBANK1554I01 }
     * 
     */
    public DoService.KBANK1554I01 createDoServiceKBANK1554I01() {
        return new DoService.KBANK1554I01();
    }

    /**
     * Create an instance of {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation }
     * 
     */
    public DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation createDoServiceResponseKBANK1554I01ResponseCVRSInfoRegulsObjRegulsVectCVRSRegulation() {
        return new DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation();
    }

    /**
     * Create an instance of {@link DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect.Error }
     * 
     */
    public DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect.Error createDoServiceResponseKBANK1554I01ResponseKBankHeaderErrorVectError() {
        return new DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect.Error();
    }

    /**
     * Create an instance of {@link DoService.KBANK1554I01 .KBankHeader }
     * 
     */
    public DoService.KBANK1554I01 .KBankHeader createDoServiceKBANK1554I01KBankHeader() {
        return new DoService.KBANK1554I01 .KBankHeader();
    }

    /**
     * Create an instance of {@link DoService.KBANK1554I01 .CISAccount }
     * 
     */
    public DoService.KBANK1554I01 .CISAccount createDoServiceKBANK1554I01CISAccount() {
        return new DoService.KBANK1554I01 .CISAccount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "doService")
    public JAXBElement<DoService> createDoService(DoService value) {
        return new JAXBElement<DoService>(_DoService_QNAME, DoService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "doServiceResponse")
    public JAXBElement<DoServiceResponse> createDoServiceResponse(DoServiceResponse value) {
        return new JAXBElement<DoServiceResponse>(_DoServiceResponse_QNAME, DoServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "subTypCode", scope = DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation.class)
    public JAXBElement<String> createDoServiceResponseKBANK1554I01ResponseCVRSInfoRegulsObjRegulsVectCVRSRegulationSubTypCode(String value) {
        return new JAXBElement<String>(_DoServiceResponseKBANK1554I01ResponseCVRSInfoRegulsObjRegulsVectCVRSRegulationSubTypCode_QNAME, String.class, DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "typCode", scope = DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation.class)
    public JAXBElement<String> createDoServiceResponseKBANK1554I01ResponseCVRSInfoRegulsObjRegulsVectCVRSRegulationTypCode(String value) {
        return new JAXBElement<String>(_DoServiceResponseKBANK1554I01ResponseCVRSInfoRegulsObjRegulsVectCVRSRegulationTypCode_QNAME, String.class, DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "corrID", scope = DoServiceResponse.KBANK1554I01Response.KBankHeader.class)
    public JAXBElement<String> createDoServiceResponseKBANK1554I01ResponseKBankHeaderCorrID(String value) {
        return new JAXBElement<String>(_DoServiceResponseKBANK1554I01ResponseKBankHeaderCorrID_QNAME, String.class, DoServiceResponse.KBANK1554I01Response.KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "reqAuthLevel", scope = DoServiceResponse.KBANK1554I01Response.KBankHeader.class)
    public JAXBElement<Integer> createDoServiceResponseKBANK1554I01ResponseKBankHeaderReqAuthLevel(Integer value) {
        return new JAXBElement<Integer>(_DoServiceResponseKBANK1554I01ResponseKBankHeaderReqAuthLevel_QNAME, Integer.class, DoServiceResponse.KBANK1554I01Response.KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "reqAuthUserId", scope = DoServiceResponse.KBANK1554I01Response.KBankHeader.class)
    public JAXBElement<String> createDoServiceResponseKBANK1554I01ResponseKBankHeaderReqAuthUserId(String value) {
        return new JAXBElement<String>(_DoServiceResponseKBANK1554I01ResponseKBankHeaderReqAuthUserId_QNAME, String.class, DoServiceResponse.KBANK1554I01Response.KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "userLangPref", scope = DoService.KBANK1554I01 .KBankHeader.class)
    public JAXBElement<String> createDoServiceKBANK1554I01KBankHeaderUserLangPref(String value) {
        return new JAXBElement<String>(_DoServiceKBANK1554I01KBankHeaderUserLangPref_QNAME, String.class, DoService.KBANK1554I01 .KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "corrID", scope = DoService.KBANK1554I01 .KBankHeader.class)
    public JAXBElement<String> createDoServiceKBANK1554I01KBankHeaderCorrID(String value) {
        return new JAXBElement<String>(_DoServiceResponseKBANK1554I01ResponseKBankHeaderCorrID_QNAME, String.class, DoService.KBANK1554I01 .KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "authUserId", scope = DoService.KBANK1554I01 .KBankHeader.class)
    public JAXBElement<String> createDoServiceKBANK1554I01KBankHeaderAuthUserId(String value) {
        return new JAXBElement<String>(_DoServiceKBANK1554I01KBankHeaderAuthUserId_QNAME, String.class, DoService.KBANK1554I01 .KBankHeader.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", name = "authLevel", scope = DoService.KBANK1554I01 .KBankHeader.class)
    public JAXBElement<Integer> createDoServiceKBANK1554I01KBankHeaderAuthLevel(Integer value) {
        return new JAXBElement<Integer>(_DoServiceKBANK1554I01KBankHeaderAuthLevel_QNAME, Integer.class, DoService.KBANK1554I01 .KBankHeader.class, value);
    }

}
