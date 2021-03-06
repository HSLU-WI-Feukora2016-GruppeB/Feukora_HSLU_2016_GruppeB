
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r brenner complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="brenner">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="baujahr" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="brennerArt" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="brennerTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "brenner", propOrder = {
    "baujahr",
    "brennerArt",
    "brennerTyp",
    "id"
})
public class Brenner {

    protected int baujahr;
    protected int brennerArt;
    protected String brennerTyp;
    protected Integer id;

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
     * Ruft den Wert der brennerArt-Eigenschaft ab.
     * 
     */
    public int getBrennerArt() {
        return brennerArt;
    }

    /**
     * Legt den Wert der brennerArt-Eigenschaft fest.
     * 
     */
    public void setBrennerArt(int value) {
        this.brennerArt = value;
    }

    /**
     * Ruft den Wert der brennerTyp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrennerTyp() {
        return brennerTyp;
    }

    /**
     * Legt den Wert der brennerTyp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrennerTyp(String value) {
        this.brennerTyp = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

}
