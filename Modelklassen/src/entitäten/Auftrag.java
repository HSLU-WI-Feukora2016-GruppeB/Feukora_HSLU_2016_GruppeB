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
	@NamedQuery(name = "Auftrag.findByKontakt", query = "SELECT a FROM Auftrag a WHERE a.kontakt=:kontakt"),
	@NamedQuery(name = "Auftrag.findByLiegenschaft", query = "SELECT a FROM Auftrag a WHERE a.liegenschaft=:liegenschaft"),
	@NamedQuery(name = "Auftrag.findByAuftragsNummer", query = "SELECT a FROM Auftrag a WHERE a.auftragsNummer=:auftragsNummer"),
	@NamedQuery(name = "Auftrag.findByMitarbeiter", query = "SELECT a FROM Auftrag a WHERE a.mitarbeiter=:mitarbeiter")
})
public class Auftrag implements Serializable{
	
	private static final long serialVersionUID = -1931313655942897483L;
	@Id
	@GeneratedValue
	private Integer auftragsNummer;
	
	@ManyToOne
	private Kontakt kunde;
	@ManyToOne
	private Liegenschaft liegenschaft;
	@ManyToOne
	private Mitarbeiter ausgeführtDurch;
	@OneToOne
	private Messung messung;
	
	@Temporal(TemporalType.DATE)
	private GregorianCalendar termin;
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
