package managerKlassen;

import java.util.HashMap;
import java.util.Map;

import entitys.Grenzwerte;
import entitys.Messung;

/**
 * Kontrolliert Messung anhand der jeweiligen Grenzwerte
 *
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class GrenzwerteManagerImpl {

	/**
	 * Deklaration einer verschachtelten Map Äussere Map hat einen Integer
	 * welchen die Brennerart angibt, siehe Brenner int brennerArt sowie eine
	 * innere Map. Die Innere Map hat einen Integer welchen die Messstufe
	 * angibt, siehe Auftrag Messungsobjekte sowie ein Grenzwerte Objekt mit den
	 * jeweiligen Grenzwerten.
	 *
	 * Alle Brenner mit Brennstoff Gas haben nur 3 Grenzwerte im gegensatz zu
	 * den Heizölbrennern mit 5. Diese sollten default mit 0, null, resp false
	 * gefüllt werden damit sie übersprungen werden können.
	 *
	 */
	private static final Map<Integer, Map<Integer, Grenzwerte>> grenzwertMap = new HashMap<Integer, Map<Integer, Grenzwerte>>();

	/*
	 * static block zum map befüllen, wird gemacht damit der complier zeitlich
	 * alles richtig abläuft
	 */
	static {
		// Gebläse 1-stufig - Heizöl
		Map<Integer, Grenzwerte> mapb1 = new HashMap();
		mapb1.put(1, new Grenzwerte(1, 80, false, 120, 7));
		grenzwertMap.put(1, mapb1);

		// Gebläse 2-stufig - Heizöl
		Map<Integer, Grenzwerte> mapb2 = new HashMap();
		// Verschiedene Grenzwerte für 2 Stufen des 2-stufigen Gebläsebrenners
		mapb2.put(1, new Grenzwerte(1, 80, false, 120, 6));
		mapb2.put(2, new Grenzwerte(1, 80, false, 120, 8));
		grenzwertMap.put(2, mapb2);

		// Verdampfungsbrenner - Heizöl
		Map<Integer, Grenzwerte> mapb3 = new HashMap();
		mapb3.put(1, new Grenzwerte(2, 150, false, 120, 7));
		grenzwertMap.put(3, mapb3);

		// Gebläse 1-stufig - Gas
		Map<Integer, Grenzwerte> mapb4 = new HashMap();
		mapb4.put(1, new Grenzwerte(Integer.MAX_VALUE, 100, false, 80, 7));
		grenzwertMap.put(4, mapb4);

		// Gebläse 2-stufig - Gas
		Map<Integer, Grenzwerte> mapb5 = new HashMap();
		// Verschiedene Grenzwerte für 2 Stufen des 2-stufigen Gebläsebrenners
		mapb5.put(1, new Grenzwerte(Integer.MAX_VALUE, 100, false, 80, 6));
		mapb5.put(2, new Grenzwerte(Integer.MAX_VALUE, 100, false, 80, 8));
		grenzwertMap.put(5, mapb5);

		// Athmosphärische Brenner - Gas
		Map<Integer, Grenzwerte> mapb6 = new HashMap();
		mapb6.put(1, new Grenzwerte(Integer.MAX_VALUE, 100, false, 120, 7));
		grenzwertMap.put(6, mapb6);

	}

	public void checkGrenzwerte(Messung messung, int brennerTyp, int messStufe) {

		Grenzwerte gWerte = grenzwertMap.get(brennerTyp).get(messStufe);
		if (messung == null || gWerte == null) {
			return;
		} else {


		messung.setRusszahlNotOk(isRusszahlNOK(messung, gWerte));

		messung.setCoMgNotOk(isCoGehaltNOK(messung, gWerte));

		messung.setOelanteilenNotOk(isOelanteilNOK(messung, gWerte));

		messung.setNoMgNotOk(isNo2GehaltNOK(messung, gWerte));

		messung.setAbgasverlusteNotOk(isAbgasverlusteNOK(messung, gWerte));

		messung.setBeurteilungNotOk(checkBeurteilung(messung));
		}
	}

	private boolean checkBeurteilung(Messung messung) {
		return messung.isRusszahlNotOk() || messung.isCoMgNotOk()
				|| messung.isOelanteilenNotOk() || messung.isNoMgNotOk()
				|| messung.isAbgasverlusteNotOk();
	}

	private boolean isAbgasverlusteNOK(Messung messung, Grenzwerte gWerte) {
		return messung.getAbgasverluste() < gWerte.getMaxAbgasverluste();
	}

	private boolean isNo2GehaltNOK(Messung messung, Grenzwerte gWerte) {
		return messung.getNo2Gehalt() < gWerte.getMaxNo2mg();
	}

	private boolean isOelanteilNOK(Messung messung, Grenzwerte gWerte) {
		return messung.isOelanteil() != gWerte.isHasOelanteil();
	}

	private boolean isCoGehaltNOK(Messung messung, Grenzwerte gWerte) {
		return messung.getCoGehalt() < gWerte.getMaxCoGehalt();
	}

	private boolean isRusszahlNOK(Messung messung, Grenzwerte gWerte) {
		return messung.getRusszahl() < gWerte.getMaxRusszahl();
	}

}
