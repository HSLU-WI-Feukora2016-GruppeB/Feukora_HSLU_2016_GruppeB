
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für findKontaktByRolleExtern complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="findKontaktByRolleExtern">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rolleExtern" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findKontaktByRolleExtern", propOrder = {
    "rolleExtern"
})
public class FindKontaktByRolleExtern {

    protected int rolleExtern;

    /**
     * Ruft den Wert der rolleExtern-Eigenschaft ab.
     * 
     */
    public int getRolleExtern() {
        return rolleExtern;
    }

    /**
     * Legt den Wert der rolleExtern-Eigenschaft fest.
     * 
     */
    public void setRolleExtern(int value) {
        this.rolleExtern = value;
    }

}
