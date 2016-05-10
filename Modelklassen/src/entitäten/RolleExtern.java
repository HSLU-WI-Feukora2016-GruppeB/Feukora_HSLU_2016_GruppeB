package entitäten;

import java.io.Serializable;

/**
 * RolleExtern liefert den Typ für einen Kontakt.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public enum RolleExtern implements Serializable{
	/*
	 * Enum benötigt keine Annotationen ist über Mitarbeiter @Enumerated
	 * geregelt
	 */
	VERWALTER, EIGENTÜMER, HAUSABWART;

}
