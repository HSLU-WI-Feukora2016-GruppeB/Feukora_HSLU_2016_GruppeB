package entitäten;
import java.io.Serializable;
import java.util.Calendar;
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
	@NamedQuery(name = "Auftrag.findById", query = "SELECT a FROM Auftrag a WHERE a.auftragsnummer=:auftragsnummer"),
	@NamedQuery(name = "Auftrag.findByKontakt", query = "SELECT a FROM Auftrag a WHERE a.kontakt=:kontakt"),
	@NamedQuery(name = "Auftrag.findByLiegenschaft", query = "SELECT a FROM Auftrag a WHERE a.liegenschaft=:liegenschaft"),
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
	
	@OneToMany
	private Messung messung1stufe1;
	
	@OneToMany
	private Messung messung1stufe2;
	
	@OneToMany
	private Messung messung2stufe1;
	
	@OneToMany
	private Messung messung2stufe2;
	
	@ManyToOne
	private Mitarbeiter mitarbeiter;
	
	@Temporal(TemporalType.DATE)
	private GregorianCalendar datum;
	
	private int terminArt;		
	
	
	//konstruktor**************************************************
	public Auftrag(){
		
	}
	
	public Auftrag(Kontakt kontakt, Liegenschaft liegenschaft,
			String infoVorOrt, Messung messung1stufe1, Messung messung1stufe2,
			Messung messung2stufe1, Messung messung2stufe2,
			Mitarbeiter mitarbeiter, GregorianCalendar datum, int terminArt) {
		this.kontakt = kontakt;
		this.liegenschaft = liegenschaft;
		this.infoVorOrt = infoVorOrt;
		this.messung1stufe1 = messung1stufe1;
		this.messung1stufe2 = messung1stufe2;
		this.messung2stufe1 = messung2stufe1;
		this.messung2stufe2 = messung2stufe2;
	}

	//getter&setter********************************************************
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
		return mitarbeiter;
	}

	public void setAusgeführtDurch(Mitarbeiter ausgeführtDurch) {
		this.mitarbeiter = ausgeführtDurch;
	}

	public GregorianCalendar getTermin() {
		return datum;
	}

	/**
	 * Hilfsmethode für toString Methode der Klasse Messung. Ein Datum wird formatiert gedruckt.
	 * @param messDatum
	 * @return
	 */
	public String printDatum(GregorianCalendar datum) {
		return datum.get(Calendar.DAY_OF_MONTH) + "/" + datum.get(Calendar.MONTH) + "/" + datum.get(Calendar.YEAR);
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
	
	public String getTerminArt() {
		
		String terminA = null;

		switch (this.terminArt) {
		case 1:
			terminA = "Routinekontrolle";
			break;
		case 2:
			terminA = "Abnahmekontrolle";
			break;
		}

		return terminA;
	}

	public void setTerminArt(int terminArt) {
		this.terminArt = terminArt;
	}
	
	
	@Override
	public String toString(){
		return "Auftrag:" + "\n"
				+ "Auftragsdatum: \t \t \t \t" + this.printDatum(this.datum)+ "\n"
				+ "Auftragsnummer: \t \t \t" + auftragsNummer + "\n" + "\n"
				
				+ "Kontakt: \n" + kontakt.toString() + "\n"
				+ "Liegenschaft: \n" + liegenschaft.toString() + "\n"
				+ "Info vor Ort: \t \t \t \t" + infoVorOrt + "\n"+ "\n"
				
				+ "Messung: \n" 
				+ messung1stufe1.toString() + "\n"
				+ messung1stufe2.toString() + "\n"
				+ messung2stufe1.toString() + "\n"
				+ messung2stufe2.toString() + "\n"+ "\n"
				
				+ "Kontrolleur: \n" + mitarbeiter.toString() + "\n"
				+ "Kontrollart: \t \t \t \t" + terminArt + "\n";
	}
	
	

}
