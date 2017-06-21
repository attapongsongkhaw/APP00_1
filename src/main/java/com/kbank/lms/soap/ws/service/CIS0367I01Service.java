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
import com.kasikornbank.eai.eaiws.cis0367i01.v9.DoServiceResponse.CIS0367I01Response;
import com.kbank.lms.common.AppProperties;
import com.kbank.lms.utils.AppUtils;
import com.kbank.lms.utils.Constants;

public class CIS0367I01Service extends WebServiceGatewaySupport {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+07:00");
	private static final Logger logger = Logger.getLogger(CIS0367I01Service.class);
	
	@Autowired
	AppProperties config;
	
	public com.kasikornbank.eai.eaiws.cis0367i01.v9.DoServiceResponse.CIS0367I01Response getServiceCIS0367I01(String accountNo) {
		
		com.kasikornbank.eai.eaiws.cis0367i01.v9.DoServiceResponse.CIS0367I01Response _doService_cis0367I01_return = null;
        try {
        	com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01 _doService_cis0367I01 = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01();
        	com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.EAIHeader _doService_cis0367I01EAIHeader = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.EAIHeader();
	        _doService_cis0367I01EAIHeader.setServiceId("CIS0367I01");
	        _doService_cis0367I01EAIHeader.setBeginTimestamp(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFormat.format(new Date().getTime())));
	        javax.xml.bind.JAXBElement<javax.xml.datatype.XMLGregorianCalendar> _doService_cis0367I01EAIHeaderEndTimestamp = null;
	        _doService_cis0367I01EAIHeader.setEndTimestamp(_doService_cis0367I01EAIHeaderEndTimestamp);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01EAIHeaderTransactionId = null;
	        _doService_cis0367I01EAIHeader.setTransactionId(_doService_cis0367I01EAIHeaderTransactionId);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01EAIHeaderSourceTransactionId = null;
	        _doService_cis0367I01EAIHeader.setSourceTransactionId(_doService_cis0367I01EAIHeaderSourceTransactionId);
	        _doService_cis0367I01EAIHeader.setSourceSystem(Constants.SOURCE_SYSTEM);
	        QName qName = new QName("com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService", "CIS0367I01");
	        JAXBElement<String> fooValue = new JAXBElement<String>(qName, String.class, Constants.USER_APP_ID);
	        _doService_cis0367I01EAIHeader.setUserId(fooValue);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01EAIHeaderPassword = null;
	        _doService_cis0367I01EAIHeader.setPassword(_doService_cis0367I01EAIHeaderPassword);
	        javax.xml.bind.JAXBElement<java.lang.Integer> _doService_cis0367I01EAIHeaderStatus = null;
	        _doService_cis0367I01EAIHeader.setStatus(_doService_cis0367I01EAIHeaderStatus);
	        javax.xml.bind.JAXBElement<java.lang.Integer> _doService_cis0367I01EAIHeaderReasonCode = null;
	        _doService_cis0367I01EAIHeader.setReasonCode(_doService_cis0367I01EAIHeaderReasonCode);
	        _doService_cis0367I01.setEAIHeader(_doService_cis0367I01EAIHeader);
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer _doService_cis0367I01CISCustomer = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer();
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.AcctsObj _doService_cis0367I01CISCustomerAcctsObj = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.AcctsObj();
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.AcctsObj.AcctsVect _doService_cis0367I01CISCustomerAcctsObjAcctsVect = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.AcctsObj.AcctsVect();
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.AcctsObj.AcctsVect.CISAccount _doService_cis0367I01CISCustomerAcctsObjAcctsVectCISAccount = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.AcctsObj.AcctsVect.CISAccount();
	        _doService_cis0367I01CISCustomerAcctsObjAcctsVectCISAccount.setNum(accountNo);
	        _doService_cis0367I01CISCustomerAcctsObjAcctsVect.setCISAccount(_doService_cis0367I01CISCustomerAcctsObjAcctsVectCISAccount);
	        _doService_cis0367I01CISCustomerAcctsObj.setAcctsVect(_doService_cis0367I01CISCustomerAcctsObjAcctsVect);
	        _doService_cis0367I01CISCustomer.setAcctsObj(_doService_cis0367I01CISCustomerAcctsObj);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISCustomerBrNo = null;
	        _doService_cis0367I01CISCustomer.setBrNo(_doService_cis0367I01CISCustomerBrNo);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISCustomerDocNum = null;
	        _doService_cis0367I01CISCustomer.setDocNum(_doService_cis0367I01CISCustomerDocNum);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISCustomerDocTypeCode = null;
	        _doService_cis0367I01CISCustomer.setDocTypeCode(_doService_cis0367I01CISCustomerDocTypeCode);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISCustomerNum = null;
	        _doService_cis0367I01CISCustomer.setNum(_doService_cis0367I01CISCustomerNum);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISCustomerProdCode = null;
	        _doService_cis0367I01CISCustomer.setProdCode(_doService_cis0367I01CISCustomerProdCode);
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.RMTeamObj _doService_cis0367I01CISCustomerRMTeamObj = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.RMTeamObj();
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.RMTeamObj.RMEmpObj _doService_cis0367I01CISCustomerRMTeamObjRMEmpObj = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.RMTeamObj.RMEmpObj();
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISCustomerRMTeamObjRMEmpObjEmpNum = null;
	        _doService_cis0367I01CISCustomerRMTeamObjRMEmpObj.setEmpNum(_doService_cis0367I01CISCustomerRMTeamObjRMEmpObjEmpNum);
	        _doService_cis0367I01CISCustomerRMTeamObj.setRMEmpObj(_doService_cis0367I01CISCustomerRMTeamObjRMEmpObj);
	        _doService_cis0367I01CISCustomer.setRMTeamObj(_doService_cis0367I01CISCustomerRMTeamObj);
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.ServicesObj _doService_cis0367I01CISCustomerServicesObj = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.ServicesObj();
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.ServicesObj.ServicesVect _doService_cis0367I01CISCustomerServicesObjServicesVect = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.ServicesObj.ServicesVect();
	        java.util.List<com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.ServicesObj.ServicesVect.CISEntities> _doService_cis0367I01CISCustomerServicesObjServicesVectCISEntities = new java.util.ArrayList<com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISCustomer.ServicesObj.ServicesVect.CISEntities>();
	        _doService_cis0367I01CISCustomerServicesObjServicesVect.getCISEntities().addAll(_doService_cis0367I01CISCustomerServicesObjServicesVectCISEntities);
	        _doService_cis0367I01CISCustomerServicesObj.setServicesVect(_doService_cis0367I01CISCustomerServicesObjServicesVect);
	        _doService_cis0367I01CISCustomer.setServicesObj(_doService_cis0367I01CISCustomerServicesObj);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISCustomerThFstName = null;
	        _doService_cis0367I01CISCustomer.setThFstName(_doService_cis0367I01CISCustomerThFstName);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISCustomerThLstName = null;
	        _doService_cis0367I01CISCustomer.setThLstName(_doService_cis0367I01CISCustomerThLstName);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISCustomerTypeCode = null;
	        _doService_cis0367I01CISCustomer.setTypeCode(_doService_cis0367I01CISCustomerTypeCode);
	        _doService_cis0367I01.setCISCustomer(_doService_cis0367I01CISCustomer);
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISNavCntrl _doService_cis0367I01CISNavCntrl = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISNavCntrl();
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISNavCntrlDirCode = null;
	        _doService_cis0367I01CISNavCntrl.setDirCode(_doService_cis0367I01CISNavCntrlDirCode);
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISNavCntrl.FstKeyNum _doService_cis0367I01CISNavCntrlFstKeyNum = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISNavCntrl.FstKeyNum();
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISNavCntrlFstKeyNumCustNum = null;
	        _doService_cis0367I01CISNavCntrlFstKeyNum.setCustNum(_doService_cis0367I01CISNavCntrlFstKeyNumCustNum);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISNavCntrlFstKeyNumThFstName = null;
	        _doService_cis0367I01CISNavCntrlFstKeyNum.setThFstName(_doService_cis0367I01CISNavCntrlFstKeyNumThFstName);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISNavCntrlFstKeyNumThLstName = null;
	        _doService_cis0367I01CISNavCntrlFstKeyNum.setThLstName(_doService_cis0367I01CISNavCntrlFstKeyNumThLstName);
	        _doService_cis0367I01CISNavCntrl.setFstKeyNum(_doService_cis0367I01CISNavCntrlFstKeyNum);
	        com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISNavCntrl.LstKeyNum _doService_cis0367I01CISNavCntrlLstKeyNum = new com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01.CISNavCntrl.LstKeyNum();
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISNavCntrlLstKeyNumCustNum = null;
	        _doService_cis0367I01CISNavCntrlLstKeyNum.setCustNum(_doService_cis0367I01CISNavCntrlLstKeyNumCustNum);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISNavCntrlLstKeyNumThFstName = null;
	        _doService_cis0367I01CISNavCntrlLstKeyNum.setThFstName(_doService_cis0367I01CISNavCntrlLstKeyNumThFstName);
	        javax.xml.bind.JAXBElement<java.lang.String> _doService_cis0367I01CISNavCntrlLstKeyNumThLstName = null;
	        _doService_cis0367I01CISNavCntrlLstKeyNum.setThLstName(_doService_cis0367I01CISNavCntrlLstKeyNumThLstName);
	        _doService_cis0367I01CISNavCntrl.setLstKeyNum(_doService_cis0367I01CISNavCntrlLstKeyNum);
	        _doService_cis0367I01.setCISNavCntrl(_doService_cis0367I01CISNavCntrl);
	        
	        logger.debug("RQ_doService_cis0367I01 : " + soapCIS0367I01RQ(_doService_cis0367I01));
	        
	        _doService_cis0367I01_return =  (CIS0367I01Response) getWebServiceTemplate().marshalSendAndReceive(config.getCisUrl(), _doService_cis0367I01);
	        
	        JAXBContext jaxbContext = JAXBContext.newInstance(com.kasikornbank.eai.eaiws.cis0367i01.v9.DoServiceResponse.CIS0367I01Response.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); 
	        qName = new QName("com.kasikornbank.eai.eaiws.cis0367i01.v9.DoServiceResponse", "CIS0367I01");
	        JAXBElement<com.kasikornbank.eai.eaiws.cis0367i01.v9.DoServiceResponse.CIS0367I01Response> rootRPCIS0367I01 = new JAXBElement<>(qName, com.kasikornbank.eai.eaiws.cis0367i01.v9.DoServiceResponse.CIS0367I01Response.class, _doService_cis0367I01_return);
	        StringWriter sw = new StringWriter();
	        jaxbMarshaller.marshal(rootRPCIS0367I01, sw);
	        logger.debug("RS_doService_cis0367I01 : " + sw.toString());
        } catch(Exception e){
        	logger.error(e);
        }
        return _doService_cis0367I01_return;
	}
	
	public static String soapCIS0367I01RQ(com.kasikornbank.eai.eaiws.cis0367i01.v9.DoService.CIS0367I01 request){
		String result = "";
		try {
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage soapMsg = factory.createMessage();
			SOAPPart part = soapMsg.getSOAPPart();
	
			SOAPEnvelope envelope = part.getEnvelope();
			SOAPBody body = envelope.getBody();
			
			SOAPFactory soapFactory = SOAPFactory.newInstance();
			Name bodyName = soapFactory.createName("doService", null, com.kasikornbank.eai.eaiws.cis0367i01.v9.CIS0367I01.SERVICE.getNamespaceURI());
			    
			SOAPBodyElement element = body.addBodyElement(bodyName);
			
		    SOAPElement CIS0367I01 = element.addChildElement(soapFactory.createName("CIS0367I01"));
		    SOAPElement headerRequest = CIS0367I01.addChildElement(soapFactory.createName("EAIHeader"));
		    
		    headerRequest.addChildElement(soapFactory.createName("serviceId")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getServiceId()));
		    headerRequest.addChildElement(soapFactory.createName("beginTimestamp")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getBeginTimestamp()));
		    headerRequest.addChildElement(soapFactory.createName("endTimestamp")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getEndTimestamp()));
		    headerRequest.addChildElement(soapFactory.createName("transactionId")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getTransactionId()));
		    headerRequest.addChildElement(soapFactory.createName("sourceTransactionId")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getSourceTransactionId()));
		    headerRequest.addChildElement(soapFactory.createName("sourceSystem")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getSourceSystem()));
		    headerRequest.addChildElement(soapFactory.createName("userId")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getUserId()));
		    headerRequest.addChildElement(soapFactory.createName("password")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getPassword()));
		    headerRequest.addChildElement(soapFactory.createName("status")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getStatus()));
		    headerRequest.addChildElement(soapFactory.createName("reasonCode")).addTextNode(AppUtils.checkNull(request.getEAIHeader().getReasonCode()));
	     
		    SOAPElement CISCustomer = CIS0367I01.addChildElement(soapFactory.createName("CISCustomer"));
		    SOAPElement AcctsObj = CISCustomer.addChildElement(soapFactory.createName("AcctsObj"));
		    SOAPElement AcctsVect = AcctsObj.addChildElement(soapFactory.createName("AcctsVect"));
		    SOAPElement CISAccount = AcctsVect.addChildElement(soapFactory.createName("CISAccount"));
		    CISAccount.addChildElement(soapFactory.createName("num")).addTextNode(AppUtils.checkNull(request.getCISCustomer().getAcctsObj().getAcctsVect().getCISAccount().getNum()));
		    
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			soapMsg.writeTo(baos);                     
			result = baos.toString();
		} catch(Exception e){
			logger.error(e);
		}
		return result;
	}
	
}
