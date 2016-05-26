
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r findFeuerungsanlageByLiegenschaft complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="findFeuerungsanlageByLiegenschaft">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="liegenschaft" type="{http://rmi.webservice.feukora/}liegenschaft" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findFeuerungsanlageByLiegenschaft", propOrder = {
    "liegenschaft"
})
public class FindFeuerungsanlageByLiegenschaft {

    protected Liegenschaft liegenschaft;

    /**
     * Ruft den Wert der liegenschaft-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Liegenschaft }
     *     
     */
    public Liegenschaft getLiegenschaft() {
        return liegenschaft;
    }

    /**
     * Legt den Wert der liegenschaft-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Liegenschaft }
     *     
     */
    public void setLiegenschaft(Liegenschaft value) {
        this.liegenschaft = value;
    }

}
