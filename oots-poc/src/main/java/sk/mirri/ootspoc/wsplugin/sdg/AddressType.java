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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FullAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocatorDesignator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostCityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Thoroughfare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdminUnitLevel1" type="{http://data.europa.eu/p4s}CodeType"/>
 *         &lt;element name="AdminUnitLevel2" type="{http://data.europa.eu/p4s}CodeType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "fullAddress",
    "locatorDesignator",
    "postCode",
    "postCityName",
    "thoroughfare",
    "adminUnitLevel1",
    "adminUnitLevel2"
})
public class AddressType {

    @XmlElement(name = "FullAddress")
    protected String fullAddress;
    @XmlElement(name = "LocatorDesignator")
    protected String locatorDesignator;
    @XmlElement(name = "PostCode")
    protected String postCode;
    @XmlElement(name = "PostCityName")
    protected String postCityName;
    @XmlElement(name = "Thoroughfare")
    protected String thoroughfare;
    @XmlElement(name = "AdminUnitLevel1", required = true)
    protected CodeType adminUnitLevel1;
    @XmlElement(name = "AdminUnitLevel2")
    protected CodeType adminUnitLevel2;

    /**
     * Gets the value of the fullAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullAddress() {
        return fullAddress;
    }

    /**
     * Sets the value of the fullAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullAddress(String value) {
        this.fullAddress = value;
    }

    /**
     * Gets the value of the locatorDesignator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocatorDesignator() {
        return locatorDesignator;
    }

    /**
     * Sets the value of the locatorDesignator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocatorDesignator(String value) {
        this.locatorDesignator = value;
    }

    /**
     * Gets the value of the postCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the postCityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostCityName() {
        return postCityName;
    }

    /**
     * Sets the value of the postCityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostCityName(String value) {
        this.postCityName = value;
    }

    /**
     * Gets the value of the thoroughfare property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThoroughfare() {
        return thoroughfare;
    }

    /**
     * Sets the value of the thoroughfare property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThoroughfare(String value) {
        this.thoroughfare = value;
    }

    /**
     * Gets the value of the adminUnitLevel1 property.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getAdminUnitLevel1() {
        return adminUnitLevel1;
    }

    /**
     * Sets the value of the adminUnitLevel1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setAdminUnitLevel1(CodeType value) {
        this.adminUnitLevel1 = value;
    }

    /**
     * Gets the value of the adminUnitLevel2 property.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getAdminUnitLevel2() {
        return adminUnitLevel2;
    }

    /**
     * Sets the value of the adminUnitLevel2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setAdminUnitLevel2(CodeType value) {
        this.adminUnitLevel2 = value;
    }

}