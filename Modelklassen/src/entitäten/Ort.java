package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Klasse Adresse enthält PLZ und Ort, ist eine eigene Tabelle die integriert werden kann.
 * @author Olivia, Dominik
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Ort.findByPLZ", query = "SELECT o FROM Ort o WHERE o.plz=:plz")
})
public class Ort implements Serializable {
	

	private static final long serialVersionUID = -873608046753875813L;
	@Id
	private Integer plz;	
	private String ort;
	
	//Standardkonstruktor*************************************************
	public Ort(){
			
	}
	
	//getter&setter*******************************************************
	public int getPlz() {
		return plz;
	}

	public String getOrt() {
		return ort;
	}
	
	@Override
	public String toString() {
		return "Ort: " + "\n"
				+ "PLZ: \t \t \t" + plz + "\n";
	}
	
	
}
