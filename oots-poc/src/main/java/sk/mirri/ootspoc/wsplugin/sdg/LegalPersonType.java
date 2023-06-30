//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.19 at 05:27:25 PM CEST 
//


package sk.mirri.ootspoc.wsplugin.sdg;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LegalPersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LegalPersonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LevelOfAssurance" type="{http://data.europa.eu/p4s}CodeType" minOccurs="0"/>
 *         &lt;element ref="{http://data.europa.eu/p4s}Identifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LegalPersonIdentifier" type="{http://data.europa.eu/p4s}IdentifierType" minOccurs="0"/>
 *         &lt;element name="LegalName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegisteredAddress" type="{http://data.europa.eu/p4s}AddressType" minOccurs="0"/>
 *         &lt;element name="SectorSpecificAttribute" type="{http://data.europa.eu/p4s}AttributeKeyValuePairType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LegalPersonType", propOrder = {
    "levelOfAssurance",
    "identifier",
    "legalPersonIdentifier",
    "legalName",
    "registeredAddress",
    "sectorSpecificAttribute"
})
public class LegalPersonType {

    @XmlElement(name = "LevelOfAssurance")
    protected CodeType levelOfAssurance;
    @XmlElement(name = "Identifier")
    protected List<IdentifierType> identifier;
    @XmlElement(name = "LegalPersonIdentifier")
    protected IdentifierType legalPersonIdentifier;
    @XmlElement(name = "LegalName", required = true)
    protected String legalName;
    @XmlElement(name = "RegisteredAddress")
    protected AddressType registeredAddress;
    @XmlElement(name = "SectorSpecificAttribute")
    protected List<AttributeKeyValuePairType> sectorSpecificAttribute;

    /**
     * Gets the value of the levelOfAssurance property.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getLevelOfAssurance() {
        return levelOfAssurance;
    }

    /**
     * Sets the value of the levelOfAssurance property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setLevelOfAssurance(CodeType value) {
        this.levelOfAssurance = value;
    }

    /**
     * Gets the value of the identifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentifierType }
     * 
     * 
     */
    public List<IdentifierType> getIdentifier() {
        if (identifier == null) {
            identifier = new ArrayList<IdentifierType>();
        }
        return this.identifier;
    }

    /**
     * Gets the value of the legalPersonIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link IdentifierType }
     *     
     */
    public IdentifierType getLegalPersonIdentifier() {
        return legalPersonIdentifier;
    }

    /**
     * Sets the value of the legalPersonIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentifierType }
     *     
     */
    public void setLegalPersonIdentifier(IdentifierType value) {
        this.legalPersonIdentifier = value;
    }

    /**
     * Gets the value of the legalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * Sets the value of the legalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLegalName(String value) {
        this.legalName = value;
    }

    /**
     * Gets the value of the registeredAddress property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getRegisteredAddress() {
        return registeredAddress;
    }

    /**
     * Sets the value of the registeredAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setRegisteredAddress(AddressType value) {
        this.registeredAddress = value;
    }

    /**
     * Gets the value of the sectorSpecificAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sectorSpecificAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSectorSpecificAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AttributeKeyValuePairType }
     * 
     * 
     */
    public List<AttributeKeyValuePairType> getSectorSpecificAttribute() {
        if (sectorSpecificAttribute == null) {
            sectorSpecificAttribute = new ArrayList<AttributeKeyValuePairType>();
        }
        return this.sectorSpecificAttribute;
    }

}