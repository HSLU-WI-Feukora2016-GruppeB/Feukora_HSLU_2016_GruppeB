package entitäten;
import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.*;

/**
 * Ein Auftrag fasst alle wichtigen Informationen für den Auftrag zusammen. 
 * Er wird normalerweise vom Sachbearbeiter erstellt und vom Feuerungskontrolleur durch
 * die Kontroll-Messdaten ergänzt. 
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Auftrag.findByKontaktName", query = "SELECT a FROM Auftrag a WHERE a.name=:name"),
	@NamedQuery(name = "Auftrag.findByKontaktVorname", query = "SELECT a FROM Auftrag a WHERE a.vorname=:vorname"),
	@NamedQuery(name = "Auftrag.findByLiegenschaftPostleitzahl", query = "SELECT a FROM Auftrag a WHERE a.adresse.ort.plz=:plz"),
	@NamedQuery(name = "Auftrag.findByLiegenschaftOrt", query = "SELECT a FROM Auftrag a WHERE a.adresse.ort.ort=:ort"),
	@NamedQuery(name = "Auftrag.findByTermin", query = "SELECT a FROM Auftrag a WHERE a.termin.termin=:termin"),
	@NamedQuery(name = "Auftrag.findByAusführenderMitarbeiter", query = "SELECT a FROM Auftrag a WHERE :kompetenz MEMBER OF d.kernkompetenzen")
	
})
public class Auftrag implements Serializable{
	
	private static final long serialVersionUID = -1931313655942897483L;
	@Id
	@GeneratedValue
	private Integer auftragsNummer;
	
	@ManyToOne
	private Kontakt kunde;
	@ManyToOne
	private Mitarbeiter aufgenommenDurch;
	@ManyToOne
	private Liegenschaft liegenschaft;
	@ManyToOne
	private Mitarbeiter ausgeführtDurch;
	@ManyToOne
	private GregorianCalendar termin;
	@OneToMany
	private boolean terminArt;		//wenn true dann Service sonst nur Kontrolle
	
	//standardkonstruktor
	public Auftrag(){
		
	}
	
	//getter&setter
	public Integer getAuftragsNummer() {
		return auftragsNummer;
	}
	public void setAuftragsNummer(Integer auftragsNummer) {
		this.auftragsNummer = auftragsNummer;
	}
	public Kontakt getKunde() {
		return kunde;
	}
	public void setKunde(Kontakt kunde) {
		this.kunde = kunde;
	}
	public Mitarbeiter getAufgenommenDurch() {
		return aufgenommenDurch;
	}
	public void setAufgenommenDurch(Mitarbeiter aufgenommenDurch) {
		this.aufgenommenDurch = aufgenommenDurch;
	}
	public Liegenschaft getLiegenschaft() {
		return liegenschaft;
	}
	public void setLiegenschaft(Liegenschaft liegenschaft) {
		this.liegenschaft = liegenschaft;
	}
	public Mitarbeiter getAusgeführtDurch() {
		return ausgeführtDurch;
	}
	public void setAusgeführtDurch(Mitarbeiter ausgeführtDurch) {
		this.ausgeführtDurch = ausgeführtDurch;
	}
	public GregorianCalendar getTermin() {
		return termin;
	}
	public void setTermin(GregorianCalendar termin) {
		this.termin = termin;
	}
	public boolean isTerminArt() {
		return terminArt;
	}
	public void setTerminArt(boolean terminArt) {
		this.terminArt = terminArt;
	}
	
	

}
