package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entitäten.Brenner;
import entitäten.Feuerungsanlage;
import entitäten.Liegenschaft;
import entitäten.Waermeerzeuger;
import managerInterfaces.FeuerungsanlageManager;

public class FeuerungsanlageROImpl extends UnicastRemoteObject implements FeuerungsanlageRO {

	private static final long serialVersionUID = 798146631432048248L;

	private FeuerungsanlageManager feuerungsanlageManager;
	
	public FeuerungsanlageROImpl() throws RemoteException {
		feuerungsanlageManager = new FeuerungsanlageManagerImpl();
	}

	@Override
	public Feuerungsanlage add(Feuerungsanlage entity) throws Exception {
		return feuerungsanlageManager.add(entity);
	}

	@Override
	public Feuerungsanlage update(Feuerungsanlage entity) throws Exception {
		return feuerungsanlageManager.update(entity);
	}

	@Override
	public void delete(Feuerungsanlage entity) throws Exception {
		feuerungsanlageManager.delete(entity);
		
	}

	@Override
	public void deleteById(Integer idFeuerungsanlage) throws Exception {
		feuerungsanlageManager.deleteById(idFeuerungsanlage);
		
	}

	@Override
	public Feuerungsanlage findById(Integer idFeuerungsanlage) throws Exception {
		return feuerungsanlageManager.findById(idFeuerungsanlage);
	}

	@Override
	public List<Feuerungsanlage> findAll() {
		return feuerungsanlageManager.findAll();
	}

	@Override
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft) {
		return feuerungsanlageManager.findByLiegenschaft(liegenschaft);
	}

	@Override
	public List<Feuerungsanlage> findByBrenner(Brenner brenner) {
		return feuerungsanlageManager.findByBrenner(brenner);
	}

	@Override
	public List<Feuerungsanlage> findByWaermeerzeuger(
			Waermeerzeuger waermeerzeuger) {
		return feuerungsanlageManager.findByWaermeerzeuger(waermeerzeuger);
	}
}
