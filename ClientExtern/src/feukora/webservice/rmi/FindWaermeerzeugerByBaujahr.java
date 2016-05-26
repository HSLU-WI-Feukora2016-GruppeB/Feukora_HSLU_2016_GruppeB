
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für findWaermeerzeugerByBaujahr complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="findWaermeerzeugerByBaujahr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baujahr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findWaermeerzeugerByBaujahr", propOrder = {
    "baujahr"
})
public class FindWaermeerzeugerByBaujahr {

    protected int baujahr;

    /**
     * Ruft den Wert der baujahr-Eigenschaft ab.
     * 
     */
    public int getBaujahr() {
        return baujahr;
    }

    /**
     * Legt den Wert der baujahr-Eigenschaft fest.
     * 
     */
    public void setBaujahr(int value) {
        this.baujahr = value;
    }

}
