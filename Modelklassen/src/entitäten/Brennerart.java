package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Brennerart beschreibt den Brenner
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
@Entity
public class Brennerart implements Serializable{
	
	private static final long serialVersionUID = 4197125319042171307L;
	
	@Id
	@GeneratedValue
	private Integer idBrennerart;
	
	private String brennerBezeichnung;
	
	//standardkonstruktor
	public Brennerart(){
		
	}

	//getter&setter
	public Integer getIdBrennerart() {
		return idBrennerart;
	}

	public void setIdBrennerart(Integer idBrennerart) {
		this.idBrennerart = idBrennerart;
	}

	public String getBrennerBezeichnung() {
		return brennerBezeichnung;
	}

	public void setBrennerBezeichnung(String brennerBezeichnung) {
		this.brennerBezeichnung = brennerBezeichnung;
	}
	
	

}
