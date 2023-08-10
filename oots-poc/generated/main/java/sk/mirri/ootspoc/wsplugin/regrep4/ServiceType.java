//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.07 at 03:47:41 PM CEST 
//


package sk.mirri.ootspoc.wsplugin.regrep4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Represents a service in ebRIM.
 *         Matches service as defined in WSDL 2.
 *       
 * 
 * <p>Java class for ServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}RegistryObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceEndpoint" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ServiceEndpointType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="serviceInterface" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}objectReferenceType" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceType", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", propOrder = {
    "serviceEndpoint"
})
public class ServiceType
    extends RegistryObjectType
{

    @XmlElement(name = "ServiceEndpoint", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0")
    protected List<ServiceEndpointType> serviceEndpoint;
    @XmlAttribute(name = "serviceInterface")
    protected String serviceInterface;

    /**
     * Gets the value of the serviceEndpoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceEndpoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceEndpoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceEndpointType }
     * 
     * 
     */
    public List<ServiceEndpointType> getServiceEndpoint() {
        if (serviceEndpoint == null) {
            serviceEndpoint = new ArrayList<ServiceEndpointType>();
        }
        return this.serviceEndpoint;
    }

    /**
     * Gets the value of the serviceInterface property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceInterface() {
        return serviceInterface;
    }

    /**
     * Sets the value of the serviceInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceInterface(String value) {
        this.serviceInterface = value;
    }

}
