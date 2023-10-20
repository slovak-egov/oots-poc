//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.12 at 09:38:05 AM CEST 
//


package sk.mirri.ootspoc.wsplugin.regrep4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Common base type for all types need to support extensibility via slots.
 *       
 * 
 * <p>Java class for ExtensibleObjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtensibleObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Slot" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}SlotType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtensibleObjectType", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", propOrder = {
    "slot"
})
@XmlSeeAlso({
    SlotType.class,
    QueryType.class,
    ObjectRefType.class,
    ActionType.class,
    PersonNameType.class,
    EmailAddressType.class,
    PostalAddressType.class,
    TelephoneNumberType.class,
    ParameterType.class,
    QueryExpressionType.class,
    DeliveryInfoType.class,
    IdentifiableType.class,
    RegistryExceptionType.class,
    RegistryResponseType.class,
    RegistryRequestType.class
})
public abstract class ExtensibleObjectType {

    @XmlElement(name = "Slot", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0")
    protected List<SlotType> slot;

    /**
     * Gets the value of the slot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlot().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SlotType }
     * 
     * 
     */
    public List<SlotType> getSlot() {
        if (slot == null) {
            slot = new ArrayList<SlotType>();
        }
        return this.slot;
    }

}
