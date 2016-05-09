package entitäten;
/**
 * Klasse Adresse enthält Strasse und Ort
 * @author Olivia, Dominik
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class Ort {
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private int plz;
	@NotNull	
	private String ort;
	
	
	public Ort(int plz, String ort) {
		super();
		this.plz = plz;
		this.ort = ort;
		
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	
	

}
