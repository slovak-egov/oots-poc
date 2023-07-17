//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.17 at 08:38:25 PM CEST 
//


package sk.mirri.ootspoc.wsplugin.regrep4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 *       
 * 
 * <p>Java class for UpdateActionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateActionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ValueHolder" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ValueType" minOccurs="0"/&gt;
 *         &lt;element name="Selector" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}QueryExpressionType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="mode" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName"&gt;
 *             &lt;enumeration value="Insert"/&gt;
 *             &lt;enumeration value="Update"/&gt;
 *             &lt;enumeration value="Delete"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateActionType", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0", propOrder = {
    "valueHolder",
    "selector"
})
public class UpdateActionType {

    @XmlElement(name = "ValueHolder", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0")
    protected ValueType valueHolder;
    @XmlElement(name = "Selector", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0", required = true)
    protected QueryExpressionType selector;
    @XmlAttribute(name = "mode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mode;

    /**
     * Gets the value of the valueHolder property.
     * 
     * @return
     *     possible object is
     *     {@link ValueType }
     *     
     */
    public ValueType getValueHolder() {
        return valueHolder;
    }

    /**
     * Sets the value of the valueHolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueType }
     *     
     */
    public void setValueHolder(ValueType value) {
        this.valueHolder = value;
    }

    /**
     * Gets the value of the selector property.
     * 
     * @return
     *     possible object is
     *     {@link QueryExpressionType }
     *     
     */
    public QueryExpressionType getSelector() {
        return selector;
    }

    /**
     * Sets the value of the selector property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryExpressionType }
     *     
     */
    public void setSelector(QueryExpressionType value) {
        this.selector = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMode(String value) {
        this.mode = value;
    }

}