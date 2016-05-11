package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Waermeerzeuger erzeugt Waerme für Feuerungsanlage, zusammen mit Brenner
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Waermeerzeuger.findByTyp", query = "SELECT w FROM Waermeerzeuger w WHERE w.waermeerzeugerTyp=:waermeerzeugerTyp"),
	@NamedQuery(name = "Waermeerzeuger.findByBrennstoff", query = "SELECT w FROM Waermeerzeuger w WHERE w.brennstoff=:brennstoff")
})
public class Waermeerzeuger implements Serializable{

	private static final long serialVersionUID = 5006295626619515437L;
	
	@Id
	@GeneratedValue
	private Integer idWaermeerzeuger;
	
	@ManyToOne
	private Brennstoff brennstoff;
	@ManyToOne
	private Waermeerzeugertyp waermeerzeugerTyp;
	
	//standardkonstruktor
	public Waermeerzeuger(){
		
	}

	//getter&setter
	public Integer getIdWaermeerzeuger() {
		return idWaermeerzeuger;
	}

	public void setIdWaermeerzeuger(int idWaermeerzeuger) {
		this.idWaermeerzeuger = idWaermeerzeuger;
	}

	public Brennstoff getBrennstoff() {
		return brennstoff;
	}

	public void setBrennstoff(Brennstoff brennstoff) {
		this.brennstoff = brennstoff;
	}

	public Waermeerzeugertyp getWaermeerzeugerTyp() {
		return waermeerzeugerTyp;
	}

	public void setWaermeerzeugerTyp(Waermeerzeugertyp waermeerzeugerTyp) {
		this.waermeerzeugerTyp = waermeerzeugerTyp;
	}
	
	

}
