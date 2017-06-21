
package com.kbank.corp.umm.schema.companymanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.kbank.corp.umm.schema.ummcommon.UMMRequestBase;


/**
 * <p>Java class for CreateCompanyReqBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateCompanyReqBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UMMHeader" type="{http://umm.corp.kbank.com/schema/UMMCommon}UMMRequestBase"/&gt;
 *         &lt;element name="CompanyProfile" type="{http://umm.corp.kbank.com/schema/CompanyManagement}CompanyProfileBase"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCompanyReqBase", propOrder = {
    "ummHeader",
    "companyProfile"
})
public class CreateCompanyReqBase {

    @XmlElement(name = "UMMHeader", required = true)
    protected UMMRequestBase ummHeader;
    @XmlElement(name = "CompanyProfile", required = true)
    protected CompanyProfileBase companyProfile;

    /**
     * Gets the value of the ummHeader property.
     * 
     * @return
     *     possible object is
     *     {@link UMMRequestBase }
     *     
     */
    public UMMRequestBase getUMMHeader() {
        return ummHeader;
    }

    /**
     * Sets the value of the ummHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link UMMRequestBase }
     *     
     */
    public void setUMMHeader(UMMRequestBase value) {
        this.ummHeader = value;
    }

    /**
     * Gets the value of the companyProfile property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyProfileBase }
     *     
     */
    public CompanyProfileBase getCompanyProfile() {
        return companyProfile;
    }

    /**
     * Sets the value of the companyProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyProfileBase }
     *     
     */
    public void setCompanyProfile(CompanyProfileBase value) {
        this.companyProfile = value;
    }

}
