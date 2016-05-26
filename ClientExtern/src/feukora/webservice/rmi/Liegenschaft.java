
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für liegenschaft complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="liegenschaft">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feuerungsanlage" type="{http://rmi.webservice.feukora/}feuerungsanlage" minOccurs="0"/>
 *         &lt;element name="idLiegenschaft" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="infoVorOrt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="kontakt" type="{http://rmi.webservice.feukora/}kontakt" minOccurs="0"/>
 *         &lt;element name="ort" type="{http://rmi.webservice.feukora/}ort" minOccurs="0"/>
 *         &lt;element name="strasse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "liegenschaft", propOrder = {
    "feuerungsanlage",
    "idLiegenschaft",
    "infoVorOrt",
    "kontakt",
    "ort",
    "strasse"
})
public class Liegenschaft {

    protected Feuerungsanlage feuerungsanlage;
    protected Integer idLiegenschaft;
    protected String infoVorOrt;
    protected Kontakt kontakt;
    protected Ort ort;
    protected String strasse;

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

    /**
     * Ruft den Wert der idLiegenschaft-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdLiegenschaft() {
        return idLiegenschaft;
    }

    /**
     * Legt den Wert der idLiegenschaft-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdLiegenschaft(Integer value) {
        this.idLiegenschaft = value;
    }

    /**
     * Ruft den Wert der infoVorOrt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfoVorOrt() {
        return infoVorOrt;
    }

    /**
     * Legt den Wert der infoVorOrt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfoVorOrt(String value) {
        this.infoVorOrt = value;
    }

    /**
     * Ruft den Wert der kontakt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Kontakt }
     *     
     */
    public Kontakt getKontakt() {
        return kontakt;
    }

    /**
     * Legt den Wert der kontakt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Kontakt }
     *     
     */
    public void setKontakt(Kontakt value) {
        this.kontakt = value;
    }

    /**
     * Ruft den Wert der ort-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Ort }
     *     
     */
    public Ort getOrt() {
        return ort;
    }

    /**
     * Legt den Wert der ort-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Ort }
     *     
     */
    public void setOrt(Ort value) {
        this.ort = value;
    }

    /**
     * Ruft den Wert der strasse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrasse() {
        return strasse;
    }

    /**
     * Legt den Wert der strasse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrasse(String value) {
        this.strasse = value;
    }

}
