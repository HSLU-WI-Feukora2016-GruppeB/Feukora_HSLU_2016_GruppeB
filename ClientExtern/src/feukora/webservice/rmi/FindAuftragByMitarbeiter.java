
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für findAuftragByMitarbeiter complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="findAuftragByMitarbeiter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mitarbeiter" type="{http://rmi.webservice.feukora/}mitarbeiter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAuftragByMitarbeiter", propOrder = {
    "mitarbeiter"
})
public class FindAuftragByMitarbeiter {

    protected Mitarbeiter mitarbeiter;

    /**
     * Ruft den Wert der mitarbeiter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Mitarbeiter }
     *     
     */
    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    /**
     * Legt den Wert der mitarbeiter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Mitarbeiter }
     *     
     */
    public void setMitarbeiter(Mitarbeiter value) {
        this.mitarbeiter = value;
    }

}
