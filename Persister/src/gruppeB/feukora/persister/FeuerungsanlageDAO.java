/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;

import entit�ten.Brenner;
import entit�ten.Feuerungsanlage;
import entit�ten.Liegenschaft;
import entit�ten.Waermeerzeuger;

/**
 * Interface f�r Persistierung von Feuerungsanlage-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface FeuerungsanlageDAO {

	/**
	 * Speichert die �bergebene Feuerungsanlage-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveFeuerungsanlage(Feuerungsanlage entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Feuerungsanlage-Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Feuerungsanlage updateFeuerungsanlage(Feuerungsanlage entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Feuerungsanlage-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteFeuerungsanlage(Feuerungsanlage entity) throws Exception;
	
	/**
	 * L�scht die Feuerungsanlage-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteFeuerungsanlageById(Integer id) throws Exception;
	
	/**
	 * Liefert die Feuerungsanlage-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 */
	public Feuerungsanlage findFeuerungsanlageById(Integer id);
	
	/**
	 * Liefert alle Feuerungsanlage-Objekte zur�ck.
	 * 
	 * @return
	 */
	List<Feuerungsanlage> findAllFeuerungsanlage();
	
	/**
	 * Liefert die Liste mit den Feuerungsanlagen f�r die �bergebene Bezeichnung zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param bezeichnung
	 * @return
	 */
	public List<Feuerungsanlage> findFeuerungsanlageByBezeichnung(String bezeichnung);
	
	/**
	 * Liefert die Liste mit den Feuerungsanlagen f�r das �bergebene Baujahr zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param baujahr
	 * @return
	 */
	public List<Feuerungsanlage> findFeuerungsanlageByBaujahr(Integer baujahr);
	
	/**
	 * Liefert die Liste mit den Feuerungsanlagen f�r die �bergebenen Brennstoffe zur�ck, falls
	 * es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param brennstoff
	 * @return
	 */
	public List<Feuerungsanlage> findFeuerungsanlageByBrennstoff(String brennstoff);

	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft);
	//toDO

	public List<Feuerungsanlage> findByBrenner(Brenner brenner);
	//toDO

	public List<Feuerungsanlage> findByWaermeerzeuger(
			Waermeerzeuger waermeerzeuger);
	//toDO
}
