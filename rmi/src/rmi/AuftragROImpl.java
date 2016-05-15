package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class AuftragROImpl extends UnicastRemoteObject implements AuftragRO {

	private static final long serialVersionUID = 4989622193039156812L;
	
	private AuftragManager auftragManager;
	
	public AuftragROImpl() throws RemoteException {
		auftragManager = new AuftragManagerImpl();
	}

	@Override
	public Auftrag add(Auftrag entity) throws Exception {
		return auftragManager.add(entity);
	}

	@Override
	public Auftrag update(Auftrag entity) throws Exception {
		return auftragManager.update(entity);
	}

	@Override
	public Auftrag delete(Auftrag entity) throws Exception {
		return auftragManager.delete(entity);
	}

	@Override
	public List<Auftrag> findAll() throws Exception {
		return auftragManager.findAll();
	}}
