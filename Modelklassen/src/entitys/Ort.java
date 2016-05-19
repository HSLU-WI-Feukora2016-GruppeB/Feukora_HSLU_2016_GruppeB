package entitys;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Klasse Adresse enthält PLZ und Ort, ist eine eigene Tabelle die integriert werden kann.
 * Kein Setter vorhanden, da die Tabelle nicht verändert werden soll. Es gibt nur diese Orte und PLZ.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Ort.findById", query = "SELECT o FROM Ort o WHERE o.id=:id"),
	@NamedQuery(name = "Ort.findByPlz", query = "SELECT o FROM Ort o WHERE o.plz=:plz"),
	@NamedQuery(name = "Ort.findByOrtBez", query = "SELECT o FROM Ort o WHERE o.ortBez=:ortBez")
})
public class Ort implements Serializable {
	

	private static final long serialVersionUID = -873608046753875813L;
	@Id
	@GeneratedValue
	private Integer id;
	private int plz;	
	
	private String ortBez;
	
	//Standardkonstruktor*************************************************
	public Ort(){
			
	}
	
	public Ort(Integer plz, String ortBez){
		this.ortBez = ortBez;
		this.plz = plz;
	}
	
	//getter&setter*******************************************************
	public Integer getPlz() {
		return plz;
	}
	
	public void setPlz(Integer plz) {
		this.plz = plz;
	}

	public String getOrt() {
		return ortBez;
	}
	
	public void setOrtBez(String ortBez) {
		this.ortBez = ortBez;
	}
	
	@Override
	public String toString() {
		return  plz + " " + ortBez;
	}
	
}
