package entitäten;

import java.io.Serializable;

/**
 * RolleIntern liefert die Rolle für den Mitarbeiter.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
public enum RolleIntern implements Serializable{
	/*
	 * Enum benötigt keine Annotationen ist über Mitarbeiter @Enumerated geregelt
	*/		
	SACHBEARBEITER, FEUERUNGSKONTROLLEUR;

}
