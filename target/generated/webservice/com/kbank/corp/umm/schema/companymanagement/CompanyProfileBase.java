
package com.kbank.corp.umm.schema.companymanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.kbank.corp.umm.schema.ummcommon.Addresses;
import com.kbank.corp.umm.schema.ummcommon.Contactpoints;
import com.kbank.corp.umm.schema.ummcommon.Services;


/**
 * <p>Java class for CompanyProfileBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompanyProfileBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="company_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="company_cust_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_name_en" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_name_th" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_register_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_register_date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_cis_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_segment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_biz_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_industry_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_industry_description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_base_ccy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_tax_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_userid_policy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_parent_flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_parent" type="{http://umm.corp.kbank.com/schema/CompanyManagement}CompanyProfileBase" minOccurs="0"/&gt;
 *         &lt;element name="company_addresses" type="{http://umm.corp.kbank.com/schema/UMMCommon}Addresses" minOccurs="0"/&gt;
 *         &lt;element name="company_contactpoints" type="{http://umm.corp.kbank.com/schema/UMMCommon}Contactpoints" minOccurs="0"/&gt;
 *         &lt;element name="company_services" type="{http://umm.corp.kbank.com/schema/UMMCommon}Services" minOccurs="0"/&gt;
 *         &lt;element name="action_mode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyProfileBase", propOrder = {
    "companyId",
    "companyCode",
    "companyCustType",
    "companyNameEn",
    "companyNameTh",
    "companyRegisterCode",
    "companyRegisterDate",
    "companyCisNo",
    "companySegment",
    "companyBizCode",
    "companyIndustryCode",
    "companyIndustryDescription",
    "companyBaseCcy",
    "companyTaxNo",
    "companyType",
    "companyStatus",
    "companyUseridPolicy",
    "companyParentFlag",
    "companyParent",
    "companyAddresses",
    "companyContactpoints",
    "companyServices",
    "actionMode"
})
public class CompanyProfileBase {

    @XmlElement(name = "company_id")
    protected String companyId;
    @XmlElement(name = "company_code", required = true)
    protected String companyCode;
    @XmlElement(name = "company_cust_type")
    protected String companyCustType;
    @XmlElement(name = "company_name_en")
    protected String companyNameEn;
    @XmlElement(name = "company_name_th")
    protected String companyNameTh;
    @XmlElement(name = "company_register_code")
    protected String companyRegisterCode;
    @XmlElement(name = "company_register_date")
    protected String companyRegisterDate;
    @XmlElement(name = "company_cis_no")
    protected String companyCisNo;
    @XmlElement(name = "company_segment")
    protected String companySegment;
    @XmlElement(name = "company_biz_code")
    protected String companyBizCode;
    @XmlElement(name = "company_industry_code")
    protected String companyIndustryCode;
    @XmlElement(name = "company_industry_description")
    protected String companyIndustryDescription;
    @XmlElement(name = "company_base_ccy")
    protected String companyBaseCcy;
    @XmlElement(name = "company_tax_no")
    protected String companyTaxNo;
    @XmlElement(name = "company_type")
    protected String companyType;
    @XmlElement(name = "company_status")
    protected String companyStatus;
    @XmlElement(name = "company_userid_policy")
    protected String companyUseridPolicy;
    @XmlElement(name = "company_parent_flag")
    protected String companyParentFlag;
    @XmlElement(name = "company_parent")
    protected CompanyProfileBase companyParent;
    @XmlElement(name = "company_addresses")
    protected Addresses companyAddresses;
    @XmlElement(name = "company_contactpoints")
    protected Contactpoints companyContactpoints;
    @XmlElement(name = "company_services")
    protected Services companyServices;
    @XmlElement(name = "action_mode")
    protected String actionMode;

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
     * Gets the value of the companyCustType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyCustType() {
        return companyCustType;
    }

    /**
     * Sets the value of the companyCustType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyCustType(String value) {
        this.companyCustType = value;
    }

    /**
     * Gets the value of the companyNameEn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyNameEn() {
        return companyNameEn;
    }

    /**
     * Sets the value of the companyNameEn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyNameEn(String value) {
        this.companyNameEn = value;
    }

    /**
     * Gets the value of the companyNameTh property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyNameTh() {
        return companyNameTh;
    }

    /**
     * Sets the value of the companyNameTh property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyNameTh(String value) {
        this.companyNameTh = value;
    }

    /**
     * Gets the value of the companyRegisterCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyRegisterCode() {
        return companyRegisterCode;
    }

    /**
     * Sets the value of the companyRegisterCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyRegisterCode(String value) {
        this.companyRegisterCode = value;
    }

    /**
     * Gets the value of the companyRegisterDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyRegisterDate() {
        return companyRegisterDate;
    }

    /**
     * Sets the value of the companyRegisterDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyRegisterDate(String value) {
        this.companyRegisterDate = value;
    }

    /**
     * Gets the value of the companyCisNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyCisNo() {
        return companyCisNo;
    }

    /**
     * Sets the value of the companyCisNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyCisNo(String value) {
        this.companyCisNo = value;
    }

    /**
     * Gets the value of the companySegment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanySegment() {
        return companySegment;
    }

    /**
     * Sets the value of the companySegment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanySegment(String value) {
        this.companySegment = value;
    }

    /**
     * Gets the value of the companyBizCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyBizCode() {
        return companyBizCode;
    }

    /**
     * Sets the value of the companyBizCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyBizCode(String value) {
        this.companyBizCode = value;
    }

    /**
     * Gets the value of the companyIndustryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyIndustryCode() {
        return companyIndustryCode;
    }

    /**
     * Sets the value of the companyIndustryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyIndustryCode(String value) {
        this.companyIndustryCode = value;
    }

    /**
     * Gets the value of the companyIndustryDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyIndustryDescription() {
        return companyIndustryDescription;
    }

    /**
     * Sets the value of the companyIndustryDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyIndustryDescription(String value) {
        this.companyIndustryDescription = value;
    }

    /**
     * Gets the value of the companyBaseCcy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyBaseCcy() {
        return companyBaseCcy;
    }

    /**
     * Sets the value of the companyBaseCcy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyBaseCcy(String value) {
        this.companyBaseCcy = value;
    }

    /**
     * Gets the value of the companyTaxNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyTaxNo() {
        return companyTaxNo;
    }

    /**
     * Sets the value of the companyTaxNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyTaxNo(String value) {
        this.companyTaxNo = value;
    }

    /**
     * Gets the value of the companyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * Sets the value of the companyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyType(String value) {
        this.companyType = value;
    }

    /**
     * Gets the value of the companyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyStatus() {
        return companyStatus;
    }

    /**
     * Sets the value of the companyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyStatus(String value) {
        this.companyStatus = value;
    }

    /**
     * Gets the value of the companyUseridPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyUseridPolicy() {
        return companyUseridPolicy;
    }

    /**
     * Sets the value of the companyUseridPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyUseridPolicy(String value) {
        this.companyUseridPolicy = value;
    }

    /**
     * Gets the value of the companyParentFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyParentFlag() {
        return companyParentFlag;
    }

    /**
     * Sets the value of the companyParentFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyParentFlag(String value) {
        this.companyParentFlag = value;
    }

    /**
     * Gets the value of the companyParent property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyProfileBase }
     *     
     */
    public CompanyProfileBase getCompanyParent() {
        return companyParent;
    }

    /**
     * Sets the value of the companyParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyProfileBase }
     *     
     */
    public void setCompanyParent(CompanyProfileBase value) {
        this.companyParent = value;
    }

    /**
     * Gets the value of the companyAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link Addresses }
     *     
     */
    public Addresses getCompanyAddresses() {
        return companyAddresses;
    }

    /**
     * Sets the value of the companyAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Addresses }
     *     
     */
    public void setCompanyAddresses(Addresses value) {
        this.companyAddresses = value;
    }

    /**
     * Gets the value of the companyContactpoints property.
     * 
     * @return
     *     possible object is
     *     {@link Contactpoints }
     *     
     */
    public Contactpoints getCompanyContactpoints() {
        return companyContactpoints;
    }

    /**
     * Sets the value of the companyContactpoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Contactpoints }
     *     
     */
    public void setCompanyContactpoints(Contactpoints value) {
        this.companyContactpoints = value;
    }

    /**
     * Gets the value of the companyServices property.
     * 
     * @return
     *     possible object is
     *     {@link Services }
     *     
     */
    public Services getCompanyServices() {
        return companyServices;
    }

    /**
     * Sets the value of the companyServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link Services }
     *     
     */
    public void setCompanyServices(Services value) {
        this.companyServices = value;
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
