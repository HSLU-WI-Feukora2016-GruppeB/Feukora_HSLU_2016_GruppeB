package entitäten;

public class Liegenschaft {
	
	private int id;
	//Kunde ist entweder Verwalter oder Eigentümer
	private Kontakt kunde;
	private Kontakt hausabwart;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isVerwalter() {
		return verwalter;
	}
	public void setVerwalter(boolean verwalter) {
		this.verwalter = verwalter;
	}
	public boolean isHauswart() {
		return hauswart;
	}
	public void setHauswart(boolean hauswart) {
		this.hauswart = hauswart;
	}
	public boolean isEigentümer() {
		return eigentümer;
	}
	public void setEigentümer(boolean eigentümer) {
		this.eigentümer = eigentümer;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
