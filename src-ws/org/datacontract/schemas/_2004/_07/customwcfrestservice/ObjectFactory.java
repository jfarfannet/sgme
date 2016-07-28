
package org.datacontract.schemas._2004._07.customwcfrestservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.datacontract.schemas._2004._07.customwcfrestservice package. 
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

    private final static QName _WSASpDatosIesResult_QNAME = new QName("http://schemas.datacontract.org/2004/07/CustomWcfRestService.Models", "WSA_Sp_DatosIes_Result");
    private final static QName _WSASpDatosIesResultNombre_QNAME = new QName("http://schemas.datacontract.org/2004/07/CustomWcfRestService.Models", "Nombre");
    private final static QName _WSASpDatosIesResultDescripcion_QNAME = new QName("http://schemas.datacontract.org/2004/07/CustomWcfRestService.Models", "Descripcion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.datacontract.schemas._2004._07.customwcfrestservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WSASpDatosIesResult }
     * 
     */
    public WSASpDatosIesResult createWSASpDatosIesResult() {
        return new WSASpDatosIesResult();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WSASpDatosIesResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/CustomWcfRestService.Models", name = "WSA_Sp_DatosIes_Result")
    public JAXBElement<WSASpDatosIesResult> createWSASpDatosIesResult(WSASpDatosIesResult value) {
        return new JAXBElement<WSASpDatosIesResult>(_WSASpDatosIesResult_QNAME, WSASpDatosIesResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/CustomWcfRestService.Models", name = "Nombre", scope = WSASpDatosIesResult.class)
    public JAXBElement<String> createWSASpDatosIesResultNombre(String value) {
        return new JAXBElement<String>(_WSASpDatosIesResultNombre_QNAME, String.class, WSASpDatosIesResult.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/CustomWcfRestService.Models", name = "Descripcion", scope = WSASpDatosIesResult.class)
    public JAXBElement<String> createWSASpDatosIesResultDescripcion(String value) {
        return new JAXBElement<String>(_WSASpDatosIesResultDescripcion_QNAME, String.class, WSASpDatosIesResult.class, value);
    }

}
