
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für findMitarbeiterByRolleIntern complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="findMitarbeiterByRolleIntern">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rolleIntern" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findMitarbeiterByRolleIntern", propOrder = {
    "rolleIntern"
})
public class FindMitarbeiterByRolleIntern {

    protected int rolleIntern;

    /**
     * Ruft den Wert der rolleIntern-Eigenschaft ab.
     * 
     */
    public int getRolleIntern() {
        return rolleIntern;
    }

    /**
     * Legt den Wert der rolleIntern-Eigenschaft fest.
     * 
     */
    public void setRolleIntern(int value) {
        this.rolleIntern = value;
    }

}
