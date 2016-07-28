
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.customwcfrestservice.WSASpDatosIesResult;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InfoInstitucionXMLResult" type="{http://schemas.datacontract.org/2004/07/CustomWcfRestService.Models}WSA_Sp_DatosIes_Result" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "infoInstitucionXMLResult"
})
@XmlRootElement(name = "InfoInstitucionXMLResponse")
public class InfoInstitucionXMLResponse {

    @XmlElementRef(name = "InfoInstitucionXMLResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<WSASpDatosIesResult> infoInstitucionXMLResult;

    /**
     * Gets the value of the infoInstitucionXMLResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WSASpDatosIesResult }{@code >}
     *     
     */
    public JAXBElement<WSASpDatosIesResult> getInfoInstitucionXMLResult() {
        return infoInstitucionXMLResult;
    }

    /**
     * Sets the value of the infoInstitucionXMLResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WSASpDatosIesResult }{@code >}
     *     
     */
    public void setInfoInstitucionXMLResult(JAXBElement<WSASpDatosIesResult> value) {
        this.infoInstitucionXMLResult = value;
    }

}
