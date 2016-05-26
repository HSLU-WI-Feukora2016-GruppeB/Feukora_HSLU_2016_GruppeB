
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für messung complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="messung">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="abgastemperatur" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="abgasverluste" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="abgasverlusteNotOk" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="beurteilungNotOk" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="coGehalt" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="coMgNotOk" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="idMessung" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="messDatum" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="no2Gehalt" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="noMgNotOk" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="o2gehalt" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="oelanteil" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="oelanteilenNotOk" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="russzahl" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="russzahlNotOk" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="verbrennungstemperatur" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="waermeerzeugertemperatur" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messung", propOrder = {
    "abgastemperatur",
    "abgasverluste",
    "abgasverlusteNotOk",
    "beurteilungNotOk",
    "coGehalt",
    "coMgNotOk",
    "idMessung",
    "messDatum",
    "no2Gehalt",
    "noMgNotOk",
    "o2Gehalt",
    "oelanteil",
    "oelanteilenNotOk",
    "russzahl",
    "russzahlNotOk",
    "verbrennungstemperatur",
    "waermeerzeugertemperatur"
})
public class Messung {

    protected int abgastemperatur;
    protected int abgasverluste;
    protected boolean abgasverlusteNotOk;
    protected boolean beurteilungNotOk;
    protected int coGehalt;
    protected boolean coMgNotOk;
    protected Integer idMessung;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar messDatum;
    protected int no2Gehalt;
    protected boolean noMgNotOk;
    @XmlElement(name = "o2gehalt")
    protected int o2Gehalt;
    protected boolean oelanteil;
    protected boolean oelanteilenNotOk;
    protected int russzahl;
    protected boolean russzahlNotOk;
    protected int verbrennungstemperatur;
    protected int waermeerzeugertemperatur;

    /**
     * Ruft den Wert der abgastemperatur-Eigenschaft ab.
     * 
     */
    public int getAbgastemperatur() {
        return abgastemperatur;
    }

    /**
     * Legt den Wert der abgastemperatur-Eigenschaft fest.
     * 
     */
    public void setAbgastemperatur(int value) {
        this.abgastemperatur = value;
    }

    /**
     * Ruft den Wert der abgasverluste-Eigenschaft ab.
     * 
     */
    public int getAbgasverluste() {
        return abgasverluste;
    }

    /**
     * Legt den Wert der abgasverluste-Eigenschaft fest.
     * 
     */
    public void setAbgasverluste(int value) {
        this.abgasverluste = value;
    }

    /**
     * Ruft den Wert der abgasverlusteNotOk-Eigenschaft ab.
     * 
     */
    public boolean isAbgasverlusteNotOk() {
        return abgasverlusteNotOk;
    }

    /**
     * Legt den Wert der abgasverlusteNotOk-Eigenschaft fest.
     * 
     */
    public void setAbgasverlusteNotOk(boolean value) {
        this.abgasverlusteNotOk = value;
    }

    /**
     * Ruft den Wert der beurteilungNotOk-Eigenschaft ab.
     * 
     */
    public boolean isBeurteilungNotOk() {
        return beurteilungNotOk;
    }

    /**
     * Legt den Wert der beurteilungNotOk-Eigenschaft fest.
     * 
     */
    public void setBeurteilungNotOk(boolean value) {
        this.beurteilungNotOk = value;
    }

    /**
     * Ruft den Wert der coGehalt-Eigenschaft ab.
     * 
     */
    public int getCoGehalt() {
        return coGehalt;
    }

    /**
     * Legt den Wert der coGehalt-Eigenschaft fest.
     * 
     */
    public void setCoGehalt(int value) {
        this.coGehalt = value;
    }

    /**
     * Ruft den Wert der coMgNotOk-Eigenschaft ab.
     * 
     */
    public boolean isCoMgNotOk() {
        return coMgNotOk;
    }

    /**
     * Legt den Wert der coMgNotOk-Eigenschaft fest.
     * 
     */
    public void setCoMgNotOk(boolean value) {
        this.coMgNotOk = value;
    }

    /**
     * Ruft den Wert der idMessung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdMessung() {
        return idMessung;
    }

    /**
     * Legt den Wert der idMessung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdMessung(Integer value) {
        this.idMessung = value;
    }

    /**
     * Ruft den Wert der messDatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMessDatum() {
        return messDatum;
    }

    /**
     * Legt den Wert der messDatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMessDatum(XMLGregorianCalendar value) {
        this.messDatum = value;
    }

    /**
     * Ruft den Wert der no2Gehalt-Eigenschaft ab.
     * 
     */
    public int getNo2Gehalt() {
        return no2Gehalt;
    }

    /**
     * Legt den Wert der no2Gehalt-Eigenschaft fest.
     * 
     */
    public void setNo2Gehalt(int value) {
        this.no2Gehalt = value;
    }

    /**
     * Ruft den Wert der noMgNotOk-Eigenschaft ab.
     * 
     */
    public boolean isNoMgNotOk() {
        return noMgNotOk;
    }

    /**
     * Legt den Wert der noMgNotOk-Eigenschaft fest.
     * 
     */
    public void setNoMgNotOk(boolean value) {
        this.noMgNotOk = value;
    }

    /**
     * Ruft den Wert der o2Gehalt-Eigenschaft ab.
     * 
     */
    public int getO2Gehalt() {
        return o2Gehalt;
    }

    /**
     * Legt den Wert der o2Gehalt-Eigenschaft fest.
     * 
     */
    public void setO2Gehalt(int value) {
        this.o2Gehalt = value;
    }

    /**
     * Ruft den Wert der oelanteil-Eigenschaft ab.
     * 
     */
    public boolean isOelanteil() {
        return oelanteil;
    }

    /**
     * Legt den Wert der oelanteil-Eigenschaft fest.
     * 
     */
    public void setOelanteil(boolean value) {
        this.oelanteil = value;
    }

    /**
     * Ruft den Wert der oelanteilenNotOk-Eigenschaft ab.
     * 
     */
    public boolean isOelanteilenNotOk() {
        return oelanteilenNotOk;
    }

    /**
     * Legt den Wert der oelanteilenNotOk-Eigenschaft fest.
     * 
     */
    public void setOelanteilenNotOk(boolean value) {
        this.oelanteilenNotOk = value;
    }

    /**
     * Ruft den Wert der russzahl-Eigenschaft ab.
     * 
     */
    public int getRusszahl() {
        return russzahl;
    }

    /**
     * Legt den Wert der russzahl-Eigenschaft fest.
     * 
     */
    public void setRusszahl(int value) {
        this.russzahl = value;
    }

    /**
     * Ruft den Wert der russzahlNotOk-Eigenschaft ab.
     * 
     */
    public boolean isRusszahlNotOk() {
        return russzahlNotOk;
    }

    /**
     * Legt den Wert der russzahlNotOk-Eigenschaft fest.
     * 
     */
    public void setRusszahlNotOk(boolean value) {
        this.russzahlNotOk = value;
    }

    /**
     * Ruft den Wert der verbrennungstemperatur-Eigenschaft ab.
     * 
     */
    public int getVerbrennungstemperatur() {
        return verbrennungstemperatur;
    }

    /**
     * Legt den Wert der verbrennungstemperatur-Eigenschaft fest.
     * 
     */
    public void setVerbrennungstemperatur(int value) {
        this.verbrennungstemperatur = value;
    }

    /**
     * Ruft den Wert der waermeerzeugertemperatur-Eigenschaft ab.
     * 
     */
    public int getWaermeerzeugertemperatur() {
        return waermeerzeugertemperatur;
    }

    /**
     * Legt den Wert der waermeerzeugertemperatur-Eigenschaft fest.
     * 
     */
    public void setWaermeerzeugertemperatur(int value) {
        this.waermeerzeugertemperatur = value;
    }

}
