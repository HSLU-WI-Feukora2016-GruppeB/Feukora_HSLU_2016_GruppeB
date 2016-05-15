package rmi;

import java.util.List;

import managerKlassen.Auftrag;

/**
 * Das Interface stellt die CRUD-Funktionen f�r den Auftrag zur Verf�gung.
 * 
 * @author Berri
 * @version 1.0
 * @since 1.0
 */

public interface AuftragRO {
	
	/** 
	 * Speichert die Aenderung.
	 * @param entity
	 * @throws Exception
	 */
	public Auftrag add(Auftrag entity) throws Exception;
	
	/**
	 * Updatet die Aenderung.
	 * @param entity
	 * @throws Exception
	 */
	public Auftrag update(Auftrag entity) throws Exception;
	
	/**
	 * L�scht die Aenderung.
	 * @param entity
	 * @throws Exception
	 */
	public Auftrag delete(Auftrag entity) throws Exception;
	
	/**
	 * Fuegt alle Aenderungen in eine Liste ein.
	 * @return
	 * @throws Exception
	 */
	public List<Auftrag> findAll() throws Exception;
	
}
