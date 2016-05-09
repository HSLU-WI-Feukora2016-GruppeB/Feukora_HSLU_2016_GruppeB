/**
 * class Adresse
 * 
 * @author Olivia
 * @version 1.0.0
 * @since 1.0.0
 *
 */

@SupressWarnings("serial")
@Entity
@Data

public class Adresse {
	
	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private Strasse strasse;
	@ManyTooOne (fetch=FetchType.EAGER)
	@NotNull
	private Ort ort;
	
	public Adresse(String strasse, Ort ort){
		super();
		this.strasse = strasse;
		this.ort = ort;
	}
}
