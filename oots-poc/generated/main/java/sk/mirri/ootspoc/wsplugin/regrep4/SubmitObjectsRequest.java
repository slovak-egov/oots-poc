//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.12 at 09:38:05 AM CEST 
//


package sk.mirri.ootspoc.wsplugin.regrep4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0}RegistryRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}RegistryObjectList" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="checkReferences" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="mode" type="{urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0}mode" default="CreateOrReplace" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "registryObjectList"
})
@XmlRootElement(name = "SubmitObjectsRequest", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0")
public class SubmitObjectsRequest
    extends RegistryRequestType
{

    @XmlElement(name = "RegistryObjectList", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0")
    protected RegistryObjectListType registryObjectList;
    @XmlAttribute(name = "checkReferences")
    protected Boolean checkReferences;
    @XmlAttribute(name = "mode")
    protected Mode mode;

    /**
     * Gets the value of the registryObjectList property.
     * 
     * @return
     *     possible object is
     *     {@link RegistryObjectListType }
     *     
     */
    public RegistryObjectListType getRegistryObjectList() {
        return registryObjectList;
    }

    /**
     * Sets the value of the registryObjectList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistryObjectListType }
     *     
     */
    public void setRegistryObjectList(RegistryObjectListType value) {
        this.registryObjectList = value;
    }

    /**
     * Gets the value of the checkReferences property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCheckReferences() {
        if (checkReferences == null) {
            return false;
        } else {
            return checkReferences;
        }
    }

    /**
     * Sets the value of the checkReferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckReferences(Boolean value) {
        this.checkReferences = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link Mode }
     *     
     */
    public Mode getMode() {
        if (mode == null) {
            return Mode.CREATE_OR_REPLACE;
        } else {
            return mode;
        }
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mode }
     *     
     */
    public void setMode(Mode value) {
        this.mode = value;
    }

}
