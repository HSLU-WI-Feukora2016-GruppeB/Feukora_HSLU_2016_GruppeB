package entit�ten;

public class Liegenschaft {
	
	private int id;
	//Kunde ist entweder Verwalter oder Eigent�mer
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
	public boolean isEigent�mer() {
		return eigent�mer;
	}
	public void setEigent�mer(boolean eigent�mer) {
		this.eigent�mer = eigent�mer;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
