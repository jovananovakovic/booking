//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.12 at 09:37:54 PM CEST 
//


package XMLandSecurity.backend1.ws;


import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="messageRes" type="{http://bookingxml.com/soap-example}messageRes"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "messageRes"
})
@XmlRootElement(name = "setMessagesResponse")
public class SetMessagesResponse {

    @XmlElement(required = true)
    protected MessageRes messageRes;

    /**
     * Gets the value of the messageRes property.
     *
     * @return possible object is
     * {@link MessageRes }
     */
    public MessageRes getMessageRes() {
        return messageRes;
    }

    /**
     * Sets the value of the messageRes property.
     *
     * @param value allowed object is
     *              {@link MessageRes }
     */
    public void setMessageRes(MessageRes value) {
        this.messageRes = value;
    }

}
