package entit�ten;

/**
 * RolleExtern liefert den Typ f�r einen Kontakt.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public enum RolleExtern {
	@Id
	@GeneratedValue
	private int id;
	
	VERWALTER, EIGENT�MER, HAUSABWART;

}
