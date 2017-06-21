
package com.kasikornbank.eai.eaiws.cbs1183i01.v2;

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
 *         &lt;element name="CBS1183I01"&gt;
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
 *                             &lt;element name="rqDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                             &lt;element name="rqAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
 *                             &lt;element name="userId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength32"/&gt;
 *                             &lt;element name="terminalId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength8"/&gt;
 *                             &lt;element name="userLangPref" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2" minOccurs="0"/&gt;
 *                             &lt;element name="corrID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength32" minOccurs="0"/&gt;
 *                             &lt;element name="authUserId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength15" minOccurs="0"/&gt;
 *                             &lt;element name="authLevel" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}intLength3" minOccurs="0"/&gt;
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
 *                             &lt;element name="AcctId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength10"/&gt;
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
    "cbs1183I01"
})
public class DoService {

    @XmlElement(name = "CBS1183I01", required = true)
    protected DoService.CBS1183I01 cbs1183I01;

    /**
     * Gets the value of the cbs1183I01 property.
     * 
     * @return
     *     possible object is
     *     {@link DoService.CBS1183I01 }
     *     
     */
    public DoService.CBS1183I01 getCBS1183I01() {
        return cbs1183I01;
    }

    /**
     * Sets the value of the cbs1183I01 property.
     * 
     * @param value
     *     allowed object is
     *     {@link DoService.CBS1183I01 }
     *     
     */
    public void setCBS1183I01(DoService.CBS1183I01 value) {
        this.cbs1183I01 = value;
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
     *                   &lt;element name="rqDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                   &lt;element name="rqAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
     *                   &lt;element name="userId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength32"/&gt;
     *                   &lt;element name="terminalId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength8"/&gt;
     *                   &lt;element name="userLangPref" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2" minOccurs="0"/&gt;
     *                   &lt;element name="corrID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength32" minOccurs="0"/&gt;
     *                   &lt;element name="authUserId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength15" minOccurs="0"/&gt;
     *                   &lt;element name="authLevel" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}intLength3" minOccurs="0"/&gt;
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
     *                   &lt;element name="AcctId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength10"/&gt;
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
    @XmlRootElement(name = "CBS1183I01")
    public static class CBS1183I01 {

        @XmlElement(name = "KBankHeader", required = true)
        protected DoService.CBS1183I01 .KBankHeader kBankHeader;
        @XmlElement(name = "CBSAccount")
        protected DoService.CBS1183I01 .CBSAccount cbsAccount;

        /**
         * Gets the value of the kBankHeader property.
         * 
         * @return
         *     possible object is
         *     {@link DoService.CBS1183I01 .KBankHeader }
         *     
         */
        public DoService.CBS1183I01 .KBankHeader getKBankHeader() {
            return kBankHeader;
        }

        /**
         * Sets the value of the kBankHeader property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoService.CBS1183I01 .KBankHeader }
         *     
         */
        public void setKBankHeader(DoService.CBS1183I01 .KBankHeader value) {
            this.kBankHeader = value;
        }

        /**
         * Gets the value of the cbsAccount property.
         * 
         * @return
         *     possible object is
         *     {@link DoService.CBS1183I01 .CBSAccount }
         *     
         */
        public DoService.CBS1183I01 .CBSAccount getCBSAccount() {
            return cbsAccount;
        }

        /**
         * Sets the value of the cbsAccount property.
         * 
         * @param value
         *     allowed object is
         *     {@link DoService.CBS1183I01 .CBSAccount }
         *     
         */
        public void setCBSAccount(DoService.CBS1183I01 .CBSAccount value) {
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
         *         &lt;element name="AcctId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength10"/&gt;
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
            "acctId"
        })
        public static class CBSAccount {

            @XmlElement(name = "AcctId", required = true, nillable = true)
            protected String acctId;

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
         *         &lt;element name="rqDt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *         &lt;element name="rqAppId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength5"/&gt;
         *         &lt;element name="userId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength32"/&gt;
         *         &lt;element name="terminalId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength8"/&gt;
         *         &lt;element name="userLangPref" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength2" minOccurs="0"/&gt;
         *         &lt;element name="corrID" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength32" minOccurs="0"/&gt;
         *         &lt;element name="authUserId" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}stringLength15" minOccurs="0"/&gt;
         *         &lt;element name="authLevel" type="{http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2}intLength3" minOccurs="0"/&gt;
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
            "rqDt",
            "rqAppId",
            "userId",
            "terminalId",
            "userLangPref",
            "corrID",
            "authUserId",
            "authLevel"
        })
        public static class KBankHeader {

            @XmlElement(required = true, nillable = true)
            protected String funcNm;
            @XmlElement(required = true, nillable = true)
            protected String rqUID;
            @XmlElement(required = true, nillable = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar rqDt;
            @XmlElement(required = true, nillable = true)
            protected String rqAppId;
            @XmlElement(required = true, nillable = true)
            protected String userId;
            @XmlElement(required = true, nillable = true)
            protected String terminalId;
            @XmlElementRef(name = "userLangPref", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> userLangPref;
            @XmlElementRef(name = "corrID", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> corrID;
            @XmlElementRef(name = "authUserId", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<String> authUserId;
            @XmlElementRef(name = "authLevel", namespace = "http://eai.kasikornbank.com/EAIWS/CBS1183I01/v2", type = JAXBElement.class, required = false)
            protected JAXBElement<Integer> authLevel;

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
             * Gets the value of the rqDt property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getRqDt() {
                return rqDt;
            }

            /**
             * Sets the value of the rqDt property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setRqDt(XMLGregorianCalendar value) {
                this.rqDt = value;
            }

            /**
             * Gets the value of the rqAppId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRqAppId() {
                return rqAppId;
            }

            /**
             * Sets the value of the rqAppId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRqAppId(String value) {
                this.rqAppId = value;
            }

            /**
             * Gets the value of the userId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUserId() {
                return userId;
            }

            /**
             * Sets the value of the userId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUserId(String value) {
                this.userId = value;
            }

            /**
             * Gets the value of the terminalId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTerminalId() {
                return terminalId;
            }

            /**
             * Sets the value of the terminalId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTerminalId(String value) {
                this.terminalId = value;
            }

            /**
             * Gets the value of the userLangPref property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getUserLangPref() {
                return userLangPref;
            }

            /**
             * Sets the value of the userLangPref property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setUserLangPref(JAXBElement<String> value) {
                this.userLangPref = value;
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
             * Gets the value of the authUserId property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getAuthUserId() {
                return authUserId;
            }

            /**
             * Sets the value of the authUserId property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setAuthUserId(JAXBElement<String> value) {
                this.authUserId = value;
            }

            /**
             * Gets the value of the authLevel property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
             *     
             */
            public JAXBElement<Integer> getAuthLevel() {
                return authLevel;
            }

            /**
             * Sets the value of the authLevel property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
             *     
             */
            public void setAuthLevel(JAXBElement<Integer> value) {
                this.authLevel = value;
            }

        }

    }

}
