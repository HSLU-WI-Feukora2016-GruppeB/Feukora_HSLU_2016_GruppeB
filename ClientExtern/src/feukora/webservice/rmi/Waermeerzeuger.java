
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für waermeerzeuger complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="waermeerzeuger">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baujahr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="brennstoff" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="waermeerzeugerTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "waermeerzeuger", propOrder = {
    "baujahr",
    "brennstoff",
    "waermeerzeugerTyp"
})
public class Waermeerzeuger {

    protected int baujahr;
    protected int brennstoff;
    protected String waermeerzeugerTyp;

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

    /**
     * Ruft den Wert der waermeerzeugerTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaermeerzeugerTyp() {
        return waermeerzeugerTyp;
    }

    /**
     * Legt den Wert der waermeerzeugerTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaermeerzeugerTyp(String value) {
        this.waermeerzeugerTyp = value;
    }

}
