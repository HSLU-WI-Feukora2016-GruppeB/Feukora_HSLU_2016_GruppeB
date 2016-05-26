
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für updateWaermeerzeuger complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="updateWaermeerzeuger">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="waermeerzeuger" type="{http://rmi.webservice.feukora/}waermeerzeuger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateWaermeerzeuger", propOrder = {
    "waermeerzeuger"
})
public class UpdateWaermeerzeuger {

    protected Waermeerzeuger waermeerzeuger;

    /**
     * Ruft den Wert der waermeerzeuger-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Waermeerzeuger }
     *     
     */
    public Waermeerzeuger getWaermeerzeuger() {
        return waermeerzeuger;
    }

    /**
     * Legt den Wert der waermeerzeuger-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Waermeerzeuger }
     *     
     */
    public void setWaermeerzeuger(Waermeerzeuger value) {
        this.waermeerzeuger = value;
    }

}
