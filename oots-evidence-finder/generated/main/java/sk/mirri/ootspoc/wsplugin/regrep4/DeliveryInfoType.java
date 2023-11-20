//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.12 at 09:38:05 AM CEST 
//


package sk.mirri.ootspoc.wsplugin.regrep4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Contains the information needed by the server to deliver notifications for the subscription. 
 *         It includes the reference to the endpoint where notifications should be delivered.
 *       
 * 
 * <p>Java class for DeliveryInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ExtensibleObjectType"&gt;
 *       &lt;sequence&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="notificationOption" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}objectReferenceType" default="urn:oasis:names:tc:ebxml-regrep:NotificationOptionType:ObjectRefs" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryInfoType", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0")
public class DeliveryInfoType
    extends ExtensibleObjectType
{

    @XmlAttribute(name = "notificationOption")
    protected String notificationOption;

    /**
     * Gets the value of the notificationOption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotificationOption() {
        if (notificationOption == null) {
            return "urn:oasis:names:tc:ebxml-regrep:NotificationOptionType:ObjectRefs";
        } else {
            return notificationOption;
        }
    }

    /**
     * Sets the value of the notificationOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotificationOption(String value) {
        this.notificationOption = value;
    }

}