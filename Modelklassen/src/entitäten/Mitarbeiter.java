import java.util.Date;
import java.util.GregorianCalendar;


public class Mitarbeiter{
	
	private String vorname;
	private String nachname;
	private Adresse adresse;
	private int tel;
	private String email;
	private RolleIntern rolleIntern;
	private String position;
	private int lohn;
	private GregorianCalendar fristSeit;
	private GregorianCalendar fristBis;
	
	
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getLohn() {
		return lohn;
	}
	public void setLohn(int lohn) {
		this.lohn = lohn;
	}
	public GregorianCalendar getFristSeit() {
		return fristSeit;
	}
	public void setFristSeit(GregorianCalendar fristSeit) {
		this.fristSeit = fristSeit;
	}
	public GregorianCalendar getFristBis() {
		return fristBis;
	}
	public void setFristBis(GregorianCalendar fristBis) {
		this.fristBis = fristBis;
	}
	
	

}
