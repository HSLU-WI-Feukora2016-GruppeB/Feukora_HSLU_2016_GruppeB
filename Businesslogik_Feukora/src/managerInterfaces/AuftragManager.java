package managerInterfaces;

import java.util.List;

import entit�ten.Auftrag;

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
	 * @param entit�t
	 * @return
	 * @throws Exception
	 */
	public Auftrag add(Auftrag entit�t) throws Exception;
	
	/**
	 * Passt den �bergebenen Auftrag an.
	 * @param entit�t
	 * @return
	 * @throws Exception
	 */
	public Auftrag update(Auftrag entit�t) throws Exception;
	
	/**
	 * L�scht den �bergebenen Auftrag.
	 * @param entit�t
	 * @return
	 * @throws Exception
	 */
	public void delete(Auftrag entit�t) throws Exception;

	/**
	 * Liefert den Auftrag der mit der Id angefragt wurde. 
	 * @param id
	 * @return
	 */
	public Auftrag findById(Integer id);
	
	/**
	 * Liefert alle Auftr�ge zur�ck.
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
