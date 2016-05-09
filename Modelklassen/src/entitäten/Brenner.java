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
public class Brenner {

	@Id
	@GeneratedValue
	private int id;
	//Attribute
	
	//Standartkonstruktor
	public Brenner (){}
}
