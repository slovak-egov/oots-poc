//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.07 at 03:47:41 PM CEST 
//


package sk.mirri.ootspoc.wsplugin.regrep4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         A specialized ValueType that may be used as a container for a Map value.
 *       
 * 
 * <p>Java class for MapValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MapValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}ValueType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Map" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}MapType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MapValueType", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0", propOrder = {
    "map"
})
public class MapValueType
    extends ValueType
{

    @XmlElement(name = "Map", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0")
    protected MapType map;

    /**
     * Gets the value of the map property.
     * 
     * @return
     *     possible object is
     *     {@link MapType }
     *     
     */
    public MapType getMap() {
        return map;
    }

    /**
     * Sets the value of the map property.
     * 
     * @param value
     *     allowed object is
     *     {@link MapType }
     *     
     */
    public void setMap(MapType value) {
        this.map = value;
    }

}
