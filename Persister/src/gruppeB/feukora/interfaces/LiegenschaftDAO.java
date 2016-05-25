package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;

/**
 * Interface f�r Persistierung von Liegenschaft-Entities.
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface LiegenschaftDAO {

	/**
	 * Speichert die �bergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @return Liegenschaft
	 * @throws Exception
	 */
	public Liegenschaft updateLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Liegenschaft-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteLiegenschaft(Liegenschaft entity) throws Exception;
	
	/**
	 * L�scht die Liegenschaft-Entity f�r den uebergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteLiegenschaftById(Integer id) throws Exception;
	
	/**
	 * Liefert die Liegenschaft-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return Liegenschaft
	 * @throws Exception
	 */
	public Liegenschaft findLiegenschaftById(Integer id) throws Exception;
	
	/**
	 * Liefert alle Liegenschaft-Objekte zur�ck.
	 * 
	 * @return List<Liegenschaft>
	 * @throws Exception
	 */
	public List<Liegenschaft> findAllLiegenschaft() throws Exception;

	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Kontakt zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return List<Liegenschaft>
	 * @throws Exception
	 */
	public List<Liegenschaft> findLiegenschaftByKontakt(Kontakt kontakt) throws Exception;
	
	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Ort zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return List<Liegenschaft>
	 * @throws Exception
	 */
	public List<Liegenschaft> findLiegenschaftByOrt(Ort ort) throws Exception;

	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Strasse zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return List<Liegenschaft>
	 * @throws Exception
	 */
	public List<Liegenschaft> findLiegenschaftByStrasse(String strasse) throws Exception;
	
}
