package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;

/**
 * Interface für Persistierung von Liegenschaft-Entities.
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface LiegenschaftDAO {

	/**
	 * Speichert die übergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * Updatet die übergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @return Liegenschaft
	 * @throws Exception
	 */
	public Liegenschaft updateLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * Löscht die übergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * Löscht die Liegenschaft-Entity für den uebergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteLiegenschaftById(Integer id) throws Exception;
	
	/**
	 * Liefert die Liegenschaft-Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return Liegenschaft
	 * @throws Exception
	 */
	public Liegenschaft findLiegenschaftById(Integer id) throws Exception;
	
	/**
	 * Liefert alle Liegenschaft-Objekte zurück.
	 * 
	 * @return List<Liegenschaft>
	 * @throws Exception
	 */
	public List<Liegenschaft> findAllLiegenschaft() throws Exception;

	/**
	 * Liefert die Liste mit den Liegenschaften für die übergebenen Kontakt zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return List<Liegenschaft>
	 * @throws Exception
	 */
	public List<Liegenschaft> findLiegenschaftByKontakt(Kontakt kontakt) throws Exception;
	
	/**
	 * Liefert die Liste mit den Liegenschaften für die übergebenen Ort zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return List<Liegenschaft>
	 * @throws Exception
	 */
	public List<Liegenschaft> findLiegenschaftByOrt(Ort ort) throws Exception;

	/**
	 * Liefert die Liste mit den Liegenschaften für die übergebenen Strasse zurück, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return List<Liegenschaft>
	 * @throws Exception
	 */
	public List<Liegenschaft> findLiegenschaftByStrasse(String strasse) throws Exception;
	
}
