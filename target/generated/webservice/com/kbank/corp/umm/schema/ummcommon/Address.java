
package com.kbank.corp.umm.schema.ummcommon;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Address"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="address_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_no" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_moo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_building" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_floor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_soi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_sub_district" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_district" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_province" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_post_code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address_country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", propOrder = {
    "addressId",
    "addressType",
    "addressName",
    "addressNo",
    "addressMoo",
    "addressBuilding",
    "addressFloor",
    "addressSoi",
    "addressStreet",
    "addressSubDistrict",
    "addressDistrict",
    "addressProvince",
    "addressRegion",
    "addressPostCode",
    "addressCountry"
})
public class Address {

    @XmlElement(name = "address_id")
    protected String addressId;
    @XmlElement(name = "address_type")
    protected String addressType;
    @XmlElement(name = "address_name")
    protected String addressName;
    @XmlElement(name = "address_no")
    protected String addressNo;
    @XmlElement(name = "address_moo")
    protected String addressMoo;
    @XmlElement(name = "address_building")
    protected String addressBuilding;
    @XmlElement(name = "address_floor")
    protected String addressFloor;
    @XmlElement(name = "address_soi")
    protected String addressSoi;
    @XmlElement(name = "address_street")
    protected String addressStreet;
    @XmlElement(name = "address_sub_district")
    protected String addressSubDistrict;
    @XmlElement(name = "address_district")
    protected String addressDistrict;
    @XmlElement(name = "address_province")
    protected String addressProvince;
    @XmlElement(name = "address_region")
    protected String addressRegion;
    @XmlElement(name = "address_post_code")
    protected String addressPostCode;
    @XmlElement(name = "address_country")
    protected String addressCountry;

    /**
     * Gets the value of the addressId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * Sets the value of the addressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressId(String value) {
        this.addressId = value;
    }

    /**
     * Gets the value of the addressType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressType(String value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the addressName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * Sets the value of the addressName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressName(String value) {
        this.addressName = value;
    }

    /**
     * Gets the value of the addressNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressNo() {
        return addressNo;
    }

    /**
     * Sets the value of the addressNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressNo(String value) {
        this.addressNo = value;
    }

    /**
     * Gets the value of the addressMoo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressMoo() {
        return addressMoo;
    }

    /**
     * Sets the value of the addressMoo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressMoo(String value) {
        this.addressMoo = value;
    }

    /**
     * Gets the value of the addressBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressBuilding() {
        return addressBuilding;
    }

    /**
     * Sets the value of the addressBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressBuilding(String value) {
        this.addressBuilding = value;
    }

    /**
     * Gets the value of the addressFloor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressFloor() {
        return addressFloor;
    }

    /**
     * Sets the value of the addressFloor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressFloor(String value) {
        this.addressFloor = value;
    }

    /**
     * Gets the value of the addressSoi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressSoi() {
        return addressSoi;
    }

    /**
     * Sets the value of the addressSoi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressSoi(String value) {
        this.addressSoi = value;
    }

    /**
     * Gets the value of the addressStreet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressStreet() {
        return addressStreet;
    }

    /**
     * Sets the value of the addressStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressStreet(String value) {
        this.addressStreet = value;
    }

    /**
     * Gets the value of the addressSubDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressSubDistrict() {
        return addressSubDistrict;
    }

    /**
     * Sets the value of the addressSubDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressSubDistrict(String value) {
        this.addressSubDistrict = value;
    }

    /**
     * Gets the value of the addressDistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressDistrict() {
        return addressDistrict;
    }

    /**
     * Sets the value of the addressDistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressDistrict(String value) {
        this.addressDistrict = value;
    }

    /**
     * Gets the value of the addressProvince property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressProvince() {
        return addressProvince;
    }

    /**
     * Sets the value of the addressProvince property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressProvince(String value) {
        this.addressProvince = value;
    }

    /**
     * Gets the value of the addressRegion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressRegion() {
        return addressRegion;
    }

    /**
     * Sets the value of the addressRegion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressRegion(String value) {
        this.addressRegion = value;
    }

    /**
     * Gets the value of the addressPostCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressPostCode() {
        return addressPostCode;
    }

    /**
     * Sets the value of the addressPostCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressPostCode(String value) {
        this.addressPostCode = value;
    }

    /**
     * Gets the value of the addressCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddressCountry() {
        return addressCountry;
    }

    /**
     * Sets the value of the addressCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddressCountry(String value) {
        this.addressCountry = value;
    }

}
