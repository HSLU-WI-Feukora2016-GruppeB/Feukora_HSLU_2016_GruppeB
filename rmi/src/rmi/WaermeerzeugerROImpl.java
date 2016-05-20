package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entitys.Waermeerzeuger;
import managerInterfaces.WaermeerzeugerManager;
import managerKlassen.WaermeerzeugerManagerImpl;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle WaermeerzeugerRO zur
 * Verf�gung.
 * 
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 *
 */

public class WaermeerzeugerROImpl extends UnicastRemoteObject implements WaermeerzeugerRO {

	private static final long serialVersionUID = 121272375245868132L;
	
	private WaermeerzeugerManager waermeerzeugerManager;
	
	public WaermeerzeugerROImpl() throws RemoteException {
		waermeerzeugerManager = new WaermeerzeugerManagerImpl();
	}

	@Override
	public Waermeerzeuger add(Waermeerzeuger entity) throws Exception {
		return waermeerzeugerManager.add(entity);
	}

	@Override
	public Waermeerzeuger update(Waermeerzeuger entity) throws Exception {
		return waermeerzeugerManager.update(entity);
	}

	@Override
	public void delete(Waermeerzeuger entity) throws Exception {
		waermeerzeugerManager.delete(entity);
		
	}

	@Override
	public void deleteById(Integer idWaermeerzeuger) throws Exception {
		waermeerzeugerManager.deleteById(idWaermeerzeuger);
		
	}

	@Override
	public Waermeerzeuger findById(Integer idWaermeerzeuger) throws Exception {
		return waermeerzeugerManager.findById(idWaermeerzeuger);
	}

	@Override
	public List<Waermeerzeuger> findAllWaermeerzeuger() throws Exception {
		return waermeerzeugerManager.findAll();
	}

	@Override
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp)
			throws Exception {
		return waermeerzeugerManager.findByTyp(waermeerzeugerTyp);
	}

	@Override
	public List<Waermeerzeuger> findByBrennstoff(int brennstoff)
			throws Exception {
		return waermeerzeugerManager.findByBrennstoff(brennstoff);
	}

	@Override
	public List<Waermeerzeuger> findByBaujahr(int baujahr) throws Exception {
		return findByBaujahr(baujahr);
	}

}
