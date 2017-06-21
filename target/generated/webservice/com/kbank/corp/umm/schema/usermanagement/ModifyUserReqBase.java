
package com.kbank.corp.umm.schema.usermanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.kbank.corp.umm.schema.ummcommon.UMMRequestBase;


/**
 * <p>Java class for ModifyUserReqBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModifyUserReqBase"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UMMHeader" type="{http://umm.corp.kbank.com/schema/UMMCommon}UMMRequestBase"/&gt;
 *         &lt;element name="UserProfile" type="{http://umm.corp.kbank.com/schema/UserManagement}UserProfileBase"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifyUserReqBase", propOrder = {
    "ummHeader",
    "userProfile"
})
public class ModifyUserReqBase {

    @XmlElement(name = "UMMHeader", required = true)
    protected UMMRequestBase ummHeader;
    @XmlElement(name = "UserProfile", required = true)
    protected UserProfileBase userProfile;

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
     * Gets the value of the userProfile property.
     * 
     * @return
     *     possible object is
     *     {@link UserProfileBase }
     *     
     */
    public UserProfileBase getUserProfile() {
        return userProfile;
    }

    /**
     * Sets the value of the userProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserProfileBase }
     *     
     */
    public void setUserProfile(UserProfileBase value) {
        this.userProfile = value;
    }

}
