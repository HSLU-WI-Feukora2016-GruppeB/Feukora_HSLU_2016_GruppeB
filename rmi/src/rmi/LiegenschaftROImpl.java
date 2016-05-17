package rmi;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;
import managerInterfaces.LiegenschaftManager;
import managerKlassen.LiegenschaftManagerImpl;

public class LiegenschaftROImpl extends UnicastRemoteObject implements LiegenschaftRO{

	private static final long serialVersionUID = 656212455655526403L;
	
	private LiegenschaftManager liegenschaftManager;
	
	public LiegenschaftROImpl() throws Exception {
		liegenschaftManager = new LiegenschaftManagerImpl();
	}

	@Override
	public Liegenschaft add(Liegenschaft entity) throws Exception {
		return liegenschaftManager.add(entity);
	}

	@Override
	public Liegenschaft update(Liegenschaft entity) throws Exception {
		return liegenschaftManager.update(entity);
	}

	@Override
	public void delete(Liegenschaft entity) throws Exception {
		liegenschaftManager.delete(entity);	
	}

	@Override
	public void deleteById(Integer idLiegenschaft) throws Exception {
		liegenschaftManager.deleteById(idLiegenschaft);	
	}

	@Override
	public Liegenschaft findById(Integer idLiegenschaft) throws Exception {
		return liegenschaftManager.findById(idLiegenschaft);
	}

	@Override
	public List<Liegenschaft> findAll() throws Exception {
		return liegenschaftManager.findAll();
	}

	@Override
	public List<Liegenschaft> findByKontakt(Kontakt kontakt) throws Exception {
		return liegenschaftManager.findByKontakt(kontakt);
	}

	@Override
	public List<Liegenschaft> findByOrt(Ort ort) throws Exception {
		return liegenschaftManager.findByOrt(ort);
	}

	@Override
	public List<Liegenschaft> findByStrasse(String strasse) throws Exception {
		return liegenschaftManager.findByStrasse(strasse);
	}
	
	
	

}
