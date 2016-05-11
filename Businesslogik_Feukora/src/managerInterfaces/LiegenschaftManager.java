package managerInterfaces;

import java.util.List;

import entitäten.Liegenschaft;

/**
 * Verwaltet eine Liegenschaft und alle Funktionen.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */
public interface LiegenschaftManager {
	
	/**
	 * Speichert einen Liegenschaft.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Liegenschaft add(Liegenschaft entitaet) throws Exception;
	
	/**
	 * Passt die übergebene Liegenschaft an.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Liegenschaft update(Liegenschaft entitaet) throws Exception;
	
	/**
	 * Löscht die übergebene Liegenschaft.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public void delete(Liegenschaft entitaet) throws Exception;

	/**
	 * Liefert die Liegenschaft die mit der Id angefragt wurde. 
	 * @param id
	 * @return
	 */
	public Liegenschaft findById(Integer id);
	
	/**
	 * Liefert alle Liegenschaften zurück.
	 * @return
	 */
	public List<Liegenschaft> findAll();
	
	/**
	 * Liefert eine Liegenschaftsliste anhand des gesuchten Termindatums.
	 * @param name
	 * @return
	 */
	public List<Liegenschaft> findByTermin(GregorianCalender termin);
	
	/**
	 * Liefert eine Liegenschaftsliste anhand des gesuchten Kontakts.
	 * @param kontakt
	 * @return
	 */
	public List<Liegenschaft> findByKontakt(String kontakt);

	/**
	 * Liefert eine Liegenschaftsliste anhand des gesuchten Orts.
	 * @param ort
	 * @return
	 */
	public List<Liegenschaft> findByOrt(String ort);
	
	/**
	 * Liefert eine Liegenschaftsliste anhand der gesuchten Strasse.
	 * @param strasseInklNr
	 * @return
	 */	
	public List<Liegenschaft> findByStrasse(String strasseInklNr);

	
}
