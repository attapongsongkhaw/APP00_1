
package com.kbank.corp.umm.schema.usermanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.kbank.corp.umm.schema.ummcommon.Contactpoints;
import com.kbank.corp.umm.schema.ummcommon.Services;
import com.kbank.corp.umm.schema.ummcommon.TokenBase;


/**
 * <p>Java class for UserProfileBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserProfileBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="user_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="login_account" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="prefix_login_account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="suffix_login_account" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="salutation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ref_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ref_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="user_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="token_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="token" type="{http://umm.corp.kbank.com/schema/UMMCommon}TokenBase" minOccurs="0"/&gt;
 *         &lt;element name="contactpointlist" type="{http://umm.corp.kbank.com/schema/UMMCommon}Contactpoints" minOccurs="0"/&gt;
 *         &lt;element name="servicelist" type="{http://umm.corp.kbank.com/schema/UMMCommon}Services" minOccurs="0"/&gt;
 *         &lt;element name="action_mode" type="{http://umm.corp.kbank.com/schema/UMMCommon}Action" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserProfileBase", propOrder = {
    "userId",
    "companyId",
    "companyCode",
    "loginAccount",
    "prefixLoginAccount",
    "suffixLoginAccount",
    "gender",
    "salutation",
    "firstname",
    "lastname",
    "refType",
    "refNo",
    "email",
    "phone",
    "mobile",
    "status",
    "userType",
    "tokenType",
    "token",
    "contactpointlist",
    "servicelist",
    "actionMode"
})
public class UserProfileBase {

    @XmlElement(name = "user_id")
    protected String userId;
    @XmlElement(name = "company_id")
    protected String companyId;
    @XmlElement(name = "company_code", required = true)
    protected String companyCode;
    @XmlElement(name = "login_account", required = true)
    protected String loginAccount;
    @XmlElement(name = "prefix_login_account")
    protected String prefixLoginAccount;
    @XmlElement(name = "suffix_login_account")
    protected String suffixLoginAccount;
    protected String gender;
    protected String salutation;
    protected String firstname;
    protected String lastname;
    @XmlElement(name = "ref_type")
    protected String refType;
    @XmlElement(name = "ref_no")
    protected String refNo;
    protected String email;
    protected String phone;
    protected String mobile;
    protected String status;
    @XmlElement(name = "user_type")
    protected String userType;
    @XmlElement(name = "token_type")
    protected String tokenType;
    protected TokenBase token;
    protected Contactpoints contactpointlist;
    protected Services servicelist;
    @XmlElement(name = "action_mode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String actionMode;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the companyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * Sets the value of the companyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyId(String value) {
        this.companyId = value;
    }

    /**
     * Gets the value of the companyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * Sets the value of the companyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyCode(String value) {
        this.companyCode = value;
    }

    /**
     * Gets the value of the loginAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginAccount() {
        return loginAccount;
    }

    /**
     * Sets the value of the loginAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginAccount(String value) {
        this.loginAccount = value;
    }

    /**
     * Gets the value of the prefixLoginAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefixLoginAccount() {
        return prefixLoginAccount;
    }

    /**
     * Sets the value of the prefixLoginAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefixLoginAccount(String value) {
        this.prefixLoginAccount = value;
    }

    /**
     * Gets the value of the suffixLoginAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffixLoginAccount() {
        return suffixLoginAccount;
    }

    /**
     * Sets the value of the suffixLoginAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffixLoginAccount(String value) {
        this.suffixLoginAccount = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the salutation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Sets the value of the salutation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalutation(String value) {
        this.salutation = value;
    }

    /**
     * Gets the value of the firstname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets the value of the firstname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstname(String value) {
        this.firstname = value;
    }

    /**
     * Gets the value of the lastname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the value of the lastname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastname(String value) {
        this.lastname = value;
    }

    /**
     * Gets the value of the refType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefType() {
        return refType;
    }

    /**
     * Sets the value of the refType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefType(String value) {
        this.refType = value;
    }

    /**
     * Gets the value of the refNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * Sets the value of the refNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefNo(String value) {
        this.refNo = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobile(String value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the userType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the value of the userType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserType(String value) {
        this.userType = value;
    }

    /**
     * Gets the value of the tokenType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Sets the value of the tokenType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenType(String value) {
        this.tokenType = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link TokenBase }
     *     
     */
    public TokenBase getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link TokenBase }
     *     
     */
    public void setToken(TokenBase value) {
        this.token = value;
    }

    /**
     * Gets the value of the contactpointlist property.
     * 
     * @return
     *     possible object is
     *     {@link Contactpoints }
     *     
     */
    public Contactpoints getContactpointlist() {
        return contactpointlist;
    }

    /**
     * Sets the value of the contactpointlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contactpoints }
     *     
     */
    public void setContactpointlist(Contactpoints value) {
        this.contactpointlist = value;
    }

    /**
     * Gets the value of the servicelist property.
     * 
     * @return
     *     possible object is
     *     {@link Services }
     *     
     */
    public Services getServicelist() {
        return servicelist;
    }

    /**
     * Sets the value of the servicelist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Services }
     *     
     */
    public void setServicelist(Services value) {
        this.servicelist = value;
    }

    /**
     * Gets the value of the actionMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionMode() {
        return actionMode;
    }

    /**
     * Sets the value of the actionMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionMode(String value) {
        this.actionMode = value;
    }

}
