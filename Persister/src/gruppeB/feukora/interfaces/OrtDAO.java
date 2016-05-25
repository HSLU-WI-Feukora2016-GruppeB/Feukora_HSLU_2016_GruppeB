package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Ort;

/**
 * Interface für Persistierung von Ort-Entities.
 * 
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface OrtDAO {

	/**
	 * Speichert die übergebene Ort-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveOrt(Ort entity) throws Exception;

	/**
	 * Updatet die übergebene Ort-Entity.
	 * 
	 * @param entity
	 * @return Ort
	 * @throws Exception
	 */
	public Ort updateOrt(Ort entity) throws Exception;

	/**
	 * Löscht die übergebene Ort-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteOrt(Ort entity) throws Exception;

	/**
	 * Löscht die Ort-Entity für den uebergebenen Id-Wert.
	 * 
	 * @param idOrt
	 * @throws Exception
	 */
	public void deleteOrtById(Integer idOrt) throws Exception;

	/**
	 * Liefert die Ort-Entity für die uebergebenen Id zurück.
	 * 
	 * @param idOrt
	 * @return Ort
	 * @throws Exception
	 */
	public Ort findOrtById(Integer idOrt) throws Exception;

	/**
	 * Liefert die Ort-Entity für die uebergebenen PLZ zurück.
	 * 
	 * @param plz
	 * @return List<Ort>
	 * @throws Exception
	 */
	public List<Ort> findOrtByPlz(Integer plz) throws Exception;

	/**
	 * Liefert alle Ort-Objekte zurück.
	 * 
	 * @return List<Ort>
	 * @throws Exception
	 */
	List<Ort> findAllOrt() throws Exception;

	/**
	 * Liefert die Liste mit den Örtlichkeiten für die übergebene
	 * Ortsbezeichnung zurück, falls welche gefunden werden. Sonst eine leere
	 * Liste.
	 * 
	 * @param ortBez
	 * @return List<Ort>
	 * @throws Exception
	 */
	public List<Ort> findOrtByBezeichnung(String ortBez) throws Exception;

}
