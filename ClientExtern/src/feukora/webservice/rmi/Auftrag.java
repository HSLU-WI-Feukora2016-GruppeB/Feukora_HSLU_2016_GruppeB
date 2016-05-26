
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für auftrag complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="auftrag">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="auftragsNummer" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ausgeführtDurch" type="{http://rmi.webservice.feukora/}mitarbeiter" minOccurs="0"/>
 *         &lt;element name="bemerkung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="einregulierungInnert30" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="einregulierungNichtMoeglich" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="kunde" type="{http://rmi.webservice.feukora/}kontakt" minOccurs="0"/>
 *         &lt;element name="liegenschaft" type="{http://rmi.webservice.feukora/}liegenschaft" minOccurs="0"/>
 *         &lt;element name="messung1stufe1" type="{http://rmi.webservice.feukora/}messung" minOccurs="0"/>
 *         &lt;element name="messung1stufe2" type="{http://rmi.webservice.feukora/}messung" minOccurs="0"/>
 *         &lt;element name="messung2stufe1" type="{http://rmi.webservice.feukora/}messung" minOccurs="0"/>
 *         &lt;element name="messung2stufe2" type="{http://rmi.webservice.feukora/}messung" minOccurs="0"/>
 *         &lt;element name="mitarbeiter" type="{http://rmi.webservice.feukora/}mitarbeiter" minOccurs="0"/>
 *         &lt;element name="termin" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="zeitSlot" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "auftrag", propOrder = {
    "auftragsNummer",
    "ausgef\u00fchrtDurch",
    "bemerkung",
    "einregulierungInnert30",
    "einregulierungNichtMoeglich",
    "kunde",
    "liegenschaft",
    "messung1Stufe1",
    "messung1Stufe2",
    "messung2Stufe1",
    "messung2Stufe2",
    "mitarbeiter",
    "termin",
    "zeitSlot"
})
public class Auftrag {

    protected Integer auftragsNummer;
    protected Mitarbeiter ausgeführtDurch;
    protected String bemerkung;
    protected boolean einregulierungInnert30;
    protected boolean einregulierungNichtMoeglich;
    protected Kontakt kunde;
    protected Liegenschaft liegenschaft;
    @XmlElement(name = "messung1stufe1")
    protected Messung messung1Stufe1;
    @XmlElement(name = "messung1stufe2")
    protected Messung messung1Stufe2;
    @XmlElement(name = "messung2stufe1")
    protected Messung messung2Stufe1;
    @XmlElement(name = "messung2stufe2")
    protected Messung messung2Stufe2;
    protected Mitarbeiter mitarbeiter;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar termin;
    protected int zeitSlot;

    /**
     * Ruft den Wert der auftragsNummer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAuftragsNummer() {
        return auftragsNummer;
    }

    /**
     * Legt den Wert der auftragsNummer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAuftragsNummer(Integer value) {
        this.auftragsNummer = value;
    }

    /**
     * Ruft den Wert der ausgeführtDurch-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Mitarbeiter }
     *     
     */
    public Mitarbeiter getAusgeführtDurch() {
        return ausgeführtDurch;
    }

    /**
     * Legt den Wert der ausgeführtDurch-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Mitarbeiter }
     *     
     */
    public void setAusgeführtDurch(Mitarbeiter value) {
        this.ausgeführtDurch = value;
    }

    /**
     * Ruft den Wert der bemerkung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBemerkung() {
        return bemerkung;
    }

    /**
     * Legt den Wert der bemerkung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBemerkung(String value) {
        this.bemerkung = value;
    }

    /**
     * Ruft den Wert der einregulierungInnert30-Eigenschaft ab.
     * 
     */
    public boolean isEinregulierungInnert30() {
        return einregulierungInnert30;
    }

    /**
     * Legt den Wert der einregulierungInnert30-Eigenschaft fest.
     * 
     */
    public void setEinregulierungInnert30(boolean value) {
        this.einregulierungInnert30 = value;
    }

    /**
     * Ruft den Wert der einregulierungNichtMoeglich-Eigenschaft ab.
     * 
     */
    public boolean isEinregulierungNichtMoeglich() {
        return einregulierungNichtMoeglich;
    }

    /**
     * Legt den Wert der einregulierungNichtMoeglich-Eigenschaft fest.
     * 
     */
    public void setEinregulierungNichtMoeglich(boolean value) {
        this.einregulierungNichtMoeglich = value;
    }

    /**
     * Ruft den Wert der kunde-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Kontakt }
     *     
     */
    public Kontakt getKunde() {
        return kunde;
    }

    /**
     * Legt den Wert der kunde-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Kontakt }
     *     
     */
    public void setKunde(Kontakt value) {
        this.kunde = value;
    }

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

    /**
     * Ruft den Wert der messung1Stufe1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Messung }
     *     
     */
    public Messung getMessung1Stufe1() {
        return messung1Stufe1;
    }

    /**
     * Legt den Wert der messung1Stufe1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Messung }
     *     
     */
    public void setMessung1Stufe1(Messung value) {
        this.messung1Stufe1 = value;
    }

    /**
     * Ruft den Wert der messung1Stufe2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Messung }
     *     
     */
    public Messung getMessung1Stufe2() {
        return messung1Stufe2;
    }

    /**
     * Legt den Wert der messung1Stufe2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Messung }
     *     
     */
    public void setMessung1Stufe2(Messung value) {
        this.messung1Stufe2 = value;
    }

    /**
     * Ruft den Wert der messung2Stufe1-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Messung }
     *     
     */
    public Messung getMessung2Stufe1() {
        return messung2Stufe1;
    }

    /**
     * Legt den Wert der messung2Stufe1-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Messung }
     *     
     */
    public void setMessung2Stufe1(Messung value) {
        this.messung2Stufe1 = value;
    }

    /**
     * Ruft den Wert der messung2Stufe2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Messung }
     *     
     */
    public Messung getMessung2Stufe2() {
        return messung2Stufe2;
    }

    /**
     * Legt den Wert der messung2Stufe2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Messung }
     *     
     */
    public void setMessung2Stufe2(Messung value) {
        this.messung2Stufe2 = value;
    }

    /**
     * Ruft den Wert der mitarbeiter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Mitarbeiter }
     *     
     */
    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    /**
     * Legt den Wert der mitarbeiter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Mitarbeiter }
     *     
     */
    public void setMitarbeiter(Mitarbeiter value) {
        this.mitarbeiter = value;
    }

    /**
     * Ruft den Wert der termin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTermin() {
        return termin;
    }

    /**
     * Legt den Wert der termin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTermin(XMLGregorianCalendar value) {
        this.termin = value;
    }

    /**
     * Ruft den Wert der zeitSlot-Eigenschaft ab.
     * 
     */
    public int getZeitSlot() {
        return zeitSlot;
    }

    /**
     * Legt den Wert der zeitSlot-Eigenschaft fest.
     * 
     */
    public void setZeitSlot(int value) {
        this.zeitSlot = value;
    }

}
