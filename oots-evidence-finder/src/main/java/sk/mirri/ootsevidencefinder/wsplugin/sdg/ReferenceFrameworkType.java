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
 * <p>Java class for ReferenceFrameworkType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReferenceFrameworkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://data.europa.eu/p4s}Identifier"/>
 *         &lt;element ref="{http://data.europa.eu/p4s}Title" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://data.europa.eu/p4s}Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="RelatedTo" type="{http://data.europa.eu/p4s}ReferenceFrameworkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://data.europa.eu/p4s}Jurisdiction" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferenceFrameworkType", propOrder = {
    "identifier",
    "title",
    "description",
    "relatedTo",
    "jurisdiction"
})
public class ReferenceFrameworkType {

    @XmlElement(name = "Identifier", required = true)
    protected IdentifierType identifier;
    @XmlElement(name = "Title")
    protected List<MultilingualStringType> title;
    @XmlElement(name = "Description")
    protected List<MultilingualStringType> description;
    @XmlElement(name = "RelatedTo")
    protected List<ReferenceFrameworkType> relatedTo;
    @XmlElement(name = "Jurisdiction")
    protected JurisdictionType jurisdiction;

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
     * Gets the value of the title property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the title property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTitle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultilingualStringType }
     * 
     * 
     */
    public List<MultilingualStringType> getTitle() {
        if (title == null) {
            title = new ArrayList<MultilingualStringType>();
        }
        return this.title;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultilingualStringType }
     * 
     * 
     */
    public List<MultilingualStringType> getDescription() {
        if (description == null) {
            description = new ArrayList<MultilingualStringType>();
        }
        return this.description;
    }

    /**
     * Gets the value of the relatedTo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relatedTo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedTo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceFrameworkType }
     * 
     * 
     */
    public List<ReferenceFrameworkType> getRelatedTo() {
        if (relatedTo == null) {
            relatedTo = new ArrayList<ReferenceFrameworkType>();
        }
        return this.relatedTo;
    }

    /**
     * Gets the value of the jurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link JurisdictionType }
     *     
     */
    public JurisdictionType getJurisdiction() {
        return jurisdiction;
    }

    /**
     * Sets the value of the jurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JurisdictionType }
     *     
     */
    public void setJurisdiction(JurisdictionType value) {
        this.jurisdiction = value;
    }

}