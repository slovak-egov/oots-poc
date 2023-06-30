//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.19 at 05:27:25 PM CEST 
//


package sk.mirri.ootspoc.wsplugin.sdg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EvidenceTypeDistributionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EvidenceTypeDistributionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Format" type="{http://data.europa.eu/p4s}CodeType"/>
 *         &lt;element ref="{http://data.europa.eu/p4s}ConformsTo" minOccurs="0"/>
 *         &lt;element name="Transformation" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceTypeDistributionType", propOrder = {
    "format",
    "conformsTo",
    "transformation"
})
public class EvidenceTypeDistributionType {

    @XmlElement(name = "Format", required = true)
    protected CodeType format;
    @XmlElement(name = "ConformsTo")
    @XmlSchemaType(name = "anyURI")
    protected String conformsTo;
    @XmlElement(name = "Transformation")
    @XmlSchemaType(name = "anyURI")
    protected String transformation;

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setFormat(CodeType value) {
        this.format = value;
    }

    /**
     * Gets the value of the conformsTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConformsTo() {
        return conformsTo;
    }

    /**
     * Sets the value of the conformsTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConformsTo(String value) {
        this.conformsTo = value;
    }

    /**
     * Gets the value of the transformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransformation() {
        return transformation;
    }

    /**
     * Sets the value of the transformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransformation(String value) {
        this.transformation = value;
    }

}
