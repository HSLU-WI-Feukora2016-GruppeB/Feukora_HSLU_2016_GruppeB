package entitäten;
/**
 * Klasse Adresse enthält Strasse und Ort
 * @author Olivia, Dominik
 * @version 1.0.0
 * @since 1.0.0
 *
 */

@Data
@Entity
public class Kontakt implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	//Attribute
	@NotNull
	private String vorname;
	@NotNull
	private String nachname;
	@NotNull
	private Adresse adresse;
	@NotNull
	private int tel;
	@NotNull
	private String email;
	@NotNull	
	private RolleExtern	rolleExtern;
	
	//Standartkonstruktor
	public Kontakt(){}
}
