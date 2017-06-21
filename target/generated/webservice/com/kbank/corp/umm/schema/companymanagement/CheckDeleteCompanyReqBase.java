
package com.kbank.corp.umm.schema.companymanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.kbank.corp.umm.schema.ummcommon.UMMRequestBase;


/**
 * <p>Java class for CheckDeleteCompanyReqBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CheckDeleteCompanyReqBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UMMHeader" type="{http://umm.corp.kbank.com/schema/UMMCommon}UMMRequestBase"/&gt;
 *         &lt;element name="company_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="company_code" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="company_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CheckDeleteCompanyReqBase", propOrder = {
    "ummHeader",
    "companyId",
    "companyCode",
    "companyName"
})
public class CheckDeleteCompanyReqBase {

    @XmlElement(name = "UMMHeader", required = true)
    protected UMMRequestBase ummHeader;
    @XmlElement(name = "company_id")
    protected String companyId;
    @XmlElement(name = "company_code", required = true)
    protected String companyCode;
    @XmlElement(name = "company_name")
    protected String companyName;

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
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

}
