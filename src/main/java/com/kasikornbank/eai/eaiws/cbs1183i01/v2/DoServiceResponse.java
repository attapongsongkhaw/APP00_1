
package com.kasikornbank.eai.eaiws.cbs1183i01.v2;

import java.math.BigDecimal;
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
 *         &lt;element name="CBS1183I01Response"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="KBankHeader"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="funcNm" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength30"/&gt;
 *                             &lt;element name="rqUID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength47"/&gt;
 *                             &lt;element name="rsAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
 *                             &lt;element name="rsUID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength47"/&gt;
 *                             &lt;element name="rsDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                             &lt;element name="statusCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2"/&gt;
 *                             &lt;element name="errorVect" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="error" maxOccurs="10" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
 *                                                 &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
 *                                                 &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength30"/&gt;
 *                                                 &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength256"/&gt;
 *                                                 &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2"/&gt;
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
 *                             &lt;element name="corrID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength32" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CBSAccount" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="AccrueIntAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="AcctBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="AcctId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength10"/&gt;
 *                             &lt;element name="AcctNameEn" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength180" minOccurs="0"/&gt;
 *                             &lt;element name="AcctNameTh" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength180"/&gt;
 *                             &lt;element name="AcctStatus" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength1"/&gt;
 *                             &lt;element name="AcctStatusDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength15"/&gt;
 *                             &lt;element name="AllowFlag" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength1"/&gt;
 *                             &lt;element name="ApparentPassbkBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="AvailBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="AvailENCLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="AvailIntradayLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="AvailLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="AvailODLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="BlockInd" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength1"/&gt;
 *                             &lt;element name="BranchName" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength50"/&gt;
 *                             &lt;element name="ClearingAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="ClosedDt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="Curcode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength3"/&gt;
 *                             &lt;element name="DomicileBranchId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength4"/&gt;
 *                             &lt;element name="ENCLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="ENCLimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="HoldAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="IntradayLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="IntradayLimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="KBankProductCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength9"/&gt;
 *                             &lt;element name="KBankProductCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength255"/&gt;
 *                             &lt;element name="LastFincDt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="LimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="LimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="ODLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="ODLimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="RefAcctBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="RefAcctId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength10" minOccurs="0"/&gt;
 *                             &lt;element name="RefBranchId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength4" minOccurs="0"/&gt;
 *                             &lt;element name="RefBranchName" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength50" minOccurs="0"/&gt;
 *                             &lt;element name="RefProductCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength9" minOccurs="0"/&gt;
 *                             &lt;element name="RefProductDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength255" minOccurs="0"/&gt;
 *                             &lt;element name="RetentionAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
 *                             &lt;element name="TCBTariffName" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength60" minOccurs="0"/&gt;
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
    "cbs1183I01Response"
})
public class DoServiceResponse {

    @XmlElement(name = "CBS1183I01Response", required = true)
    protected DoServiceResponse.CBS1183I01Response cbs1183I01Response;

    /**
     * Gets the value of the cbs1183I01Response property.
     * 
     * @return
     *     possible object is
     *     {@link DoServiceResponse.CBS1183I01Response }
     *     
     */
    public DoServiceResponse.CBS1183I01Response getCBS1183I01Response() {
        return cbs1183I01Response;
    }

    /**
     * Sets the value of the cbs1183I01Response property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoServiceResponse.CBS1183I01Response }
     *     
     */
    public void setCBS1183I01Response(DoServiceResponse.CBS1183I01Response value) {
        this.cbs1183I01Response = value;
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
     *         &lt;element name="KBankHeader"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="funcNm" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength30"/&gt;
     *                   &lt;element name="rqUID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength47"/&gt;
     *                   &lt;element name="rsAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
     *                   &lt;element name="rsUID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength47"/&gt;
     *                   &lt;element name="rsDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                   &lt;element name="statusCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2"/&gt;
     *                   &lt;element name="errorVect" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="error" maxOccurs="10" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
     *                                       &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
     *                                       &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength30"/&gt;
     *                                       &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength256"/&gt;
     *                                       &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2"/&gt;
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
     *                   &lt;element name="corrID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength32" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CBSAccount" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="AccrueIntAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="AcctBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="AcctId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength10"/&gt;
     *                   &lt;element name="AcctNameEn" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength180" minOccurs="0"/&gt;
     *                   &lt;element name="AcctNameTh" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength180"/&gt;
     *                   &lt;element name="AcctStatus" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength1"/&gt;
     *                   &lt;element name="AcctStatusDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength15"/&gt;
     *                   &lt;element name="AllowFlag" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength1"/&gt;
     *                   &lt;element name="ApparentPassbkBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="AvailBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="AvailENCLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="AvailIntradayLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="AvailLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="AvailODLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="BlockInd" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength1"/&gt;
     *                   &lt;element name="BranchName" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength50"/&gt;
     *                   &lt;element name="ClearingAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="ClosedDt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="Curcode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength3"/&gt;
     *                   &lt;element name="DomicileBranchId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength4"/&gt;
     *                   &lt;element name="ENCLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="ENCLimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="HoldAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="IntradayLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="IntradayLimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="KBankProductCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength9"/&gt;
     *                   &lt;element name="KBankProductCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength255"/&gt;
     *                   &lt;element name="LastFincDt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="LimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="LimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="ODLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="ODLimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="RefAcctBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="RefAcctId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength10" minOccurs="0"/&gt;
     *                   &lt;element name="RefBranchId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength4" minOccurs="0"/&gt;
     *                   &lt;element name="RefBranchName" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength50" minOccurs="0"/&gt;
     *                   &lt;element name="RefProductCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength9" minOccurs="0"/&gt;
     *                   &lt;element name="RefProductDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength255" minOccurs="0"/&gt;
     *                   &lt;element name="RetentionAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
     *                   &lt;element name="TCBTariffName" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength60" minOccurs="0"/&gt;
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
        "kBankHeader",
        "cbsAccount"
    })
    @XmlRootElement(name = "CBS1183I01Response")
    public static class CBS1183I01Response {

        @XmlElement(name = "KBankHeader", required = true)
        protected DoServiceResponse.CBS1183I01Response.KBankHeader kBankHeader;
        @XmlElement(name = "CBSAccount")
        protected DoServiceResponse.CBS1183I01Response.CBSAccount cbsAccount;

        /**
         * Gets the value of the kBankHeader property.
         * 
         * @return
         *     possible object is
         *     {@link DoServiceResponse.CBS1183I01Response.KBankHeader }
         *     
         */
        public DoServiceResponse.CBS1183I01Response.KBankHeader getKBankHeader() {
            return kBankHeader;
        }

        /**
         * Sets the value of the kBankHeader property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoServiceResponse.CBS1183I01Response.KBankHeader }
         *     
         */
        public void setKBankHeader(DoServiceResponse.CBS1183I01Response.KBankHeader value) {
            this.kBankHeader = value;
        }

        /**
         * Gets the value of the cbsAccount property.
         * 
         * @return
         *     possible object is
         *     {@link DoServiceResponse.CBS1183I01Response.CBSAccount }
         *     
         */
        public DoServiceResponse.CBS1183I01Response.CBSAccount getCBSAccount() {
            return cbsAccount;
        }

        /**
         * Sets the value of the cbsAccount property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoServiceResponse.CBS1183I01Response.CBSAccount }
         *     
         */
        public void setCBSAccount(DoServiceResponse.CBS1183I01Response.CBSAccount value) {
            this.cbsAccount = value;
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
         *         &lt;element name="AccrueIntAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="AcctBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="AcctId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength10"/&gt;
         *         &lt;element name="AcctNameEn" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength180" minOccurs="0"/&gt;
         *         &lt;element name="AcctNameTh" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength180"/&gt;
         *         &lt;element name="AcctStatus" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength1"/&gt;
         *         &lt;element name="AcctStatusDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength15"/&gt;
         *         &lt;element name="AllowFlag" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength1"/&gt;
         *         &lt;element name="ApparentPassbkBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="AvailBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="AvailENCLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="AvailIntradayLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="AvailLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="AvailODLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="BlockInd" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength1"/&gt;
         *         &lt;element name="BranchName" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength50"/&gt;
         *         &lt;element name="ClearingAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="ClosedDt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="Curcode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength3"/&gt;
         *         &lt;element name="DomicileBranchId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength4"/&gt;
         *         &lt;element name="ENCLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="ENCLimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="HoldAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="IntradayLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="IntradayLimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="KBankProductCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength9"/&gt;
         *         &lt;element name="KBankProductCodeDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength255"/&gt;
         *         &lt;element name="LastFincDt" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="LimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="LimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="ODLimitAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="ODLimitUsed" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="RefAcctBal" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="RefAcctId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength10" minOccurs="0"/&gt;
         *         &lt;element name="RefBranchId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength4" minOccurs="0"/&gt;
         *         &lt;element name="RefBranchName" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength50" minOccurs="0"/&gt;
         *         &lt;element name="RefProductCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength9" minOccurs="0"/&gt;
         *         &lt;element name="RefProductDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength255" minOccurs="0"/&gt;
         *         &lt;element name="RetentionAmt" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}decimalLength18frictions18_2" minOccurs="0"/&gt;
         *         &lt;element name="TCBTariffName" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength60" minOccurs="0"/&gt;
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
            "accrueIntAmt",
            "acctBal",
            "acctId",
            "acctNameEn",
            "acctNameTh",
            "acctStatus",
            "acctStatusDesc",
            "allowFlag",
            "apparentPassbkBal",
            "availBal",
            "availENCLimitAmt",
            "availIntradayLimitAmt",
            "availLimitAmt",
            "availODLimitAmt",
            "blockInd",
            "branchName",
            "clearingAmt",
            "closedDt",
            "curcode",
            "domicileBranchId",
            "encLimitAmt",
            "encLimitUsed",
            "holdAmt",
            "intradayLimitAmt",
            "intradayLimitUsed",
            "kBankProductCode",
            "kBankProductCodeDesc",
            "lastFincDt",
            "limitAmt",
            "limitUsed",
            "srcSystemFlg",
            "odLimitAmt",
            "odLimitUsed",
            "refAcctBal",
            "refAcctId",
            "refBranchId",
            "refBranchName",
            "refProductCode",
            "refProductDesc",
            "retentionAmt",
            "tcbTariffName"
        })
        public static class CBSAccount {

            @XmlElementRef(name = "AccrueIntAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> accrueIntAmt;
            @XmlElementRef(name = "AcctBal", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> acctBal;
            @XmlElement(name = "AcctId", required = true, nillable = true)
            protected String acctId;
            @XmlElementRef(name = "AcctNameEn", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> acctNameEn;
            @XmlElement(name = "AcctNameTh", required = true, nillable = true)
            protected String acctNameTh;
            @XmlElement(name = "AcctStatus", required = true, nillable = true)
            protected String acctStatus;
            @XmlElement(name = "AcctStatusDesc", required = true, nillable = true)
            protected String acctStatusDesc;
            @XmlElement(name = "AllowFlag", required = true, nillable = true)
            protected String allowFlag;
            @XmlElementRef(name = "ApparentPassbkBal", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> apparentPassbkBal;
            @XmlElementRef(name = "AvailBal", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> availBal;
            @XmlElementRef(name = "AvailENCLimitAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> availENCLimitAmt;
            @XmlElementRef(name = "AvailIntradayLimitAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> availIntradayLimitAmt;
            @XmlElementRef(name = "AvailLimitAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> availLimitAmt;
            @XmlElementRef(name = "AvailODLimitAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> availODLimitAmt;
            @XmlElement(name = "BlockInd", required = true, nillable = true)
            protected String blockInd;
            @XmlElement(name = "BranchName", required = true, nillable = true)
            protected String branchName;
            @XmlElementRef(name = "ClearingAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> clearingAmt;
            @XmlElementRef(name = "ClosedDt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<XMLGregorianCalendar> closedDt;
            @XmlElement(name = "Curcode", required = true, nillable = true)
            protected String curcode;
            @XmlElement(name = "DomicileBranchId", required = true, nillable = true)
            protected String domicileBranchId;
            @XmlElementRef(name = "ENCLimitAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> encLimitAmt;
            @XmlElementRef(name = "ENCLimitUsed", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> encLimitUsed;
            @XmlElementRef(name = "HoldAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> holdAmt;
            @XmlElementRef(name = "IntradayLimitAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> intradayLimitAmt;
            @XmlElementRef(name = "IntradayLimitUsed", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> intradayLimitUsed;
            @XmlElement(name = "KBankProductCode", required = true, nillable = true)
            protected String kBankProductCode;
            @XmlElement(name = "KBankProductCodeDesc", required = true, nillable = true)
            protected String kBankProductCodeDesc;
            @XmlElementRef(name = "LastFincDt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<XMLGregorianCalendar> lastFincDt;
            @XmlElementRef(name = "LimitAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> limitAmt;
            @XmlElementRef(name = "LimitUsed", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> limitUsed;
            @XmlElementRef(name = "ODLimitAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> srcSystemFlg;
            @XmlElementRef(name = "SrcSystemFlg", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> odLimitAmt;
            @XmlElementRef(name = "ODLimitUsed", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> odLimitUsed;
            @XmlElementRef(name = "RefAcctBal", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> refAcctBal;
            @XmlElementRef(name = "RefAcctId", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> refAcctId;
            @XmlElementRef(name = "RefBranchId", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> refBranchId;
            @XmlElementRef(name = "RefBranchName", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> refBranchName;
            @XmlElementRef(name = "RefProductCode", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> refProductCode;
            @XmlElementRef(name = "RefProductDesc", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> refProductDesc;
            @XmlElementRef(name = "RetentionAmt", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<BigDecimal> retentionAmt;
            @XmlElementRef(name = "TCBTariffName", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> tcbTariffName;

            /**
             * Gets the value of the accrueIntAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getAccrueIntAmt() {
                return accrueIntAmt;
            }

            /**
             * Sets the value of the accrueIntAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setAccrueIntAmt(JAXBElement<BigDecimal> value) {
                this.accrueIntAmt = value;
            }

            /**
             * Gets the value of the acctBal property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getAcctBal() {
                return acctBal;
            }

            /**
             * Sets the value of the acctBal property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setAcctBal(JAXBElement<BigDecimal> value) {
                this.acctBal = value;
            }

            /**
             * Gets the value of the acctId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAcctId() {
                return acctId;
            }

            /**
             * Sets the value of the acctId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAcctId(String value) {
                this.acctId = value;
            }

            /**
             * Gets the value of the acctNameEn property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getAcctNameEn() {
                return acctNameEn;
            }

            /**
             * Sets the value of the acctNameEn property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setAcctNameEn(JAXBElement<String> value) {
                this.acctNameEn = value;
            }

            /**
             * Gets the value of the acctNameTh property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAcctNameTh() {
                return acctNameTh;
            }

            /**
             * Sets the value of the acctNameTh property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAcctNameTh(String value) {
                this.acctNameTh = value;
            }

            /**
             * Gets the value of the acctStatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAcctStatus() {
                return acctStatus;
            }

            /**
             * Sets the value of the acctStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAcctStatus(String value) {
                this.acctStatus = value;
            }

            /**
             * Gets the value of the acctStatusDesc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAcctStatusDesc() {
                return acctStatusDesc;
            }

            /**
             * Sets the value of the acctStatusDesc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAcctStatusDesc(String value) {
                this.acctStatusDesc = value;
            }

            /**
             * Gets the value of the allowFlag property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAllowFlag() {
                return allowFlag;
            }

            /**
             * Sets the value of the allowFlag property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAllowFlag(String value) {
                this.allowFlag = value;
            }

            /**
             * Gets the value of the apparentPassbkBal property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getApparentPassbkBal() {
                return apparentPassbkBal;
            }

            /**
             * Sets the value of the apparentPassbkBal property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setApparentPassbkBal(JAXBElement<BigDecimal> value) {
                this.apparentPassbkBal = value;
            }

            /**
             * Gets the value of the availBal property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getAvailBal() {
                return availBal;
            }

            /**
             * Sets the value of the availBal property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setAvailBal(JAXBElement<BigDecimal> value) {
                this.availBal = value;
            }

            /**
             * Gets the value of the availENCLimitAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getAvailENCLimitAmt() {
                return availENCLimitAmt;
            }

            /**
             * Sets the value of the availENCLimitAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setAvailENCLimitAmt(JAXBElement<BigDecimal> value) {
                this.availENCLimitAmt = value;
            }

            /**
             * Gets the value of the availIntradayLimitAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getAvailIntradayLimitAmt() {
                return availIntradayLimitAmt;
            }

            /**
             * Sets the value of the availIntradayLimitAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setAvailIntradayLimitAmt(JAXBElement<BigDecimal> value) {
                this.availIntradayLimitAmt = value;
            }

            /**
             * Gets the value of the availLimitAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getAvailLimitAmt() {
                return availLimitAmt;
            }

            /**
             * Sets the value of the availLimitAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setAvailLimitAmt(JAXBElement<BigDecimal> value) {
                this.availLimitAmt = value;
            }

            /**
             * Gets the value of the availODLimitAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getAvailODLimitAmt() {
                return availODLimitAmt;
            }

            /**
             * Sets the value of the availODLimitAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setAvailODLimitAmt(JAXBElement<BigDecimal> value) {
                this.availODLimitAmt = value;
            }

            /**
             * Gets the value of the blockInd property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBlockInd() {
                return blockInd;
            }

            /**
             * Sets the value of the blockInd property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBlockInd(String value) {
                this.blockInd = value;
            }

            /**
             * Gets the value of the branchName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBranchName() {
                return branchName;
            }

            /**
             * Sets the value of the branchName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBranchName(String value) {
                this.branchName = value;
            }

            /**
             * Gets the value of the clearingAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getClearingAmt() {
                return clearingAmt;
            }

            /**
             * Sets the value of the clearingAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setClearingAmt(JAXBElement<BigDecimal> value) {
                this.clearingAmt = value;
            }

            /**
             * Gets the value of the closedDt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
             *     
             */
            public JAXBElement<XMLGregorianCalendar> getClosedDt() {
                return closedDt;
            }

            /**
             * Sets the value of the closedDt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
             *     
             */
            public void setClosedDt(JAXBElement<XMLGregorianCalendar> value) {
                this.closedDt = value;
            }

            /**
             * Gets the value of the curcode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCurcode() {
                return curcode;
            }

            /**
             * Sets the value of the curcode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCurcode(String value) {
                this.curcode = value;
            }

            /**
             * Gets the value of the domicileBranchId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDomicileBranchId() {
                return domicileBranchId;
            }

            /**
             * Sets the value of the domicileBranchId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDomicileBranchId(String value) {
                this.domicileBranchId = value;
            }

            /**
             * Gets the value of the encLimitAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getENCLimitAmt() {
                return encLimitAmt;
            }

            /**
             * Sets the value of the encLimitAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setENCLimitAmt(JAXBElement<BigDecimal> value) {
                this.encLimitAmt = value;
            }

            /**
             * Gets the value of the encLimitUsed property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getENCLimitUsed() {
                return encLimitUsed;
            }

            /**
             * Sets the value of the encLimitUsed property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setENCLimitUsed(JAXBElement<BigDecimal> value) {
                this.encLimitUsed = value;
            }

            /**
             * Gets the value of the holdAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getHoldAmt() {
                return holdAmt;
            }

            /**
             * Sets the value of the holdAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setHoldAmt(JAXBElement<BigDecimal> value) {
                this.holdAmt = value;
            }

            /**
             * Gets the value of the intradayLimitAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getIntradayLimitAmt() {
                return intradayLimitAmt;
            }

            /**
             * Sets the value of the intradayLimitAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setIntradayLimitAmt(JAXBElement<BigDecimal> value) {
                this.intradayLimitAmt = value;
            }

            /**
             * Gets the value of the intradayLimitUsed property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getIntradayLimitUsed() {
                return intradayLimitUsed;
            }

            /**
             * Sets the value of the intradayLimitUsed property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setIntradayLimitUsed(JAXBElement<BigDecimal> value) {
                this.intradayLimitUsed = value;
            }

            /**
             * Gets the value of the kBankProductCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKBankProductCode() {
                return kBankProductCode;
            }

            /**
             * Sets the value of the kBankProductCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKBankProductCode(String value) {
                this.kBankProductCode = value;
            }

            /**
             * Gets the value of the kBankProductCodeDesc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKBankProductCodeDesc() {
                return kBankProductCodeDesc;
            }

            /**
             * Sets the value of the kBankProductCodeDesc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKBankProductCodeDesc(String value) {
                this.kBankProductCodeDesc = value;
            }

            /**
             * Gets the value of the lastFincDt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
             *     
             */
            public JAXBElement<XMLGregorianCalendar> getLastFincDt() {
                return lastFincDt;
            }

            /**
             * Sets the value of the lastFincDt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
             *     
             */
            public void setLastFincDt(JAXBElement<XMLGregorianCalendar> value) {
                this.lastFincDt = value;
            }

            /**
             * Gets the value of the limitAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getLimitAmt() {
                return limitAmt;
            }

            /**
             * Sets the value of the limitAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setLimitAmt(JAXBElement<BigDecimal> value) {
                this.limitAmt = value;
            }

            /**
             * Gets the value of the limitUsed property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getLimitUsed() {
                return limitUsed;
            }

            /**
             * Sets the value of the limitUsed property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setLimitUsed(JAXBElement<BigDecimal> value) {
                this.limitUsed = value;
            }

            /**
             * Gets the value of the odLimitAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<String> getSrcSystemFlg() {
                return srcSystemFlg;
            }
            
            /**
             * Gets the value of the odLimitAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getODLimitAmt() {
                return odLimitAmt;
            }

            /**
             * Sets the value of the odLimitAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setSrcSystemFlg(JAXBElement<String> value) {
                this.srcSystemFlg = value;
            }
            
            /**
             * Sets the value of the odLimitAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setODLimitAmt(JAXBElement<BigDecimal> value) {
                this.odLimitAmt = value;
            }

            /**
             * Gets the value of the odLimitUsed property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getODLimitUsed() {
                return odLimitUsed;
            }

            /**
             * Sets the value of the odLimitUsed property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setODLimitUsed(JAXBElement<BigDecimal> value) {
                this.odLimitUsed = value;
            }

            /**
             * Gets the value of the refAcctBal property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getRefAcctBal() {
                return refAcctBal;
            }

            /**
             * Sets the value of the refAcctBal property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setRefAcctBal(JAXBElement<BigDecimal> value) {
                this.refAcctBal = value;
            }

            /**
             * Gets the value of the refAcctId property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getRefAcctId() {
                return refAcctId;
            }

            /**
             * Sets the value of the refAcctId property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setRefAcctId(JAXBElement<String> value) {
                this.refAcctId = value;
            }

            /**
             * Gets the value of the refBranchId property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getRefBranchId() {
                return refBranchId;
            }

            /**
             * Sets the value of the refBranchId property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setRefBranchId(JAXBElement<String> value) {
                this.refBranchId = value;
            }

            /**
             * Gets the value of the refBranchName property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getRefBranchName() {
                return refBranchName;
            }

            /**
             * Sets the value of the refBranchName property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setRefBranchName(JAXBElement<String> value) {
                this.refBranchName = value;
            }

            /**
             * Gets the value of the refProductCode property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getRefProductCode() {
                return refProductCode;
            }

            /**
             * Sets the value of the refProductCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setRefProductCode(JAXBElement<String> value) {
                this.refProductCode = value;
            }

            /**
             * Gets the value of the refProductDesc property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getRefProductDesc() {
                return refProductDesc;
            }

            /**
             * Sets the value of the refProductDesc property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setRefProductDesc(JAXBElement<String> value) {
                this.refProductDesc = value;
            }

            /**
             * Gets the value of the retentionAmt property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public JAXBElement<BigDecimal> getRetentionAmt() {
                return retentionAmt;
            }

            /**
             * Sets the value of the retentionAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
             *     
             */
            public void setRetentionAmt(JAXBElement<BigDecimal> value) {
                this.retentionAmt = value;
            }

            /**
             * Gets the value of the tcbTariffName property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getTCBTariffName() {
                return tcbTariffName;
            }

            /**
             * Sets the value of the tcbTariffName property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setTCBTariffName(JAXBElement<String> value) {
                this.tcbTariffName = value;
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
         *         &lt;element name="funcNm" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength30"/&gt;
         *         &lt;element name="rqUID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength47"/&gt;
         *         &lt;element name="rsAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
         *         &lt;element name="rsUID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength47"/&gt;
         *         &lt;element name="rsDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *         &lt;element name="statusCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2"/&gt;
         *         &lt;element name="errorVect" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="error" maxOccurs="10" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
         *                             &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
         *                             &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength30"/&gt;
         *                             &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength256"/&gt;
         *                             &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2"/&gt;
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
         *         &lt;element name="corrID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength32" minOccurs="0"/&gt;
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
            "funcNm",
            "rqUID",
            "rsAppId",
            "rsUID",
            "rsDt",
            "statusCode",
            "errorVect",
            "corrID"
        })
        public static class KBankHeader {

            @XmlElement(required = true, nillable = true)
            protected String funcNm;
            @XmlElement(required = true, nillable = true)
            protected String rqUID;
            @XmlElement(required = true, nillable = true)
            protected String rsAppId;
            @XmlElement(required = true, nillable = true)
            protected String rsUID;
            @XmlElement(required = true, nillable = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar rsDt;
            @XmlElement(required = true, nillable = true)
            protected String statusCode;
            protected DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect errorVect;
            @XmlElementRef(name = "corrID", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> corrID;

            /**
             * Gets the value of the funcNm property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFuncNm() {
                return funcNm;
            }

            /**
             * Sets the value of the funcNm property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFuncNm(String value) {
                this.funcNm = value;
            }

            /**
             * Gets the value of the rqUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRqUID() {
                return rqUID;
            }

            /**
             * Sets the value of the rqUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRqUID(String value) {
                this.rqUID = value;
            }

            /**
             * Gets the value of the rsAppId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRsAppId() {
                return rsAppId;
            }

            /**
             * Sets the value of the rsAppId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRsAppId(String value) {
                this.rsAppId = value;
            }

            /**
             * Gets the value of the rsUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRsUID() {
                return rsUID;
            }

            /**
             * Sets the value of the rsUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRsUID(String value) {
                this.rsUID = value;
            }

            /**
             * Gets the value of the rsDt property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getRsDt() {
                return rsDt;
            }

            /**
             * Sets the value of the rsDt property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setRsDt(XMLGregorianCalendar value) {
                this.rsDt = value;
            }

            /**
             * Gets the value of the statusCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStatusCode() {
                return statusCode;
            }

            /**
             * Sets the value of the statusCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStatusCode(String value) {
                this.statusCode = value;
            }

            /**
             * Gets the value of the errorVect property.
             * 
             * @return
             *     possible object is
             *     {@link DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect }
             *     
             */
            public DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect getErrorVect() {
                return errorVect;
            }

            /**
             * Sets the value of the errorVect property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect }
             *     
             */
            public void setErrorVect(DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect value) {
                this.errorVect = value;
            }

            /**
             * Gets the value of the corrID property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getCorrID() {
                return corrID;
            }

            /**
             * Sets the value of the corrID property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setCorrID(JAXBElement<String> value) {
                this.corrID = value;
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
             *         &lt;element name="error" maxOccurs="10" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
             *                   &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
             *                   &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength30"/&gt;
             *                   &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength256"/&gt;
             *                   &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2"/&gt;
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
                "error"
            })
            public static class ErrorVect {

                protected List<DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect.Error> error;

                /**
                 * Gets the value of the error property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the error property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getError().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect.Error }
                 * 
                 * 
                 */
                public List<DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect.Error> getError() {
                    if (error == null) {
                        error = new ArrayList<DoServiceResponse.CBS1183I01Response.KBankHeader.ErrorVect.Error>();
                    }
                    return this.error;
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
                 *         &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
                 *         &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
                 *         &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength30"/&gt;
                 *         &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength256"/&gt;
                 *         &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2"/&gt;
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
                    "errorAppId",
                    "errorAppAbbrv",
                    "errorCode",
                    "errorDesc",
                    "errorSeverity"
                })
                public static class Error {

                    @XmlElement(required = true, nillable = true)
                    protected String errorAppId;
                    @XmlElement(required = true, nillable = true)
                    protected String errorAppAbbrv;
                    @XmlElement(required = true, nillable = true)
                    protected String errorCode;
                    @XmlElement(required = true, nillable = true)
                    protected String errorDesc;
                    @XmlElement(required = true, nillable = true)
                    protected String errorSeverity;

                    /**
                     * Gets the value of the errorAppId property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getErrorAppId() {
                        return errorAppId;
                    }

                    /**
                     * Sets the value of the errorAppId property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setErrorAppId(String value) {
                        this.errorAppId = value;
                    }

                    /**
                     * Gets the value of the errorAppAbbrv property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getErrorAppAbbrv() {
                        return errorAppAbbrv;
                    }

                    /**
                     * Sets the value of the errorAppAbbrv property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setErrorAppAbbrv(String value) {
                        this.errorAppAbbrv = value;
                    }

                    /**
                     * Gets the value of the errorCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getErrorCode() {
                        return errorCode;
                    }

                    /**
                     * Sets the value of the errorCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setErrorCode(String value) {
                        this.errorCode = value;
                    }

                    /**
                     * Gets the value of the errorDesc property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getErrorDesc() {
                        return errorDesc;
                    }

                    /**
                     * Sets the value of the errorDesc property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setErrorDesc(String value) {
                        this.errorDesc = value;
                    }

                    /**
                     * Gets the value of the errorSeverity property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getErrorSeverity() {
                        return errorSeverity;
                    }

                    /**
                     * Sets the value of the errorSeverity property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setErrorSeverity(String value) {
                        this.errorSeverity = value;
                    }

                }

            }

        }

    }

}
