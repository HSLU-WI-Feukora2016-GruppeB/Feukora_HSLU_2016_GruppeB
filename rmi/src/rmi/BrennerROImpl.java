package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entitys.Brenner;
import managerInterfaces.BrennerManager;
import managerKlassen.BrennerManagerImpl;

public class BrennerROImpl extends UnicastRemoteObject implements BrennerRO{

	private static final long serialVersionUID = 6998134367703280863L;
	
	private BrennerManager brennerManager;
	
	public BrennerROImpl() throws RemoteException {
		brennerManager = new BrennerManagerImpl();
	}

	@Override
	public Brenner add(Brenner entity) throws Exception {
		return brennerManager.add(entity);
	}

	@Override
	public Brenner update(Brenner entity) throws Exception {
		return brennerManager.update(entity);
	}

	@Override
	public void delete(Brenner entity) throws Exception {
		brennerManager.delete(entity);
		
	}

	@Override
	public void deleteById(Integer idBrenner) throws Exception {
		brennerManager.deleteById(idBrenner);
		
	}

	@Override
	public Brenner findById(Integer id) {
		return brennerManager.findById(id);
	}

	@Override
	public List<Brenner> findAll() {
		return brennerManager.findAll();
	}

	@Override
	public List<Brenner> findByTyp(String brennerTyp) {
		return brennerManager.findByTyp(brennerTyp);
	}

	@Override
	public List<Brenner> findByArt(int brennerArt) {
		return brennerManager.findByArt(brennerArt);
	}

	@Override
	public List<Brenner> findByBaujahr(int baujahr) {
		return brennerManager.findByBaujahr(baujahr);
	}
	
	

}
