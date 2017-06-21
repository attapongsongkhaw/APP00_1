
package com.kasikornbank.eai.eaiws.cis0367i01.v9;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for doService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doService"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CIS0367I01"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="EAIHeader"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="serviceId" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength12"/&gt;
 *                             &lt;element name="beginTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                             &lt;element name="endTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *                             &lt;element name="transactionId" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength32" minOccurs="0"/&gt;
 *                             &lt;element name="sourceTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="sourceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="status" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength1" minOccurs="0"/&gt;
 *                             &lt;element name="reasonCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength5" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CISCustomer" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="acctsObj" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="acctsVect" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="CISAccount" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="brNo" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength4" minOccurs="0"/&gt;
 *                             &lt;element name="docNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength15" minOccurs="0"/&gt;
 *                             &lt;element name="docTypeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
 *                             &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
 *                             &lt;element name="prodCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength9" minOccurs="0"/&gt;
 *                             &lt;element name="RMTeamObj" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="RMEmpObj" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="empNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength6" minOccurs="0"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="servicesObj" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="servicesVect" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="CISEntities" maxOccurs="3" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="entitiesVect" minOccurs="0"&gt;
 *                                                             &lt;complexType&gt;
 *                                                               &lt;complexContent&gt;
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                   &lt;sequence&gt;
 *                                                                     &lt;element name="CISATMEnty" minOccurs="0"&gt;
 *                                                                       &lt;complexType&gt;
 *                                                                         &lt;complexContent&gt;
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                             &lt;sequence&gt;
 *                                                                               &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
 *                                                                             &lt;/sequence&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/complexContent&gt;
 *                                                                       &lt;/complexType&gt;
 *                                                                     &lt;/element&gt;
 *                                                                     &lt;element name="CISCrCardEnty" minOccurs="0"&gt;
 *                                                                       &lt;complexType&gt;
 *                                                                         &lt;complexContent&gt;
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                             &lt;sequence&gt;
 *                                                                               &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
 *                                                                             &lt;/sequence&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/complexContent&gt;
 *                                                                       &lt;/complexType&gt;
 *                                                                     &lt;/element&gt;
 *                                                                     &lt;element name="CISLPMEnty" minOccurs="0"&gt;
 *                                                                       &lt;complexType&gt;
 *                                                                         &lt;complexContent&gt;
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                             &lt;sequence&gt;
 *                                                                               &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
 *                                                                             &lt;/sequence&gt;
 *                                                                           &lt;/restriction&gt;
 *                                                                         &lt;/complexContent&gt;
 *                                                                       &lt;/complexType&gt;
 *                                                                     &lt;/element&gt;
 *                                                                   &lt;/sequence&gt;
 *                                                                 &lt;/restriction&gt;
 *                                                               &lt;/complexContent&gt;
 *                                                             &lt;/complexType&gt;
 *                                                           &lt;/element&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
 *                             &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
 *                             &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CISNavCntrl" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="dirCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
 *                             &lt;element name="fstKeyNum" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
 *                                       &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
 *                                       &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="lstKeyNum" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
 *                                       &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
 *                                       &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doService", propOrder = {
    "cis0367I01"
})
public class DoService {

    @XmlElement(name = "CIS0367I01", required = true)
    protected DoService.CIS0367I01 cis0367I01;

    /**
     * Gets the value of the cis0367I01 property.
     * 
     * @return
     *     possible object is
     *     {@link DoService.CIS0367I01 }
     *     
     */
    public DoService.CIS0367I01 getCIS0367I01() {
        return cis0367I01;
    }

    /**
     * Sets the value of the cis0367I01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoService.CIS0367I01 }
     *     
     */
    public void setCIS0367I01(DoService.CIS0367I01 value) {
        this.cis0367I01 = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="EAIHeader"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="serviceId" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength12"/&gt;
     *                   &lt;element name="beginTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                   &lt;element name="endTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
     *                   &lt;element name="transactionId" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength32" minOccurs="0"/&gt;
     *                   &lt;element name="sourceTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="sourceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="status" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength1" minOccurs="0"/&gt;
     *                   &lt;element name="reasonCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength5" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CISCustomer" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="acctsObj" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="acctsVect" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="CISAccount" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="brNo" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength4" minOccurs="0"/&gt;
     *                   &lt;element name="docNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength15" minOccurs="0"/&gt;
     *                   &lt;element name="docTypeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
     *                   &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
     *                   &lt;element name="prodCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength9" minOccurs="0"/&gt;
     *                   &lt;element name="RMTeamObj" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="RMEmpObj" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="empNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength6" minOccurs="0"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="servicesObj" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="servicesVect" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="CISEntities" maxOccurs="3" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="entitiesVect" minOccurs="0"&gt;
     *                                                   &lt;complexType&gt;
     *                                                     &lt;complexContent&gt;
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                         &lt;sequence&gt;
     *                                                           &lt;element name="CISATMEnty" minOccurs="0"&gt;
     *                                                             &lt;complexType&gt;
     *                                                               &lt;complexContent&gt;
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                   &lt;sequence&gt;
     *                                                                     &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
     *                                                                   &lt;/sequence&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/complexContent&gt;
     *                                                             &lt;/complexType&gt;
     *                                                           &lt;/element&gt;
     *                                                           &lt;element name="CISCrCardEnty" minOccurs="0"&gt;
     *                                                             &lt;complexType&gt;
     *                                                               &lt;complexContent&gt;
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                   &lt;sequence&gt;
     *                                                                     &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
     *                                                                   &lt;/sequence&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/complexContent&gt;
     *                                                             &lt;/complexType&gt;
     *                                                           &lt;/element&gt;
     *                                                           &lt;element name="CISLPMEnty" minOccurs="0"&gt;
     *                                                             &lt;complexType&gt;
     *                                                               &lt;complexContent&gt;
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                   &lt;sequence&gt;
     *                                                                     &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
     *                                                                   &lt;/sequence&gt;
     *                                                                 &lt;/restriction&gt;
     *                                                               &lt;/complexContent&gt;
     *                                                             &lt;/complexType&gt;
     *                                                           &lt;/element&gt;
     *                                                         &lt;/sequence&gt;
     *                                                       &lt;/restriction&gt;
     *                                                     &lt;/complexContent&gt;
     *                                                   &lt;/complexType&gt;
     *                                                 &lt;/element&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
     *                   &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
     *                   &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CISNavCntrl" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="dirCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
     *                   &lt;element name="fstKeyNum" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
     *                             &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
     *                             &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="lstKeyNum" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
     *                             &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
     *                             &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "eaiHeader",
        "cisCustomer",
        "cisNavCntrl"
    })
    @XmlRootElement(name = "CIS0367I01")
    public static class CIS0367I01 {

        @XmlElement(name = "EAIHeader", required = true)
        protected DoService.CIS0367I01 .EAIHeader eaiHeader;
        @XmlElement(name = "CISCustomer")
        protected DoService.CIS0367I01 .CISCustomer cisCustomer;
        @XmlElement(name = "CISNavCntrl")
        protected DoService.CIS0367I01 .CISNavCntrl cisNavCntrl;

        /**
         * Gets the value of the eaiHeader property.
         * 
         * @return
         *     possible object is
         *     {@link DoService.CIS0367I01 .EAIHeader }
         *     
         */
        public DoService.CIS0367I01 .EAIHeader getEAIHeader() {
            return eaiHeader;
        }

        /**
         * Sets the value of the eaiHeader property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoService.CIS0367I01 .EAIHeader }
         *     
         */
        public void setEAIHeader(DoService.CIS0367I01 .EAIHeader value) {
            this.eaiHeader = value;
        }

        /**
         * Gets the value of the cisCustomer property.
         * 
         * @return
         *     possible object is
         *     {@link DoService.CIS0367I01 .CISCustomer }
         *     
         */
        public DoService.CIS0367I01 .CISCustomer getCISCustomer() {
            return cisCustomer;
        }

        /**
         * Sets the value of the cisCustomer property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoService.CIS0367I01 .CISCustomer }
         *     
         */
        public void setCISCustomer(DoService.CIS0367I01 .CISCustomer value) {
            this.cisCustomer = value;
        }

        /**
         * Gets the value of the cisNavCntrl property.
         * 
         * @return
         *     possible object is
         *     {@link DoService.CIS0367I01 .CISNavCntrl }
         *     
         */
        public DoService.CIS0367I01 .CISNavCntrl getCISNavCntrl() {
            return cisNavCntrl;
        }

        /**
         * Sets the value of the cisNavCntrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoService.CIS0367I01 .CISNavCntrl }
         *     
         */
        public void setCISNavCntrl(DoService.CIS0367I01 .CISNavCntrl value) {
            this.cisNavCntrl = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="acctsObj" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="acctsVect" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="CISAccount" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
         *                                     &lt;/sequence&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="brNo" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength4" minOccurs="0"/&gt;
         *         &lt;element name="docNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength15" minOccurs="0"/&gt;
         *         &lt;element name="docTypeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
         *         &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
         *         &lt;element name="prodCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength9" minOccurs="0"/&gt;
         *         &lt;element name="RMTeamObj" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="RMEmpObj" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="empNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength6" minOccurs="0"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="servicesObj" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="servicesVect" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="CISEntities" maxOccurs="3" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="entitiesVect" minOccurs="0"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;complexContent&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                               &lt;sequence&gt;
         *                                                 &lt;element name="CISATMEnty" minOccurs="0"&gt;
         *                                                   &lt;complexType&gt;
         *                                                     &lt;complexContent&gt;
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                         &lt;sequence&gt;
         *                                                           &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
         *                                                         &lt;/sequence&gt;
         *                                                       &lt;/restriction&gt;
         *                                                     &lt;/complexContent&gt;
         *                                                   &lt;/complexType&gt;
         *                                                 &lt;/element&gt;
         *                                                 &lt;element name="CISCrCardEnty" minOccurs="0"&gt;
         *                                                   &lt;complexType&gt;
         *                                                     &lt;complexContent&gt;
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                         &lt;sequence&gt;
         *                                                           &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
         *                                                         &lt;/sequence&gt;
         *                                                       &lt;/restriction&gt;
         *                                                     &lt;/complexContent&gt;
         *                                                   &lt;/complexType&gt;
         *                                                 &lt;/element&gt;
         *                                                 &lt;element name="CISLPMEnty" minOccurs="0"&gt;
         *                                                   &lt;complexType&gt;
         *                                                     &lt;complexContent&gt;
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                         &lt;sequence&gt;
         *                                                           &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
         *                                                         &lt;/sequence&gt;
         *                                                       &lt;/restriction&gt;
         *                                                     &lt;/complexContent&gt;
         *                                                   &lt;/complexType&gt;
         *                                                 &lt;/element&gt;
         *                                               &lt;/sequence&gt;
         *                                             &lt;/restriction&gt;
         *                                           &lt;/complexContent&gt;
         *                                         &lt;/complexType&gt;
         *                                       &lt;/element&gt;
         *                                     &lt;/sequence&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
         *         &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
         *         &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "acctsObj",
            "brNo",
            "docNum",
            "docTypeCode",
            "num",
            "prodCode",
            "rmTeamObj",
            "servicesObj",
            "thFstName",
            "thLstName",
            "typeCode"
        })
        public static class CISCustomer {

            protected DoService.CIS0367I01 .CISCustomer.AcctsObj acctsObj;
            @XmlElementRef(name = "brNo", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> brNo;
            @XmlElementRef(name = "docNum", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> docNum;
            @XmlElementRef(name = "docTypeCode", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> docTypeCode;
            @XmlElementRef(name = "num", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> num;
            @XmlElementRef(name = "prodCode", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> prodCode;
            @XmlElement(name = "RMTeamObj")
            protected DoService.CIS0367I01 .CISCustomer.RMTeamObj rmTeamObj;
            protected DoService.CIS0367I01 .CISCustomer.ServicesObj servicesObj;
            @XmlElementRef(name = "thFstName", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> thFstName;
            @XmlElementRef(name = "thLstName", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> thLstName;
            @XmlElementRef(name = "typeCode", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> typeCode;

            /**
             * Gets the value of the acctsObj property.
             * 
             * @return
             *     possible object is
             *     {@link DoService.CIS0367I01 .CISCustomer.AcctsObj }
             *     
             */
            public DoService.CIS0367I01 .CISCustomer.AcctsObj getAcctsObj() {
                return acctsObj;
            }

            /**
             * Sets the value of the acctsObj property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoService.CIS0367I01 .CISCustomer.AcctsObj }
             *     
             */
            public void setAcctsObj(DoService.CIS0367I01 .CISCustomer.AcctsObj value) {
                this.acctsObj = value;
            }

            /**
             * Gets the value of the brNo property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getBrNo() {
                return brNo;
            }

            /**
             * Sets the value of the brNo property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setBrNo(JAXBElement<String> value) {
                this.brNo = value;
            }

            /**
             * Gets the value of the docNum property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getDocNum() {
                return docNum;
            }

            /**
             * Sets the value of the docNum property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setDocNum(JAXBElement<String> value) {
                this.docNum = value;
            }

            /**
             * Gets the value of the docTypeCode property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getDocTypeCode() {
                return docTypeCode;
            }

            /**
             * Sets the value of the docTypeCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setDocTypeCode(JAXBElement<String> value) {
                this.docTypeCode = value;
            }

            /**
             * Gets the value of the num property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getNum() {
                return num;
            }

            /**
             * Sets the value of the num property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setNum(JAXBElement<String> value) {
                this.num = value;
            }

            /**
             * Gets the value of the prodCode property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getProdCode() {
                return prodCode;
            }

            /**
             * Sets the value of the prodCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setProdCode(JAXBElement<String> value) {
                this.prodCode = value;
            }

            /**
             * Gets the value of the rmTeamObj property.
             * 
             * @return
             *     possible object is
             *     {@link DoService.CIS0367I01 .CISCustomer.RMTeamObj }
             *     
             */
            public DoService.CIS0367I01 .CISCustomer.RMTeamObj getRMTeamObj() {
                return rmTeamObj;
            }

            /**
             * Sets the value of the rmTeamObj property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoService.CIS0367I01 .CISCustomer.RMTeamObj }
             *     
             */
            public void setRMTeamObj(DoService.CIS0367I01 .CISCustomer.RMTeamObj value) {
                this.rmTeamObj = value;
            }

            /**
             * Gets the value of the servicesObj property.
             * 
             * @return
             *     possible object is
             *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj }
             *     
             */
            public DoService.CIS0367I01 .CISCustomer.ServicesObj getServicesObj() {
                return servicesObj;
            }

            /**
             * Sets the value of the servicesObj property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj }
             *     
             */
            public void setServicesObj(DoService.CIS0367I01 .CISCustomer.ServicesObj value) {
                this.servicesObj = value;
            }

            /**
             * Gets the value of the thFstName property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getThFstName() {
                return thFstName;
            }

            /**
             * Sets the value of the thFstName property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setThFstName(JAXBElement<String> value) {
                this.thFstName = value;
            }

            /**
             * Gets the value of the thLstName property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getThLstName() {
                return thLstName;
            }

            /**
             * Sets the value of the thLstName property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setThLstName(JAXBElement<String> value) {
                this.thLstName = value;
            }

            /**
             * Gets the value of the typeCode property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getTypeCode() {
                return typeCode;
            }

            /**
             * Sets the value of the typeCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setTypeCode(JAXBElement<String> value) {
                this.typeCode = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="acctsVect" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="CISAccount" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
             *                           &lt;/sequence&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/complexContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "acctsVect"
            })
            public static class AcctsObj {

                protected DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect acctsVect;

                /**
                 * Gets the value of the acctsVect property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect }
                 *     
                 */
                public DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect getAcctsVect() {
                    return acctsVect;
                }

                /**
                 * Sets the value of the acctsVect property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect }
                 *     
                 */
                public void setAcctsVect(DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect value) {
                    this.acctsVect = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="CISAccount" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
                 *                 &lt;/sequence&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "cisAccount"
                })
                public static class AcctsVect {

                    @XmlElement(name = "CISAccount")
                    protected DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect.CISAccount cisAccount;

                    /**
                     * Gets the value of the cisAccount property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect.CISAccount }
                     *     
                     */
                    public DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect.CISAccount getCISAccount() {
                        return cisAccount;
                    }

                    /**
                     * Sets the value of the cisAccount property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect.CISAccount }
                     *     
                     */
                    public void setCISAccount(DoService.CIS0367I01 .CISCustomer.AcctsObj.AcctsVect.CISAccount value) {
                        this.cisAccount = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;complexContent&gt;
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *       &lt;sequence&gt;
                     *         &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
                     *       &lt;/sequence&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/complexContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "num"
                    })
                    public static class CISAccount {

                        @XmlElement(required = true, nillable = true)
                        protected String num;

                        /**
                         * Gets the value of the num property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getNum() {
                            return num;
                        }

                        /**
                         * Sets the value of the num property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setNum(String value) {
                            this.num = value;
                        }

                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="RMEmpObj" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="empNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength6" minOccurs="0"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "rmEmpObj"
            })
            public static class RMTeamObj {

                @XmlElement(name = "RMEmpObj")
                protected DoService.CIS0367I01 .CISCustomer.RMTeamObj.RMEmpObj rmEmpObj;

                /**
                 * Gets the value of the rmEmpObj property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link DoService.CIS0367I01 .CISCustomer.RMTeamObj.RMEmpObj }
                 *     
                 */
                public DoService.CIS0367I01 .CISCustomer.RMTeamObj.RMEmpObj getRMEmpObj() {
                    return rmEmpObj;
                }

                /**
                 * Sets the value of the rmEmpObj property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link DoService.CIS0367I01 .CISCustomer.RMTeamObj.RMEmpObj }
                 *     
                 */
                public void setRMEmpObj(DoService.CIS0367I01 .CISCustomer.RMTeamObj.RMEmpObj value) {
                    this.rmEmpObj = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="empNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength6" minOccurs="0"/&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "empNum"
                })
                public static class RMEmpObj {

                    @XmlElementRef(name = "empNum", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                    protected JAXBElement<String> empNum;

                    /**
                     * Gets the value of the empNum property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                     *     
                     */
                    public JAXBElement<String> getEmpNum() {
                        return empNum;
                    }

                    /**
                     * Sets the value of the empNum property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                     *     
                     */
                    public void setEmpNum(JAXBElement<String> value) {
                        this.empNum = value;
                    }

                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="servicesVect" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="CISEntities" maxOccurs="3" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="entitiesVect" minOccurs="0"&gt;
             *                               &lt;complexType&gt;
             *                                 &lt;complexContent&gt;
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                     &lt;sequence&gt;
             *                                       &lt;element name="CISATMEnty" minOccurs="0"&gt;
             *                                         &lt;complexType&gt;
             *                                           &lt;complexContent&gt;
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                               &lt;sequence&gt;
             *                                                 &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
             *                                               &lt;/sequence&gt;
             *                                             &lt;/restriction&gt;
             *                                           &lt;/complexContent&gt;
             *                                         &lt;/complexType&gt;
             *                                       &lt;/element&gt;
             *                                       &lt;element name="CISCrCardEnty" minOccurs="0"&gt;
             *                                         &lt;complexType&gt;
             *                                           &lt;complexContent&gt;
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                               &lt;sequence&gt;
             *                                                 &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
             *                                               &lt;/sequence&gt;
             *                                             &lt;/restriction&gt;
             *                                           &lt;/complexContent&gt;
             *                                         &lt;/complexType&gt;
             *                                       &lt;/element&gt;
             *                                       &lt;element name="CISLPMEnty" minOccurs="0"&gt;
             *                                         &lt;complexType&gt;
             *                                           &lt;complexContent&gt;
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                               &lt;sequence&gt;
             *                                                 &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
             *                                               &lt;/sequence&gt;
             *                                             &lt;/restriction&gt;
             *                                           &lt;/complexContent&gt;
             *                                         &lt;/complexType&gt;
             *                                       &lt;/element&gt;
             *                                     &lt;/sequence&gt;
             *                                   &lt;/restriction&gt;
             *                                 &lt;/complexContent&gt;
             *                               &lt;/complexType&gt;
             *                             &lt;/element&gt;
             *                           &lt;/sequence&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/complexContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "servicesVect"
            })
            public static class ServicesObj {

                protected DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect servicesVect;

                /**
                 * Gets the value of the servicesVect property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect }
                 *     
                 */
                public DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect getServicesVect() {
                    return servicesVect;
                }

                /**
                 * Sets the value of the servicesVect property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect }
                 *     
                 */
                public void setServicesVect(DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect value) {
                    this.servicesVect = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType&gt;
                 *   &lt;complexContent&gt;
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *       &lt;sequence&gt;
                 *         &lt;element name="CISEntities" maxOccurs="3" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="entitiesVect" minOccurs="0"&gt;
                 *                     &lt;complexType&gt;
                 *                       &lt;complexContent&gt;
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                           &lt;sequence&gt;
                 *                             &lt;element name="CISATMEnty" minOccurs="0"&gt;
                 *                               &lt;complexType&gt;
                 *                                 &lt;complexContent&gt;
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                     &lt;sequence&gt;
                 *                                       &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
                 *                                     &lt;/sequence&gt;
                 *                                   &lt;/restriction&gt;
                 *                                 &lt;/complexContent&gt;
                 *                               &lt;/complexType&gt;
                 *                             &lt;/element&gt;
                 *                             &lt;element name="CISCrCardEnty" minOccurs="0"&gt;
                 *                               &lt;complexType&gt;
                 *                                 &lt;complexContent&gt;
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                     &lt;sequence&gt;
                 *                                       &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
                 *                                     &lt;/sequence&gt;
                 *                                   &lt;/restriction&gt;
                 *                                 &lt;/complexContent&gt;
                 *                               &lt;/complexType&gt;
                 *                             &lt;/element&gt;
                 *                             &lt;element name="CISLPMEnty" minOccurs="0"&gt;
                 *                               &lt;complexType&gt;
                 *                                 &lt;complexContent&gt;
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                     &lt;sequence&gt;
                 *                                       &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
                 *                                     &lt;/sequence&gt;
                 *                                   &lt;/restriction&gt;
                 *                                 &lt;/complexContent&gt;
                 *                               &lt;/complexType&gt;
                 *                             &lt;/element&gt;
                 *                           &lt;/sequence&gt;
                 *                         &lt;/restriction&gt;
                 *                       &lt;/complexContent&gt;
                 *                     &lt;/complexType&gt;
                 *                   &lt;/element&gt;
                 *                 &lt;/sequence&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *       &lt;/sequence&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "cisEntities"
                })
                public static class ServicesVect {

                    @XmlElement(name = "CISEntities")
                    protected List<DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities> cisEntities;

                    /**
                     * Gets the value of the cisEntities property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the cisEntities property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getCISEntities().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities }
                     * 
                     * 
                     */
                    public List<DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities> getCISEntities() {
                        if (cisEntities == null) {
                            cisEntities = new ArrayList<DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities>();
                        }
                        return this.cisEntities;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     * 
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     * 
                     * <pre>
                     * &lt;complexType&gt;
                     *   &lt;complexContent&gt;
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *       &lt;sequence&gt;
                     *         &lt;element name="entitiesVect" minOccurs="0"&gt;
                     *           &lt;complexType&gt;
                     *             &lt;complexContent&gt;
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                 &lt;sequence&gt;
                     *                   &lt;element name="CISATMEnty" minOccurs="0"&gt;
                     *                     &lt;complexType&gt;
                     *                       &lt;complexContent&gt;
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                           &lt;sequence&gt;
                     *                             &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
                     *                           &lt;/sequence&gt;
                     *                         &lt;/restriction&gt;
                     *                       &lt;/complexContent&gt;
                     *                     &lt;/complexType&gt;
                     *                   &lt;/element&gt;
                     *                   &lt;element name="CISCrCardEnty" minOccurs="0"&gt;
                     *                     &lt;complexType&gt;
                     *                       &lt;complexContent&gt;
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                           &lt;sequence&gt;
                     *                             &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
                     *                           &lt;/sequence&gt;
                     *                         &lt;/restriction&gt;
                     *                       &lt;/complexContent&gt;
                     *                     &lt;/complexType&gt;
                     *                   &lt;/element&gt;
                     *                   &lt;element name="CISLPMEnty" minOccurs="0"&gt;
                     *                     &lt;complexType&gt;
                     *                       &lt;complexContent&gt;
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                           &lt;sequence&gt;
                     *                             &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
                     *                           &lt;/sequence&gt;
                     *                         &lt;/restriction&gt;
                     *                       &lt;/complexContent&gt;
                     *                     &lt;/complexType&gt;
                     *                   &lt;/element&gt;
                     *                 &lt;/sequence&gt;
                     *               &lt;/restriction&gt;
                     *             &lt;/complexContent&gt;
                     *           &lt;/complexType&gt;
                     *         &lt;/element&gt;
                     *       &lt;/sequence&gt;
                     *     &lt;/restriction&gt;
                     *   &lt;/complexContent&gt;
                     * &lt;/complexType&gt;
                     * </pre>
                     * 
                     * 
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "", propOrder = {
                        "entitiesVect"
                    })
                    public static class CISEntities {

                        protected DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect entitiesVect;

                        /**
                         * Gets the value of the entitiesVect property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect }
                         *     
                         */
                        public DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect getEntitiesVect() {
                            return entitiesVect;
                        }

                        /**
                         * Sets the value of the entitiesVect property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect }
                         *     
                         */
                        public void setEntitiesVect(DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect value) {
                            this.entitiesVect = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         * 
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         * 
                         * <pre>
                         * &lt;complexType&gt;
                         *   &lt;complexContent&gt;
                         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *       &lt;sequence&gt;
                         *         &lt;element name="CISATMEnty" minOccurs="0"&gt;
                         *           &lt;complexType&gt;
                         *             &lt;complexContent&gt;
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                 &lt;sequence&gt;
                         *                   &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
                         *                 &lt;/sequence&gt;
                         *               &lt;/restriction&gt;
                         *             &lt;/complexContent&gt;
                         *           &lt;/complexType&gt;
                         *         &lt;/element&gt;
                         *         &lt;element name="CISCrCardEnty" minOccurs="0"&gt;
                         *           &lt;complexType&gt;
                         *             &lt;complexContent&gt;
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                 &lt;sequence&gt;
                         *                   &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
                         *                 &lt;/sequence&gt;
                         *               &lt;/restriction&gt;
                         *             &lt;/complexContent&gt;
                         *           &lt;/complexType&gt;
                         *         &lt;/element&gt;
                         *         &lt;element name="CISLPMEnty" minOccurs="0"&gt;
                         *           &lt;complexType&gt;
                         *             &lt;complexContent&gt;
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                 &lt;sequence&gt;
                         *                   &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
                         *                 &lt;/sequence&gt;
                         *               &lt;/restriction&gt;
                         *             &lt;/complexContent&gt;
                         *           &lt;/complexType&gt;
                         *         &lt;/element&gt;
                         *       &lt;/sequence&gt;
                         *     &lt;/restriction&gt;
                         *   &lt;/complexContent&gt;
                         * &lt;/complexType&gt;
                         * </pre>
                         * 
                         * 
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = {
                            "cisatmEnty",
                            "cisCrCardEnty",
                            "cislpmEnty"
                        })
                        public static class EntitiesVect {

                            @XmlElement(name = "CISATMEnty")
                            protected DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISATMEnty cisatmEnty;
                            @XmlElement(name = "CISCrCardEnty")
                            protected DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISCrCardEnty cisCrCardEnty;
                            @XmlElement(name = "CISLPMEnty")
                            protected DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISLPMEnty cislpmEnty;

                            /**
                             * Gets the value of the cisatmEnty property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISATMEnty }
                             *     
                             */
                            public DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISATMEnty getCISATMEnty() {
                                return cisatmEnty;
                            }

                            /**
                             * Sets the value of the cisatmEnty property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISATMEnty }
                             *     
                             */
                            public void setCISATMEnty(DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISATMEnty value) {
                                this.cisatmEnty = value;
                            }

                            /**
                             * Gets the value of the cisCrCardEnty property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISCrCardEnty }
                             *     
                             */
                            public DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISCrCardEnty getCISCrCardEnty() {
                                return cisCrCardEnty;
                            }

                            /**
                             * Sets the value of the cisCrCardEnty property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISCrCardEnty }
                             *     
                             */
                            public void setCISCrCardEnty(DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISCrCardEnty value) {
                                this.cisCrCardEnty = value;
                            }

                            /**
                             * Gets the value of the cislpmEnty property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISLPMEnty }
                             *     
                             */
                            public DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISLPMEnty getCISLPMEnty() {
                                return cislpmEnty;
                            }

                            /**
                             * Sets the value of the cislpmEnty property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISLPMEnty }
                             *     
                             */
                            public void setCISLPMEnty(DoService.CIS0367I01 .CISCustomer.ServicesObj.ServicesVect.CISEntities.EntitiesVect.CISLPMEnty value) {
                                this.cislpmEnty = value;
                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType&gt;
                             *   &lt;complexContent&gt;
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *       &lt;sequence&gt;
                             *         &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
                             *       &lt;/sequence&gt;
                             *     &lt;/restriction&gt;
                             *   &lt;/complexContent&gt;
                             * &lt;/complexType&gt;
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "num"
                            })
                            public static class CISATMEnty {

                                @XmlElementRef(name = "num", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                                protected JAXBElement<String> num;

                                /**
                                 * Gets the value of the num property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                 *     
                                 */
                                public JAXBElement<String> getNum() {
                                    return num;
                                }

                                /**
                                 * Sets the value of the num property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                 *     
                                 */
                                public void setNum(JAXBElement<String> value) {
                                    this.num = value;
                                }

                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType&gt;
                             *   &lt;complexContent&gt;
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *       &lt;sequence&gt;
                             *         &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength16" minOccurs="0"/&gt;
                             *       &lt;/sequence&gt;
                             *     &lt;/restriction&gt;
                             *   &lt;/complexContent&gt;
                             * &lt;/complexType&gt;
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "num"
                            })
                            public static class CISCrCardEnty {

                                @XmlElementRef(name = "num", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                                protected JAXBElement<String> num;

                                /**
                                 * Gets the value of the num property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                 *     
                                 */
                                public JAXBElement<String> getNum() {
                                    return num;
                                }

                                /**
                                 * Sets the value of the num property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                 *     
                                 */
                                public void setNum(JAXBElement<String> value) {
                                    this.num = value;
                                }

                            }


                            /**
                             * <p>Java class for anonymous complex type.
                             * 
                             * <p>The following schema fragment specifies the expected content contained within this class.
                             * 
                             * <pre>
                             * &lt;complexType&gt;
                             *   &lt;complexContent&gt;
                             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *       &lt;sequence&gt;
                             *         &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
                             *       &lt;/sequence&gt;
                             *     &lt;/restriction&gt;
                             *   &lt;/complexContent&gt;
                             * &lt;/complexType&gt;
                             * </pre>
                             * 
                             * 
                             */
                            @XmlAccessorType(XmlAccessType.FIELD)
                            @XmlType(name = "", propOrder = {
                                "num"
                            })
                            public static class CISLPMEnty {

                                @XmlElementRef(name = "num", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                                protected JAXBElement<String> num;

                                /**
                                 * Gets the value of the num property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                 *     
                                 */
                                public JAXBElement<String> getNum() {
                                    return num;
                                }

                                /**
                                 * Sets the value of the num property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                 *     
                                 */
                                public void setNum(JAXBElement<String> value) {
                                    this.num = value;
                                }

                            }

                        }

                    }

                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="dirCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
         *         &lt;element name="fstKeyNum" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
         *                   &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
         *                   &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="lstKeyNum" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
         *                   &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
         *                   &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dirCode",
            "fstKeyNum",
            "lstKeyNum"
        })
        public static class CISNavCntrl {

            @XmlElementRef(name = "dirCode", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> dirCode;
            protected DoService.CIS0367I01 .CISNavCntrl.FstKeyNum fstKeyNum;
            protected DoService.CIS0367I01 .CISNavCntrl.LstKeyNum lstKeyNum;

            /**
             * Gets the value of the dirCode property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getDirCode() {
                return dirCode;
            }

            /**
             * Sets the value of the dirCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setDirCode(JAXBElement<String> value) {
                this.dirCode = value;
            }

            /**
             * Gets the value of the fstKeyNum property.
             * 
             * @return
             *     possible object is
             *     {@link DoService.CIS0367I01 .CISNavCntrl.FstKeyNum }
             *     
             */
            public DoService.CIS0367I01 .CISNavCntrl.FstKeyNum getFstKeyNum() {
                return fstKeyNum;
            }

            /**
             * Sets the value of the fstKeyNum property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoService.CIS0367I01 .CISNavCntrl.FstKeyNum }
             *     
             */
            public void setFstKeyNum(DoService.CIS0367I01 .CISNavCntrl.FstKeyNum value) {
                this.fstKeyNum = value;
            }

            /**
             * Gets the value of the lstKeyNum property.
             * 
             * @return
             *     possible object is
             *     {@link DoService.CIS0367I01 .CISNavCntrl.LstKeyNum }
             *     
             */
            public DoService.CIS0367I01 .CISNavCntrl.LstKeyNum getLstKeyNum() {
                return lstKeyNum;
            }

            /**
             * Sets the value of the lstKeyNum property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoService.CIS0367I01 .CISNavCntrl.LstKeyNum }
             *     
             */
            public void setLstKeyNum(DoService.CIS0367I01 .CISNavCntrl.LstKeyNum value) {
                this.lstKeyNum = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
             *         &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
             *         &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "custNum",
                "thFstName",
                "thLstName"
            })
            public static class FstKeyNum {

                @XmlElementRef(name = "custNum", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> custNum;
                @XmlElementRef(name = "thFstName", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> thFstName;
                @XmlElementRef(name = "thLstName", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> thLstName;

                /**
                 * Gets the value of the custNum property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public JAXBElement<String> getCustNum() {
                    return custNum;
                }

                /**
                 * Sets the value of the custNum property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public void setCustNum(JAXBElement<String> value) {
                    this.custNum = value;
                }

                /**
                 * Gets the value of the thFstName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public JAXBElement<String> getThFstName() {
                    return thFstName;
                }

                /**
                 * Sets the value of the thFstName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public void setThFstName(JAXBElement<String> value) {
                    this.thFstName = value;
                }

                /**
                 * Gets the value of the thLstName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public JAXBElement<String> getThLstName() {
                    return thLstName;
                }

                /**
                 * Sets the value of the thLstName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public void setThLstName(JAXBElement<String> value) {
                    this.thLstName = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
             *         &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
             *         &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "custNum",
                "thFstName",
                "thLstName"
            })
            public static class LstKeyNum {

                @XmlElementRef(name = "custNum", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> custNum;
                @XmlElementRef(name = "thFstName", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> thFstName;
                @XmlElementRef(name = "thLstName", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> thLstName;

                /**
                 * Gets the value of the custNum property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public JAXBElement<String> getCustNum() {
                    return custNum;
                }

                /**
                 * Sets the value of the custNum property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public void setCustNum(JAXBElement<String> value) {
                    this.custNum = value;
                }

                /**
                 * Gets the value of the thFstName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public JAXBElement<String> getThFstName() {
                    return thFstName;
                }

                /**
                 * Sets the value of the thFstName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public void setThFstName(JAXBElement<String> value) {
                    this.thFstName = value;
                }

                /**
                 * Gets the value of the thLstName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public JAXBElement<String> getThLstName() {
                    return thLstName;
                }

                /**
                 * Sets the value of the thLstName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public void setThLstName(JAXBElement<String> value) {
                    this.thLstName = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="serviceId" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength12"/&gt;
         *         &lt;element name="beginTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *         &lt;element name="endTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
         *         &lt;element name="transactionId" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength32" minOccurs="0"/&gt;
         *         &lt;element name="sourceTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="sourceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="status" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength1" minOccurs="0"/&gt;
         *         &lt;element name="reasonCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength5" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "serviceId",
            "beginTimestamp",
            "endTimestamp",
            "transactionId",
            "sourceTransactionId",
            "sourceSystem",
            "userId",
            "password",
            "status",
            "reasonCode"
        })
        public static class EAIHeader {

            @XmlElement(required = true, nillable = true)
            protected String serviceId;
            @XmlElement(required = true, nillable = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar beginTimestamp;
            @XmlElementRef(name = "endTimestamp", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<XMLGregorianCalendar> endTimestamp;
            @XmlElementRef(name = "transactionId", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> transactionId;
            @XmlElementRef(name = "sourceTransactionId", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> sourceTransactionId;
            @XmlElement(required = true, nillable = true)
            protected String sourceSystem;
            @XmlElementRef(name = "userId", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> userId;
            @XmlElementRef(name = "password", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> password;
            @XmlElementRef(name = "status", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<Integer> status;
            @XmlElementRef(name = "reasonCode", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<Integer> reasonCode;

            /**
             * Gets the value of the serviceId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getServiceId() {
                return serviceId;
            }

            /**
             * Sets the value of the serviceId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setServiceId(String value) {
                this.serviceId = value;
            }

            /**
             * Gets the value of the beginTimestamp property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getBeginTimestamp() {
                return beginTimestamp;
            }

            /**
             * Sets the value of the beginTimestamp property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setBeginTimestamp(XMLGregorianCalendar value) {
                this.beginTimestamp = value;
            }

            /**
             * Gets the value of the endTimestamp property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
             *     
             */
            public JAXBElement<XMLGregorianCalendar> getEndTimestamp() {
                return endTimestamp;
            }

            /**
             * Sets the value of the endTimestamp property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
             *     
             */
            public void setEndTimestamp(JAXBElement<XMLGregorianCalendar> value) {
                this.endTimestamp = value;
            }

            /**
             * Gets the value of the transactionId property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getTransactionId() {
                return transactionId;
            }

            /**
             * Sets the value of the transactionId property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setTransactionId(JAXBElement<String> value) {
                this.transactionId = value;
            }

            /**
             * Gets the value of the sourceTransactionId property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getSourceTransactionId() {
                return sourceTransactionId;
            }

            /**
             * Sets the value of the sourceTransactionId property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setSourceTransactionId(JAXBElement<String> value) {
                this.sourceTransactionId = value;
            }

            /**
             * Gets the value of the sourceSystem property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSourceSystem() {
                return sourceSystem;
            }

            /**
             * Sets the value of the sourceSystem property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSourceSystem(String value) {
                this.sourceSystem = value;
            }

            /**
             * Gets the value of the userId property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getUserId() {
                return userId;
            }

            /**
             * Sets the value of the userId property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setUserId(JAXBElement<String> value) {
                this.userId = value;
            }

            /**
             * Gets the value of the password property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getPassword() {
                return password;
            }

            /**
             * Sets the value of the password property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setPassword(JAXBElement<String> value) {
                this.password = value;
            }

            /**
             * Gets the value of the status property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
             *     
             */
            public JAXBElement<Integer> getStatus() {
                return status;
            }

            /**
             * Sets the value of the status property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
             *     
             */
            public void setStatus(JAXBElement<Integer> value) {
                this.status = value;
            }

            /**
             * Gets the value of the reasonCode property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
             *     
             */
            public JAXBElement<Integer> getReasonCode() {
                return reasonCode;
            }

            /**
             * Sets the value of the reasonCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
             *     
             */
            public void setReasonCode(JAXBElement<Integer> value) {
                this.reasonCode = value;
            }

        }

    }

}
