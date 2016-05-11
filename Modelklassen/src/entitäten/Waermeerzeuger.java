package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Wärmeerzeuger erzeugt Wärme für Feuerungsanlage, zusammen mit Brenner
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Wärmeerzeuger.findByTyp", query = "SELECT w FROM Wärmeerzeuger w WHERE w.wärmeerzeugerTyp=:wärmeerzeugerTyp"),
	@NamedQuery(name = "Wärmeerzeuger.findByBrennstoff", query = "SELECT w FROM Wärmeerzeuger w WHERE w.brennstoff=:brennstoff")
})
public class Waermeerzeuger implements Serializable{

	private static final long serialVersionUID = 5006295626619515437L;
	
	@Id
	@GeneratedValue
	private int idWärmeerzeuger;
	
	@ManyToOne
	private Brennstoff brennstoff;
	@ManyToOne
	private Wärmeerzeugertyp wärmeerzeugerTyp;
	
	//standardkonstruktor
	public Wärmeerzeuger(){
		
	}

	//getter&setter
	public int getIdWärmeerzeuger() {
		return idWärmeerzeuger;
	}

	public void setIdWärmeerzeuger(int idWärmeerzeuger) {
		this.idWärmeerzeuger = idWärmeerzeuger;
	}

	public Brennstoff getBrennstoff() {
		return brennstoff;
	}

	public void setBrennstoff(Brennstoff brennstoff) {
		this.brennstoff = brennstoff;
	}

	public Wärmeerzeugertyp getWärmeerzeugerTyp() {
		return wärmeerzeugerTyp;
	}

	public void setWärmeerzeugerTyp(Wärmeerzeugertyp wärmeerzeugerTyp) {
		this.wärmeerzeugerTyp = wärmeerzeugerTyp;
	}
	
	

}
