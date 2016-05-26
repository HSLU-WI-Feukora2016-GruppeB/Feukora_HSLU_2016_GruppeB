
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für findWaermeerzeugerByBrennstoff complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="findWaermeerzeugerByBrennstoff">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="brennstoff" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findWaermeerzeugerByBrennstoff", propOrder = {
    "brennstoff"
})
public class FindWaermeerzeugerByBrennstoff {

    protected int brennstoff;

    /**
     * Ruft den Wert der brennstoff-Eigenschaft ab.
     * 
     */
    public int getBrennstoff() {
        return brennstoff;
    }

    /**
     * Legt den Wert der brennstoff-Eigenschaft fest.
     * 
     */
    public void setBrennstoff(int value) {
        this.brennstoff = value;
    }

}
