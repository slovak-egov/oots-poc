//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.12 at 09:38:05 AM CEST 
//


package sk.mirri.ootspoc.wsplugin.regrep4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A specialized ValueType that may be used as a container for a Slot value.
 *       
 * 
 * <p>Java class for SlotValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SlotValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ValueType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Slot" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}SlotType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SlotValueType", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", propOrder = {
    "slot"
})
public class SlotValueType
    extends ValueType
{

    @XmlElement(name = "Slot", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0")
    protected SlotType slot;

    /**
     * Gets the value of the slot property.
     * 
     * @return
     *     possible object is
     *     {@link SlotType }
     *     
     */
    public SlotType getSlot() {
        return slot;
    }

    /**
     * Sets the value of the slot property.
     * 
     * @param value
     *     allowed object is
     *     {@link SlotType }
     *     
     */
    public void setSlot(SlotType value) {
        this.slot = value;
    }

}