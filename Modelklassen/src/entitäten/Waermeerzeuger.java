package entit�ten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Waermeerzeuger erzeugt Waerme f�r Feuerungsanlage, zusammen mit Brenner
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Waermeerzeuger.findById", query = "SELECT w FROM Waermeerzeuger w WHERE w.idWaermeerzeuger=:idWaermeerzeuger"),
	@NamedQuery(name = "Waermeerzeuger.findByTyp", query = "SELECT w FROM Waermeerzeuger w WHERE w.waermeerzeugerTyp=:waermeerzeugerTyp"),
	@NamedQuery(name = "Waermeerzeuger.findByBaujahr", query = "SELECT w FROM Waermeerzeuger w WHERE w.baujahr=:baujahr"),
	@NamedQuery(name = "Waermeerzeuger.findByBrennstoff", query = "SELECT w FROM Waermeerzeuger w WHERE w.brennstoff=:brennstoff")
})
public class Waermeerzeuger implements Serializable{

	private static final long serialVersionUID = 5006295626619515437L;
	
	@Id
	@GeneratedValue
	private Integer idWaermeerzeuger;
	
	private int brennstoff;
	private String waermeerzeugerTyp;
	private int baujahr;

	
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

	public String getBrennstoff() {
		
		String brennS = null;
		
		switch (this.brennstoff){
			case 1: brennS = "�l";
				break;
			case 2: brennS = "Erdgas";
				break;
			case 3: brennS = "Fl�ssiggas";
				break;
		}
		
		return brennS;
	}
		
	public void setBrennstoff(int brennstoff) {
		this.brennstoff = brennstoff;
	}

	public String getWaermeerzeugerTyp() {
		return waermeerzeugerTyp;
	}

	public void setWaermeerzeugerTyp(String waermeerzeugerTyp) {
		this.waermeerzeugerTyp = waermeerzeugerTyp;
	}
	
	public int getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
	
	@Override
	public String toString() {
		return "Waermeerzeuger: " + "\n"
				+ "Brennstoff: \t \t \t" + brennstoff + "(1=�l/2=Erdgas/3=Fl�ssiggas)" + "\n"
				+ "Waermeerzeugertyp: \t \t" + waermeerzeugerTyp
				;
	}

	
	
	

}