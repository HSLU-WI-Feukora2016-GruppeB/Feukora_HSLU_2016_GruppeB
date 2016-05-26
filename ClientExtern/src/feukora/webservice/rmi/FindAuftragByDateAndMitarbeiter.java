
package feukora.webservice.rmi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für findAuftragByDateAndMitarbeiter complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="findAuftragByDateAndMitarbeiter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="startdatum" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="enddatum" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="mitarbeiter" type="{http://rmi.webservice.feukora/}mitarbeiter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findAuftragByDateAndMitarbeiter", propOrder = {
    "startdatum",
    "enddatum",
    "mitarbeiter"
})
public class FindAuftragByDateAndMitarbeiter {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startdatum;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar enddatum;
    protected Mitarbeiter mitarbeiter;

    /**
     * Ruft den Wert der startdatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartdatum() {
        return startdatum;
    }

    /**
     * Legt den Wert der startdatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartdatum(XMLGregorianCalendar value) {
        this.startdatum = value;
    }

    /**
     * Ruft den Wert der enddatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnddatum() {
        return enddatum;
    }

    /**
     * Legt den Wert der enddatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnddatum(XMLGregorianCalendar value) {
        this.enddatum = value;
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

}
