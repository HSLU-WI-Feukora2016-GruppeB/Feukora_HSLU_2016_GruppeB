package entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@NamedQuery(name = "Waermeerzeuger.findById", query = "SELECT w FROM Waermeerzeuger w WHERE w.id=:id"),
	@NamedQuery(name = "Waermeerzeuger.findByTyp", query = "SELECT w FROM Waermeerzeuger w WHERE w.waermeerzeugerTyp=:waermeerzeugerTyp"),
	@NamedQuery(name = "Waermeerzeuger.findByBaujahr", query = "SELECT w FROM Waermeerzeuger w WHERE w.baujahr=:baujahr"),
	@NamedQuery(name = "Waermeerzeuger.findByBrennstoff", query = "SELECT w FROM Waermeerzeuger w WHERE w.brennstoff=:brennstoff")
})
public class Waermeerzeuger implements Serializable{

	private static final long serialVersionUID = 5006295626619515437L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private int brennstoff;
	private String waermeerzeugerTyp;
	private int baujahr;

	
	//standardkonstruktor**************************************************
	public Waermeerzeuger(){
		
	}
	
	public Waermeerzeuger(int brennstoff, String waermeerzeugerTyp, int baujahr) {
		super();
		this.brennstoff = brennstoff;
		this.waermeerzeugerTyp = waermeerzeugerTyp;
		this.baujahr = baujahr;
	}


	//getter&setter********************************************************
	public Integer getIdWaermeerzeuger() {
		return id;
	}

	public void setIdWaermeerzeuger(int idWaermeerzeuger) {
		this.id = idWaermeerzeuger;
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
	
	public int getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
	
	@Override
	public String toString() {
		return "Wärmeerzeuger: " + "\n"
				+ "Brennstoff: \t \t \t" + brennstoff + "(1=Öl/2=Erdgas/3=Flüssiggas)" + "\n"
				+ "Waermeerzeugertyp: \t \t" + waermeerzeugerTyp
				;
	}

}