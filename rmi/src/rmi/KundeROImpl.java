package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

//import businesslogic.KundeManager;
//import businesslogic.KundeManagerImpl;
import rmi.KundeRO;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * KundeRO zur Verfügung.
 * 
 * @author Matthias
 * @version 1.0
 * @since 1.0
 * 
 */
public class KundeROImpl extends UnicastRemoteObject implements KundeRO {

	private static final long serialVersionUID = -7028582177505153730L;

	private KundeManager kundeManager;

	public KundeROImpl() throws RemoteException {
		kundeManager = new KundeManagerImpl();
	}

	@Override
	public Kunde add(Kunde entity) throws RemoteException, Exception {
		return kundeManager.add(entity);
	}

	@Override
	public Kunde update(Kunde entity) throws RemoteException, Exception {
		return kundeManager.update(entity);
	}

	@Override
	public void delete(Kunde entity) throws RemoteException, Exception {
		kundeManager.delete(entity);
	}

	@Override
	public Kunde findById(Integer id) throws RemoteException {
		return kundeManager.findById(id);
	}

	@Override
	public List<Kunde> findAll() throws RemoteException {
		return kundeManager.findAll();
	}

	@Override
	public List<Kunde> findByNameUndVorname(String name, String vorname)
			throws RemoteException {
		return kundeManager.findByNameUndVorname(name, vorname);
	}

	@Override
	public List<Kunde> findByPostleitzahlUndOrt(int plz, String ort)
			throws RemoteException {
		return kundeManager.findByPostleitzahlUndOrt(plz, ort);
	}


}
