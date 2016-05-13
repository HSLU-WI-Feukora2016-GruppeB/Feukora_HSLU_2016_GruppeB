package entitäten;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ein Mitarbeiter ist eine Person welche nur Firmenintern zu tun hat,
 * sie ist entweder Sachbearbeiter oder Feuerungskontrolleur.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Mitarbeiter.findByName", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.name=:name"),
	@NamedQuery(name = "Mitarbeiter.findByVorname", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.vorname=:vorname"),
	@NamedQuery(name = "Mitarbeiter.findByNameVorname", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.vorname=:vorname AND ma.name=:name"),
	@NamedQuery(name = "Mitarbeiter.findByRolleIntern", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.rolleIntern=:rolleIntern"),
	@NamedQuery(name = "Mitarbeiter.findById", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.id=:id"),
	@NamedQuery(name = "Mitarbeiter.findByStrasse", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.strasse=:strasse"),
	@NamedQuery(name = "Mitarbeiter.findByOrt", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.ort=:ort"),
	@NamedQuery(name = "Mitarbeiter.findByUser", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.user=:user"),
	@NamedQuery(name = "Mitarbeiter.findByArbeitetSeit", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.arbeitetSeit=:arbeitetSeit"),
	@NamedQuery(name = "Mitarbeiter.findByArbeitetBis", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.arbeitetBis=:arbeitetBis")
})
public class Mitarbeiter implements Serializable{
	
	private static final long serialVersionUID = -4687080612851353080L;
	
	@Id
	@GeneratedValue
	private int idMitarbeiter;
	
	private String vorname;
	private String name;
	private String strasse;
	@ManyToOne
	private Ort ort;
	private int tel;
	private String email;
	private int rolleIntern;
	@OneToOne
	private User user;
	private float lohn;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar arbeitetSeit;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar arbeitetBis;
	
	//standardkonstruktor**************************************************
	public Mitarbeiter(){
		
	}
	
	//getter&setter********************************************************
	public Integer getIdMitarbeiter() {
		return idMitarbeiter;
	}

	public void setIdMitarbeiter(int idMitarbeiter) {
		this.idMitarbeiter = idMitarbeiter;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public Ort getOrt() {
		return ort;
	}

	public void setOrt(Ort ort) {
		this.ort = ort;
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

	public String getRolleIntern() {
		
		String rolleI = null;
		
		switch (this.rolleIntern){
		case 1: rolleI = "Kontrolleur";
			break;
		case 2: rolleI = "Sachbearbeiter";
			break;
		case 3: rolleI = "Administrator";
			break;
		}
		return rolleI;
	}

	public void setRolleIntern(int rolleIntern) {
		this.rolleIntern = rolleIntern;
	}

	public User getUsercredentials() {
		return user;
	}

	public void setUsercredentials(User usercredentials) {
		this.user = usercredentials;
	}

	public float getLohn() {
		return lohn;
	}

	public void setLohn(float lohn) {
		this.lohn = lohn;
	}

	public GregorianCalendar getArbeitetSeit() {
		return arbeitetSeit;
	}
	
	/**
	 * Hilfsmethode für toString Methode der Klasse Messung. Ein Datum wird formatiert gedruckt.
	 * @param messDatum
	 * @return
	 */
	public String printArbeitetSeitDatum(GregorianCalendar arbeitetSeit) {
		return arbeitetSeit.get(Calendar.DAY_OF_MONTH) + "/" + arbeitetSeit.get(Calendar.MONTH) + "/" + arbeitetSeit.get(Calendar.YEAR);
	}

	public void setArbeitetSeit(GregorianCalendar arbeitetSeit) {
		this.arbeitetSeit = arbeitetSeit;
	}

	public GregorianCalendar getArbeitetBis() {
		return arbeitetBis;
	}
	
	public String printArbeitetBisDatum(GregorianCalendar arbeitetBis) {
		return arbeitetBis.get(Calendar.DAY_OF_MONTH) + "/" + arbeitetBis.get(Calendar.MONTH) + "/" + arbeitetBis.get(Calendar.YEAR);
	}

	public void setArbeitetBis(GregorianCalendar arbeitetBis) {
		this.arbeitetBis = arbeitetBis;
	}
	
	@Override
	public String toString() {
		return "Mitarbeiter: " + "\n"
				+ "Vorname: \n" + vorname.toString() + "\n"
				+ "Name: \n" + name.toString() + "\n"
				+ "Strasse: \n" + strasse.toString() + "\n"
				+ "Ort: \t \t \t" + ort + "\n"
				+ "Telefon: \t \t \t" + tel + "\n"
				+ "eMail: \n" + email.toString() + "\n"
				+ "Rolle Intern: \t \t \t" + rolleIntern + "\n"
				+ "User: \t \t \t" + user + "\n"
				+ "Lohn: \t \t \t" + lohn + "\n"
				+ "Arbeitet seit: \n" + this.printArbeitetSeitDatum(this.arbeitetSeit) + "\n"
				+ "Arbeitet bis: \n" + this.printArbeitetBisDatum(this.arbeitetBis) + "\n";
	}

}