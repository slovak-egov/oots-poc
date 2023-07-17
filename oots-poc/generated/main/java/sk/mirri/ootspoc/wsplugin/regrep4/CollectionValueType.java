//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.17 at 08:38:25 PM CEST 
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
 *         A specialized ValueType that may be used as a container for a collection of elements where each element is a ValueType.
 *       
 * 
 * <p>Java class for CollectionValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CollectionValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ValueType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Element" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ValueType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="collectionType" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}objectReferenceType" default="urn:oasis:names:tc:ebxml-regrep:CollectionType:Bag" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollectionValueType", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", propOrder = {
    "element"
})
public class CollectionValueType
    extends ValueType
{

    @XmlElement(name = "Element", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0")
    protected List<ValueType> element;
    @XmlAttribute(name = "collectionType")
    protected String collectionType;

    /**
     * Gets the value of the element property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the element property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueType }
     * 
     * 
     */
    public List<ValueType> getElement() {
        if (element == null) {
            element = new ArrayList<ValueType>();
        }
        return this.element;
    }

    /**
     * Gets the value of the collectionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionType() {
        if (collectionType == null) {
            return "urn:oasis:names:tc:ebxml-regrep:CollectionType:Bag";
        } else {
            return collectionType;
        }
    }

    /**
     * Sets the value of the collectionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionType(String value) {
        this.collectionType = value;
    }

}