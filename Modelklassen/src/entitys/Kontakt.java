package entitys;

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
	@NamedQuery(name = "Kontakt.findByNameVorname", query = "SELECT k FROM Kontakt k WHERE k.name=:name AND k.vorname=:vorname"),
	@NamedQuery(name = "Kontakt.findByOrt", query = "SELECT k FROM Kontakt k WHERE k.ort=:ort"),
	@NamedQuery(name = "Kontakt.findByRolleExtern", query = "SELECT k FROM Kontakt k WHERE k.rolleExtern=:rolleExtern"),
	@NamedQuery(name = "Kontakt.findById", query = "SELECT k FROM Kontakt k WHERE k.idKontakt=:idKontakt"),
	@NamedQuery(name = "Kontakt.findByStrasse", query = "SELECT k FROM Kontakt k WHERE k.strasse=:strasse")
})
public class Kontakt implements Serializable{
	
	private static final long serialVersionUID = 1916150058162417599L;

	@Id
	@GeneratedValue
	private Integer idKontakt;

	private String vorname;

	private String name;

	private String strasse;

	@ManyToOne
	private Ort ort;

	private String tel;

	private String email;

	private int	rolleExtern;
	
	//konstruktor**************************************************
	public Kontakt(){
		
	}
	
	public Kontakt(String vorname, String name, String strasse, Ort ort, String tel, String email, int rolleExtern){
		this.vorname = vorname;
		this.name = name;
		this.strasse = strasse;
		this.ort = ort;
		this.tel = tel;
		this.email = email;
		this.rolleExtern = rolleExtern;
	}

	//getter&setter********************************************************
	public Integer getId() {
		return idKontakt;
	}

	public void setId(Integer id) {
		this.idKontakt = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return name;
	}

	public void setNachname(String nachname) {
		this.name = nachname;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public Ort getAdresse() {
		return ort;
	}

	public void setAdresse(Ort adresse) {
		this.ort = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRolleExtern() {
		
		String rolleE = null;
		
		switch (this.rolleExtern){
			case 1: rolleE = "Eigentümer";
				break;
			case 2: rolleE = "Verwaltung";
				break;
		}
		
		return rolleE;
	}

	public void setRolleExtern(int rolleExtern) {
		this.rolleExtern = rolleExtern;
	}
	
	@Override
	public String toString() {
		return "Kontakt: " + "\n"
				+ "Vorname: \n" + vorname.toString() + "\n"
				+ "Nachname: \n" + name.toString() + "\n"
				+ "Strasse: \n" + strasse.toString() + "\n"
				+ "Ort: \t \t \t" + ort + "\n"
				+ "Telefon: \t \t \t" + tel + "\n"
				+ "eMail: \n" + email.toString() + "\n"
				+ "Rolle Extern: \t \t \t" + rolleExtern + "\n";
	}
	
	
}
