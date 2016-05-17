package rmi;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entitäten.Ort;
import managerInterfaces.OrtManager;

public class OrtROImpl extends UnicastRemoteObject implements OrtRO  {

	private static final long serialVersionUID = 8798146929222063776L;
	
	private OrtManager ortManager;
	
	public OrtROImpl() throws Exception {
		ortManager = new OrtManagerImpl();
	}

	@Override
	public Ort add(Ort entity) throws Exception {
		return ortManager.add(entity);
	}

	@Override
	public Ort update(Ort entity) throws Exception {
		return ortManager.update(entity);
	}

	@Override
	public void delete(Ort entity) throws Exception {
		ortManager.delete(entity);
		
	}

	@Override
	public void deleteById(Integer plz) throws Exception {
		ortManager.deleteById(plz);
	}

	@Override
	public Ort findById(Integer plz) throws Exception {
		return ortManager.findById(plz);
	}

	@Override
	public List<Ort> findByOrtBez(String ortBez) throws Exception {
		return ortManager.findByOrtBez(ortBez);
	}

	@Override
	public List<Ort> findAll() throws Exception {
		return ortManager.findAll();
	}
	
	

}
