package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Brennstoff treibt Brenner an.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
public class Brennstoff implements Serializable{
	
	private static final long serialVersionUID = -8878899783571226193L;

	@Id
	@GeneratedValue
	private int id;
	
	private String brennstoffBezeichnung;
	
	//standardkonstruktor
	public Brennstoff(){
		
	}
	
	//getter&setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrennerBezeichnung() {
		return brennstoffBezeichnung;
	}

	public void setBrennerBezeichnung(String brennerBezeichnung) {
		this.brennstoffBezeichnung = brennerBezeichnung;
	}
	
	
}
