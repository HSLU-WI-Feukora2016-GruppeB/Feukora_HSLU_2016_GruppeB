package entit�ten;

/**
 * RolleIntern liefert die Rolle f�r den Mitarbeiter.
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
