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

/**
 * Messung enthält alle Messergebnisse die der Feuerungskontrolleur beim Wärmeerzeuger abliest.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Messung.findByMessDatum", query = "SELECT m FROM Messung m WHERE m.messDatum=:messDatum")
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
	
	private int ölanteil;
	
	private int stickstoffgehalt;
	
	private int abgastemperatur;
	
	private int wärmeerzeugertemperatur;
	
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

	public int getÖlanteil() {
		return ölanteil;
	}

	public void setÖlanteil(int ölanteil) {
		this.ölanteil = ölanteil;
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

	public int getWärmeerzeugertemperatur() {
		return wärmeerzeugertemperatur;
	}

	public void setWärmeerzeugertemperatur(int wärmeerzeugertemperatur) {
		this.wärmeerzeugertemperatur = wärmeerzeugertemperatur;
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
	
	
	
	

}
