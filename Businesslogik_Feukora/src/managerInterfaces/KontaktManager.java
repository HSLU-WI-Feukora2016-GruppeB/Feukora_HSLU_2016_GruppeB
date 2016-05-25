package managerInterfaces;

import java.util.List;

import entitys.Kontakt;
import entitys.Ort;

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
	 * @throws Exception
	 */
	public Kontakt findById(Integer id)throws Exception; 
	
	/**
	 * Liefert Liste aller Kontakte.
	 * @return
	 * @throws Exception
	 */
	public List<Kontakt> findAll()throws Exception;
	
	/**
	 * Liefert alle Kontakt mit gesuchtem Namen.
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Kontakt> findByName(String name)throws Exception;
	
	/**
	 * Liefert alle Kontakte mit gesuchtem Vornamen.
	 * @param vorname
	 * @return
	 * @throws Exception
	 */
	public List<Kontakt> findByVorname(String vorname)throws Exception;
	
	/**
	 * Liefert alle Kontakte mit gesuchtem Vornamen.
	 * @param name
	 * @param vorname	 
	 * @return
	 * @throws Exception
	 */
	public List<Kontakt> findByNameVorname(String name, String vorname)throws Exception;
	
	/**
	 * Liefert alle Kontakte mit gesuchtem Ort.
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	public List<Kontakt> findByOrt (Ort ort)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Rolle.
	 * @param rolleIntern
	 * @return
	 * @throws Exception
	 */
	public List<Kontakt> findByRolleExtern (int rolleExtern)throws Exception;
	
	/**
	 * Liefert alle Mitarbeiter mit gesuchter Strasse.
	 * @param strasse
	 * @return
	 * @throws Exception
	 */
	public List<Kontakt> findByStrasse (String strasse)throws Exception;

}
