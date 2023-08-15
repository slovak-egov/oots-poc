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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rs:4.0}RegistryRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Query" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}QueryType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ObjectRefList" minOccurs="0"/&gt;
 *         &lt;element name="UpdateAction" type="{urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0}UpdateActionType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="checkReferences" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="mode" type="{urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0}mode" default="CreateOrReplace" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "query",
    "objectRefList",
    "updateAction"
})
@XmlRootElement(name = "UpdateObjectsRequest", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0")
public class UpdateObjectsRequest
    extends RegistryRequestType
{

    @XmlElement(name = "Query", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0")
    protected QueryType query;
    @XmlElement(name = "ObjectRefList", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0")
    protected ObjectRefListType objectRefList;
    @XmlElement(name = "UpdateAction", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:lcm:4.0", required = true)
    protected List<UpdateActionType> updateAction;
    @XmlAttribute(name = "checkReferences")
    protected Boolean checkReferences;
    @XmlAttribute(name = "mode")
    protected Mode mode;

    /**
     * Gets the value of the query property.
     * 
     * @return
     *     possible object is
     *     {@link QueryType }
     *     
     */
    public QueryType getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryType }
     *     
     */
    public void setQuery(QueryType value) {
        this.query = value;
    }

    /**
     * Gets the value of the objectRefList property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectRefListType }
     *     
     */
    public ObjectRefListType getObjectRefList() {
        return objectRefList;
    }

    /**
     * Sets the value of the objectRefList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectRefListType }
     *     
     */
    public void setObjectRefList(ObjectRefListType value) {
        this.objectRefList = value;
    }

    /**
     * Gets the value of the updateAction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the updateAction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUpdateAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UpdateActionType }
     * 
     * 
     */
    public List<UpdateActionType> getUpdateAction() {
        if (updateAction == null) {
            updateAction = new ArrayList<UpdateActionType>();
        }
        return this.updateAction;
    }

    /**
     * Gets the value of the checkReferences property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCheckReferences() {
        if (checkReferences == null) {
            return false;
        } else {
            return checkReferences;
        }
    }

    /**
     * Sets the value of the checkReferences property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCheckReferences(Boolean value) {
        this.checkReferences = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link Mode }
     *     
     */
    public Mode getMode() {
        if (mode == null) {
            return Mode.CREATE_OR_REPLACE;
        } else {
            return mode;
        }
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mode }
     *     
     */
    public void setMode(Mode value) {
        this.mode = value;
    }

}
