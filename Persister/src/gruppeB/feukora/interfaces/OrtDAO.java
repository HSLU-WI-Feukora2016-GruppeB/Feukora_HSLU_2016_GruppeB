package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Ort;

/**
 * Interface f�r Persistierung von Ort-Entities.
 * 
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface OrtDAO {

	/**
	 * Speichert die �bergebene Ort-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveOrt(Ort entity) throws Exception;

	/**
	 * Updatet die �bergebene Ort-Entity.
	 * 
	 * @param entity
	 * @return Ort
	 * @throws Exception
	 */
	public Ort updateOrt(Ort entity) throws Exception;

	/**
	 * L�scht die �bergebene Ort-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteOrt(Ort entity) throws Exception;

	/**
	 * L�scht die Ort-Entity f�r den uebergebenen Id-Wert.
	 * 
	 * @param idOrt
	 * @throws Exception
	 */
	public void deleteOrtById(Integer idOrt) throws Exception;

	/**
	 * Liefert die Ort-Entity f�r die uebergebenen Id zur�ck.
	 * 
	 * @param idOrt
	 * @return Ort
	 * @throws Exception
	 */
	public Ort findOrtById(Integer idOrt) throws Exception;

	/**
	 * Liefert die Ort-Entity f�r die uebergebenen PLZ zur�ck.
	 * 
	 * @param plz
	 * @return List<Ort>
	 * @throws Exception
	 */
	public List<Ort> findOrtByPlz(Integer plz) throws Exception;

	/**
	 * Liefert alle Ort-Objekte zur�ck.
	 * 
	 * @return List<Ort>
	 * @throws Exception
	 */
	List<Ort> findAllOrt() throws Exception;

	/**
	 * Liefert die Liste mit den �rtlichkeiten f�r die �bergebene
	 * Ortsbezeichnung zur�ck, falls welche gefunden werden. Sonst eine leere
	 * Liste.
	 * 
	 * @param ortBez
	 * @return List<Ort>
	 * @throws Exception
	 */
	public List<Ort> findOrtByBezeichnung(String ortBez) throws Exception;

}
