
package com.kbank.corp.umm.schema.companymanagement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kbank.corp.umm.schema.companymanagement package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateCompanyReq_QNAME = new QName("http://umm.corp.kbank.com/schema/CompanyManagement", "CreateCompanyReq");
    private final static QName _CreateCompanyRes_QNAME = new QName("http://umm.corp.kbank.com/schema/CompanyManagement", "CreateCompanyRes");
    private final static QName _ModifyCompanyReq_QNAME = new QName("http://umm.corp.kbank.com/schema/CompanyManagement", "ModifyCompanyReq");
    private final static QName _ModifyCompanyRes_QNAME = new QName("http://umm.corp.kbank.com/schema/CompanyManagement", "ModifyCompanyRes");
    private final static QName _DeleteCompanyReq_QNAME = new QName("http://umm.corp.kbank.com/schema/CompanyManagement", "DeleteCompanyReq");
    private final static QName _DeleteCompanyRes_QNAME = new QName("http://umm.corp.kbank.com/schema/CompanyManagement", "DeleteCompanyRes");
    private final static QName _CheckDeleteCompanyReq_QNAME = new QName("http://umm.corp.kbank.com/schema/CompanyManagement", "CheckDeleteCompanyReq");
    private final static QName _CheckDeleteCompanyRes_QNAME = new QName("http://umm.corp.kbank.com/schema/CompanyManagement", "CheckDeleteCompanyRes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kbank.corp.umm.schema.companymanagement
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateCompanyReqBase }
     * 
     */
    public CreateCompanyReqBase createCreateCompanyReqBase() {
        return new CreateCompanyReqBase();
    }

    /**
     * Create an instance of {@link CreateCompanyResBase }
     * 
     */
    public CreateCompanyResBase createCreateCompanyResBase() {
        return new CreateCompanyResBase();
    }

    /**
     * Create an instance of {@link ModifyCompanyReqBase }
     * 
     */
    public ModifyCompanyReqBase createModifyCompanyReqBase() {
        return new ModifyCompanyReqBase();
    }

    /**
     * Create an instance of {@link ModifyCompanyResBase }
     * 
     */
    public ModifyCompanyResBase createModifyCompanyResBase() {
        return new ModifyCompanyResBase();
    }

    /**
     * Create an instance of {@link DeleteCompanyReqBase }
     * 
     */
    public DeleteCompanyReqBase createDeleteCompanyReqBase() {
        return new DeleteCompanyReqBase();
    }

    /**
     * Create an instance of {@link DeleteCompanyResBase }
     * 
     */
    public DeleteCompanyResBase createDeleteCompanyResBase() {
        return new DeleteCompanyResBase();
    }

    /**
     * Create an instance of {@link CheckDeleteCompanyReqBase }
     * 
     */
    public CheckDeleteCompanyReqBase createCheckDeleteCompanyReqBase() {
        return new CheckDeleteCompanyReqBase();
    }

    /**
     * Create an instance of {@link CheckDeleteCompanyResBase }
     * 
     */
    public CheckDeleteCompanyResBase createCheckDeleteCompanyResBase() {
        return new CheckDeleteCompanyResBase();
    }

    /**
     * Create an instance of {@link CompanyProfileBase }
     * 
     */
    public CompanyProfileBase createCompanyProfileBase() {
        return new CompanyProfileBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCompanyReqBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/CompanyManagement", name = "CreateCompanyReq")
    public JAXBElement<CreateCompanyReqBase> createCreateCompanyReq(CreateCompanyReqBase value) {
        return new JAXBElement<CreateCompanyReqBase>(_CreateCompanyReq_QNAME, CreateCompanyReqBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCompanyResBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/CompanyManagement", name = "CreateCompanyRes")
    public JAXBElement<CreateCompanyResBase> createCreateCompanyRes(CreateCompanyResBase value) {
        return new JAXBElement<CreateCompanyResBase>(_CreateCompanyRes_QNAME, CreateCompanyResBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyCompanyReqBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/CompanyManagement", name = "ModifyCompanyReq")
    public JAXBElement<ModifyCompanyReqBase> createModifyCompanyReq(ModifyCompanyReqBase value) {
        return new JAXBElement<ModifyCompanyReqBase>(_ModifyCompanyReq_QNAME, ModifyCompanyReqBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyCompanyResBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/CompanyManagement", name = "ModifyCompanyRes")
    public JAXBElement<ModifyCompanyResBase> createModifyCompanyRes(ModifyCompanyResBase value) {
        return new JAXBElement<ModifyCompanyResBase>(_ModifyCompanyRes_QNAME, ModifyCompanyResBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCompanyReqBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/CompanyManagement", name = "DeleteCompanyReq")
    public JAXBElement<DeleteCompanyReqBase> createDeleteCompanyReq(DeleteCompanyReqBase value) {
        return new JAXBElement<DeleteCompanyReqBase>(_DeleteCompanyReq_QNAME, DeleteCompanyReqBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCompanyResBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/CompanyManagement", name = "DeleteCompanyRes")
    public JAXBElement<DeleteCompanyResBase> createDeleteCompanyRes(DeleteCompanyResBase value) {
        return new JAXBElement<DeleteCompanyResBase>(_DeleteCompanyRes_QNAME, DeleteCompanyResBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDeleteCompanyReqBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/CompanyManagement", name = "CheckDeleteCompanyReq")
    public JAXBElement<CheckDeleteCompanyReqBase> createCheckDeleteCompanyReq(CheckDeleteCompanyReqBase value) {
        return new JAXBElement<CheckDeleteCompanyReqBase>(_CheckDeleteCompanyReq_QNAME, CheckDeleteCompanyReqBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDeleteCompanyResBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/CompanyManagement", name = "CheckDeleteCompanyRes")
    public JAXBElement<CheckDeleteCompanyResBase> createCheckDeleteCompanyRes(CheckDeleteCompanyResBase value) {
        return new JAXBElement<CheckDeleteCompanyResBase>(_CheckDeleteCompanyRes_QNAME, CheckDeleteCompanyResBase.class, null, value);
    }

}
