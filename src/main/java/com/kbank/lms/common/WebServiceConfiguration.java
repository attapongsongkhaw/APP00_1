package com.kbank.lms.common;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpsUrlConnectionMessageSender;
import com.kbank.corp.lms.schema.lmsprofileservice.LMSProfileService;
import com.kbank.lms.soap.ws.service.CBS1183I01Service;
import com.kbank.lms.soap.ws.service.CIS0367I01Service;
import com.kbank.lms.soap.ws.service.KBANK1554I01Service;
import com.kbank.lms.soap.ws.service.LMSProfileServiceImpl;
import com.kbank.lms.utils.AppUtils;

@Configuration
@PropertySource("classpath:app.properties")
public class WebServiceConfiguration {

	private static final String SERVICE_NAME_URL_PATH = "/LMSProfileService";
	private static final String SERVLET_MAPPING_URL_PATH = "/soap/*";
	private static final Logger logger = Logger.getLogger(WebServiceConfiguration.class);
	
	@Value("${lms.cbs.endpoint-url}")
    private String cbsUrl;
	
	@Value("${lms.cis.endpoint-url}")
    private String cisUrl;
	
	@Value("${lms.kbank.endpoint-url}")
    private String kbankUrl;

    @Value("${lms.eai.ws.key-store}")
    private String eaiKeyStore;

    @Value("${lms.eai.ws.key-store-password}")
    private String eaiKeyStorePassword;

    @Value("${lms.eai.ws.trust-store}")
    private String eaiTrustStore;

    @Value("${lms.eai.ws.trust-store-password}")
    private String eaiTrustStorePassword;

    @Value("${lms.ws.sslcontext}")
    private String SSLcontext;

	@Bean
    public ServletRegistrationBean dispatcherServletCXF() {
    	return new ServletRegistrationBean(new CXFServlet(), SERVLET_MAPPING_URL_PATH);
    }
 
	@Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {    	
    	return new SpringBus();
    }
    
    @Bean
    public Endpoint lmsProfileService() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), lmsProfileServiceBean());        
        endpoint.publish(SERVICE_NAME_URL_PATH);
        return endpoint;
    }     
    
    @Bean
    public LMSProfileService lmsProfileServiceBean(){
    	return new LMSProfileServiceImpl();
    }
    
    @Bean(name = "CBSService")
    public CBS1183I01Service CBSService() {
    	CBS1183I01Service client = new CBS1183I01Service();
        try{
        	Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.kasikornbank.eai.eaiws.cbs1183i01.v2");
	        client.setDefaultUri(cbsUrl);
	        client.setMarshaller(marshaller);
	        client.setUnmarshaller(marshaller);
	        HttpsUrlConnectionMessageSender messageSender = AppUtils.connectSSLWebService(eaiKeyStore, eaiKeyStorePassword, eaiTrustStore, eaiTrustStorePassword, SSLcontext);
	        client.setMessageSender(messageSender);
	        logger.info("Load CBSService SUCCESS !!");
        } catch(Exception e){
        	logger.error(e);
        	throw e;
        }
	    return client;
    }
    
    @Bean(name = "CISService")
    public CIS0367I01Service CISService() {
    	CIS0367I01Service client = new CIS0367I01Service();
        try{
        	Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.kasikornbank.eai.eaiws.cis0367i01.v9");
	        client.setDefaultUri(cisUrl);
	        client.setMarshaller(marshaller);
	        client.setUnmarshaller(marshaller);
	        HttpsUrlConnectionMessageSender messageSender = AppUtils.connectSSLWebService(eaiKeyStore, eaiKeyStorePassword, eaiTrustStore, eaiTrustStorePassword, SSLcontext);
	        client.setMessageSender(messageSender);
	        logger.info("Load CISService SUCCESS !!");
        } catch(Exception e){
        	logger.error(e);
        	throw e;
        }
	    return client;
    }
    
    @Bean(name = "KBANKService")
    public KBANK1554I01Service KBANKService() {
    	KBANK1554I01Service client = new KBANK1554I01Service();
        try{
        	Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
            marshaller.setContextPath("com.kasikornbank.eai.eaiws.kbank1554i01.v1");
	        client.setDefaultUri(kbankUrl);
	        client.setMarshaller(marshaller);
	        client.setUnmarshaller(marshaller);
	        HttpsUrlConnectionMessageSender messageSender = AppUtils.connectSSLWebService(eaiKeyStore, eaiKeyStorePassword, eaiTrustStore, eaiTrustStorePassword, SSLcontext);
	        client.setMessageSender(messageSender);
	        logger.info("Load KBANK1554I01Service SUCCESS !!");
        } catch(Exception e){
        	logger.error(e);
        	throw e;
        }
	    return client;
    }
}
