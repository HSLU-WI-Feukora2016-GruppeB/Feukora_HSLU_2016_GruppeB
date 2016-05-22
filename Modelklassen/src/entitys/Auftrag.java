package entitys;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.*;

import org.eclipse.jdt.annotation.Nullable;

/**
 * Ein Auftrag fasst alle wichtigen Informationen für den Auftrag zusammen. Er
 * wird normalerweise vom Sachbearbeiter erstellt und vom Feuerungskontrolleur
 * durch die Kontroll-Messdaten ergänzt.
 *
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Auftrag.findById", query = "SELECT a FROM Auftrag a WHERE a.id=:id"),
		@NamedQuery(name = "Auftrag.findByKontakt", query = "SELECT a FROM Auftrag a WHERE a.kontakt=:kontakt"),
		@NamedQuery(name = "Auftrag.findByLiegenschaft", query = "SELECT a FROM Auftrag a WHERE a.liegenschaft=:liegenschaft"),
		@NamedQuery(name = "Auftrag.findByMitarbeiter", query = "SELECT a FROM Auftrag a WHERE a.mitarbeiter=:mitarbeiter"),
		@NamedQuery(name = "Auftrag.findByDatum", query = "SELECT a FROM Auftrag a WHERE a.datum=:datum"),
		@NamedQuery(name = "Auftrag.findByDatumAndMitarbeiter", query = "SELECT a FROM Auftrag a WHERE a.datum>=:startdatum AND a.datum<=:enddatum AND a.mitarbeiter=:mitarbeiter"),
		@NamedQuery(name = "Auftrag.findAuftragByDateAndMitarbeiterAndZeitslot", query = "SELECT a FROM Auftrag a WHERE a.datum=:datum AND a.mitarbeiter=:mitarbeiter AND a.zeitSlot=:zeitSlot") })
public class Auftrag implements Serializable {

	private static final long serialVersionUID = -1931313655942897483L;
	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private Kontakt kontakt;

	@ManyToOne
	private Liegenschaft liegenschaft;

	@Nullable
	@OneToOne // (cascade = CascadeType.ALL)
	private Messung messung1stufe1;

	@Nullable
	@OneToOne // (cascade = CascadeType.ALL)
	private Messung messung1stufe2;

	@Nullable
	@OneToOne // (cascade = CascadeType.ALL)
	private Messung messung2stufe1;

	@Nullable
	@OneToOne // (cascade = CascadeType.ALL)
	private Messung messung2stufe2;

	// weiteres vorgehen wird manuell entschieden
	private boolean einregulierungInnert30;

	private boolean einregulierungNichtMoeglich;

	private String bemerkung;

	@ManyToOne
	private Mitarbeiter mitarbeiter;

	@Temporal(TemporalType.DATE)
	private GregorianCalendar datum;

	private int zeitSlot;

	private int terminArt;

	// konstruktor**************************************************
	public Auftrag() {

	}

	public Auftrag(Kontakt kontakt, Liegenschaft liegenschaft, Mitarbeiter mitarbeiter, GregorianCalendar datum,
			int zeitSlot, int terminArt) {
		this.kontakt = kontakt;
		this.liegenschaft = liegenschaft;
		this.mitarbeiter = mitarbeiter;
		this.datum = datum;
		this.zeitSlot = zeitSlot;
		this.terminArt = terminArt;
	}

	public Auftrag(Kontakt kontakt, Liegenschaft liegenschaft, @Nullable Messung messung1stufe1,
			@Nullable Messung messung1stufe2, @Nullable Messung messung2stufe1, @Nullable Messung messung2stufe2,
			Mitarbeiter mitarbeiter, GregorianCalendar datum, int zeitSlot, int terminArt) {
		super();
		this.kontakt = kontakt;
		this.liegenschaft = liegenschaft;
		this.messung1stufe1 = messung1stufe1;
		this.messung1stufe2 = messung1stufe2;
		this.messung2stufe1 = messung2stufe1;
		this.messung2stufe2 = messung2stufe2;
		this.mitarbeiter = mitarbeiter;
		this.datum = datum;
		this.zeitSlot = zeitSlot;
		this.terminArt = terminArt;
	}

	// getter&setter********************************************************
	public Integer getAuftragsNummer() {
		return id;
	}

	public void setAuftragsNummer(Integer auftragsNummer) {
		this.id = auftragsNummer;
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

	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public Messung getMessung1stufe1() {
		return messung1stufe1;
	}

	public void setMessung1stufe1(Messung messung1stufe1) {
		this.messung1stufe1 = messung1stufe1;
	}

	public Messung getMessung1stufe2() {
		return messung1stufe2;
	}

	public void setMessung1stufe2(Messung messung1stufe2) {
		this.messung1stufe2 = messung1stufe2;
	}

	public Messung getMessung2stufe1() {
		return messung2stufe1;
	}

	public void setMessung2stufe1(Messung messung2stufe1) {
		this.messung2stufe1 = messung2stufe1;
	}

	public Messung getMessung2stufe2() {
		return messung2stufe2;
	}

	public void setMessung2stufe2(Messung messung2stufe2) {
		this.messung2stufe2 = messung2stufe2;
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
	 * Hilfsmethode für toString Methode der Klasse Messung. Ein Datum wird
	 * formatiert gedruckt.
	 *
	 * @param messDatum
	 * @return
	 */
	public String printDatum(GregorianCalendar datum) {
		return datum.get(Calendar.DAY_OF_MONTH) + "/" + datum.get(Calendar.MONTH) + "/" + datum.get(Calendar.YEAR);
	}

	public void setTermin(GregorianCalendar datum) {
		this.datum = datum;
	}

	/**
	 * Gibt Terminarten für Termine: 1 == Routinekontrolle 2 == Abnahmekontrolle
	 *
	 * @return
	 */
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

	/**
	 * Setzt Terminarten für Termine: 1 == Routinekontrolle 2 ==
	 * Abnahmekontrolle
	 *
	 * @return
	 * @throws Exception
	 */
	public void setTerminArt(int terminArt) throws Exception {
		if (terminArt == 1 || terminArt == 2) {
			this.terminArt = terminArt;
		} else {
			throw new Exception("Terminart ungültig, 1 für Routinekontrolle, 2 für Abnahmekontrolle");
		}

	}

	/**
	 * Gibt Zeitslots für Termine: 1==8-10Uhr 2==10-12Uhr 3==13-15Uhr
	 * 4==15-17Uhr
	 *
	 * @return
	 */
	public int getZeitSlot() {
		return zeitSlot;
	}

	public String getZeitSlotString() {
		String termin = null;

		switch (this.zeitSlot) {
		case 1:
			termin = "8:00 - 10:00 Uhr";
			break;
		case 2:
			termin = "10:00 - 12:00 Uhr";
			break;
		case 3:
			termin = "13:00 - 15:00 Uhr";
			break;
		case 4:
			termin = "15:00 - 17:00 Uhr";
			break;
		}

		return termin;
	}

	/**
	 * Setzt Zeitslots für Termine: 1==8-10Uhr 2==10-12Uhr 3==13-15Uhr
	 * 4==15-17Uhr
	 *
	 * @return
	 * @throws Exception
	 */
	public void setZeitSlot(int zeitSlot) throws Exception {
		if (zeitSlot <= 4 && zeitSlot >= 1) {
			this.zeitSlot = zeitSlot;
		} else {
			throw new Exception("Der Zeitslot ist ungültig, bitte Zahl zwischen 1-4");
		}

	}

	@Override
	public String toString() {

		String auftrag = "";

		auftrag += "Auftrag:" + "\n" + "Auftragsdatum: " + this.printDatum(this.datum) + "\n" + "Termin "
				+ this.getZeitSlotString() + "\n" + "Auftragsnummer: " + id + "\n" + "\n"

				+ "Kontakt: \n" + kontakt.toString() + "\n" + "Liegenschaft: \n" + liegenschaft.toString() + "\n"
				+ "Info vor Ort: " + liegenschaft.getInfoVorOrt() + "\n" + "\n"

				+ "Messung: \n";

		if (messung1stufe1 == null) {
			auftrag += "Keine Messung 1 Stufe 1 vorhanden! +\n";
		} else {
			auftrag += messung1stufe1.toString() + "\n";
		}

		if (messung1stufe2 == null) {
			auftrag += "Keine Messung 1 Stufe 2 vorhanden! + \n";
		} else {
			auftrag += messung1stufe2.toString() + "\n";
		}

		if (messung2stufe1 == null) {
			auftrag += "Keine Messung 2 Stufe 1 vorhanden!";
		} else {
			auftrag += messung2stufe1.toString() + "\n";
		}

		if (messung2stufe2 == null) {
			auftrag += "Keine Messung 2 Stufe 2 vorhanden!";
		} else {
			auftrag += messung2stufe2.toString() + "\n" + "\n";
		}

		auftrag += "Kontrolleur: \n" + mitarbeiter.toString() + "\n" + "Kontrollart: " + terminArt + "\n";

		return auftrag;
	}

	public boolean isEinregulierungInnert30() {
		return einregulierungInnert30;
	}

	public void setEinregulierungInnert30(boolean einregulierungInnert30) {
		this.einregulierungInnert30 = einregulierungInnert30;
	}

	public boolean isEinregulierungNichtMoeglich() {
		return einregulierungNichtMoeglich;
	}

	public void setEinregulierungNichtMoeglich(boolean einregulierungNichtMoeglich) {
		this.einregulierungNichtMoeglich = einregulierungNichtMoeglich;
	}

	public String getBemerkung() {
		return bemerkung;
	}

	public void setBemerkung(String bemerkung) {
		this.bemerkung = bemerkung;
	}

}
