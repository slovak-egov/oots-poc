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
 * <p>Java class for JurisdictionDeterminationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JurisdictionDeterminationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JurisdictionContextId" type="{http://data.europa.eu/p4s}CodeType"/>
 *         &lt;element name="JurisdictionContext" type="{http://data.europa.eu/p4s}MultilingualStringType" maxOccurs="unbounded"/>
 *         &lt;element name="JurisdictionLevel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JurisdictionDeterminationType", propOrder = {
    "jurisdictionContextId",
    "jurisdictionContext",
    "jurisdictionLevel"
})
public class JurisdictionDeterminationType {

    @XmlElement(name = "JurisdictionContextId", required = true)
    protected CodeType jurisdictionContextId;
    @XmlElement(name = "JurisdictionContext", required = true)
    protected List<MultilingualStringType> jurisdictionContext;
    @XmlElement(name = "JurisdictionLevel", required = true)
    protected String jurisdictionLevel;

    /**
     * Gets the value of the jurisdictionContextId property.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getJurisdictionContextId() {
        return jurisdictionContextId;
    }

    /**
     * Sets the value of the jurisdictionContextId property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setJurisdictionContextId(CodeType value) {
        this.jurisdictionContextId = value;
    }

    /**
     * Gets the value of the jurisdictionContext property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jurisdictionContext property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJurisdictionContext().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultilingualStringType }
     * 
     * 
     */
    public List<MultilingualStringType> getJurisdictionContext() {
        if (jurisdictionContext == null) {
            jurisdictionContext = new ArrayList<MultilingualStringType>();
        }
        return this.jurisdictionContext;
    }

    /**
     * Gets the value of the jurisdictionLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdictionLevel() {
        return jurisdictionLevel;
    }

    /**
     * Sets the value of the jurisdictionLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdictionLevel(String value) {
        this.jurisdictionLevel = value;
    }

}