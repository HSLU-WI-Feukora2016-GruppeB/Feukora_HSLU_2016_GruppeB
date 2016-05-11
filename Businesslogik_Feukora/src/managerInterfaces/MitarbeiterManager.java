package managerInterfaces;

import java.util.List;

import entitäten.Mitarbeiter;
import entitäten.RolleIntern;


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
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter add(Mitarbeiter entitaet) throws Exception;
	
	/**
	 * Passt einen Mitarbeiter an.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Mitarbeiter update(Mitarbeiter entitaet) throws Exception;
	
	/**
	 * Löscht den mitgegebenen Mitarbeiter.
	 * @param entitaet
	 * @throws Exception
	 */
	public void delete(Mitarbeiter entitaet) throws Exception;
	
	/**
	 * Liefert Liste aller Mitarbeiter.
	 * @return
	 */
	public List<Mitarbeiter> findAll();
	
	/**
	 * Liefert alle Mitarbeiter des angefragten Typs.
	 * @param name
	 * @return
	 */
	public List<Mitarbeiter> findByName(String name);
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchtem Vornamen.
	 * @param vorname
	 * @return
	 */
	public List<Mitarbeiter> findByVorname(String vorname);
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Rolle.
	 * @param rolleIntern
	 * @return
	 */
	public List<Mitarbeiter> findByRolleIntern (RolleIntern rolleIntern);

}
