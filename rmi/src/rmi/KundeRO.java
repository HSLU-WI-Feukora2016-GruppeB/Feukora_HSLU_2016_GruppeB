package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

//import modelKlasse Kunde

/**
 * RMI-Interface für Handling von Kunde-Entities.
 * 
 * @author Matthias
 * @version 1.0
 * @since 1.0
 * 
 */

public interface KundeRO extends Remote {

	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Kunde add(Kunde entity) throws RemoteException, Exception;

	/**
	 * Updatet die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Kunde update(Kunde entity) throws RemoteException, Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Kunde entity) throws RemoteException, Exception;

	/**
	 * Liefert die Entity für den übergebenen Id-Wert zurück.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	Kunde findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Kunde> findAll() throws RemoteException;

	/**
	 * Liefert die Liste mit Kunden für die übergebenen Namen und Vornamen
	 * zurück, falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 * @throws RemoteException
	 */
	List<Kunde> findByNameUndVorname(String name, String vorname)
			throws RemoteException;

	/**
	 * Liefert die Liste mit Kunden für die übergebenen Postleitzahl und Ort
	 * zurück, falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param postleitzahl
	 * @param ort
	 * @return
	 * @throws RemoteException
	 */
	List<Kunde> findByPostleitzahlUndOrt(int plz, String ort)
			throws RemoteException;

}

