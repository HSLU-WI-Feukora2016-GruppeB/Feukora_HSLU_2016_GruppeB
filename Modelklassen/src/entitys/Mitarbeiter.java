package entitys;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.jdt.annotation.Nullable;

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
	@NamedQuery(name = "Mitarbeiter.findById", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.idMitarbeiter=:idMitarbeiter"),
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
	private Integer idMitarbeiter;
	
	private String vorname;
	private String name;
	private String strasse;
	@ManyToOne
	private Ort ort;
	private String tel;
	private String email;
	private int rolleIntern;
	@Nullable
	@OneToOne
	private Benutzer user;
	private int lohn;
	@Temporal(TemporalType.DATE)
	private GregorianCalendar arbeitetSeit;
	@Nullable
	@Temporal(TemporalType.DATE)
	private GregorianCalendar arbeitetBis;
	
	//standardkonstruktor**************************************************
	public Mitarbeiter(){
		
	}
	
	public Mitarbeiter(String vorname, String name, String strasse, Ort ort,
			String tel, String email, int rolleIntern, Benutzer user,
			int lohn, GregorianCalendar arbeitetSeit,
			GregorianCalendar arbeitetBis) {
		this.vorname = vorname;
		this.name = name;
		this.strasse = strasse;
		this.ort = ort;
		this.tel = tel;
		this.email = email;
		this.rolleIntern = rolleIntern;
		this.user = user;
		this.lohn = lohn;
		this.arbeitetSeit = arbeitetSeit;
		this.arbeitetBis = arbeitetBis;
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

	public Benutzer getUsercredentials() {
		return user;
	}

	public void setUsercredentials(Benutzer usercredentials) {
		this.user = usercredentials;
	}

	public int getLohn() {
		return lohn;
	}

	public void setLohn(int lohn) {
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
	public String formatDatum(GregorianCalendar datum) {
		String cal = "";
		
		if(datum==null){
			cal = "x";
		} else {
			cal = arbeitetSeit.get(Calendar.DAY_OF_MONTH) + "/" + arbeitetSeit.get(Calendar.MONTH) + "/" + arbeitetSeit.get(Calendar.YEAR);
				}
		return cal;
	}

	public void setArbeitetSeit(GregorianCalendar arbeitetSeit) {
		this.arbeitetSeit = arbeitetSeit;
	}

	public GregorianCalendar getArbeitetBis() {
		return arbeitetBis;
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
				+ "Ort: " + ort + "\n"
				+ "Telefon: " + tel + "\n"
				+ "eMail: \n" + email.toString() + "\n"
				+ "Rolle Intern: " + rolleIntern + "\n"
				+ "User: " + user + "\n"
				+ "Lohn: " + lohn + "\n"
				+ "Arbeitet seit: \n" + this.formatDatum(this.arbeitetSeit) + "\n"
				+ "Arbeitet bis: \n" + this.formatDatum(this.arbeitetBis) + "\n";
	}

}