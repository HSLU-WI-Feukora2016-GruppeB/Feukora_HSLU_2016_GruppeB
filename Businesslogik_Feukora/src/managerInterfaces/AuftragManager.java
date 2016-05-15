package managerInterfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entit�ten.Auftrag;
import entit�ten.Kontakt;
import entit�ten.Liegenschaft;
import entit�ten.Mitarbeiter;

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
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Auftrag add(Auftrag entity) throws Exception;
	
	/**
	 * Passt den �bergebenen Auftrag an.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Auftrag update(Auftrag entity) throws Exception;
	
	/**
	 * L�scht den �bergebenen Auftrag.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public void delete(Auftrag entity) throws Exception;
	
	/**
	 * L�scht den �bergebenen Auftrag mithilfe der auftragsnummer.
	 * @param auftragsNummer
	 * @return
	 * @throws Exception
	 */
	public void deleteById(Integer auftragsNummer) throws Exception;

	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Auftrags-Nummer.
	 * @param auftragsNummer
	 * @return
	 */	
	public Auftrag findByAuftragsNummer(Integer auftragsNummer);
	
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
	public List<Auftrag> findByDatum(GregorianCalendar datum);
	
	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter.
	 * @param mitarbeiter
	 * @return
	 */
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter);
	
	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Mitarbeiter 
	 * f�r eine bestimmte Arbeitswoche.
	 * @param startdatum
	 * @param enddatum
	 * @param mitarbeiter
	 * @return
	 */
	public List<Auftrag> findByDateAndMitarbeiter(GregorianCalendar startdatum, GregorianCalendar enddatum,
			Mitarbeiter mitarbeiter);
	
	/**
	 * Liefert eine Auftragsliste anhand des gesuchten Kontakts.
	 * @param kontakt
	 * @return
	 */
	public List<Auftrag> findByKontakt(Kontakt kontakt);
	
	/**
	 * Liefert eine Auftragsliste anhand der gesuchten Liegenschaften.
	 * @param liegenschaftOrt
	 * @return
	 */
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft);

	


	

	
}
