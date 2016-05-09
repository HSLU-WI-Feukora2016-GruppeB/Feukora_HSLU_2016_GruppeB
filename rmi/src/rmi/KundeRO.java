package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

//import modelKlasse Kunde

/**
 * RMI-Interface f�r Handling von Kunde-Entities.
 * 
 * @author Matthias
 * @version 1.0
 * @since 1.0
 * 
 */

public interface KundeRO extends Remote {

	/**
	 * Speichert die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Kunde add(Kunde entity) throws RemoteException, Exception;

	/**
	 * Updatet die �bergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws RemoteException
	 * @throws Exception
	 */
	Kunde update(Kunde entity) throws RemoteException, Exception;

	/**
	 * L�scht die �bergebene Entity.
	 * 
	 * @param entity
	 * @throws RemoteException
	 * @throws Exception
	 */
	void delete(Kunde entity) throws RemoteException, Exception;

	/**
	 * Liefert die Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	Kunde findById(Integer id) throws RemoteException;

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 * 
	 * @return
	 * @throws RemoteException
	 */
	List<Kunde> findAll() throws RemoteException;

	/**
	 * Liefert die Liste mit Kunden f�r die �bergebenen Namen und Vornamen
	 * zur�ck, falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return
	 * @throws RemoteException
	 */
	List<Kunde> findByNameUndVorname(String name, String vorname)
			throws RemoteException;

	/**
	 * Liefert die Liste mit Kunden f�r die �bergebenen Postleitzahl und Ort
	 * zur�ck, falls welche gefunden, sonst eine leere Liste.
	 * 
	 * @param postleitzahl
	 * @param ort
	 * @return
	 * @throws RemoteException
	 */
	List<Kunde> findByPostleitzahlUndOrt(int plz, String ort)
			throws RemoteException;

}

