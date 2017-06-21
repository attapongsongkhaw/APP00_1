
package com.kasikornbank.eai.eaiws.cbs1183i01.v2;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 3.1.11
 * 2560-05-08T17:24:21.047+07:00
 * Generated source version: 3.1.11
 * 
 */
public final class CBS1183I01Soap_CBS1183I01SoapPort_Client {

    private static final QName SERVICE_NAME = new QName("http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", "CBS1183I01");
    private static final Logger LOG = Logger.getLogger(CBS1183I01Soap_CBS1183I01SoapPort_Client.class.getName());
    
    private CBS1183I01Soap_CBS1183I01SoapPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = CBS1183I01.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
            	LOG.info(e.getMessage());
            }
        }
      
        CBS1183I01 ss = new CBS1183I01(wsdlURL, SERVICE_NAME);
        CBS1183I01Soap port = ss.getCBS1183I01SoapPort();  
        
        {
        LOG.info("Invoking doService...");
        com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01 _doService_cbs1183I01 = new com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01();
        com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01.KBankHeader _doService_cbs1183I01KBankHeader = new com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoService.CBS1183I01.KBankHeader();
        _doService_cbs1183I01KBankHeader.setFuncNm("FuncNm-1122397402");
        _doService_cbs1183I01KBankHeader.setRqUID("RqUID-1837023311");
        _doService_cbs1183I01KBankHeader.setRqDt(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-05-08T17:24:21.092+07:00"));
        _doService_cbs1183I01KBankHeader.setRqAppId("RqAppId-633677780");
        _doService_cbs1183I01KBankHeader.setUserId("UserId-628040833");
        _doService_cbs1183I01KBankHeader.setTerminalId("TerminalId557721396");
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
        _doService_cbs1183I01CBSAccount.setAcctId("AcctId-596314613");
        _doService_cbs1183I01.setCBSAccount(_doService_cbs1183I01CBSAccount);
        com.kasikornbank.eai.eaiws.cbs1183i01.v2.DoServiceResponse.CBS1183I01Response _doService__return = port.doService(_doService_cbs1183I01);
        LOG.info("doService.result=" + _doService__return);


        }

        System.exit(0);
    }

}
