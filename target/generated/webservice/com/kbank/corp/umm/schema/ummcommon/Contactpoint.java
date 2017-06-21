
package com.kbank.corp.umm.schema.ummcommon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Contactpoint complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Contactpoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contactpoint_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactpoint_address_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactpoint_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactpoint_default" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactpoint_department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactpoint_phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactpoint_mobile" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactpoint_fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactpoint_email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contactpoint", propOrder = {
    "contactpointId",
    "contactpointAddressId",
    "contactpointName",
    "contactpointDefault",
    "contactpointDepartment",
    "contactpointPhone",
    "contactpointMobile",
    "contactpointFax",
    "contactpointEmail"
})
public class Contactpoint {

    @XmlElement(name = "contactpoint_id")
    protected String contactpointId;
    @XmlElement(name = "contactpoint_address_id")
    protected String contactpointAddressId;
    @XmlElement(name = "contactpoint_name")
    protected String contactpointName;
    @XmlElement(name = "contactpoint_default")
    protected String contactpointDefault;
    @XmlElement(name = "contactpoint_department")
    protected String contactpointDepartment;
    @XmlElement(name = "contactpoint_phone")
    protected String contactpointPhone;
    @XmlElement(name = "contactpoint_mobile")
    protected String contactpointMobile;
    @XmlElement(name = "contactpoint_fax")
    protected String contactpointFax;
    @XmlElement(name = "contactpoint_email")
    protected String contactpointEmail;

    /**
     * Gets the value of the contactpointId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactpointId() {
        return contactpointId;
    }

    /**
     * Sets the value of the contactpointId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactpointId(String value) {
        this.contactpointId = value;
    }

    /**
     * Gets the value of the contactpointAddressId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactpointAddressId() {
        return contactpointAddressId;
    }

    /**
     * Sets the value of the contactpointAddressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactpointAddressId(String value) {
        this.contactpointAddressId = value;
    }

    /**
     * Gets the value of the contactpointName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactpointName() {
        return contactpointName;
    }

    /**
     * Sets the value of the contactpointName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactpointName(String value) {
        this.contactpointName = value;
    }

    /**
     * Gets the value of the contactpointDefault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactpointDefault() {
        return contactpointDefault;
    }

    /**
     * Sets the value of the contactpointDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactpointDefault(String value) {
        this.contactpointDefault = value;
    }

    /**
     * Gets the value of the contactpointDepartment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactpointDepartment() {
        return contactpointDepartment;
    }

    /**
     * Sets the value of the contactpointDepartment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactpointDepartment(String value) {
        this.contactpointDepartment = value;
    }

    /**
     * Gets the value of the contactpointPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactpointPhone() {
        return contactpointPhone;
    }

    /**
     * Sets the value of the contactpointPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactpointPhone(String value) {
        this.contactpointPhone = value;
    }

    /**
     * Gets the value of the contactpointMobile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactpointMobile() {
        return contactpointMobile;
    }

    /**
     * Sets the value of the contactpointMobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactpointMobile(String value) {
        this.contactpointMobile = value;
    }

    /**
     * Gets the value of the contactpointFax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactpointFax() {
        return contactpointFax;
    }

    /**
     * Sets the value of the contactpointFax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactpointFax(String value) {
        this.contactpointFax = value;
    }

    /**
     * Gets the value of the contactpointEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactpointEmail() {
        return contactpointEmail;
    }

    /**
     * Sets the value of the contactpointEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactpointEmail(String value) {
        this.contactpointEmail = value;
    }

}
