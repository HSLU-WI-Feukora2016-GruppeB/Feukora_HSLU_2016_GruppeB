
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für updateAuftrag complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="updateAuftrag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auftrag" type="{http://rmi.webservice.feukora/}auftrag" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateAuftrag", propOrder = {
    "auftrag"
})
public class UpdateAuftrag {

    protected Auftrag auftrag;

    /**
     * Ruft den Wert der auftrag-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Auftrag }
     *     
     */
    public Auftrag getAuftrag() {
        return auftrag;
    }

    /**
     * Legt den Wert der auftrag-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Auftrag }
     *     
     */
    public void setAuftrag(Auftrag value) {
        this.auftrag = value;
    }

}
