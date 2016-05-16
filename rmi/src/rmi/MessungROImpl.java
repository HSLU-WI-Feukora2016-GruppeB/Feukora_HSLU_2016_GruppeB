package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;
import java.util.List;

import entit�ten.Messung;
import managerInterfaces.MessungsManager;

public class MessungROImpl extends UnicastRemoteObject implements MessungRO{

	private static final long serialVersionUID = -4170197917321873446L;
	
	private MessungsManager messungsManager;
	
	public MessungROImpl() throws RemoteException {
		messungsManager = new MessungsManagerImpl();
	
	}
	
	@Override
	public Messung add(Messung entity) throws Exception {
		return messungsManager.add(entity);
	}

	@Override
	public Messung update(Messung entity) throws Exception {
		return messungsManager.update(entity);
	}

	@Override
	public void delete(Messung entity) throws Exception {
		messungsManager.delete(entity);
		
	}

	@Override
	public void deleteById(Integer idMessung) throws Exception {
		messungsManager.deleteById(idMessung);
		
	}

	@Override
	public Messung findById(Integer idMessung) throws Exception {
		return messungsManager.findById(idMessung);
		
	}

	@Override
	public List<Messung> findAll() throws Exception {
		return messungsManager.findAll() ;
	}

	@Override
	public List<Messung> findByDatum(GregorianCalendar messDatum)
			throws Exception {
		return messungsManager.findByDatum(messDatum);
	}

	@Override
	public List<Messung> findByBeurteilungNotOk(boolean beurteilungNotOk)
			throws Exception {
		return messungsManager.findByBeurteilungNotOk(beurteilungNotOk);
	}
	

}
