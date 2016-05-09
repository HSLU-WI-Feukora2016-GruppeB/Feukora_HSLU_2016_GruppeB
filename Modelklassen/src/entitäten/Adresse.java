package entitäten;
/**
 * Klasse Adresse enthält Strasse und Ort
 * @author Olivia, Dominik
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Entity
@Data
public class Adresse {
	
	@Id
	@GeneratedValue
	private int id;
	//Attribute
	@NotNull
	private Strasse strasse;
	@ManyTooOne
	private Ort ort;
	
	/**
	 * Konstruktor erstellt eine Adresse aus Ort und Strasse.
	 * @param strasse
	 * @param ort
	 */
	//Standartkonstruktor
	public Adresse(){}
	
	public Adresse(Strasse strasse, Ort ort){
		super();
		this.strasse = strasse;
		this.ort = ort;
	}
}
