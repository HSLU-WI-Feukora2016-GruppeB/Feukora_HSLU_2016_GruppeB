package entitäten;
/**
 * Kontakt stellt eine Kontaktperson oder einen Kunden dar, sie ist entweder 
 * ein Hauseigentümer, Verwalter oder Hausmeister.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Data
@Entity
public class Kontakt {
	
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
