
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
 * <p>Java class for doServiceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="doServiceResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CIS0367I01Response"&gt;
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
 *                             &lt;element name="endTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                             &lt;element name="transactionId" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength32"/&gt;
 *                             &lt;element name="sourceTransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="sourceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="status" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength1"/&gt;
 *                             &lt;element name="reasonCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength5"/&gt;
 *                             &lt;element name="reasonDesc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
 *                             &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
 *                             &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
 *                             &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CISCustomers" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="CISCustsVect" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="CISCustomer" maxOccurs="20" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="brthDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                                 &lt;element name="chgNameFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
 *                                                 &lt;element name="coAcctRelationObj" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="ownerFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="CVRSInfoObj" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="regulsObj" minOccurs="0"&gt;
 *                                                             &lt;complexType&gt;
 *                                                               &lt;complexContent&gt;
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                   &lt;sequence&gt;
 *                                                                     &lt;element name="regulsVect" minOccurs="0"&gt;
 *                                                                       &lt;complexType&gt;
 *                                                                         &lt;complexContent&gt;
 *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                             &lt;sequence&gt;
 *                                                                               &lt;element name="CVRSRegulation" minOccurs="0"&gt;
 *                                                                                 &lt;complexType&gt;
 *                                                                                   &lt;complexContent&gt;
 *                                                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                                       &lt;sequence&gt;
 *                                                                                         &lt;element name="actCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
 *                                                                                         &lt;element name="actDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
 *                                                                                         &lt;element name="rankCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength3" minOccurs="0"/&gt;
 *                                                                                         &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
 *                                                                                         &lt;element name="subTypCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
 *                                                                                       &lt;/sequence&gt;
 *                                                                                     &lt;/restriction&gt;
 *                                                                                   &lt;/complexContent&gt;
 *                                                                                 &lt;/complexType&gt;
 *                                                                               &lt;/element&gt;
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
 *                                                 &lt;element name="docNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength15"/&gt;
 *                                                 &lt;element name="docTypeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2"/&gt;
 *                                                 &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
 *                                                 &lt;element name="prospectFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
 *                                                 &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120"/&gt;
 *                                                 &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
 *                                                 &lt;element name="thMidName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength60" minOccurs="0"/&gt;
 *                                                 &lt;element name="thTitle" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength20" minOccurs="0"/&gt;
 *                                                 &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
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
 *                             &lt;element name="totCustCnt" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength5"/&gt;
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
 *                             &lt;element name="fstKeyNum" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
 *                                       &lt;element name="terminateFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
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
 *                                       &lt;element name="terminateFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
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
@XmlType(name = "doServiceResponse", propOrder = {
    "cis0367I01Response"
})
public class DoServiceResponse {

    @XmlElement(name = "CIS0367I01Response", required = true)
    protected DoServiceResponse.CIS0367I01Response cis0367I01Response;

    /**
     * Gets the value of the cis0367I01Response property.
     * 
     * @return
     *     possible object is
     *     {@link DoServiceResponse.CIS0367I01Response }
     *     
     */
    public DoServiceResponse.CIS0367I01Response getCIS0367I01Response() {
        return cis0367I01Response;
    }

    /**
     * Sets the value of the cis0367I01Response property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoServiceResponse.CIS0367I01Response }
     *     
     */
    public void setCIS0367I01Response(DoServiceResponse.CIS0367I01Response value) {
        this.cis0367I01Response = value;
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
     *                   &lt;element name="endTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                   &lt;element name="transactionId" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength32"/&gt;
     *                   &lt;element name="sourceTransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="sourceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="status" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength1"/&gt;
     *                   &lt;element name="reasonCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength5"/&gt;
     *                   &lt;element name="reasonDesc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
     *                   &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120" minOccurs="0"/&gt;
     *                   &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
     *                   &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CISCustomers" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="CISCustsVect" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="CISCustomer" maxOccurs="20" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="brthDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                                       &lt;element name="chgNameFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
     *                                       &lt;element name="coAcctRelationObj" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="ownerFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="CVRSInfoObj" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="regulsObj" minOccurs="0"&gt;
     *                                                   &lt;complexType&gt;
     *                                                     &lt;complexContent&gt;
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                         &lt;sequence&gt;
     *                                                           &lt;element name="regulsVect" minOccurs="0"&gt;
     *                                                             &lt;complexType&gt;
     *                                                               &lt;complexContent&gt;
     *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                   &lt;sequence&gt;
     *                                                                     &lt;element name="CVRSRegulation" minOccurs="0"&gt;
     *                                                                       &lt;complexType&gt;
     *                                                                         &lt;complexContent&gt;
     *                                                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                                             &lt;sequence&gt;
     *                                                                               &lt;element name="actCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
     *                                                                               &lt;element name="actDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
     *                                                                               &lt;element name="rankCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength3" minOccurs="0"/&gt;
     *                                                                               &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
     *                                                                               &lt;element name="subTypCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
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
     *                                       &lt;element name="docNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength15"/&gt;
     *                                       &lt;element name="docTypeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2"/&gt;
     *                                       &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
     *                                       &lt;element name="prospectFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
     *                                       &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120"/&gt;
     *                                       &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
     *                                       &lt;element name="thMidName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength60" minOccurs="0"/&gt;
     *                                       &lt;element name="thTitle" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength20" minOccurs="0"/&gt;
     *                                       &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
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
     *                   &lt;element name="totCustCnt" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength5"/&gt;
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
     *                   &lt;element name="fstKeyNum" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
     *                             &lt;element name="terminateFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
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
     *                             &lt;element name="terminateFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
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
        "cisCustomers",
        "cisNavCntrl"
    })
    @XmlRootElement(name = "CIS0367I01Response")
    public static class CIS0367I01Response {

        @XmlElement(name = "EAIHeader", required = true)
        protected DoServiceResponse.CIS0367I01Response.EAIHeader eaiHeader;
        @XmlElement(name = "CISCustomer")
        protected DoServiceResponse.CIS0367I01Response.CISCustomer cisCustomer;
        @XmlElement(name = "CISCustomers")
        protected DoServiceResponse.CIS0367I01Response.CISCustomers cisCustomers;
        @XmlElement(name = "CISNavCntrl")
        protected DoServiceResponse.CIS0367I01Response.CISNavCntrl cisNavCntrl;

        /**
         * Gets the value of the eaiHeader property.
         * 
         * @return
         *     possible object is
         *     {@link DoServiceResponse.CIS0367I01Response.EAIHeader }
         *     
         */
        public DoServiceResponse.CIS0367I01Response.EAIHeader getEAIHeader() {
            return eaiHeader;
        }

        /**
         * Sets the value of the eaiHeader property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoServiceResponse.CIS0367I01Response.EAIHeader }
         *     
         */
        public void setEAIHeader(DoServiceResponse.CIS0367I01Response.EAIHeader value) {
            this.eaiHeader = value;
        }

        /**
         * Gets the value of the cisCustomer property.
         * 
         * @return
         *     possible object is
         *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer }
         *     
         */
        public DoServiceResponse.CIS0367I01Response.CISCustomer getCISCustomer() {
            return cisCustomer;
        }

        /**
         * Sets the value of the cisCustomer property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer }
         *     
         */
        public void setCISCustomer(DoServiceResponse.CIS0367I01Response.CISCustomer value) {
            this.cisCustomer = value;
        }

        /**
         * Gets the value of the cisCustomers property.
         * 
         * @return
         *     possible object is
         *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers }
         *     
         */
        public DoServiceResponse.CIS0367I01Response.CISCustomers getCISCustomers() {
            return cisCustomers;
        }

        /**
         * Sets the value of the cisCustomers property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers }
         *     
         */
        public void setCISCustomers(DoServiceResponse.CIS0367I01Response.CISCustomers value) {
            this.cisCustomers = value;
        }

        /**
         * Gets the value of the cisNavCntrl property.
         * 
         * @return
         *     possible object is
         *     {@link DoServiceResponse.CIS0367I01Response.CISNavCntrl }
         *     
         */
        public DoServiceResponse.CIS0367I01Response.CISNavCntrl getCISNavCntrl() {
            return cisNavCntrl;
        }

        /**
         * Sets the value of the cisNavCntrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoServiceResponse.CIS0367I01Response.CISNavCntrl }
         *     
         */
        public void setCISNavCntrl(DoServiceResponse.CIS0367I01Response.CISNavCntrl value) {
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
            "rmTeamObj",
            "thFstName",
            "thLstName",
            "typeCode"
        })
        public static class CISCustomer {

            protected DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj acctsObj;
            @XmlElement(name = "RMTeamObj")
            protected DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj rmTeamObj;
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
             *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj }
             *     
             */
            public DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj getAcctsObj() {
                return acctsObj;
            }

            /**
             * Sets the value of the acctsObj property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj }
             *     
             */
            public void setAcctsObj(DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj value) {
                this.acctsObj = value;
            }

            /**
             * Gets the value of the rmTeamObj property.
             * 
             * @return
             *     possible object is
             *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj }
             *     
             */
            public DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj getRMTeamObj() {
                return rmTeamObj;
            }

            /**
             * Sets the value of the rmTeamObj property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj }
             *     
             */
            public void setRMTeamObj(DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj value) {
                this.rmTeamObj = value;
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
                "acctsVect"
            })
            public static class AcctsObj {

                protected DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect acctsVect;

                /**
                 * Gets the value of the acctsVect property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect }
                 *     
                 */
                public DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect getAcctsVect() {
                    return acctsVect;
                }

                /**
                 * Sets the value of the acctsVect property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect }
                 *     
                 */
                public void setAcctsVect(DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect value) {
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
                    "cisAccount"
                })
                public static class AcctsVect {

                    @XmlElement(name = "CISAccount")
                    protected DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect.CISAccount cisAccount;

                    /**
                     * Gets the value of the cisAccount property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect.CISAccount }
                     *     
                     */
                    public DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect.CISAccount getCISAccount() {
                        return cisAccount;
                    }

                    /**
                     * Sets the value of the cisAccount property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect.CISAccount }
                     *     
                     */
                    public void setCISAccount(DoServiceResponse.CIS0367I01Response.CISCustomer.AcctsObj.AcctsVect.CISAccount value) {
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
                    public static class CISAccount {

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
                protected DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj.RMEmpObj rmEmpObj;

                /**
                 * Gets the value of the rmEmpObj property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj.RMEmpObj }
                 *     
                 */
                public DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj.RMEmpObj getRMEmpObj() {
                    return rmEmpObj;
                }

                /**
                 * Sets the value of the rmEmpObj property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj.RMEmpObj }
                 *     
                 */
                public void setRMEmpObj(DoServiceResponse.CIS0367I01Response.CISCustomer.RMTeamObj.RMEmpObj value) {
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
         *         &lt;element name="CISCustsVect" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="CISCustomer" maxOccurs="20" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="brthDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                             &lt;element name="chgNameFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
         *                             &lt;element name="coAcctRelationObj" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="ownerFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
         *                                     &lt;/sequence&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="CVRSInfoObj" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="regulsObj" minOccurs="0"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;complexContent&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                               &lt;sequence&gt;
         *                                                 &lt;element name="regulsVect" minOccurs="0"&gt;
         *                                                   &lt;complexType&gt;
         *                                                     &lt;complexContent&gt;
         *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                         &lt;sequence&gt;
         *                                                           &lt;element name="CVRSRegulation" minOccurs="0"&gt;
         *                                                             &lt;complexType&gt;
         *                                                               &lt;complexContent&gt;
         *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                                   &lt;sequence&gt;
         *                                                                     &lt;element name="actCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
         *                                                                     &lt;element name="actDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
         *                                                                     &lt;element name="rankCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength3" minOccurs="0"/&gt;
         *                                                                     &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
         *                                                                     &lt;element name="subTypCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
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
         *                             &lt;element name="docNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength15"/&gt;
         *                             &lt;element name="docTypeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2"/&gt;
         *                             &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
         *                             &lt;element name="prospectFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
         *                             &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120"/&gt;
         *                             &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
         *                             &lt;element name="thMidName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength60" minOccurs="0"/&gt;
         *                             &lt;element name="thTitle" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength20" minOccurs="0"/&gt;
         *                             &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
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
         *         &lt;element name="totCustCnt" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength5"/&gt;
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
            "cisCustsVect",
            "totCustCnt"
        })
        public static class CISCustomers {

            @XmlElement(name = "CISCustsVect")
            protected DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect cisCustsVect;
            @XmlElement(required = true, type = Integer.class, nillable = true)
            protected Integer totCustCnt;

            /**
             * Gets the value of the cisCustsVect property.
             * 
             * @return
             *     possible object is
             *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect }
             *     
             */
            public DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect getCISCustsVect() {
                return cisCustsVect;
            }

            /**
             * Sets the value of the cisCustsVect property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect }
             *     
             */
            public void setCISCustsVect(DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect value) {
                this.cisCustsVect = value;
            }

            /**
             * Gets the value of the totCustCnt property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getTotCustCnt() {
                return totCustCnt;
            }

            /**
             * Sets the value of the totCustCnt property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setTotCustCnt(Integer value) {
                this.totCustCnt = value;
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
             *         &lt;element name="CISCustomer" maxOccurs="20" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="brthDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *                   &lt;element name="chgNameFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
             *                   &lt;element name="coAcctRelationObj" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="ownerFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
             *                           &lt;/sequence&gt;
             *                         &lt;/restriction&gt;
             *                       &lt;/complexContent&gt;
             *                     &lt;/complexType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="CVRSInfoObj" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="regulsObj" minOccurs="0"&gt;
             *                               &lt;complexType&gt;
             *                                 &lt;complexContent&gt;
             *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                     &lt;sequence&gt;
             *                                       &lt;element name="regulsVect" minOccurs="0"&gt;
             *                                         &lt;complexType&gt;
             *                                           &lt;complexContent&gt;
             *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                               &lt;sequence&gt;
             *                                                 &lt;element name="CVRSRegulation" minOccurs="0"&gt;
             *                                                   &lt;complexType&gt;
             *                                                     &lt;complexContent&gt;
             *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                                                         &lt;sequence&gt;
             *                                                           &lt;element name="actCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
             *                                                           &lt;element name="actDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
             *                                                           &lt;element name="rankCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength3" minOccurs="0"/&gt;
             *                                                           &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
             *                                                           &lt;element name="subTypCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
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
             *                   &lt;element name="docNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength15"/&gt;
             *                   &lt;element name="docTypeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2"/&gt;
             *                   &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
             *                   &lt;element name="prospectFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
             *                   &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120"/&gt;
             *                   &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
             *                   &lt;element name="thMidName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength60" minOccurs="0"/&gt;
             *                   &lt;element name="thTitle" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength20" minOccurs="0"/&gt;
             *                   &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
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
                "cisCustomer"
            })
            public static class CISCustsVect {

                @XmlElement(name = "CISCustomer")
                protected List<DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer> cisCustomer;

                /**
                 * Gets the value of the cisCustomer property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the cisCustomer property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getCISCustomer().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer }
                 * 
                 * 
                 */
                public List<DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer> getCISCustomer() {
                    if (cisCustomer == null) {
                        cisCustomer = new ArrayList<DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer>();
                    }
                    return this.cisCustomer;
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
                 *         &lt;element name="brthDate" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
                 *         &lt;element name="chgNameFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
                 *         &lt;element name="coAcctRelationObj" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="ownerFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
                 *                 &lt;/sequence&gt;
                 *               &lt;/restriction&gt;
                 *             &lt;/complexContent&gt;
                 *           &lt;/complexType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="CVRSInfoObj" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="regulsObj" minOccurs="0"&gt;
                 *                     &lt;complexType&gt;
                 *                       &lt;complexContent&gt;
                 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                           &lt;sequence&gt;
                 *                             &lt;element name="regulsVect" minOccurs="0"&gt;
                 *                               &lt;complexType&gt;
                 *                                 &lt;complexContent&gt;
                 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                     &lt;sequence&gt;
                 *                                       &lt;element name="CVRSRegulation" minOccurs="0"&gt;
                 *                                         &lt;complexType&gt;
                 *                                           &lt;complexContent&gt;
                 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                                               &lt;sequence&gt;
                 *                                                 &lt;element name="actCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                 *                                                 &lt;element name="actDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
                 *                                                 &lt;element name="rankCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength3" minOccurs="0"/&gt;
                 *                                                 &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                 *                                                 &lt;element name="subTypCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
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
                 *         &lt;element name="docNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength15"/&gt;
                 *         &lt;element name="docTypeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2"/&gt;
                 *         &lt;element name="num" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10"/&gt;
                 *         &lt;element name="prospectFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
                 *         &lt;element name="thFstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength120"/&gt;
                 *         &lt;element name="thLstName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
                 *         &lt;element name="thMidName" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength60" minOccurs="0"/&gt;
                 *         &lt;element name="thTitle" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength20" minOccurs="0"/&gt;
                 *         &lt;element name="typeCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
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
                    "brthDate",
                    "chgNameFlag",
                    "coAcctRelationObj",
                    "cvrsInfoObj",
                    "docNum",
                    "docTypeCode",
                    "num",
                    "prospectFlag",
                    "thFstName",
                    "thLstName",
                    "thMidName",
                    "thTitle",
                    "typeCode"
                })
                public static class CISCustomer {

                    @XmlElement(required = true, nillable = true)
                    @XmlSchemaType(name = "date")
                    protected XMLGregorianCalendar brthDate;
                    @XmlElement(required = true, nillable = true)
                    protected String chgNameFlag;
                    protected DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CoAcctRelationObj coAcctRelationObj;
                    @XmlElement(name = "CVRSInfoObj")
                    protected DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj cvrsInfoObj;
                    @XmlElement(required = true, nillable = true)
                    protected String docNum;
                    @XmlElement(required = true, nillable = true)
                    protected String docTypeCode;
                    @XmlElement(required = true, nillable = true)
                    protected String num;
                    @XmlElement(required = true, nillable = true)
                    protected String prospectFlag;
                    @XmlElement(required = true, nillable = true)
                    protected String thFstName;
                    @XmlElementRef(name = "thLstName", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                    protected JAXBElement<String> thLstName;
                    @XmlElementRef(name = "thMidName", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                    protected JAXBElement<String> thMidName;
                    @XmlElementRef(name = "thTitle", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                    protected JAXBElement<String> thTitle;
                    @XmlElement(required = true, nillable = true)
                    protected String typeCode;

                    /**
                     * Gets the value of the brthDate property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public XMLGregorianCalendar getBrthDate() {
                        return brthDate;
                    }

                    /**
                     * Sets the value of the brthDate property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public void setBrthDate(XMLGregorianCalendar value) {
                        this.brthDate = value;
                    }

                    /**
                     * Gets the value of the chgNameFlag property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getChgNameFlag() {
                        return chgNameFlag;
                    }

                    /**
                     * Sets the value of the chgNameFlag property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setChgNameFlag(String value) {
                        this.chgNameFlag = value;
                    }

                    /**
                     * Gets the value of the coAcctRelationObj property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CoAcctRelationObj }
                     *     
                     */
                    public DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CoAcctRelationObj getCoAcctRelationObj() {
                        return coAcctRelationObj;
                    }

                    /**
                     * Sets the value of the coAcctRelationObj property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CoAcctRelationObj }
                     *     
                     */
                    public void setCoAcctRelationObj(DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CoAcctRelationObj value) {
                        this.coAcctRelationObj = value;
                    }

                    /**
                     * Gets the value of the cvrsInfoObj property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj }
                     *     
                     */
                    public DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj getCVRSInfoObj() {
                        return cvrsInfoObj;
                    }

                    /**
                     * Sets the value of the cvrsInfoObj property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj }
                     *     
                     */
                    public void setCVRSInfoObj(DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj value) {
                        this.cvrsInfoObj = value;
                    }

                    /**
                     * Gets the value of the docNum property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDocNum() {
                        return docNum;
                    }

                    /**
                     * Sets the value of the docNum property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDocNum(String value) {
                        this.docNum = value;
                    }

                    /**
                     * Gets the value of the docTypeCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDocTypeCode() {
                        return docTypeCode;
                    }

                    /**
                     * Sets the value of the docTypeCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDocTypeCode(String value) {
                        this.docTypeCode = value;
                    }

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

                    /**
                     * Gets the value of the prospectFlag property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getProspectFlag() {
                        return prospectFlag;
                    }

                    /**
                     * Sets the value of the prospectFlag property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setProspectFlag(String value) {
                        this.prospectFlag = value;
                    }

                    /**
                     * Gets the value of the thFstName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getThFstName() {
                        return thFstName;
                    }

                    /**
                     * Sets the value of the thFstName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setThFstName(String value) {
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
                     * Gets the value of the thMidName property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                     *     
                     */
                    public JAXBElement<String> getThMidName() {
                        return thMidName;
                    }

                    /**
                     * Sets the value of the thMidName property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                     *     
                     */
                    public void setThMidName(JAXBElement<String> value) {
                        this.thMidName = value;
                    }

                    /**
                     * Gets the value of the thTitle property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                     *     
                     */
                    public JAXBElement<String> getThTitle() {
                        return thTitle;
                    }

                    /**
                     * Sets the value of the thTitle property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                     *     
                     */
                    public void setThTitle(JAXBElement<String> value) {
                        this.thTitle = value;
                    }

                    /**
                     * Gets the value of the typeCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTypeCode() {
                        return typeCode;
                    }

                    /**
                     * Sets the value of the typeCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTypeCode(String value) {
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
                     *         &lt;element name="regulsObj" minOccurs="0"&gt;
                     *           &lt;complexType&gt;
                     *             &lt;complexContent&gt;
                     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                 &lt;sequence&gt;
                     *                   &lt;element name="regulsVect" minOccurs="0"&gt;
                     *                     &lt;complexType&gt;
                     *                       &lt;complexContent&gt;
                     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                           &lt;sequence&gt;
                     *                             &lt;element name="CVRSRegulation" minOccurs="0"&gt;
                     *                               &lt;complexType&gt;
                     *                                 &lt;complexContent&gt;
                     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                     *                                     &lt;sequence&gt;
                     *                                       &lt;element name="actCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                     *                                       &lt;element name="actDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
                     *                                       &lt;element name="rankCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength3" minOccurs="0"/&gt;
                     *                                       &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                     *                                       &lt;element name="subTypCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
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
                        "regulsObj"
                    })
                    public static class CVRSInfoObj {

                        protected DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj regulsObj;

                        /**
                         * Gets the value of the regulsObj property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj }
                         *     
                         */
                        public DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj getRegulsObj() {
                            return regulsObj;
                        }

                        /**
                         * Sets the value of the regulsObj property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj }
                         *     
                         */
                        public void setRegulsObj(DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj value) {
                            this.regulsObj = value;
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
                         *         &lt;element name="regulsVect" minOccurs="0"&gt;
                         *           &lt;complexType&gt;
                         *             &lt;complexContent&gt;
                         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                 &lt;sequence&gt;
                         *                   &lt;element name="CVRSRegulation" minOccurs="0"&gt;
                         *                     &lt;complexType&gt;
                         *                       &lt;complexContent&gt;
                         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                         *                           &lt;sequence&gt;
                         *                             &lt;element name="actCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                         *                             &lt;element name="actDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
                         *                             &lt;element name="rankCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength3" minOccurs="0"/&gt;
                         *                             &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                         *                             &lt;element name="subTypCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
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
                            "regulsVect"
                        })
                        public static class RegulsObj {

                            protected DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect regulsVect;

                            /**
                             * Gets the value of the regulsVect property.
                             * 
                             * @return
                             *     possible object is
                             *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect }
                             *     
                             */
                            public DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect getRegulsVect() {
                                return regulsVect;
                            }

                            /**
                             * Sets the value of the regulsVect property.
                             * 
                             * @param value
                             *     allowed object is
                             *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect }
                             *     
                             */
                            public void setRegulsVect(DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect value) {
                                this.regulsVect = value;
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
                             *         &lt;element name="CVRSRegulation" minOccurs="0"&gt;
                             *           &lt;complexType&gt;
                             *             &lt;complexContent&gt;
                             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                             *                 &lt;sequence&gt;
                             *                   &lt;element name="actCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                             *                   &lt;element name="actDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
                             *                   &lt;element name="rankCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength3" minOccurs="0"/&gt;
                             *                   &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                             *                   &lt;element name="subTypCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
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
                                "cvrsRegulation"
                            })
                            public static class RegulsVect {

                                @XmlElement(name = "CVRSRegulation")
                                protected DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect.CVRSRegulation cvrsRegulation;

                                /**
                                 * Gets the value of the cvrsRegulation property.
                                 * 
                                 * @return
                                 *     possible object is
                                 *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect.CVRSRegulation }
                                 *     
                                 */
                                public DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect.CVRSRegulation getCVRSRegulation() {
                                    return cvrsRegulation;
                                }

                                /**
                                 * Sets the value of the cvrsRegulation property.
                                 * 
                                 * @param value
                                 *     allowed object is
                                 *     {@link DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect.CVRSRegulation }
                                 *     
                                 */
                                public void setCVRSRegulation(DoServiceResponse.CIS0367I01Response.CISCustomers.CISCustsVect.CISCustomer.CVRSInfoObj.RegulsObj.RegulsVect.CVRSRegulation value) {
                                    this.cvrsRegulation = value;
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
                                 *         &lt;element name="actCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                                 *         &lt;element name="actDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
                                 *         &lt;element name="rankCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength3" minOccurs="0"/&gt;
                                 *         &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength2" minOccurs="0"/&gt;
                                 *         &lt;element name="subTypCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength50" minOccurs="0"/&gt;
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
                                    "actCode",
                                    "actDesc",
                                    "rankCode",
                                    "subTypCode",
                                    "subTypCodeDesc"
                                })
                                public static class CVRSRegulation {

                                    @XmlElementRef(name = "actCode", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                                    protected JAXBElement<String> actCode;
                                    @XmlElementRef(name = "actDesc", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                                    protected JAXBElement<String> actDesc;
                                    @XmlElementRef(name = "rankCode", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                                    protected JAXBElement<String> rankCode;
                                    @XmlElementRef(name = "subTypCode", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                                    protected JAXBElement<String> subTypCode;
                                    @XmlElementRef(name = "subTypCodeDesc", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                                    protected JAXBElement<String> subTypCodeDesc;

                                    /**
                                     * Gets the value of the actCode property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public JAXBElement<String> getActCode() {
                                        return actCode;
                                    }

                                    /**
                                     * Sets the value of the actCode property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public void setActCode(JAXBElement<String> value) {
                                        this.actCode = value;
                                    }

                                    /**
                                     * Gets the value of the actDesc property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public JAXBElement<String> getActDesc() {
                                        return actDesc;
                                    }

                                    /**
                                     * Sets the value of the actDesc property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public void setActDesc(JAXBElement<String> value) {
                                        this.actDesc = value;
                                    }

                                    /**
                                     * Gets the value of the rankCode property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public JAXBElement<String> getRankCode() {
                                        return rankCode;
                                    }

                                    /**
                                     * Sets the value of the rankCode property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public void setRankCode(JAXBElement<String> value) {
                                        this.rankCode = value;
                                    }

                                    /**
                                     * Gets the value of the subTypCode property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public JAXBElement<String> getSubTypCode() {
                                        return subTypCode;
                                    }

                                    /**
                                     * Sets the value of the subTypCode property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public void setSubTypCode(JAXBElement<String> value) {
                                        this.subTypCode = value;
                                    }

                                    /**
                                     * Gets the value of the subTypCodeDesc property.
                                     * 
                                     * @return
                                     *     possible object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public JAXBElement<String> getSubTypCodeDesc() {
                                        return subTypCodeDesc;
                                    }

                                    /**
                                     * Sets the value of the subTypCodeDesc property.
                                     * 
                                     * @param value
                                     *     allowed object is
                                     *     {@link JAXBElement }{@code <}{@link String }{@code >}
                                     *     
                                     */
                                    public void setSubTypCodeDesc(JAXBElement<String> value) {
                                        this.subTypCodeDesc = value;
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
                     *         &lt;element name="ownerFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1"/&gt;
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
                        "ownerFlag"
                    })
                    public static class CoAcctRelationObj {

                        @XmlElement(required = true, nillable = true)
                        protected String ownerFlag;

                        /**
                         * Gets the value of the ownerFlag property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getOwnerFlag() {
                            return ownerFlag;
                        }

                        /**
                         * Sets the value of the ownerFlag property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setOwnerFlag(String value) {
                            this.ownerFlag = value;
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
         *         &lt;element name="fstKeyNum" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="custNum" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength10" minOccurs="0"/&gt;
         *                   &lt;element name="terminateFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
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
         *                   &lt;element name="terminateFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
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
            "fstKeyNum",
            "lstKeyNum"
        })
        public static class CISNavCntrl {

            protected DoServiceResponse.CIS0367I01Response.CISNavCntrl.FstKeyNum fstKeyNum;
            protected DoServiceResponse.CIS0367I01Response.CISNavCntrl.LstKeyNum lstKeyNum;

            /**
             * Gets the value of the fstKeyNum property.
             * 
             * @return
             *     possible object is
             *     {@link DoServiceResponse.CIS0367I01Response.CISNavCntrl.FstKeyNum }
             *     
             */
            public DoServiceResponse.CIS0367I01Response.CISNavCntrl.FstKeyNum getFstKeyNum() {
                return fstKeyNum;
            }

            /**
             * Sets the value of the fstKeyNum property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoServiceResponse.CIS0367I01Response.CISNavCntrl.FstKeyNum }
             *     
             */
            public void setFstKeyNum(DoServiceResponse.CIS0367I01Response.CISNavCntrl.FstKeyNum value) {
                this.fstKeyNum = value;
            }

            /**
             * Gets the value of the lstKeyNum property.
             * 
             * @return
             *     possible object is
             *     {@link DoServiceResponse.CIS0367I01Response.CISNavCntrl.LstKeyNum }
             *     
             */
            public DoServiceResponse.CIS0367I01Response.CISNavCntrl.LstKeyNum getLstKeyNum() {
                return lstKeyNum;
            }

            /**
             * Sets the value of the lstKeyNum property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoServiceResponse.CIS0367I01Response.CISNavCntrl.LstKeyNum }
             *     
             */
            public void setLstKeyNum(DoServiceResponse.CIS0367I01Response.CISNavCntrl.LstKeyNum value) {
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
             *         &lt;element name="terminateFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
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
                "terminateFlag",
                "thFstName",
                "thLstName"
            })
            public static class FstKeyNum {

                @XmlElementRef(name = "custNum", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> custNum;
                @XmlElementRef(name = "terminateFlag", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> terminateFlag;
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
                 * Gets the value of the terminateFlag property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public JAXBElement<String> getTerminateFlag() {
                    return terminateFlag;
                }

                /**
                 * Sets the value of the terminateFlag property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public void setTerminateFlag(JAXBElement<String> value) {
                    this.terminateFlag = value;
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
             *         &lt;element name="terminateFlag" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength1" minOccurs="0"/&gt;
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
                "terminateFlag",
                "thFstName",
                "thLstName"
            })
            public static class LstKeyNum {

                @XmlElementRef(name = "custNum", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> custNum;
                @XmlElementRef(name = "terminateFlag", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
                protected JAXBElement<String> terminateFlag;
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
                 * Gets the value of the terminateFlag property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public JAXBElement<String> getTerminateFlag() {
                    return terminateFlag;
                }

                /**
                 * Sets the value of the terminateFlag property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link JAXBElement }{@code <}{@link String }{@code >}
                 *     
                 */
                public void setTerminateFlag(JAXBElement<String> value) {
                    this.terminateFlag = value;
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
         *         &lt;element name="endTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *         &lt;element name="transactionId" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}stringLength32"/&gt;
         *         &lt;element name="sourceTransactionId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="sourceSystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="status" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength1"/&gt;
         *         &lt;element name="reasonCode" type="{http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9}intLength5"/&gt;
         *         &lt;element name="reasonDesc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
            "reasonCode",
            "reasonDesc"
        })
        public static class EAIHeader {

            @XmlElement(required = true, nillable = true)
            protected String serviceId;
            @XmlElement(required = true, nillable = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar beginTimestamp;
            @XmlElement(required = true, nillable = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar endTimestamp;
            @XmlElement(required = true, nillable = true)
            protected String transactionId;
            @XmlElement(required = true, nillable = true)
            protected String sourceTransactionId;
            @XmlElement(required = true, nillable = true)
            protected String sourceSystem;
            @XmlElementRef(name = "userId", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> userId;
            @XmlElementRef(name = "password", namespace = "http://eai.kasikornbank.com/EAIWS/CIS0367I01/v9", type = JAXBElement.class, required = false)
            protected JAXBElement<String> password;
            @XmlElement(required = true, type = Integer.class, nillable = true)
            protected Integer status;
            @XmlElement(required = true, type = Integer.class, nillable = true)
            protected Integer reasonCode;
            @XmlElement(required = true, nillable = true)
            protected String reasonDesc;

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
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getEndTimestamp() {
                return endTimestamp;
            }

            /**
             * Sets the value of the endTimestamp property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setEndTimestamp(XMLGregorianCalendar value) {
                this.endTimestamp = value;
            }

            /**
             * Gets the value of the transactionId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTransactionId() {
                return transactionId;
            }

            /**
             * Sets the value of the transactionId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTransactionId(String value) {
                this.transactionId = value;
            }

            /**
             * Gets the value of the sourceTransactionId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSourceTransactionId() {
                return sourceTransactionId;
            }

            /**
             * Sets the value of the sourceTransactionId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSourceTransactionId(String value) {
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
             *     {@link Integer }
             *     
             */
            public Integer getStatus() {
                return status;
            }

            /**
             * Sets the value of the status property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setStatus(Integer value) {
                this.status = value;
            }

            /**
             * Gets the value of the reasonCode property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getReasonCode() {
                return reasonCode;
            }

            /**
             * Sets the value of the reasonCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setReasonCode(Integer value) {
                this.reasonCode = value;
            }

            /**
             * Gets the value of the reasonDesc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReasonDesc() {
                return reasonDesc;
            }

            /**
             * Sets the value of the reasonDesc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReasonDesc(String value) {
                this.reasonDesc = value;
            }

        }

    }

}
