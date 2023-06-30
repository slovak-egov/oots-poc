
package org.oasis_open.docs.ebxml_msg.ebms.v3_0.ns.core._200704;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessingType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="ProcessingType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PUSH"/&gt;
 *     &lt;enumeration value="PULL"/&gt;
 *     &lt;minLength value="0"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ProcessingType")
@XmlEnum
public enum ProcessingType {

    PUSH,
    PULL;

    public String value() {
        return name();
    }

    public static ProcessingType fromValue(String v) {
        return valueOf(v);
    }

}
