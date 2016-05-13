package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Eine Liegenschaft stellt ein Haus oder eine Wohnung dar, 
 * sie hat jeweils einen oder mehrere Kontaktpersonen
 * um Kontakt aufzunehmen.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Liegenschaft.findById", query = "SELECT l FROM Liegenschaft l WHERE l.idLiegenschaft=:idLiegenschaft"),
	@NamedQuery(name = "Liegenschaft.findByKontakt", query = "SELECT l FROM Liegenschaft l WHERE l.kontakt=:kontakt"),
	@NamedQuery(name = "Liegenschaft.findByOrt", query = "SELECT l FROM Liegenschaft l WHERE l.ortInklPlz=:ortInklPlz"),
	@NamedQuery(name = "Liegenschaft.findByStrasse", query = "SELECT l FROM Liegenschaft l WHERE l.strasseInklNr=:strasseInklNr"),
	@NamedQuery(name = "Liegenschaft.findByFeuerungsanlage", query = "SELECT l FROM Liegenschaft l WHERE l.feuerungsanlage=:feuerungsanlage")
})
public class Liegenschaft implements Serializable{
	
	private static final long serialVersionUID = -964056024070796750L;

	@Id
	@GeneratedValue
	private Integer idLiegenschaft;
	
	/*
	 * Je nach Handling ist es entweder ManyToMany oder OneToMany 
	 * hier haben wir uns für ManyToMany entschieden 
	 * somit entsteht eine assoziative Tabelle 
	 * zwischen Kontakt und Liegenschaft, 
	 * diese wird jedoch im Hintergrund automatisch erstellt. 
	 * Sie ist jedoch nicht weiter ersichtlich.
	 */
	@ManyToOne
	private Kontakt kontakt;	
	
	//hier wird per Text zb Hausmeisterinfo eingetragen
	private String infoVorOrt;
	
	private String strasseInklNr;
	
	@ManyToOne
	private Feuerungsanlage feuerungsanlage;

	@ManyToOne
	private Ort ortInklPlz;
	
	//standardkonstruktor
	public Liegenschaft(){
		
	}

	//getter&setter
	public Integer getIdLiegenschaft() {
		return idLiegenschaft;
	}

	public void setIdLiegenschaft(Integer idLiegenschaft) {
		this.idLiegenschaft = idLiegenschaft;
	}

	public Kontakt getKontakt() {
		return kontakt;
	}

	public void setKontakt(Kontakt kontakt) {
		this.kontakt = kontakt;
	}

	public String getStrasseInklNr() {
		return strasseInklNr;
	}

	public void setStrasseInklNr(String strasseInklNr) {
		this.strasseInklNr = strasseInklNr;
	}

	public Feuerungsanlage getFeuerungsanlage() {
		return feuerungsanlage;
	}

	public void setFeuerungsanlage(Feuerungsanlage feuerungsanlage) {
		this.feuerungsanlage = feuerungsanlage;
	}
	
	public Ort getOrtInklPlz() {
		return ortInklPlz;
	}

	public void setOrtInklPlz(Ort ortInklPlz) {
		this.ortInklPlz = ortInklPlz;
	}

	public String getInfoVorOrt() {
		return infoVorOrt;
	}

	public void setInfoVorOrt(String infoVorOrt) {
		this.infoVorOrt = infoVorOrt;
	}
	
	@Override
	public String toString(){
		return "Liegenschaft:" + "\n"
				+ "Kontakt: \t \t \t" + kontakt + "\n"
				+ "Info vo Ort: \n" + infoVorOrt.toString() + "\n"
				+ "Feuerungsanlage: \n" + feuerungsanlage.toString() + "\n"
				+ "Strasse mit Nummer: \n" + strasseInklNr.toString() + "\n"
				+ "Ort mit PLZ: \n" + ortInklPlz.toString() + "\n";
	}
	
}