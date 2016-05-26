
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für deleteMessung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="deleteMessung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="messung" type="{http://rmi.webservice.feukora/}messung" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteMessung", propOrder = {
    "messung"
})
public class DeleteMessung {

    protected Messung messung;

    /**
     * Ruft den Wert der messung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Messung }
     *     
     */
    public Messung getMessung() {
        return messung;
    }

    /**
     * Legt den Wert der messung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Messung }
     *     
     */
    public void setMessung(Messung value) {
        this.messung = value;
    }

}
