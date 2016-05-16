package entitys;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

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
	@NamedQuery(name = "Liegenschaft.findByOrt", query = "SELECT l FROM Liegenschaft l WHERE l.ort=:ort"),
	@NamedQuery(name = "Liegenschaft.findByStrasse", query = "SELECT l FROM Liegenschaft l WHERE l.strasse=:strasse"),
})
public class Liegenschaft implements Serializable{
	
	private static final long serialVersionUID = -964056024070796750L;

	@Id
	@GeneratedValue
	private Integer idLiegenschaft;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Kontakt kontakt;	
	
	//hier wird per Text zb Hausmeisterinfo eingetragen
	private String infoVorOrt;
	
	private String strasse;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Ort ort;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Feuerungsanlage feuerungsanlage;
	
	//standardkonstruktor**************************************************
	public Liegenschaft(){
		
	}
	
	public Liegenschaft(Kontakt kontakt, String infoVorOrt, String strasse,
			Ort ort, Feuerungsanlage feuerungsanlage) {
		this.kontakt = kontakt;
		this.infoVorOrt = infoVorOrt;
		this.strasse = strasse;
		this.ort = ort;
		this.feuerungsanlage = feuerungsanlage;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public Ort getOrt() {
		return ort;
	}

	public void setOrt(Ort ort) {
		this.ort = ort;
	}

	public Feuerungsanlage getFeuerungsanlage() {
		return feuerungsanlage;
	}

	public void setFeuerungsanlage(Feuerungsanlage feuerungsanlage) {
		this.feuerungsanlage = feuerungsanlage;
	}

	//getter&setter********************************************************
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
				+ "Strasse: \n" + strasse.toString() + "\n"
				+ "Ort: \n" + ort.toString() + "\n";
	}
	
}