
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für deleteFeuerungsanlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="deleteFeuerungsanlage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feuerungsanlage" type="{http://rmi.webservice.feukora/}feuerungsanlage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteFeuerungsanlage", propOrder = {
    "feuerungsanlage"
})
public class DeleteFeuerungsanlage {

    protected Feuerungsanlage feuerungsanlage;

    /**
     * Ruft den Wert der feuerungsanlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Feuerungsanlage }
     *     
     */
    public Feuerungsanlage getFeuerungsanlage() {
        return feuerungsanlage;
    }

    /**
     * Legt den Wert der feuerungsanlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Feuerungsanlage }
     *     
     */
    public void setFeuerungsanlage(Feuerungsanlage value) {
        this.feuerungsanlage = value;
    }

}
