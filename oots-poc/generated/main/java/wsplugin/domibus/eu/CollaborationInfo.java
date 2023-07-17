//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.17 at 08:38:27 PM CEST 
//


package wsplugin.domibus.eu;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for CollaborationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CollaborationInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="AgreementRef" type="{http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/}AgreementRef" minOccurs="0"/&gt;
 *         &lt;element name="Service" type="{http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/}Service"/&gt;
 *         &lt;element name="Action" type="{http://www.w3.org/2001/XMLSchema}token"/&gt;
 *         &lt;element name="ConversationId" type="{http://www.w3.org/2001/XMLSchema}token" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollaborationInfo", propOrder = {

})
public class CollaborationInfo {

    @XmlElement(name = "AgreementRef", namespace = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/")
    protected AgreementRef agreementRef;
    @XmlElement(name = "Service", namespace = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/", required = true)
    protected Service service;
    @XmlElement(name = "Action", namespace = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String action;
    @XmlElement(name = "ConversationId", namespace = "http://docs.oasis-open.org/ebxml-msg/ebms/v3.0/ns/core/200704/")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String conversationId;

    /**
     * Gets the value of the agreementRef property.
     * 
     * @return
     *     possible object is
     *     {@link AgreementRef }
     *     
     */
    public AgreementRef getAgreementRef() {
        return agreementRef;
    }

    /**
     * Sets the value of the agreementRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link AgreementRef }
     *     
     */
    public void setAgreementRef(AgreementRef value) {
        this.agreementRef = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link Service }
     *     
     */
    public Service getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link Service }
     *     
     */
    public void setService(Service value) {
        this.service = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the conversationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConversationId() {
        return conversationId;
    }

    /**
     * Sets the value of the conversationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConversationId(String value) {
        this.conversationId = value;
    }

}
