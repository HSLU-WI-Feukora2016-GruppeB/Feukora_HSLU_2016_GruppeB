package managerInterfaces;

import java.util.List;

import entitäten.Kontakt;
import entitäten.Ort;

/**
 * Liefert Funktionalität eines Kontaktes.
 * @author Olivia
 *
 */
public interface KontaktManager {
	
	/**
	 * Speichert einen Kontakt.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Kontakt add(Kontakt entity) throws Exception;
	/**
	 * Passt einen Kontakt an.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Kontakt update(Kontakt entity) throws Exception;
	
	/**
	 * Löscht den mitgegebenen Kontakt.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Kontakt entity) throws Exception;
	
	/**
	 * Löscht den mitgegebenen Kontakt mithilfe seiner Id.
	 * @param idKontakt
	 * @throws Exception
	 */
	public void deleteById(Integer idKontakt) throws Exception;

	/**
	 * Liefert Liste von Kontakten mit der mitgegebenen ID.
	 * @return
	 */
	public Kontakt findById(Integer id);
	
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
	 * Liefert alle Kontakte mit gesuchtem Vornamen.
	 * @param name
	 * @param vorname	 
	 * @return
	 */
	public List<Kontakt> findByNameVorname(String name, String vorname);
	
	/**
	 * Liefert alle Kontakte mit gesuchtem Ort.
	 * @param ort
	 * @return
	 */
	public List<Kontakt> findByOrt (Ort ort);
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Rolle.
	 * @param rolleIntern
	 * @return
	 */
	public List<Kontakt> findByRolleExtern (int rolleExtern);
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Strasse.
	 * @param strasse
	 * @return
	 */
	public List<Kontakt> findByStrasse (String strasse);

}
