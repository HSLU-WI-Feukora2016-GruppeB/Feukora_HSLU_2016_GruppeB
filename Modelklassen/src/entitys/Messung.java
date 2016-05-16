package entitys;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Messung enthält alle Messergebnisse die der Feuerungskontrolleur beim Wärmeerzeuger abliest.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Messung.findById", query = "SELECT m FROM Messung m WHERE m.idMessung=:idMessung"),
	@NamedQuery(name = "Messung.findByMessDatum", query = "SELECT m FROM Messung m WHERE m.messDatum=:messDatum"),
	@NamedQuery(name = "Messung.findByBeurteilungOk", query = "SELECT m FROM Messung m WHERE m.beurteilungOk=:beurteilungOk"),
	@NamedQuery(name = "Messung.findByBeurteilungNotOk", query = "SELECT m FROM Messung m WHERE m.beurteilungNotOk=:beurteilungNotOk")
})
public class Messung implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Integer idMessung;
	
	@Temporal(TemporalType.DATE)
	private GregorianCalendar messDatum;
	
	//messdaten
	private int russzahl;
	
	private int coGehalt;
	
	private boolean oelanteil;
	
	private int no2gehalt;
	
	private int abgastemperatur;
	
	private int waermeerzeugertemperatur;
	
	private int verbrennungstemperatur;
	
	private int o2gehalt;
	
	private int abgasverluste;
	
	//weiteres vorgehen wird manuell entschieden
	private boolean einregulierungInnert30;
	
	private boolean einregulierungNichtMoeglich;
	
	//beurteilung true wenn nicht ok
	private boolean beurteilungNotOk;
	
	//true wenn nicht ok
	private boolean russzahlNotOk;
	
	private boolean oelanteilenNotOk;
	
	private boolean abgasverlusteNotOk;
	
	private boolean coMgNotOk;
	
	private boolean noMgNotOk;
	
	//standardkonstruktor
	public Messung(){
		
	}
	
	//nur für messwerte, beurteilungswerte werden via grenzwerte klasse gesetzt
	public Messung(GregorianCalendar messDatum, int russzahl, int coGehalt,
			boolean oelanteil, int no2gehalt, int abgastemperatur,
			int waermeerzeugertemperatur, int verbrennungstemperatur,
			int o2gehalt, int abgasverluste) {
		super();
		this.messDatum = messDatum;
		this.russzahl = russzahl;
		this.coGehalt = coGehalt;
		this.oelanteil = oelanteil;
		this.no2gehalt = no2gehalt;
		this.abgastemperatur = abgastemperatur;
		this.waermeerzeugertemperatur = waermeerzeugertemperatur;
		this.verbrennungstemperatur = verbrennungstemperatur;
		this.o2gehalt = o2gehalt;
		this.abgasverluste = abgasverluste;
	}



	//getter&setter
	public Integer getIdMessung() {
		return idMessung;
	}

	public void setIdMessung(Integer idMessung) {
		this.idMessung = idMessung;
	}

	public GregorianCalendar getMessDatum() {
		return messDatum;
	}
	
	public void setMessDatum(GregorianCalendar messDatum) {
		this.messDatum = messDatum;
	}
	
	/**
	 * Setter für ein MessDatumObjekt mithilfe von int Werten.
	 * @param tag
	 * @param monat
	 * @param jahr
	 */
	public void setMessDatum(int tag, int monat, int jahr) {
		GregorianCalendar gregCal = new GregorianCalendar(jahr, monat, tag);
		this.messDatum = gregCal;
	}
	
	/**
	 * Hilfsmethode für toString Methode der Klasse Messung. Ein Datum wird formatiert gedruckt.
	 * @param messDatum
	 * @return
	 */
	public String printMessdatum(GregorianCalendar messDatum) {
		return messDatum.get(Calendar.DAY_OF_MONTH) + "/" + messDatum.get(Calendar.MONTH) + "/" + messDatum.get(Calendar.YEAR);
	}

	public int getRusszahl() {
		return russzahl;
	}

	public void setRusszahl(int russzahl) {
		this.russzahl = russzahl;
	}

	public int getCoGehalt() {
		return coGehalt;
	}

	public void setCoGehalt(int coGehalt) {
		this.coGehalt = coGehalt;
	}

	public boolean isOelanteil() {
		return oelanteil;
	}

	public void setOelanteil(boolean oelanteil) {
		this.oelanteil = oelanteil;
	}

	public int getNo2Gehalt() {
		return no2gehalt;
	}

	public void setNo2Gehalt(int no2gehalt) {
		this.no2gehalt = no2gehalt;
	}

	public int getAbgastemperatur() {
		return abgastemperatur;
	}

	public void setAbgastemperatur(int abgastemperatur) {
		this.abgastemperatur = abgastemperatur;
	}

	public int getWaermeerzeugertemperatur() {
		return waermeerzeugertemperatur;
	}

	public void setWaermeerzeugertemperatur(int waermeerzeugertemperatur) {
		this.waermeerzeugertemperatur = waermeerzeugertemperatur;
	}

	public int getVerbrennungstemperatur() {
		return verbrennungstemperatur;
	}

	public void setVerbrennungstemperatur(int verbrennungstemperatur) {
		this.verbrennungstemperatur = verbrennungstemperatur;
	}

	public int getO2gehalt() {
		return o2gehalt;
	}

	public void setO2gehalt(int o2gehalt) {
		this.o2gehalt = o2gehalt;
	}

	public int getAbgasverluste() {
		return abgasverluste;
	}

	public void setAbgasverluste(int abgasverluste) {
		this.abgasverluste = abgasverluste;
	}
	
	public boolean isBeurteilungNotOk() {
		return beurteilungNotOk;
	}

	public void setBeurteilungNotOk(boolean beurteilungNotOk) {
		this.beurteilungNotOk = beurteilungNotOk;
	}

	public boolean isRusszahlNotOk() {
		return russzahlNotOk;
	}

	public void setRusszahlNotOk(boolean russzahlNotOk) {
		this.russzahlNotOk = russzahlNotOk;
	}

	public boolean isOelanteilenNotOk() {
		return oelanteilenNotOk;
	}

	public void setOelanteilenNotOk(boolean oelanteilenNotOk) {
		this.oelanteilenNotOk = oelanteilenNotOk;
	}

	public boolean isAbgasverlusteNotOk() {
		return abgasverlusteNotOk;
	}

	public void setAbgasverlusteNotOk(boolean abgasverlusteNotOk) {
		this.abgasverlusteNotOk = abgasverlusteNotOk;
	}

	public boolean isCoMgNotOk() {
		return coMgNotOk;
	}

	public void setCoMgNotOk(boolean coMgNotOk) {
		this.coMgNotOk = coMgNotOk;
	}

	public boolean isNoMgNotOk() {
		return noMgNotOk;
	}

	public void setNoMgNotOk(boolean noMgNotOk) {
		this.noMgNotOk = noMgNotOk;
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
	
	@Override
	public String toString(){
		
		String messung = "";
		
		messung += "Messung:" + "\n"
				+ "Messdatum: \t \t \t" + this.printMessdatum(this.messDatum) + "\n"
				+ "Russzahl: \t \t \t" + russzahl + "\n"
				+ "Kohlenstoff: \t \t \t" + coGehalt + "\n"
				+ "Oelanteil: \t \t \t" + oelanteil + "\n"
				+ "Stickstoffgehalt: \t \t \t" + no2gehalt + "\n"
				+ "Abgastemperatur: \t \t \t" + abgastemperatur + "\n"
				+ "Waermeerzeugertemperatur: \t \t \t" + waermeerzeugertemperatur + "\n"
				+ "Verbrennungstemperatur: \t \t \t" + verbrennungstemperatur + "\n"
				+ "O2Gehalt: \t \t \t" + o2gehalt + "\n"
				+ "Abgasverluste: \t \t \t" + abgasverluste + "\n";
		
		if(beurteilungNotOk){
			messung+="Die Anlage wird beanstandet wegen Überschreibung von: \n"
					+ "Russzahl \t" + russzahlNotOk + "\n"
					+ "Ölanteilen: \t" + oelanteilenNotOk + "\n"
					+ "CO in mg/m3: \t" + coMgNotOk + "\n"
					+ "NO2 in mg/m3: \t" + noMgNotOk + "\n"
					+ "Abgasverluste: \t" + abgasverlusteNotOk + "\n";
		} else {
			messung+="Die geltenden LRV-Grenzwerte werden eingehalten. Es sind keine Massnahmen nötig. \n";
		}
				
		if(einregulierungInnert30){
			messung+= "Die Anlage muss innert 30 Tagen einreguliert werden. Die erfolgte Einregulierung ist durch den Brennermonteur mit der beiligenden Rückmeldekarte zu bestätigen. \n";
		} else {
			messung+= "Einregulierung auf Einhaltung der LRV-Grenzwerte ist nicht möglich \n";
		}
				
		return messung;	
	}
	
	

}