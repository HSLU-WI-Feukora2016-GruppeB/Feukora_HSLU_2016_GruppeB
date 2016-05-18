package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;
import managerInterfaces.MitarbeiterManager;
import managerKlassen.MitarbeiterManagerImpl;

public class MitarbeiterROImpl extends UnicastRemoteObject implements MitarbeiterRO {

	
	private static final long serialVersionUID = -9116622738542118483L;
	
	private MitarbeiterManager mitarbeiterManager;
	
	public MitarbeiterROImpl() throws RemoteException {
		mitarbeiterManager = new MitarbeiterManagerImpl();
	}

	@Override
	public Mitarbeiter add(Mitarbeiter entity) throws Exception {
		return mitarbeiterManager.add(entity);
	}

	@Override
	public Mitarbeiter update(Mitarbeiter entity) throws Exception {
		return mitarbeiterManager.update(entity);
	}

	@Override
	public void delete(Mitarbeiter entity) throws Exception {
		mitarbeiterManager.delete(entity);
		
	}

	@Override
	public void deleteById(Integer idMitarbeiter) throws Exception {
		mitarbeiterManager.deleteById(idMitarbeiter);
		
	}

	@Override
	public Mitarbeiter findById(Integer idMitarbeiter) throws Exception {
		return mitarbeiterManager.findById(idMitarbeiter);
	}

	@Override
	public List<Mitarbeiter> findAllMitarbeiter() throws Exception {
		return mitarbeiterManager.findAllMitarbeiter();
	}

	@Override
	public List<Mitarbeiter> findByName(String name) throws Exception {
		return mitarbeiterManager.findByName(name);
	}

	@Override
	public List<Mitarbeiter> findByVorname(String vorname) throws Exception {		
		return mitarbeiterManager.findByVorname(vorname);
	}

	@Override
	public List<Mitarbeiter> findByNameVorname(String name, String vorname)
			throws Exception {
		return mitarbeiterManager.findByNameVorname(name, vorname);
	}

	@Override
	public List<Mitarbeiter> findByRolleIntern(int rolleIntern)
			throws Exception {
		return mitarbeiterManager.findByRolleIntern(rolleIntern);
	}

	@Override
	public List<Mitarbeiter> findByStrasse(String strasse) throws Exception {
		return mitarbeiterManager.findByStrasse(strasse);
	}

	@Override
	public List<Mitarbeiter> findByOrt(Ort ort) throws Exception {
		return mitarbeiterManager.findByOrt(ort);
	}

	@Override
	public List<Mitarbeiter> findByBenutzer(Benutzer user) throws Exception {
		return mitarbeiterManager.findByBenutzer(user);
	}

	@Override
	public List<Mitarbeiter> findByArbeitetSeit(GregorianCalendar arbeitetSeit)
			throws Exception {
		return mitarbeiterManager.findByArbeitetSeit(arbeitetSeit);
	}

	@Override
	public List<Mitarbeiter> findByArbeitetBis(GregorianCalendar arbeitetBis)
			throws Exception {
		return mitarbeiterManager.findByArbeitetBis(arbeitetBis);
	}
	
	

}
