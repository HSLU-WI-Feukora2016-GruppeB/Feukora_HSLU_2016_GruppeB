package managerInterfaces;

import java.util.List;

import entitäten.Auftrag;

/**
 * Verwaltet einen Auftrag und alle Funktionen.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface AuftragManager {
	
	/**
	 * Speichert einen Auftrag.
	 * @param entität
	 * @return
	 * @throws Exception
	 */
	public Auftrag add(Auftrag entität) throws Exception;
	
	/**
	 * Passt den übergebenen Auftrag an.
	 * @param entität
	 * @return
	 * @throws Exception
	 */
	public Auftrag update(Auftrag entität) throws Exception;
	
	/**
	 * Löscht den übergebenen Auftrag.
	 * @param entität
	 * @return
	 * @throws Exception
	 */
	public void delete(Auftrag entität) throws Exception;

	/**
	 * Liefert den Auftrag der mit der Id angefragt wurde. 
	 * @param id
	 * @return
	 */
	public Auftrag findById(Integer id);
	
	/**
	 * Liefert alle Aufträge zurück.
	 * @return
	 */
	public List<Auftrag> findAll();
	
	/**
	 * Liefert eine Auftragliste anhand des gesuchten Terminsdatums.
	 * @param datum
	 * @return
	 */
	public List<Auftrag> findByDatum(GregorianCalender datum);
	
	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Kontrolleur-Namens.
	 * @param kontrolleurName
	 * @return
	 */
	public List<Auftrag> findByMitarbeiterName(String mitarbeiterName);
	
	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Kontaktnamens.
	 * @param kontaktName
	 * @return
	 */
	public List<Auftrag> findByKontaktName(String kontaktName);
	
	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Liegenschafts-Ortes.
	 * @param liegenschaftOrt
	 * @return
	 */
	public List<Auftrag> findByLiegenschaftOrt(String liegenschaftOrt);
	
	
	

	
}
