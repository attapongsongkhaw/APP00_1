package com.kbank.lms.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Configuration
@Component
@PropertySource("classpath:app.properties")
public class AppProperties {

	@Value("${lms.datasource.primary.jndiName}")
	private String primaryJndiName;
	
	@Value("${lms.datasource.primary.driverClassName}")
	private String primaryDriverClassName;
	
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

	public String getPrimaryJndiName() {
		return primaryJndiName;
	}

	public void setPrimaryJndiName(String primaryJndiName) {
		this.primaryJndiName = primaryJndiName;
	}

	public String getPrimaryDriverClassName() {
		return primaryDriverClassName;
	}

	public void setPrimaryDriverClassName(String primaryDriverClassName) {
		this.primaryDriverClassName = primaryDriverClassName;
	}
	
	public String getCbsUrl() {
		return cbsUrl;
	}

	public void setCbsUrl(String cbsUrl) {
		this.cbsUrl = cbsUrl;
	}

	public String getEaiKeyStore() {
		return eaiKeyStore;
	}

	public void setEaiKeyStore(String eaiKeyStore) {
		this.eaiKeyStore = eaiKeyStore;
	}

	public String getEaiKeyStorePassword() {
		return eaiKeyStorePassword;
	}

	public void setEaiKeyStorePassword(String eaiKeyStorePassword) {
		this.eaiKeyStorePassword = eaiKeyStorePassword;
	}

	public String getEaiTrustStore() {
		return eaiTrustStore;
	}

	public void setEaiTrustStore(String eaiTrustStore) {
		this.eaiTrustStore = eaiTrustStore;
	}

	public String getEaiTrustStorePassword() {
		return eaiTrustStorePassword;
	}

	public void setEaiTrustStorePassword(String eaiTrustStorePassword) {
		this.eaiTrustStorePassword = eaiTrustStorePassword;
	}

	public String getSSLcontext() {
		return SSLcontext;
	}

	public void setSSLcontext(String sSLcontext) {
		SSLcontext = sSLcontext;
	}

	public String getCisUrl() {
		return cisUrl;
	}

	public void setCisUrl(String cisUrl) {
		this.cisUrl = cisUrl;
	}

	public String getKbankUrl() {
		return kbankUrl;
	}

	public void setKbankUrl(String kbankUrl) {
		this.kbankUrl = kbankUrl;
	}

	@Override
	public String toString() {
		return "AppProperties [primaryJndiName=" + primaryJndiName + ", primaryDriverClassName="
				+ primaryDriverClassName + "]";
	}
	
}
