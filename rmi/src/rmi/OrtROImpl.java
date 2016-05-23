package rmi;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import rmi.interfaces.OrtRO;
import entitys.Ort;
import managerInterfaces.OrtManager;
import managerKlassen.OrtManagerImpl;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle OrtRO zur
 * Verfügung.
 * 
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 *
 */

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
	public Ort findById(Integer idOrt) throws Exception {
		return ortManager.findById(idOrt);
	}

	@Override
	public List<Ort> findByOrtBez(String ortBez) throws Exception {
		return ortManager.findByOrtBez(ortBez);
	}

	@Override
	public List<Ort> findAll() throws Exception {
		return ortManager.findAll();
	}

	@Override
	public List<Ort> findByOrtPlz(int plz) throws Exception {
		return ortManager.findByPlz(plz);
	}
	
	

}
