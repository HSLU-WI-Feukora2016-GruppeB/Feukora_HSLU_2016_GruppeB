package entitäten;

import java.io.Serializable;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// enthält GregorienKalender...

/**
 * Messung enthält alle Messergebnisse die der Feuerungskontrolleur beim Wärmeerzeuger abliest.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Messung.findByMessDatum", query = "SELECT m FROM Messung m WHERE m.messDatum=:messDatum"),
	@NamedQuery(name = "Messung.findByRusszahl", query = "SELECT m FROM Messung m WHERE m.russzahl=:russzahl"),
	@NamedQuery(name = "Messung.findByKohlenstoff", query = "SELECT m FROM Messung m WHERE m.kohlenstoff=:kohlenstoff"),
	@NamedQuery(name = "Messung.findByOelanteil", query = "SELECT m FROM Messung m WHERE m.oelanteil=:oelanteil"),
	@NamedQuery(name = "Messung.findByStickstoffgehalt", query = "SELECT m FROM Messung m WHERE m.stickstoffgehalt=:stickstoffgehalt"),
	@NamedQuery(name = "Messung.findByAbgastemperatur", query = "SELECT m FROM Messung m WHERE m.abgastemperatur=:abgastemperatur"),
	@NamedQuery(name = "Messung.findByWaermeerzeugertemperatur", query = "SELECT m FROM Messung m WHERE m.waermeerzeugertemperatur=:waermeerzeugertemperatur"),
	@NamedQuery(name = "Messung.findByVerbrennungstemperatur", query = "SELECT m FROM Messung m WHERE m.verbrennungstemperatur=:verbrennungstemperatur"),
	@NamedQuery(name = "Messung.findByO2gehalt", query = "SELECT m FROM Messung m WHERE m.o2gehalt=:o2gehalt"),
	@NamedQuery(name = "Messung.findByAbgasverluste", query = "SELECT m FROM Messung m WHERE m.abgasverluste=:abgasverluste")
})
public class Messung implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int idMessung;
	
	@Temporal(TemporalType.DATE)
	private GregorianCalendar messDatum;
	
	private int russzahl;
	
	private int kohlenstoff;
	
	private int oelanteil;
	
	private int stickstoffgehalt;
	
	private int abgastemperatur;
	
	private int waermeerzeugertemperatur;
	
	private int verbrennungstemperatur;
	
	private int o2gehalt;
	
	private int abgasverluste;
	
	//standardkonstruktor
	public Messung(){
		
	}
	
	//getter&setter
	public int getIdMessung() {
		return idMessung;
	}

	public void setIdMessung(int idMessung) {
		this.idMessung = idMessung;
	}

	public GregorianCalendar getMessDatum() {
		return messDatum;
	}

	public void setMessDatum(GregorianCalendar messDatum) {
		this.messDatum = messDatum;
	}

	public int getRusszahl() {
		return russzahl;
	}

	public void setRusszahl(int russzahl) {
		this.russzahl = russzahl;
	}

	public int getKohlenstoff() {
		return kohlenstoff;
	}

	public void setKohlenstoff(int kohlenstoff) {
		this.kohlenstoff = kohlenstoff;
	}

	public int getOelanteil() {
		return oelanteil;
	}

	public void setOelanteil(int oelanteil) {
		this.oelanteil = oelanteil;
	}

	public int getStickstoffgehalt() {
		return stickstoffgehalt;
	}

	public void setStickstoffgehalt(int stickstoffgehalt) {
		this.stickstoffgehalt = stickstoffgehalt;
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
	
	@Override
	public String toString(){
		return "Messung:" + "\n"
				+ "Messdatum: \t \t \t" + messDatum + "\n"
				+ "Russzahl: \t \t \t" + russzahl + "\n"
				+ "Kohlenstoff: \t \t \t" + kohlenstoff + "\n"
				+ "Oelanteil: \t \t \t" + oelanteil + "\n"
				+ "Stickstoffgehalt: \t \t \t" + stickstoffgehalt + "\n"
				+ "Abgastemperatur: \t \t \t" + abgastemperatur + "\n"
				+ "Waermeerzeugertemperatur: \t \t \t" + waermeerzeugertemperatur + "\n"
				+ "Verbrennungstemperatur: \t \t \t" + verbrennungstemperatur + "\n"
				+ "O2Gehalt: \t \t \t" + o2gehalt + "\n"
				+ "Abgasverluste: \t \t \t" + abgasverluste + "\n";
				
	}
	
	
}