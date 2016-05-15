package managerKlassen;

import java.util.HashMap;
import java.util.Map;

import entit�ten.Grenzwerte;

/**
 * Kontrolliert Messung anhand der jeweiligen Grenzwerte
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class GrenzwerteManagerImpl {
	
	/**
	 * Deklaration einer verschachtelten Map
	 * �ussere Map hat einen Integer welchen die Brennerart angibt, 
	 * siehe Brenner int brennerArt sowie eine innere Map.
	 * Die Innere Map hat einen Integer welchen die Messstufe angibt,
	 * siehe Auftrag Messungsobjekte sowie ein Grenzwerte Objekt 
	 * mit den jeweiligen Grenzwerten.
	 * 
	 * Alle Brenner mit Brennstoff Gas haben nur 3 Grenzwerte im gegensatz zu
	 * den HEiz�lbrennern mit 5. 
	 * Diese sollten default mit 0, null, resp false gef�llt werden 
	 * damit sie �bersprungen werden k�nnen.
	 * 
	 */
	private static final Map<Integer, Map<Integer, Grenzwerte>> grenzwertMap 
		= new HashMap<Integer, Map<Integer,Grenzwerte>>();
	
	
	/*
	 * static block zum map bef�llen, wird gemacht 
	 * damit der complier zeitlich alles richtig abl�uft
	 */
	static{
		//Gebl�se 1-stufig - Heiz�l
		Map<Integer, Grenzwerte> mapb1 = new HashMap();
		mapb1.put(1, new Grenzwerte(1, 80, false, 120, 7));
		grenzwertMap.put(1, mapb1);
		
		//Gebl�se 2-stufig - Heiz�l
		Map<Integer, Grenzwerte> mapb2 = new HashMap();
		//Verschiedene Grenzwerte f�r 2 Stufen des 2-stufigen Gebl�sebrenners
		mapb2.put(1, new Grenzwerte(1, 80, false, 120, 6));
		mapb2.put(2, new Grenzwerte(1, 80, false, 120, 8));
		grenzwertMap.put(2, mapb2);
		
		//Verdampfungsbrenner - Heiz�l
		Map<Integer, Grenzwerte> mapb3 = new HashMap();
		mapb3.put(1, new Grenzwerte(2, 150, false, 120, 7));
		grenzwertMap.put(3, mapb3);
		
		// Gebl�se 1-stufig - Gas
		Map<Integer, Grenzwerte> mapb4 = new HashMap();
		mapb4.put(1, new Grenzwerte(Integer.MAX_VALUE, 100, false, 80, 7));
		grenzwertMap.put(4, mapb4);
		
		// Gebl�se 2-stufig - Gas
		Map<Integer, Grenzwerte> mapb5 = new HashMap();
		// Verschiedene Grenzwerte f�r 2 Stufen des 2-stufigen Gebl�sebrenners
		mapb5.put(1, new Grenzwerte(Integer.MAX_VALUE, 100, false, 80, 6));
		mapb5.put(2, new Grenzwerte(Integer.MAX_VALUE, 100, false, 80, 8));
		grenzwertMap.put(5, mapb5);
		
		//Athmosph�rische Brenner - Gas
		Map<Integer, Grenzwerte> mapb6 = new HashMap();
		mapb6.put(1, new Grenzwerte(Integer.MAX_VALUE, 100, false, 120, 7));
		grenzwertMap.put(6, mapb6);
		
	}
	
	public void test(){
		Grenzwerte gWerte = grenzwertMap.get(1).get(1);
	}

}
