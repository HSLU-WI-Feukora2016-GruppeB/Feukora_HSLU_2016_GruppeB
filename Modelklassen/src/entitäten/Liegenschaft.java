package entitäten;

/**
 * Eine Liegenschaft stellt ein Haus oder eine Wohnung dar, 
 * sie hat jeweils einen oder mehrere Kontaktpersonen
 * um Kontakt aufzunehmen.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class Liegenschaft {
	
	private int id;
	private Kontakt kunde;	//Kunde ist entweder Verwalter oder Eigentümer
	private Kontakt hausabwart;
	
	

}
