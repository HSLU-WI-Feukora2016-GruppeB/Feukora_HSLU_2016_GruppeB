package entit�ten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * W�rmeerzeuger erzeugt W�rme f�r Feuerungsanlage, zusammen mit Brenner
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "W�rmeerzeuger.findByTyp", query = "SELECT w FROM W�rmeerzeuger w WHERE w.w�rmeerzeugerTyp=:w�rmeerzeugerTyp"),
	@NamedQuery(name = "W�rmeerzeuger.findByBrennstoff", query = "SELECT w FROM W�rmeerzeuger w WHERE w.brennstoff=:brennstoff")
})
public class Waermeerzeuger implements Serializable{

	private static final long serialVersionUID = 5006295626619515437L;
	
	@Id
	@GeneratedValue
	private int idW�rmeerzeuger;
	
	@ManyToOne
	private Brennstoff brennstoff;
	@ManyToOne
	private W�rmeerzeugertyp w�rmeerzeugerTyp;
	
	//standardkonstruktor
	public W�rmeerzeuger(){
		
	}

	//getter&setter
	public int getIdW�rmeerzeuger() {
		return idW�rmeerzeuger;
	}

	public void setIdW�rmeerzeuger(int idW�rmeerzeuger) {
		this.idW�rmeerzeuger = idW�rmeerzeuger;
	}

	public Brennstoff getBrennstoff() {
		return brennstoff;
	}

	public void setBrennstoff(Brennstoff brennstoff) {
		this.brennstoff = brennstoff;
	}

	public W�rmeerzeugertyp getW�rmeerzeugerTyp() {
		return w�rmeerzeugerTyp;
	}

	public void setW�rmeerzeugerTyp(W�rmeerzeugertyp w�rmeerzeugerTyp) {
		this.w�rmeerzeugerTyp = w�rmeerzeugerTyp;
	}
	
	

}
