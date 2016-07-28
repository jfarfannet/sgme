
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.datacontract.schemas._2004._07.customwcfrestservice.WSASpDatosIesResult;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
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

    private final static QName _LoginPassword_QNAME = new QName("http://tempuri.org/", "password");
    private final static QName _LoginUserName_QNAME = new QName("http://tempuri.org/", "userName");
    private final static QName _InfoInstitucionJsonResponseInfoInstitucionJsonResult_QNAME = new QName("http://tempuri.org/", "InfoInstitucionJsonResult");
    private final static QName _InfoInstitucionXMLResponseInfoInstitucionXMLResult_QNAME = new QName("http://tempuri.org/", "InfoInstitucionXMLResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link InfoInstitucionXMLResponse }
     * 
     */
    public InfoInstitucionXMLResponse createInfoInstitucionXMLResponse() {
        return new InfoInstitucionXMLResponse();
    }

    /**
     * Create an instance of {@link InfoInstitucionJson }
     * 
     */
    public InfoInstitucionJson createInfoInstitucionJson() {
        return new InfoInstitucionJson();
    }

    /**
     * Create an instance of {@link InfoInstitucionXML }
     * 
     */
    public InfoInstitucionXML createInfoInstitucionXML() {
        return new InfoInstitucionXML();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link InfoInstitucionJsonResponse }
     * 
     */
    public InfoInstitucionJsonResponse createInfoInstitucionJsonResponse() {
        return new InfoInstitucionJsonResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "password", scope = Login.class)
    public JAXBElement<String> createLoginPassword(String value) {
        return new JAXBElement<String>(_LoginPassword_QNAME, String.class, Login.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "userName", scope = Login.class)
    public JAXBElement<String> createLoginUserName(String value) {
        return new JAXBElement<String>(_LoginUserName_QNAME, String.class, Login.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "InfoInstitucionJsonResult", scope = InfoInstitucionJsonResponse.class)
    public JAXBElement<String> createInfoInstitucionJsonResponseInfoInstitucionJsonResult(String value) {
        return new JAXBElement<String>(_InfoInstitucionJsonResponseInfoInstitucionJsonResult_QNAME, String.class, InfoInstitucionJsonResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WSASpDatosIesResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "InfoInstitucionXMLResult", scope = InfoInstitucionXMLResponse.class)
    public JAXBElement<WSASpDatosIesResult> createInfoInstitucionXMLResponseInfoInstitucionXMLResult(WSASpDatosIesResult value) {
        return new JAXBElement<WSASpDatosIesResult>(_InfoInstitucionXMLResponseInfoInstitucionXMLResult_QNAME, WSASpDatosIesResult.class, InfoInstitucionXMLResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "password", scope = InfoInstitucionXML.class)
    public JAXBElement<String> createInfoInstitucionXMLPassword(String value) {
        return new JAXBElement<String>(_LoginPassword_QNAME, String.class, InfoInstitucionXML.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "userName", scope = InfoInstitucionXML.class)
    public JAXBElement<String> createInfoInstitucionXMLUserName(String value) {
        return new JAXBElement<String>(_LoginUserName_QNAME, String.class, InfoInstitucionXML.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "password", scope = InfoInstitucionJson.class)
    public JAXBElement<String> createInfoInstitucionJsonPassword(String value) {
        return new JAXBElement<String>(_LoginPassword_QNAME, String.class, InfoInstitucionJson.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "userName", scope = InfoInstitucionJson.class)
    public JAXBElement<String> createInfoInstitucionJsonUserName(String value) {
        return new JAXBElement<String>(_LoginUserName_QNAME, String.class, InfoInstitucionJson.class, value);
    }

}
