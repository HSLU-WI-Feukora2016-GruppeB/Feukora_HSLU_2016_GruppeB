package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entitys.Kontakt;
import entitys.Ort;
import managerInterfaces.KontaktManager;
import managerKlassen.KontaktManagerImpl;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle KontaktRO zur
 * Verfügung.
 * 
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 *
 */

public class KontaktROImpl extends UnicastRemoteObject implements KontaktRO{

	private static final long serialVersionUID = -3510032604171544455L;
	
	private KontaktManager kontaktManager;
	
	public KontaktROImpl() throws RemoteException {
		kontaktManager = new KontaktManagerImpl();
	}

	@Override
	public Kontakt add(Kontakt entity) throws Exception {
		return kontaktManager.add(entity);
	}

	@Override
	public Kontakt update(Kontakt entity) throws Exception {
		return kontaktManager.update(entity);
	}

	@Override
	public void delete(Kontakt entity) throws Exception {
		kontaktManager.delete(entity);
		
	}

	@Override
	public void deleteById(Integer idKontakt) throws Exception {
		kontaktManager.deleteById(idKontakt);
		
	}

	@Override
	public Kontakt findById(Integer id) throws Exception {
		return kontaktManager.findById(id);
	}

	@Override
	public List<Kontakt> findAll() throws Exception {
		return kontaktManager.findAll();
	}

	@Override
	public List<Kontakt> findByName(String name) throws Exception {
		return kontaktManager.findByName(name);
	}

	@Override
	public List<Kontakt> findByVorname(String vorname) throws Exception {
		return kontaktManager.findByVorname(vorname);
	}

	@Override
	public List<Kontakt> findByNameVorname(String name, String vorname)
			throws Exception {
		return kontaktManager.findByNameVorname(name, vorname);
	}

	@Override
	public List<Kontakt> findByOrt(Ort ort) throws Exception {
		return kontaktManager.findByOrt(ort);
	}

	@Override
	public List<Kontakt> findByRolleExtern(int rolleExtern) throws Exception {
		return kontaktManager.findByRolleExtern(rolleExtern);
	}

	@Override
	public List<Kontakt> findByStrasse(String strasse) throws Exception {
		return kontaktManager.findByStrasse(strasse);
	}
	
	

}
