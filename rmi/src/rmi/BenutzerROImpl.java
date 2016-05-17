package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entitys.Benutzer;
import managerInterfaces.BenutzerManager;
import managerKlassen.BenutzerManagerImpl;

public class BenutzerROImpl extends UnicastRemoteObject implements BenutzerRO {

	private static final long serialVersionUID = -1920906288057625340L;
	
	private BenutzerManager benutzerManager;
	
	public BenutzerROImpl() throws RemoteException {
		benutzerManager = new BenutzerManagerImpl();
	}

	@Override
	public Benutzer add(Benutzer entity) throws Exception {
		return benutzerManager.add(entity);
	}

	@Override
	public Benutzer update(Benutzer entity) throws Exception {
		return benutzerManager.update(entity);
	}

	@Override
	public void delete(Benutzer entity) throws Exception {
		benutzerManager.delete(entity);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		benutzerManager.deleteById(id);
		
	}

	@Override
	public Benutzer findById(Integer id) throws Exception {
		return benutzerManager.findById(id);
	}

	@Override
	public List<Benutzer> findAll() throws Exception {
		return benutzerManager.findAll();
	}

	@Override
	public List<Benutzer> findByUsername(String username) throws Exception {
		return benutzerManager.findByUsername(username);
	}

	@Override
	public List<Benutzer> findByUsernamePassword(String username, String password) throws Exception {
		return benutzerManager.findByUsernamePassword(username, password);
	}

	
}
