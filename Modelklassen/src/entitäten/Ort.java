package entit�ten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Klasse Adresse enth�lt PLZ und Ort, ist eine eigene Tabelle die integriert werden kann.
 * @author Olivia, Dominik
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Ort.findByPlz", query = "SELECT o FROM Ort o WHERE o.plz=:plz"),
	@NamedQuery(name = "Ort.findByOrtBez", query = "SELECT o FROM Ort o WHERE o.ortBez=:ortBez")
})
public class Ort implements Serializable {
	

	private static final long serialVersionUID = -873608046753875813L;
	@Id
	private Integer plz;	
	private String ortBez;
	
	//Standardkonstruktor*************************************************
	public Ort(){
			
	}
	
	//getter&setter*******************************************************
	//keine setter da die Tabelle vorgegeben ist und nicht angepasst werden soll
	public int getPlz() {
		return plz;
	}

	public String getOrt() {
		return ortBez;
	}
	
	@Override
	public String toString() {
		return "Ort:" + "\n" 
				+ "PLZ: \n" + plz.toString() + "\n"
				+ "Ort: \t \t \t" + ortBez + "\n";
	}
	
}
