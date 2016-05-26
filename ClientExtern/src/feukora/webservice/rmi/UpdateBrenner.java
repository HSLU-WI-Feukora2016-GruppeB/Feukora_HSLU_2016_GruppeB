
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r updateBrenner complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="updateBrenner">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="brenner" type="{http://rmi.webservice.feukora/}brenner" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateBrenner", propOrder = {
    "brenner"
})
public class UpdateBrenner {

    protected Brenner brenner;

    /**
     * Ruft den Wert der brenner-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Brenner }
     *     
     */
    public Brenner getBrenner() {
        return brenner;
    }

    /**
     * Legt den Wert der brenner-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Brenner }
     *     
     */
    public void setBrenner(Brenner value) {
        this.brenner = value;
    }

}
