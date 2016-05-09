package entitäten;
import java.util.GregorianCalendar;

/**
 * Ein Auftrag fasst alle wichtigen Informationen für den Auftrag zusammen. 
 * Er wird normalerweise vom Sachbearbeiter erstellt und vom Feuerungskontrolleur durch
 * die Kontroll-Messdaten ergänzt. 
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
public class Auftrag {
	
	private Kontakt kunde;
	private Mitarbeiter aufgenommenDurch;
	private Liegenschaft liegenschaft;
	private Mitarbeiter ausgeführtDurch;
	private GregorianCalendar termin;
	private boolean terminart;		//wenn true dann Service sonst nur Kontrolle
	
	

}
