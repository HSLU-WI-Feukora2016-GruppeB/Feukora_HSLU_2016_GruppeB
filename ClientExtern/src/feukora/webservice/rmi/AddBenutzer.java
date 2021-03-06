
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r addBenutzer complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="addBenutzer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="benutzer" type="{http://rmi.webservice.feukora/}benutzer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addBenutzer", propOrder = {
    "benutzer"
})
public class AddBenutzer {

    protected Benutzer benutzer;

    /**
     * Ruft den Wert der benutzer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Benutzer }
     *     
     */
    public Benutzer getBenutzer() {
        return benutzer;
    }

    /**
     * Legt den Wert der benutzer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Benutzer }
     *     
     */
    public void setBenutzer(Benutzer value) {
        this.benutzer = value;
    }

}
