package gruppeB.feukora.persister;

import java.util.List;

import entit�ten.Liegenschaft;
import entit�ten.Kontakt;
import entit�ten.Ort;

/**
 * Interface f�r Persistierung von Liegenschaft-Entities.
 * 
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
	 * @return
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
	 * @return
	 */
	public Liegenschaft findLiegenschaftById(Integer id);
	
	/**
	 * Liefert alle Liegenschaft-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Liegenschaft> findAllLiegenschaft();

	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Kontakt zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param kontakt
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByKontakt(Kontakt kontakt);
	
	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Ort zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByOrt(Ort ort);

	/**
	 * Liefert die Liste mit den Liegenschaften f�r die �bergebenen Strasse zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return
	 */
	public List<Liegenschaft> findLiegenschaftByStrasse(String strasse);
	
}
