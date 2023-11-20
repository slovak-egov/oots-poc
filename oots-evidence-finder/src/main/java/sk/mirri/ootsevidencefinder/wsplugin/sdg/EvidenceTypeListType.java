//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.19 at 05:27:25 PM CEST 
//


package sk.mirri.ootsevidencefinder.wsplugin.sdg;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EvidenceTypeListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EvidenceTypeListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://data.europa.eu/p4s}Identifier"/>
 *         &lt;element ref="{http://data.europa.eu/p4s}Name" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EvidenceType" type="{http://data.europa.eu/p4s}EvidenceTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EvidenceTypeListType", propOrder = {
    "identifier",
    "name",
    "evidenceType"
})
public class EvidenceTypeListType {

    @XmlElement(name = "Identifier", required = true)
    protected IdentifierType identifier;
    @XmlElement(name = "Name")
    protected List<MultilingualStringType> name;
    @XmlElement(name = "EvidenceType")
    protected List<EvidenceTypeType> evidenceType;

    /**
     * Gets the value of the identifier property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifierType }
     *     
     */
    public IdentifierType getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierType }
     *     
     */
    public void setIdentifier(IdentifierType value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultilingualStringType }
     * 
     * 
     */
    public List<MultilingualStringType> getName() {
        if (name == null) {
            name = new ArrayList<MultilingualStringType>();
        }
        return this.name;
    }

    /**
     * Gets the value of the evidenceType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evidenceType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvidenceType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvidenceTypeType }
     * 
     * 
     */
    public List<EvidenceTypeType> getEvidenceType() {
        if (evidenceType == null) {
            evidenceType = new ArrayList<EvidenceTypeType>();
        }
        return this.evidenceType;
    }

}
