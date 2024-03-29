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
 * <p>Java class for RequirementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequirementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://data.europa.eu/p4s}Identifier"/>
 *         &lt;element ref="{http://data.europa.eu/p4s}Name" maxOccurs="unbounded"/>
 *         &lt;element name="ReferenceFramework" type="{http://data.europa.eu/p4s}ReferenceFrameworkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EvidenceTypeList" type="{http://data.europa.eu/p4s}EvidenceTypeListType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequirementType", propOrder = {
    "identifier",
    "name",
    "referenceFramework",
    "evidenceTypeList"
})
public class RequirementType {

    @XmlElement(name = "Identifier", required = true)
    protected IdentifierType identifier;
    @XmlElement(name = "Name", required = true)
    protected List<MultilingualStringType> name;
    @XmlElement(name = "ReferenceFramework")
    protected List<ReferenceFrameworkType> referenceFramework;
    @XmlElement(name = "EvidenceTypeList")
    protected List<EvidenceTypeListType> evidenceTypeList;

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
     * Gets the value of the referenceFramework property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the referenceFramework property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReferenceFramework().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceFrameworkType }
     * 
     * 
     */
    public List<ReferenceFrameworkType> getReferenceFramework() {
        if (referenceFramework == null) {
            referenceFramework = new ArrayList<ReferenceFrameworkType>();
        }
        return this.referenceFramework;
    }

    /**
     * Gets the value of the evidenceTypeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the evidenceTypeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvidenceTypeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EvidenceTypeListType }
     * 
     * 
     */
    public List<EvidenceTypeListType> getEvidenceTypeList() {
        if (evidenceTypeList == null) {
            evidenceTypeList = new ArrayList<EvidenceTypeListType>();
        }
        return this.evidenceTypeList;
    }

}
