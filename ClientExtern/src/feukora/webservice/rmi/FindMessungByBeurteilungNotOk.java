
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für findMessungByBeurteilungNotOk complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="findMessungByBeurteilungNotOk">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="beurteilungNotOK" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findMessungByBeurteilungNotOk", propOrder = {
    "beurteilungNotOK"
})
public class FindMessungByBeurteilungNotOk {

    protected boolean beurteilungNotOK;

    /**
     * Ruft den Wert der beurteilungNotOK-Eigenschaft ab.
     * 
     */
    public boolean isBeurteilungNotOK() {
        return beurteilungNotOK;
    }

    /**
     * Legt den Wert der beurteilungNotOK-Eigenschaft fest.
     * 
     */
    public void setBeurteilungNotOK(boolean value) {
        this.beurteilungNotOK = value;
    }

}
