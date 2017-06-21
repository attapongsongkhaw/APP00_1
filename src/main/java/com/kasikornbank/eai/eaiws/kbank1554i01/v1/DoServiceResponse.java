
package com.kasikornbank.eai.eaiws.kbank1554i01.v1;

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
 *         &lt;element name="KBANK1554I01Response"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="KBankHeader"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="funcNm" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength30"/&gt;
 *                             &lt;element name="rqUID" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength47"/&gt;
 *                             &lt;element name="rsAppId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
 *                             &lt;element name="rsUID" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength47"/&gt;
 *                             &lt;element name="rsDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                             &lt;element name="statusCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2"/&gt;
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
 *                                                 &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
 *                                                 &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
 *                                                 &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength30"/&gt;
 *                                                 &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength256"/&gt;
 *                                                 &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2"/&gt;
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
 *                             &lt;element name="corrID" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength32" minOccurs="0"/&gt;
 *                             &lt;element name="reqAuthLevel" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}intLength3" minOccurs="0"/&gt;
 *                             &lt;element name="reqAuthUserId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength15" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="CVRSInfo" minOccurs="0"&gt;
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
 *                                                 &lt;element name="CVRSRegulation" maxOccurs="15" minOccurs="0"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
 *                                                           &lt;element name="typCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
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
 *                                       &lt;element name="totRegulCnt" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}intLength2"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="sanctionFlg" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength1"/&gt;
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
    "kbank1554I01Response"
})
public class DoServiceResponse {

    @XmlElement(name = "KBANK1554I01Response", required = true)
    protected DoServiceResponse.KBANK1554I01Response kbank1554I01Response;

    /**
     * Gets the value of the kbank1554I01Response property.
     * 
     * @return
     *     possible object is
     *     {@link DoServiceResponse.KBANK1554I01Response }
     *     
     */
    public DoServiceResponse.KBANK1554I01Response getKBANK1554I01Response() {
        return kbank1554I01Response;
    }

    /**
     * Sets the value of the kbank1554I01Response property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoServiceResponse.KBANK1554I01Response }
     *     
     */
    public void setKBANK1554I01Response(DoServiceResponse.KBANK1554I01Response value) {
        this.kbank1554I01Response = value;
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
     *                   &lt;element name="funcNm" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength30"/&gt;
     *                   &lt;element name="rqUID" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength47"/&gt;
     *                   &lt;element name="rsAppId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
     *                   &lt;element name="rsUID" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength47"/&gt;
     *                   &lt;element name="rsDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                   &lt;element name="statusCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2"/&gt;
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
     *                                       &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
     *                                       &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
     *                                       &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength30"/&gt;
     *                                       &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength256"/&gt;
     *                                       &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2"/&gt;
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
     *                   &lt;element name="corrID" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength32" minOccurs="0"/&gt;
     *                   &lt;element name="reqAuthLevel" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}intLength3" minOccurs="0"/&gt;
     *                   &lt;element name="reqAuthUserId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength15" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="CVRSInfo" minOccurs="0"&gt;
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
     *                                       &lt;element name="CVRSRegulation" maxOccurs="15" minOccurs="0"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
     *                                                 &lt;element name="typCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
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
     *                             &lt;element name="totRegulCnt" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}intLength2"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="sanctionFlg" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength1"/&gt;
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
        "cvrsInfo"
    })
    @XmlRootElement(name = "KBANK1554I01Response")
    public static class KBANK1554I01Response {

        @XmlElement(name = "KBankHeader", required = true)
        protected DoServiceResponse.KBANK1554I01Response.KBankHeader kBankHeader;
        @XmlElement(name = "CVRSInfo")
        protected DoServiceResponse.KBANK1554I01Response.CVRSInfo cvrsInfo;

        /**
         * Gets the value of the kBankHeader property.
         * 
         * @return
         *     possible object is
         *     {@link DoServiceResponse.KBANK1554I01Response.KBankHeader }
         *     
         */
        public DoServiceResponse.KBANK1554I01Response.KBankHeader getKBankHeader() {
            return kBankHeader;
        }

        /**
         * Sets the value of the kBankHeader property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoServiceResponse.KBANK1554I01Response.KBankHeader }
         *     
         */
        public void setKBankHeader(DoServiceResponse.KBANK1554I01Response.KBankHeader value) {
            this.kBankHeader = value;
        }

        /**
         * Gets the value of the cvrsInfo property.
         * 
         * @return
         *     possible object is
         *     {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo }
         *     
         */
        public DoServiceResponse.KBANK1554I01Response.CVRSInfo getCVRSInfo() {
            return cvrsInfo;
        }

        /**
         * Sets the value of the cvrsInfo property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo }
         *     
         */
        public void setCVRSInfo(DoServiceResponse.KBANK1554I01Response.CVRSInfo value) {
            this.cvrsInfo = value;
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
         *                             &lt;element name="CVRSRegulation" maxOccurs="15" minOccurs="0"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
         *                                       &lt;element name="typCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
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
         *                   &lt;element name="totRegulCnt" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}intLength2"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="sanctionFlg" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength1"/&gt;
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
            "regulsObj",
            "sanctionFlg"
        })
        public static class CVRSInfo {

            protected DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj regulsObj;
            @XmlElement(required = true, nillable = true)
            protected String sanctionFlg;

            /**
             * Gets the value of the regulsObj property.
             * 
             * @return
             *     possible object is
             *     {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj }
             *     
             */
            public DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj getRegulsObj() {
                return regulsObj;
            }

            /**
             * Sets the value of the regulsObj property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj }
             *     
             */
            public void setRegulsObj(DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj value) {
                this.regulsObj = value;
            }

            /**
             * Gets the value of the sanctionFlg property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSanctionFlg() {
                return sanctionFlg;
            }

            /**
             * Sets the value of the sanctionFlg property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSanctionFlg(String value) {
                this.sanctionFlg = value;
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
             *                   &lt;element name="CVRSRegulation" maxOccurs="15" minOccurs="0"&gt;
             *                     &lt;complexType&gt;
             *                       &lt;complexContent&gt;
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                           &lt;sequence&gt;
             *                             &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
             *                             &lt;element name="typCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
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
             *         &lt;element name="totRegulCnt" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}intLength2"/&gt;
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
                "regulsVect",
                "totRegulCnt"
            })
            public static class RegulsObj {

                protected DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect regulsVect;
                @XmlElement(required = true, type = Integer.class, nillable = true)
                protected Integer totRegulCnt;

                /**
                 * Gets the value of the regulsVect property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect }
                 *     
                 */
                public DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect getRegulsVect() {
                    return regulsVect;
                }

                /**
                 * Sets the value of the regulsVect property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect }
                 *     
                 */
                public void setRegulsVect(DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect value) {
                    this.regulsVect = value;
                }

                /**
                 * Gets the value of the totRegulCnt property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getTotRegulCnt() {
                    return totRegulCnt;
                }

                /**
                 * Sets the value of the totRegulCnt property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setTotRegulCnt(Integer value) {
                    this.totRegulCnt = value;
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
                 *         &lt;element name="CVRSRegulation" maxOccurs="15" minOccurs="0"&gt;
                 *           &lt;complexType&gt;
                 *             &lt;complexContent&gt;
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
                 *                 &lt;sequence&gt;
                 *                   &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
                 *                   &lt;element name="typCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
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
                    protected List<DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation> cvrsRegulation;

                    /**
                     * Gets the value of the cvrsRegulation property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the cvrsRegulation property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getCVRSRegulation().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation }
                     * 
                     * 
                     */
                    public List<DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation> getCVRSRegulation() {
                        if (cvrsRegulation == null) {
                            cvrsRegulation = new ArrayList<DoServiceResponse.KBANK1554I01Response.CVRSInfo.RegulsObj.RegulsVect.CVRSRegulation>();
                        }
                        return this.cvrsRegulation;
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
                     *         &lt;element name="subTypCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
                     *         &lt;element name="typCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2" minOccurs="0"/&gt;
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
                        "subTypCode",
                        "typCode"
                    })
                    public static class CVRSRegulation {

                        @XmlElementRef(name = "subTypCode", namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", type = JAXBElement.class, required = false)
                        protected JAXBElement<String> subTypCode;
                        @XmlElementRef(name = "typCode", namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", type = JAXBElement.class, required = false)
                        protected JAXBElement<String> typCode;

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
                         * Gets the value of the typCode property.
                         * 
                         * @return
                         *     possible object is
                         *     {@link JAXBElement }{@code <}{@link String }{@code >}
                         *     
                         */
                        public JAXBElement<String> getTypCode() {
                            return typCode;
                        }

                        /**
                         * Sets the value of the typCode property.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link JAXBElement }{@code <}{@link String }{@code >}
                         *     
                         */
                        public void setTypCode(JAXBElement<String> value) {
                            this.typCode = value;
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
         *         &lt;element name="funcNm" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength30"/&gt;
         *         &lt;element name="rqUID" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength47"/&gt;
         *         &lt;element name="rsAppId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
         *         &lt;element name="rsUID" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength47"/&gt;
         *         &lt;element name="rsDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *         &lt;element name="statusCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2"/&gt;
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
         *                             &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
         *                             &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
         *                             &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength30"/&gt;
         *                             &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength256"/&gt;
         *                             &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2"/&gt;
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
         *         &lt;element name="corrID" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength32" minOccurs="0"/&gt;
         *         &lt;element name="reqAuthLevel" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}intLength3" minOccurs="0"/&gt;
         *         &lt;element name="reqAuthUserId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength15" minOccurs="0"/&gt;
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
            "corrID",
            "reqAuthLevel",
            "reqAuthUserId"
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
            protected DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect errorVect;
            @XmlElementRef(name = "corrID", namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", type = JAXBElement.class, required = false)
            protected JAXBElement<String> corrID;
            @XmlElementRef(name = "reqAuthLevel", namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", type = JAXBElement.class, required = false)
            protected JAXBElement<Integer> reqAuthLevel;
            @XmlElementRef(name = "reqAuthUserId", namespace = "http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1", type = JAXBElement.class, required = false)
            protected JAXBElement<String> reqAuthUserId;

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
             *     {@link DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect }
             *     
             */
            public DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect getErrorVect() {
                return errorVect;
            }

            /**
             * Sets the value of the errorVect property.
             * 
             * @param value
             *     allowed object is
             *     {@link DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect }
             *     
             */
            public void setErrorVect(DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect value) {
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
             * Gets the value of the reqAuthLevel property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
             *     
             */
            public JAXBElement<Integer> getReqAuthLevel() {
                return reqAuthLevel;
            }

            /**
             * Sets the value of the reqAuthLevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
             *     
             */
            public void setReqAuthLevel(JAXBElement<Integer> value) {
                this.reqAuthLevel = value;
            }

            /**
             * Gets the value of the reqAuthUserId property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getReqAuthUserId() {
                return reqAuthUserId;
            }

            /**
             * Sets the value of the reqAuthUserId property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setReqAuthUserId(JAXBElement<String> value) {
                this.reqAuthUserId = value;
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
             *                   &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
             *                   &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
             *                   &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength30"/&gt;
             *                   &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength256"/&gt;
             *                   &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2"/&gt;
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

                protected List<DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect.Error> error;

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
                 * {@link DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect.Error }
                 * 
                 * 
                 */
                public List<DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect.Error> getError() {
                    if (error == null) {
                        error = new ArrayList<DoServiceResponse.KBANK1554I01Response.KBankHeader.ErrorVect.Error>();
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
                 *         &lt;element name="errorAppId" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
                 *         &lt;element name="errorAppAbbrv" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength5"/&gt;
                 *         &lt;element name="errorCode" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength30"/&gt;
                 *         &lt;element name="errorDesc" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength256"/&gt;
                 *         &lt;element name="errorSeverity" type="{http://eai.kasikornbank.com/EAIWS/KBANK1554I01/v1}stringLength2"/&gt;
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
