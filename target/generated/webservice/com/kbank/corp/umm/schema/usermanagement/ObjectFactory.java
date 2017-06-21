
package com.kbank.corp.umm.schema.usermanagement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kbank.corp.umm.schema.usermanagement package. 
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

    private final static QName _CreateUserReq_QNAME = new QName("http://umm.corp.kbank.com/schema/UserManagement", "CreateUserReq");
    private final static QName _CreateUserRes_QNAME = new QName("http://umm.corp.kbank.com/schema/UserManagement", "CreateUserRes");
    private final static QName _ModifyUserReq_QNAME = new QName("http://umm.corp.kbank.com/schema/UserManagement", "ModifyUserReq");
    private final static QName _ModifyUserRes_QNAME = new QName("http://umm.corp.kbank.com/schema/UserManagement", "ModifyUserRes");
    private final static QName _DeleteUserReq_QNAME = new QName("http://umm.corp.kbank.com/schema/UserManagement", "DeleteUserReq");
    private final static QName _DeleteUserRes_QNAME = new QName("http://umm.corp.kbank.com/schema/UserManagement", "DeleteUserRes");
    private final static QName _CheckDeleteUserReq_QNAME = new QName("http://umm.corp.kbank.com/schema/UserManagement", "CheckDeleteUserReq");
    private final static QName _CheckDeleteUserRes_QNAME = new QName("http://umm.corp.kbank.com/schema/UserManagement", "CheckDeleteUserRes");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kbank.corp.umm.schema.usermanagement
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateUserReqBase }
     * 
     */
    public CreateUserReqBase createCreateUserReqBase() {
        return new CreateUserReqBase();
    }

    /**
     * Create an instance of {@link CreateUserResBase }
     * 
     */
    public CreateUserResBase createCreateUserResBase() {
        return new CreateUserResBase();
    }

    /**
     * Create an instance of {@link ModifyUserReqBase }
     * 
     */
    public ModifyUserReqBase createModifyUserReqBase() {
        return new ModifyUserReqBase();
    }

    /**
     * Create an instance of {@link ModifyUserResBase }
     * 
     */
    public ModifyUserResBase createModifyUserResBase() {
        return new ModifyUserResBase();
    }

    /**
     * Create an instance of {@link DeleteUserReqBase }
     * 
     */
    public DeleteUserReqBase createDeleteUserReqBase() {
        return new DeleteUserReqBase();
    }

    /**
     * Create an instance of {@link DeleteUserResBase }
     * 
     */
    public DeleteUserResBase createDeleteUserResBase() {
        return new DeleteUserResBase();
    }

    /**
     * Create an instance of {@link CheckDeleteUserReqBase }
     * 
     */
    public CheckDeleteUserReqBase createCheckDeleteUserReqBase() {
        return new CheckDeleteUserReqBase();
    }

    /**
     * Create an instance of {@link CheckDeleteUserResBase }
     * 
     */
    public CheckDeleteUserResBase createCheckDeleteUserResBase() {
        return new CheckDeleteUserResBase();
    }

    /**
     * Create an instance of {@link UserProfileBase }
     * 
     */
    public UserProfileBase createUserProfileBase() {
        return new UserProfileBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserReqBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/UserManagement", name = "CreateUserReq")
    public JAXBElement<CreateUserReqBase> createCreateUserReq(CreateUserReqBase value) {
        return new JAXBElement<CreateUserReqBase>(_CreateUserReq_QNAME, CreateUserReqBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateUserResBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/UserManagement", name = "CreateUserRes")
    public JAXBElement<CreateUserResBase> createCreateUserRes(CreateUserResBase value) {
        return new JAXBElement<CreateUserResBase>(_CreateUserRes_QNAME, CreateUserResBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUserReqBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/UserManagement", name = "ModifyUserReq")
    public JAXBElement<ModifyUserReqBase> createModifyUserReq(ModifyUserReqBase value) {
        return new JAXBElement<ModifyUserReqBase>(_ModifyUserReq_QNAME, ModifyUserReqBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUserResBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/UserManagement", name = "ModifyUserRes")
    public JAXBElement<ModifyUserResBase> createModifyUserRes(ModifyUserResBase value) {
        return new JAXBElement<ModifyUserResBase>(_ModifyUserRes_QNAME, ModifyUserResBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserReqBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/UserManagement", name = "DeleteUserReq")
    public JAXBElement<DeleteUserReqBase> createDeleteUserReq(DeleteUserReqBase value) {
        return new JAXBElement<DeleteUserReqBase>(_DeleteUserReq_QNAME, DeleteUserReqBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteUserResBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/UserManagement", name = "DeleteUserRes")
    public JAXBElement<DeleteUserResBase> createDeleteUserRes(DeleteUserResBase value) {
        return new JAXBElement<DeleteUserResBase>(_DeleteUserRes_QNAME, DeleteUserResBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDeleteUserReqBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/UserManagement", name = "CheckDeleteUserReq")
    public JAXBElement<CheckDeleteUserReqBase> createCheckDeleteUserReq(CheckDeleteUserReqBase value) {
        return new JAXBElement<CheckDeleteUserReqBase>(_CheckDeleteUserReq_QNAME, CheckDeleteUserReqBase.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckDeleteUserResBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://umm.corp.kbank.com/schema/UserManagement", name = "CheckDeleteUserRes")
    public JAXBElement<CheckDeleteUserResBase> createCheckDeleteUserRes(CheckDeleteUserResBase value) {
        return new JAXBElement<CheckDeleteUserResBase>(_CheckDeleteUserRes_QNAME, CheckDeleteUserResBase.class, null, value);
    }

}
