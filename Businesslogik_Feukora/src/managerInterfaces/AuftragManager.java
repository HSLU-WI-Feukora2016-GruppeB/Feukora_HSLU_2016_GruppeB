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
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Auftrag add(Auftrag entitaet) throws Exception;
	
	/**
	 * Passt den übergebenen Auftrag an.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public Auftrag update(Auftrag entität) throws Exception;
	
	/**
	 * Löscht den übergebenen Auftrag.
	 * @param entitaet
	 * @return
	 * @throws Exception
	 */
	public void delete(Auftrag entitaet) throws Exception;

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
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter.
	 * @param mitarbeiter
	 * @return
	 */
	public List<Auftrag> findByMitarbeiter(String mitarbeiter);
	
	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Kontakts.
	 * @param kontakt
	 * @return
	 */
	public List<Auftrag> findByKontakt(String kontakt);
	
	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Liegenschaften.
	 * @param liegenschaftOrt
	 * @return
	 */
	public List<Auftrag> findByLiegenschaft(String liegenschaft);

	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Auftrags-Nummer.
	 * @param auftragsNummer
	 * @return
	 */	
	public List<Auftrag> findByAuftragsNummer(String auftragsNummer);
	
	/**
	 * Liefert eine Auftragsliste anhand der Messung.
	 * @param messung
	 * @return
	 */		
	public List<Auftrag> findByMessung(String messung);

	

	
}
