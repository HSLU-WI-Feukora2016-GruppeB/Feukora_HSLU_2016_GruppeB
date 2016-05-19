package entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Brenner setzt sich aus Brennertyp und Brennerart zusammen, 
 * ein Wärmeerzeuger enthält einen Brenner.
 * @author Matthias
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Brenner.findById", query = "SELECT b FROM Brenner b WHERE b.id=:id"),
	@NamedQuery(name = "Brenner.findByTyp", query = "SELECT b FROM Brenner b WHERE b.brennerTyp=:brennerTyp"),
	@NamedQuery(name = "Brenner.findByArt", query = "SELECT b FROM Brenner b WHERE b.brennerArt=:brennerArt"),
	@NamedQuery(name = "Brenner.findByBaujahr", query = "SELECT b FROM Brenner b WHERE b.baujahr=:baujahr")
})
public class Brenner implements Serializable{
	
	private static final long serialVersionUID = -5965676583012641658L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private int brennerArt;
	private String brennerTyp;
	private int baujahr;
	
	//konstruktor**************************************************
	public Brenner(){
		
	}
	
	public Brenner(int brennerArt, String brennerTyp, int baujahr){
		this.brennerArt = brennerArt;
		this.brennerTyp = brennerTyp;
		this.baujahr = baujahr;
	}

	//getter&setter********************************************************
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getBrennerArt(){
		return brennerArt;
	}
	
	public String getBrennerArtString() {
		
		String brennerA = null;
		
		switch (this.brennerArt){
			case 1: brennerA = "Gebläsebrenner 1-stufig mit Heizöl";
				break;
			case 2: brennerA = "Gebläsebrenner 2-stufig mit Heizöl";
				break;
			case 3: brennerA = "Verdampfungsbrenner";
				break;
			case 4: brennerA = "Gebläsebrenner 1-stufig mit Gas";
				break;
			case 5: brennerA = "Gebläsebrenner 2-stufig mit Gas";
				break;
			case 6: brennerA = "Athmosphärischer Brenner";
				break;
		}
		
		return brennerA;
	}

	public void setBrennerArt(int brennerArt) {
		this.brennerArt = brennerArt;
	}

	public String getBrennerTyp() {
		return brennerTyp;
	}

	public void setBrennerTyp(String brennerTyp) {
		this.brennerTyp = brennerTyp;
	}

	public int getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
	
	@Override
	public String toString(){
		return "Brenner:" + "\n"
				+ "Brennerart: \t \t \t" + brennerTyp + "\n"
				+ "Brennertyp: \t \t \t" + brennerArt + "\n"
				+ "Baujahr: \t \t \t \t" + baujahr;
	}		
	
}
