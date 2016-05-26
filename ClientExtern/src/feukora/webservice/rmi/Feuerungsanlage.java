
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für feuerungsanlage complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="feuerungsanlage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="brenner" type="{http://rmi.webservice.feukora/}brenner" minOccurs="0"/>
 *         &lt;element name="feuerungswaermeleistung" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idFeuerungsanlage" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="waermeerzeuger" type="{http://rmi.webservice.feukora/}waermeerzeuger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "feuerungsanlage", propOrder = {
    "brenner",
    "feuerungswaermeleistung",
    "idFeuerungsanlage",
    "waermeerzeuger"
})
public class Feuerungsanlage {

    protected Brenner brenner;
    protected int feuerungswaermeleistung;
    protected Integer idFeuerungsanlage;
    protected Waermeerzeuger waermeerzeuger;

    /**
     * Ruft den Wert der brenner-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Brenner }
     *     
     */
    public Brenner getBrenner() {
        return brenner;
    }

    /**
     * Legt den Wert der brenner-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Brenner }
     *     
     */
    public void setBrenner(Brenner value) {
        this.brenner = value;
    }

    /**
     * Ruft den Wert der feuerungswaermeleistung-Eigenschaft ab.
     * 
     */
    public int getFeuerungswaermeleistung() {
        return feuerungswaermeleistung;
    }

    /**
     * Legt den Wert der feuerungswaermeleistung-Eigenschaft fest.
     * 
     */
    public void setFeuerungswaermeleistung(int value) {
        this.feuerungswaermeleistung = value;
    }

    /**
     * Ruft den Wert der idFeuerungsanlage-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdFeuerungsanlage() {
        return idFeuerungsanlage;
    }

    /**
     * Legt den Wert der idFeuerungsanlage-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdFeuerungsanlage(Integer value) {
        this.idFeuerungsanlage = value;
    }

    /**
     * Ruft den Wert der waermeerzeuger-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Waermeerzeuger }
     *     
     */
    public Waermeerzeuger getWaermeerzeuger() {
        return waermeerzeuger;
    }

    /**
     * Legt den Wert der waermeerzeuger-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Waermeerzeuger }
     *     
     */
    public void setWaermeerzeuger(Waermeerzeuger value) {
        this.waermeerzeuger = value;
    }

}
