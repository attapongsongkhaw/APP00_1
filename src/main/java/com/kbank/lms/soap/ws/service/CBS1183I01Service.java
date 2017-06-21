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

import com.kbank.lms.common.AppProperties;
import com.kbank.lms.utils.AppUtils;
import com.kbank.lms.utils.Constants;

public class CBS1183I01Service extends WebServiceGatewaySupport {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+07:00");
	private static final Logger logger = Logger.getLogger(CBS1183I01Service.class);
	
	@Autowired
	AppProperties config;
	
	public com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoServiceResponse.CBS1183I01Response getServiceCBS1183I01(String accountNo) {
		com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoServiceResponse.CBS1183I01Response  _doService_CBS1183I01_return = null;
		try {
	        com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01 _doService_cbs1183I01 = new com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01();
	        com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01.KBankHeader _doService_cbs1183I01KBankHeader = new com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01.KBankHeader();
	        _doService_cbs1183I01KBankHeader.setFuncNm("CBS1183I01");
	        _doService_cbs1183I01KBankHeader.setRqUID(AppUtils.genUniqueRequestId());
	        _doService_cbs1183I01KBankHeader.setRqDt(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFormat.format(new Date().getTime())));
	        _doService_cbs1183I01KBankHeader.setRqAppId(Constants.RQ_APP_ID); 
	        _doService_cbs1183I01KBankHeader.setUserId(Constants.USER_APP_ID);
	        _doService_cbs1183I01KBankHeader.setTerminalId(Constants.TERMINAL_ID);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cbs1183I01KBankHeaderUserLangPref = null;
	        _doService_cbs1183I01KBankHeader.setUserLangPref(_doService_cbs1183I01KBankHeaderUserLangPref);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cbs1183I01KBankHeaderCorrID = null;
	        _doService_cbs1183I01KBankHeader.setCorrID(_doService_cbs1183I01KBankHeaderCorrID);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cbs1183I01KBankHeaderAuthUserId = null;
	        _doService_cbs1183I01KBankHeader.setAuthUserId(_doService_cbs1183I01KBankHeaderAuthUserId);
	        javax.xml.bind.JAXBElement<java.lang.Integer> _doService_cbs1183I01KBankHeaderAuthLevel = null;
	        _doService_cbs1183I01KBankHeader.setAuthLevel(_doService_cbs1183I01KBankHeaderAuthLevel);
	        _doService_cbs1183I01.setKBankHeader(_doService_cbs1183I01KBankHeader);
	        com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01.CBSAccount _doService_cbs1183I01CBSAccount = new com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01.CBSAccount();
	        _doService_cbs1183I01CBSAccount.setAcctId(accountNo);
	        _doService_cbs1183I01.setCBSAccount(_doService_cbs1183I01CBSAccount);
	        logger.debug("RQ_doService_cbs1183I01 : " + soapCBS1183I01RQ(_doService_cbs1183I01));
	        
	        _doService_CBS1183I01_return =  (com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoServiceResponse.CBS1183I01Response) getWebServiceTemplate().marshalSendAndReceive(config.getCbsUrl(), _doService_cbs1183I01);
	
	        JAXBContext jaxbContext = JAXBContext.newInstance(com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoServiceResponse.CBS1183I01Response.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
	        QName qName = new QName("com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoServiceResponse", "CBS1183I01");
	        JAXBElement<com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoServiceResponse.CBS1183I01Response> rootRSCBS1183I01 = new JAXBElement<>(qName, com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoServiceResponse.CBS1183I01Response.class, _doService_CBS1183I01_return);
	        StringWriter sw = new StringWriter();
	        jaxbMarshaller.marshal(rootRSCBS1183I01, sw);
	        logger.debug("RS_doService_cbs1183I01 : " + sw.toString());
		} catch(Exception e){
			logger.error(e);
		}
		return _doService_CBS1183I01_return;
	}
	
	public static String soapCBS1183I01RQ(com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01 request){
		
		String result = "";	
		try {
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage soapMsg = factory.createMessage();
			SOAPPart part = soapMsg.getSOAPPart();
	
			SOAPEnvelope envelope = part.getEnvelope();
			SOAPBody body = envelope.getBody();
			
			SOAPFactory soapFactory = SOAPFactory.newInstance();
			Name bodyName = soapFactory.createName("doService", null, com.kasikornbank.eai.eaiws.cbs1183i01.v2.CBS1183I01.SERVICE.getNamespaceURI());
			    
			SOAPBodyElement element = body.addBodyElement(bodyName);
			
		    SOAPElement CBS1183I01 = element.addChildElement(soapFactory.createName("CBS1183I01"));
		    SOAPElement headerRequest = CBS1183I01.addChildElement(soapFactory.createName("KBankHeader"));
		    
		    headerRequest.addChildElement(soapFactory.createName("funcNm")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getFuncNm()));
		    headerRequest.addChildElement(soapFactory.createName("rqUID")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getRqUID()));
		    headerRequest.addChildElement(soapFactory.createName("rqDt")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getRqDt()));
		    headerRequest.addChildElement(soapFactory.createName("rqAppId")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getRqAppId()));
		    headerRequest.addChildElement(soapFactory.createName("userId")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getUserId()));
		    headerRequest.addChildElement(soapFactory.createName("terminalId")).addTextNode(AppUtils.checkNull(request.getKBankHeader().getTerminalId()));
	
	
		    SOAPElement CBSAccount = CBS1183I01.addChildElement(soapFactory.createName("CBSAccount"));
		    CBSAccount.addChildElement(soapFactory.createName("AcctId")).addTextNode(AppUtils.checkNull(request.getCBSAccount().getAcctId()));
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			soapMsg.writeTo(baos);                     
			result = baos.toString();
		} catch(Exception e){
			logger.error(e);
		}
		return result;
	}  
}
