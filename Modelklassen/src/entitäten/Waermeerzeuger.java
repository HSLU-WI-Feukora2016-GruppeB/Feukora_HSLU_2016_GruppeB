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
	
	private int brennstoff;
	private String waermeerzeugerTyp;
	
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
			case 1: brennS = "Öl";
				break;
			case 2: brennS = "Erdgas";
				break;
			case 3: brennS = "Flüssiggas";
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
	
	

}
