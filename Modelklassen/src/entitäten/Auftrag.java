import java.util.GregorianCalendar;


public class Auftrag {
	
	private Person person;
	private Liegenschaft liegenschaft;
	private Auftrag auftrag;
	private GregorianCalendar termin;
	private boolean terminart;
		//wenn true dann Service sonst nur Kontrolle
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Liegenschaft getLiegenschaft() {
		return liegenschaft;
	}
	public void setLiegenschaft(Liegenschaft liegenschaft) {
		this.liegenschaft = liegenschaft;
	}
	public Auftrag getAuftrag() {
		return auftrag;
	}
	public void setAuftrag(Auftrag auftrag) {
		this.auftrag = auftrag;
	}
	public GregorianCalendar getTermin() {
		return termin;
	}
	public void setTermin(GregorianCalendar termin) {
		this.termin = termin;
	}
	public boolean isTerminart() {
		return terminart;
	}
	public void setTerminart(boolean terminart) {
		this.terminart = terminart;
	}
	
	

}
