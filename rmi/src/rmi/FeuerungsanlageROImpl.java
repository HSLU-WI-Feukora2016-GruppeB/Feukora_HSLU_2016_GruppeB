package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Liegenschaft;
import entitys.Waermeerzeuger;
import managerInterfaces.FeuerungsanlageManager;
import managerKlassen.FeuerungsanlageManagerImpl;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle FeuerungsanlageRO zur
 * Verfügung.
 * 
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */

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
	public List<Feuerungsanlage> findAll() throws Exception {
		return feuerungsanlageManager.findAll();
	}

	@Override
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft) throws Exception {
		return feuerungsanlageManager.findByLiegenschaft(liegenschaft);
	}

	@Override
	public List<Feuerungsanlage> findByBrenner(Brenner brenner) throws Exception {
		return feuerungsanlageManager.findByBrenner(brenner);
	}

	@Override
	public List<Feuerungsanlage> findByWaermeerzeuger(
			Waermeerzeuger waermeerzeuger) throws Exception {
		return feuerungsanlageManager.findByWaermeerzeuger(waermeerzeuger);
	}
}
