package entitäten;

import java.io.Serializable;
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

/**
 * Ein Mitarbeiter ist eine Person welche nur Firmenintern zu tun hat,
 * sie ist entweder Sachbearbeiter oder Feuerungskontrolleur.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Mitarbeiter.findByName", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.name=:name"),
	@NamedQuery(name = "Mitarbeiter.findByVorname", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.vorname=:vorname"),
	@NamedQuery(name = "Mitarbeiter.findByRolleIntern", query = "SELECT ma FROM Mitarbeiter ma WHERE ma.rolleIntern=:rolleIntern")
})
public class Mitarbeiter implements Serializable{
	
	private static final long serialVersionUID = -4687080612851353080L;
	
	@Id
	@GeneratedValue
	private int idMitarbeiter;
	
	private String vorname;
	private String name;
	private String strasseInklNr;
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
	
	//standardkonstruktor
	public Mitarbeiter(){
		
	}
	
	//getter&setter
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

	public String getStrasseInklNr() {
		return strasseInklNr;
	}

	public void setStrasseInklNr(String strasseInklNr) {
		this.strasseInklNr = strasseInklNr;
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

	public RolleIntern getRolleIntern() {
		return rolleIntern;
	}

	public void setRolleIntern(RolleIntern rolleIntern) {
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

	public void setArbeitetSeit(GregorianCalendar arbeitetSeit) {
		this.arbeitetSeit = arbeitetSeit;
	}

	public GregorianCalendar getArbeitetBis() {
		return arbeitetBis;
	}

	public void setArbeitetBis(GregorianCalendar arbeitetBis) {
		this.arbeitetBis = arbeitetBis;
	}

}
