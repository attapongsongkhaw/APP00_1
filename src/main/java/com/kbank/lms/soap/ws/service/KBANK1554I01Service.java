package com.kbank.lms.soap.ws.service;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoServiceResponse.KBANK1554I01Response;
import com.kbank.lms.common.AppProperties;
import com.kbank.lms.utils.AppUtils;
import com.kbank.lms.utils.Constants;

public class KBANK1554I01Service extends WebServiceGatewaySupport {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+07:00");
	private static final Logger logger = Logger.getLogger(KBANK1554I01Service.class);

	@Autowired
	AppProperties config;
	
	public com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoServiceResponse.KBANK1554I01Response getServiceKBANK1554I01(String accountNo) {
		com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoServiceResponse.KBANK1554I01Response _doService_KBANK1554I01_return = null;
		try {
			com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoService.KBANK1554I01 _doService_kbank1554I01 = new com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoService.KBANK1554I01();
	        com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoService.KBANK1554I01.KBankHeader _doService_kbank1554I01KBankHeader = new com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoService.KBANK1554I01.KBankHeader();
	        _doService_kbank1554I01KBankHeader.setFuncNm("KBANK1554I01");
	        _doService_kbank1554I01KBankHeader.setRqUID(AppUtils.genUniqueRequestId());
	        _doService_kbank1554I01KBankHeader.setRqDt(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFormat.format(new Date().getTime())));
	        _doService_kbank1554I01KBankHeader.setRqAppId(Constants.RQ_APP_ID);
	        _doService_kbank1554I01KBankHeader.setUserId(Constants.USER_APP_ID);
	        _doService_kbank1554I01KBankHeader.setTerminalId(Constants.TERMINAL_ID);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_kbank1554I01KBankHeaderUserLangPref = null;
	        _doService_kbank1554I01KBankHeader.setUserLangPref(_doService_kbank1554I01KBankHeaderUserLangPref);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_kbank1554I01KBankHeaderCorrID = null;
	        _doService_kbank1554I01KBankHeader.setCorrID(_doService_kbank1554I01KBankHeaderCorrID);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_kbank1554I01KBankHeaderAuthUserId = null;
	        _doService_kbank1554I01KBankHeader.setAuthUserId(_doService_kbank1554I01KBankHeaderAuthUserId);
	        javax.xml.bind.JAXBElement<java.lang.Integer> _doService_kbank1554I01KBankHeaderAuthLevel = null;
	        _doService_kbank1554I01KBankHeader.setAuthLevel(_doService_kbank1554I01KBankHeaderAuthLevel);
	        _doService_kbank1554I01.setKBankHeader(_doService_kbank1554I01KBankHeader);
	        com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoService.KBANK1554I01.CISAccount _doService_kbank1554I01CISAccount = new com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoService.KBANK1554I01.CISAccount();
	        _doService_kbank1554I01CISAccount.setNum(accountNo);
	        _doService_kbank1554I01.setCISAccount(_doService_kbank1554I01CISAccount);
	        
	        logger.debug("RQ_doService_KBANK1554I01 : " + soapKBANK1554I01RQ(_doService_kbank1554I01));
	        
	        _doService_KBANK1554I01_return = (KBANK1554I01Response) getWebServiceTemplate().marshalSendAndReceive(config.getKbankUrl(), _doService_kbank1554I01);
	        
	        JAXBContext jaxbContext = JAXBContext.newInstance(com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoServiceResponse.KBANK1554I01Response.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
	        QName qName = new QName("com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoServiceResponse", "KBANK1554I01");
	        JAXBElement<com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoServiceResponse.KBANK1554I01Response> rootRRKBANK1554I01 = new JAXBElement<>(qName, com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoServiceResponse.KBANK1554I01Response.class, _doService_KBANK1554I01_return);
	        StringWriter sw = new StringWriter();
	        jaxbMarshaller.marshal(rootRRKBANK1554I01, sw);
	        logger.debug("RS_doService_KBANK1554I01 : " + sw.toString());
		} catch(Exception e){
			logger.error(e);
		}
		return _doService_KBANK1554I01_return;
	}
	
	public static String soapKBANK1554I01RQ(com.kasikornbank.eai.eaiws.kbank1554i01.v1.DoService.KBANK1554I01 request) {
		String result = "";
		try {
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage soapMsg = factory.createMessage();
			SOAPPart part = soapMsg.getSOAPPart();
	
			SOAPEnvelope envelope = part.getEnvelope();
			SOAPBody body = envelope.getBody();
			
			SOAPFactory soapFactory = SOAPFactory.newInstance();
			Name bodyName = soapFactory.createName("doService", null, com.kasikornbank.eai.eaiws.kbank1554i01.v1.KBANK1554I01.SERVICE.getNamespaceURI());
			    
			SOAPBodyElement element = body.addBodyElement(bodyName);
			
		    SOAPElement KBANK1554I01 = element.addChildElement(soapFactory.createName("KBANK1554I01"));
		    SOAPElement headerRequest = KBANK1554I01.addChildElement(soapFactory.createName("KBankHeader"));
		    
		    headerRequest.addChildElement(soapFactory.createName("funcNm")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getFuncNm()));
		    headerRequest.addChildElement(soapFactory.createName("rqUID")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getRqUID()));
		    headerRequest.addChildElement(soapFactory.createName("rqDt")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getRqDt()));
		    headerRequest.addChildElement(soapFactory.createName("rqAppId")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getRqAppId()));
		    headerRequest.addChildElement(soapFactory.createName("userId")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getUserId()));
		    headerRequest.addChildElement(soapFactory.createName("terminalId")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getTerminalId()));
		    headerRequest.addChildElement(soapFactory.createName("userLangPref")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getUserLangPref()));
		    headerRequest.addChildElement(soapFactory.createName("corrID")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getCorrID()));
		    headerRequest.addChildElement(soapFactory.createName("authUserId")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getAuthUserId()));
		    headerRequest.addChildElement(soapFactory.createName("authLevel")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getAuthLevel()));
	     
		    SOAPElement CISAccount = KBANK1554I01.addChildElement(soapFactory.createName("CISAccount"));
		    CISAccount.addChildElement(soapFactory.createName("num")).addTextNode(AppUtils.checkNull(request.getCISAccount().getNum()));
		    
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			soapMsg.writeTo(baos);                     
			result = baos.toString();
		} catch(Exception e){
			logger.error(e);
		}
		return result;
	}
}
