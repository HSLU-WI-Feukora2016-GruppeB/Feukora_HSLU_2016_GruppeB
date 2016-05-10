package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Brennertyp definiert den Brenner.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
public class Brennertyp implements Serializable{
	
	private static final long serialVersionUID = -5991202562826726636L;

	@Id
	@GeneratedValue
	private Integer idBrennertyp;
	
	private String brennerTyp;
	
	//standardkonstruktor
	public Brennertyp(){
		
	}
	
	//getter&setter
	public int getId() {
		return idBrennertyp;
	}

	public void setId(int id) {
		this.idBrennertyp = id;
	}

	public String getBrennerTyp() {
		return brennerTyp;
	}

	public void setBrennerTyp(String brennerTyp) {
		this.brennerTyp = brennerTyp;
	}
	
	
}
