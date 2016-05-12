package entitäten;
import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.*;

//SimpleDateFormat für KAlender und toString noch implementieren

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
	@NamedQuery(name = "Auftrag.findById", query = "SELECT a FROM Auftrag a WHERE a.auftragsnummer=:auftragsnummer"),
	@NamedQuery(name = "Auftrag.findByKontakt", query = "SELECT a FROM Auftrag a WHERE a.kontakt=:kontakt"),
	@NamedQuery(name = "Auftrag.findByLiegenschaft", query = "SELECT a FROM Auftrag a WHERE a.liegenschaft=:liegenschaft"),
	@NamedQuery(name = "Auftrag.findByMessung", query = "SELECT a FROM Auftrag a WHERE a.messung=:messung"),
	@NamedQuery(name = "Auftrag.findByMitarbeiter", query = "SELECT a FROM Auftrag a WHERE a.mitarbeiter=:mitarbeiter"),
	@NamedQuery(name = "Auftrag.findByDatum", query = "SELECT a FROM Auftrag a WHERE a.datum=:datum")
})
public class Auftrag implements Serializable{
	
	private static final long serialVersionUID = -1931313655942897483L;
	@Id
	@GeneratedValue
	private Integer auftragsNummer;
	
	@ManyToOne
	private Kontakt kontakt;
	
	@ManyToOne
	private Liegenschaft liegenschaft;
	
	private String infoVorOrt;
	
	@OneToOne
	private Messung messung;
	
	@ManyToOne
	private Mitarbeiter kontrolleur;
	
	@Temporal(TemporalType.DATE)
	private GregorianCalendar datum;
	
	private int terminArt;		
	
	
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
		return kontakt;
	}

	public void setKunde(Kontakt kunde) {
		this.kontakt = kunde;
	}

	public Liegenschaft getLiegenschaft() {
		return liegenschaft;
	}

	public void setLiegenschaft(Liegenschaft liegenschaft) {
		this.liegenschaft = liegenschaft;
	}

	public Mitarbeiter getAusgeführtDurch() {
		return kontrolleur;
	}

	public void setAusgeführtDurch(Mitarbeiter ausgeführtDurch) {
		this.kontrolleur = ausgeführtDurch;
	}

	public GregorianCalendar getTermin() {
		return datum;
	}

	public void setTermin(GregorianCalendar datum) {
		this.datum = datum;
	}

	public String getInfoVorOrt() {
		return infoVorOrt;
	}

	public void setInfoVorOrt(String infoVorOrt) {
		this.infoVorOrt = infoVorOrt;
	}
	
	public int getTerminArt() {
		return terminArt;
	}

	public void setTerminArt(int terminArt) {
		this.terminArt = terminArt;
	}
	
	@Override
	public String toString(){
		return "Auftrag:" + "\n"
				+ "Auftragsnummer: \t \t \t" + auftragsNummer + "\n"
				+ "Kontakt: \n" + kontakt.toString() + "\n"
				+ "Liegenschaft: \n" + liegenschaft.toString() + "\n"
				+ "Info vor Ort: \t \t \t \t" + infoVorOrt + "\n"
				+ "Messung: \n" + messung.toString() + "\n"
				+ "Kontrolleur: \n" + kontrolleur.toString() + "\n"
				+ "Kontrolldatum: \t \t \t \t" + datum.toString() + "\n"
				+ "Kontrollart: \t \t \t \t" + terminArt + "\n";
	}
	
	

}
