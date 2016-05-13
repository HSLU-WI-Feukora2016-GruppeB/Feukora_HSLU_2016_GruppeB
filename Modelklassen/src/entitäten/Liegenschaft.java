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
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Liegenschaft.findByKontakt", query = "SELECT l FROM Liegenschaft l WHERE l.kontakt=:kontakt"),
	@NamedQuery(name = "Liegenschaft.findByOrt", query = "SELECT l FROM Liegenschaft l WHERE l.ort=:ort"),
	@NamedQuery(name = "Liegenschaft.findByStrasse", query = "SELECT l FROM Liegenschaft l WHERE l.strasseInklNr=:strasseInklNr")
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
	@ManyToMany
	private Kontakt kunde;	
	@ManyToMany
	private Kontakt hausabwart;
	
	private String strasseInklNr;

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

	public Kontakt getKunde() {
		return kunde;
	}

	public void setKunde(Kontakt kunde) {
		this.kunde = kunde;
	}

	public Kontakt getHausabwart() {
		return hausabwart;
	}

	public void setHausabwart(Kontakt hausabwart) {
		this.hausabwart = hausabwart;
	}

	public String getStrasseInklNr() {
		return strasseInklNr;
	}

	public void setStrasseInklNr(String strasseInklNr) {
		this.strasseInklNr = strasseInklNr;
	}

	public Ort getOrtInklPlz() {
		return ortInklPlz;
	}

	public void setOrtInklPlz(Ort ortInklPlz) {
		this.ortInklPlz = ortInklPlz;
	}
	
}
