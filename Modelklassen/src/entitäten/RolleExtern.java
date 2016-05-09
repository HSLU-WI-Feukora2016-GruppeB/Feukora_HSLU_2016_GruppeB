package entitäten;
/**
 * Klasse Adresse enthält Strasse und Ort
 * @author Olivia, Dominik
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public enum RolleExtern {
	@Id
	@GeneratedValue
	private int id;
	VERWALTER, EIGENTÜMER, HAUSABWART;

}
