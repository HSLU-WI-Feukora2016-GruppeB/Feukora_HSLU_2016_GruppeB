package entit�ten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Eine Feuerungsanlage besteht aus einem Brenner 
 * und einem W�rmeerzeuger sie erzeugt W�rme f�r eine bestimmt Liegenschaft.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Feuerungsanlage.findByLiegenschaft", query = "SELECT f FROM Feuerungsanlage f WHERE f.liegenschaft=:liegenschaft"),
	@NamedQuery(name = "Feuerungsanlage.findByBrenner", query = "SELECT f FROM Feuerungsanlage f WHERE f.brenner=:brenner"),
	@NamedQuery(name = "Feuerungsanlage.findByW�rmeerzeuger", query = "SELECT f FROM Feuerungsanlage f WHERE f.w�rmeerzeuger=:w�rmeerzeuger")
})
public class Feuerungsanlage implements Serializable{
	
	private static final long serialVersionUID = -4675827977388169401L;
	
	@Id
	@GeneratedValue
	private Integer idFeuerungsanlage;
	
	//Liegenschaft wird auf Many Seite annotiert
	private Liegenschaft liegenschaft;
	@ManyToOne
	private Brenner brenner;
	@ManyToOne
	private W�rmeerzeuger w�rmeerzeuger;
	
	//standardkonstruktor
	public Feuerungsanlage(){
		
	}

	//getter&setter
	public Integer getIdFeuerungsanlage() {
		return idFeuerungsanlage;
	}

	public void setIdFeuerungsanlage(Integer idFeuerungsanlage) {
		this.idFeuerungsanlage = idFeuerungsanlage;
	}

	public Liegenschaft getLiegenschaft() {
		return liegenschaft;
	}

	public void setLiegenschaft(Liegenschaft liegenschaft) {
		this.liegenschaft = liegenschaft;
	}

	public Brenner getBrenner() {
		return brenner;
	}

	public void setBrenner(Brenner brenner) {
		this.brenner = brenner;
	}

	public W�rmeerzeuger getW�rmeerzeuger() {
		return w�rmeerzeuger;
	}

	public void setW�rmeerzeuger(W�rmeerzeuger w�rmeerzeuger) {
		this.w�rmeerzeuger = w�rmeerzeuger;
	}
	

}
