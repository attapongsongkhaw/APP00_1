
package com.kbank.corp.umm.schema.ummcommon;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Contactpoints complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Contactpoints"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contactpoint" type="{http://umm.corp.kbank.com/schema/UMMCommon}Contactpoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Contactpoints", propOrder = {
    "contactpoint"
})
public class Contactpoints {

    protected List<Contactpoint> contactpoint;

    /**
     * Gets the value of the contactpoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactpoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactpoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Contactpoint }
     * 
     * 
     */
    public List<Contactpoint> getContactpoint() {
        if (contactpoint == null) {
            contactpoint = new ArrayList<Contactpoint>();
        }
        return this.contactpoint;
    }

}
