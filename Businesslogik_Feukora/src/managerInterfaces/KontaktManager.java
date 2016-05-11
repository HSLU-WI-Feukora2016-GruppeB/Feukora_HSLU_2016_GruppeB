package managerInterfaces;

import java.util.List;

import entitäten.Kontakt;
import entitäten.RolleExtern;

/**
 * Liefert Funktionalität eines Kontaktes.
 * @author Olivia
 *
 */
public interface KontaktManager {
	
	/**
	 * Speichert einen Kontakt.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Kontakt add(Kontakt entitaet) throws Exception;
	/**
	 * Passt einen Kontakt an.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Kontakt update(Kontakt entitaet) throws Exception;
	
	/**
	 * Löscht den mitgegebenen Kontakt.
	 * @param entitaet
	 * @throws Exception
	 */
	public void delete(Kontakt entitaet) throws Exception;
	
	/**
	 * Liefert Liste aller Kontakte.
	 * @return
	 */
	public List<Kontakt> findAll();
	
	/**
	 * Liefert alle Kontakt mit gesuchtem Namen.
	 * @param name
	 * @return
	 */
	public List<Kontakt> findByName(String name);
	
	/**
	 * Liefert alle Kontakte mit gesuchtem Vornamen.
	 * @param vorname
	 * @return
	 */
	public List<Kontakt> findByVorname(String vorname);
	
	/**
	 * Liefert alle Kontakte mit gesuchtem Ort.
	 * @param ort
	 * @return
	 */
	public List<Kontakt> findByOrt (String ort);
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Rolle.
	 * @param rolleIntern
	 * @return
	 */
	public List<Kontakt> findByRolleExtern (RolleExtern rolleExtern);

}
