package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Brenner setzt sich aus Brennertyp und Brennerart zusammen, 
 * ein Wärmeerzeuger enthält einen Brenner.
 * @author Olivia
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Brenner.findByTyp", query = "SELECT b FROM Brenner b WHERE b.brennerTyp=:brennerTyp"),
	@NamedQuery(name = "Brenner.findByArt", query = "SELECT b FROM Brenner b WHERE b.brennerArt=:brennerArt")
})
public class Brenner implements Serializable{
	
	private static final long serialVersionUID = -5965676583012641658L;
	
	@Id
	@GeneratedValue
	private Integer idBrenner;
	
	@ManyToOne
	private Brennerart brennerArt;
	@ManyToOne
	private Brennertyp brennerTyp;
	
	private int baujahr;
	
	//standardkonstruktor
	public Brenner(){
		
	}

	//getter&setter
	public Integer getId() {
		return idBrenner;
	}

	public void setId(Integer id) {
		this.idBrenner = id;
	}

	public Brennerart getBrennerArt() {
		return brennerArt;
	}

	public void setBrennerArt(Brennerart brennerArt) {
		this.brennerArt = brennerArt;
	}

	public Brennertyp getBrennerTyp() {
		return brennerTyp;
	}

	public void setBrennerTyp(Brennertyp brennerTyp) {
		this.brennerTyp = brennerTyp;
	}

	public int getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
	
	
}
