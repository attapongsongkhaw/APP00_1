
package com.kbank.corp.umm.schema.ummcommon;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.kbank.corp.umm.schema.ummcommon package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.kbank.corp.umm.schema.ummcommon
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UMMRequestBase }
     * 
     */
    public UMMRequestBase createUMMRequestBase() {
        return new UMMRequestBase();
    }

    /**
     * Create an instance of {@link UMMResponseBase }
     * 
     */
    public UMMResponseBase createUMMResponseBase() {
        return new UMMResponseBase();
    }

    /**
     * Create an instance of {@link Contactpoints }
     * 
     */
    public Contactpoints createContactpoints() {
        return new Contactpoints();
    }

    /**
     * Create an instance of {@link Contactpoint }
     * 
     */
    public Contactpoint createContactpoint() {
        return new Contactpoint();
    }

    /**
     * Create an instance of {@link Services }
     * 
     */
    public Services createServices() {
        return new Services();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link Addresses }
     * 
     */
    public Addresses createAddresses() {
        return new Addresses();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link TokenBase }
     * 
     */
    public TokenBase createTokenBase() {
        return new TokenBase();
    }

}
