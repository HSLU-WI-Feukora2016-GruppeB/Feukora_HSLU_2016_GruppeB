package entitäten;

/**
 * Enthält Benutzerdaten für die Anmeldung.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	

	
}
