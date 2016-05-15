package managerInterfaces;

import java.util.List;

import entitäten.Mitarbeiter;


/**
 * Interface welches Mitarbeiter funktionalitäten liefert.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface MitarbeiterManager {
	
	
	/**
	 * Speichert einen Mitarbeiter.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter add(Mitarbeiter entity) throws Exception;
	
	/**
	 * Passt einen Mitarbeiter an.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter update(Mitarbeiter entity) throws Exception;
	
	/**
	 * Löscht den mitgegebenen Mitarbeiter.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Mitarbeiter entity) throws Exception;
	
	/**
	 * Liefert Liste aller Mitarbeiter.
	 * @return
	 */
	public List<Mitarbeiter> findAllMitarbeiter();
	
	/**
	 * Liefert alle Mitarbeiter des angefragten Typs.
	 * @param name
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByName(String name);
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Vornamen.
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname);
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Rolle.
	 * @param rolleIntern
	 * @return
	 */
	public List<Mitarbeiter> findByRolleIntern (int rolleIntern);

}
