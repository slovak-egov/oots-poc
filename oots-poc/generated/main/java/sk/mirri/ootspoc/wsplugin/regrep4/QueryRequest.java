//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.17 at 08:38:25 PM CEST 
//


package sk.mirri.ootspoc.wsplugin.regrep4;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="ResponseOption" type="{urn:oasis:names:tc:ebxml-regrep:xsd:query:4.0}ResponseOptionType"/&gt;
 *         &lt;element name="Query" type="{urn:oasis:names:tc:ebxml-regrep:xsd:rim:4.0}QueryType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="federated" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *       &lt;attribute name="federation" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *       &lt;attribute name="format" type="{http://www.w3.org/2001/XMLSchema}string" default="application/ebrim+xml" /&gt;
 *       &lt;attribute name="startIndex" type="{http://www.w3.org/2001/XMLSchema}integer" default="0" /&gt;
 *       &lt;attribute name="maxResults" type="{http://www.w3.org/2001/XMLSchema}integer" default="-1" /&gt;
 *       &lt;attribute name="depth" type="{http://www.w3.org/2001/XMLSchema}integer" default="0" /&gt;
 *       &lt;attribute name="matchOlderVersions" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "responseOption",
    "query"
})
@XmlRootElement(name = "QueryRequest", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:query:4.0")
public class QueryRequest
    extends RegistryRequestType
{

    @XmlElement(name = "ResponseOption", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:query:4.0", required = true)
    protected ResponseOptionType responseOption;
    @XmlElement(name = "Query", namespace = "urn:oasis:names:tc:ebxml-regrep:xsd:query:4.0", required = true)
    protected QueryType query;
    @XmlAttribute(name = "federated")
    protected Boolean federated;
    @XmlAttribute(name = "federation")
    @XmlSchemaType(name = "anyURI")
    protected String federation;
    @XmlAttribute(name = "format")
    protected String format;
    @XmlAttribute(name = "startIndex")
    protected BigInteger startIndex;
    @XmlAttribute(name = "maxResults")
    protected BigInteger maxResults;
    @XmlAttribute(name = "depth")
    protected BigInteger depth;
    @XmlAttribute(name = "matchOlderVersions")
    protected Boolean matchOlderVersions;

    /**
     * Gets the value of the responseOption property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseOptionType }
     *     
     */
    public ResponseOptionType getResponseOption() {
        return responseOption;
    }

    /**
     * Sets the value of the responseOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseOptionType }
     *     
     */
    public void setResponseOption(ResponseOptionType value) {
        this.responseOption = value;
    }

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
     * Gets the value of the federated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isFederated() {
        if (federated == null) {
            return false;
        } else {
            return federated;
        }
    }

    /**
     * Sets the value of the federated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFederated(Boolean value) {
        this.federated = value;
    }

    /**
     * Gets the value of the federation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFederation() {
        return federation;
    }

    /**
     * Sets the value of the federation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFederation(String value) {
        this.federation = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        if (format == null) {
            return "application/ebrim+xml";
        } else {
            return format;
        }
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the startIndex property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStartIndex() {
        if (startIndex == null) {
            return new BigInteger("0");
        } else {
            return startIndex;
        }
    }

    /**
     * Sets the value of the startIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStartIndex(BigInteger value) {
        this.startIndex = value;
    }

    /**
     * Gets the value of the maxResults property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxResults() {
        if (maxResults == null) {
            return new BigInteger("-1");
        } else {
            return maxResults;
        }
    }

    /**
     * Sets the value of the maxResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxResults(BigInteger value) {
        this.maxResults = value;
    }

    /**
     * Gets the value of the depth property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDepth() {
        if (depth == null) {
            return new BigInteger("0");
        } else {
            return depth;
        }
    }

    /**
     * Sets the value of the depth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDepth(BigInteger value) {
        this.depth = value;
    }

    /**
     * Gets the value of the matchOlderVersions property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMatchOlderVersions() {
        if (matchOlderVersions == null) {
            return false;
        } else {
            return matchOlderVersions;
        }
    }

    /**
     * Sets the value of the matchOlderVersions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMatchOlderVersions(Boolean value) {
        this.matchOlderVersions = value;
    }

}