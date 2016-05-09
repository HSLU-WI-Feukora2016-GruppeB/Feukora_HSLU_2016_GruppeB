package entitäten;

/**
 * Ein Ort liefert Details zur Adresse.
 * @author Olivia
 * @version 1.0
 * @since 1.0
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
		
	
	

}
