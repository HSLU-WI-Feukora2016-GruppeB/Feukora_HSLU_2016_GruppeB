package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Kontakt stellt eine Kontaktperson oder einen Kunden dar, sie ist entweder 
 * ein Hauseigentümer, Verwalter oder Hausmeister.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Kontakt.findByName", query = "SELECT k FROM Kontakt k WHERE k.name=:name"),
	@NamedQuery(name = "Kontakt.findByVorname", query = "SELECT k FROM Kontakt k WHERE k.vorname=:vorname"),
	@NamedQuery(name = "Kontakt.findByOrt", query = "SELECT k FROM Kontakt k WHERE k.ort=:ort"),
	@NamedQuery(name = "Kontakt.findByRolleExtern", query = "SELECT k FROM Kontakt k WHERE k.rolleExtern=:rolleExtern")
})
public class Kontakt implements Serializable{
	
	private static final long serialVersionUID = 1916150058162417599L;

	@Id
	@GeneratedValue
	private Integer id;

	private String vorname;

	private String nachname;

	private String strasseInklNr;

	@ManyToOne
	private Ort ortInklPlz;

	private int tel;

	private String email;

	@ManyToOne
	@Enumerated(EnumType.STRING)
	private RolleExtern	rolleExtern;
	
	//Standartkonstruktor
	public Kontakt(){
		
	}

	//getter&setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getStrasseInklNr() {
		return strasseInklNr;
	}

	public void setStrasseInklNr(String strasseInklNr) {
		this.strasseInklNr = strasseInklNr;
	}

	public Ort getAdresse() {
		return ortInklPlz;
	}

	public void setAdresse(Ort adresse) {
		this.ortInklPlz = adresse;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RolleExtern getRolleExtern() {
		return rolleExtern;
	}

	public void setRolleExtern(RolleExtern rolleExtern) {
		this.rolleExtern = rolleExtern;
	}
	
	
}
