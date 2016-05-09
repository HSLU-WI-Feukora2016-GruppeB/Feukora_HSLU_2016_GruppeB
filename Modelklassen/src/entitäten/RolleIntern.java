package entitäten;

/**
 * RolleIntern liefert die Rolle für den Mitarbeiter.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
public enum RolleIntern {
	@Id
	@GeneratedValue
	private int id;
	
	SACHBEARBEITER, FEUERUNGSKONTROLLEUR;

}
