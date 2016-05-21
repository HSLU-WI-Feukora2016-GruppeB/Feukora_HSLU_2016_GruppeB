package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;
import java.util.List;

import entitys.*;
import managerInterfaces.AuftragManager;
import managerKlassen.AuftragManagerImpl;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle AuftragRO zur
 * Verfügung.
 * 
 * @author Matthias Perrollaz
 * @version 1.0
 * @since 1.0
 *
 */

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
	public void delete(Auftrag entity) throws Exception {
		auftragManager.delete(entity);
	}

	@Override
	public List<Auftrag> findAll() throws Exception {
		return auftragManager.findAll();
	}

	@Override
	public void deleteById(Integer auftragsNummer) throws Exception {
		 auftragManager.deleteById(auftragsNummer);
	}

	@Override
	public Auftrag findByAuftragsNummer(Integer auftragsNummer)
			throws Exception {
		return auftragManager.findById(auftragsNummer);
	}

	@Override
	public List<Auftrag> findByDatum(GregorianCalendar datum) throws Exception {
		return auftragManager.findByDatum(datum);
	}

	@Override
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter)
			throws Exception {
		return auftragManager.findByMitarbeiter(mitarbeiter);
	}

	@Override
	public List<Auftrag> findByDateAndMitarbeiter(GregorianCalendar startdatum,
			GregorianCalendar enddatum, Mitarbeiter mitarbeiter)
			throws Exception {
		return auftragManager.findByDateAndMitarbeiter(startdatum, enddatum, mitarbeiter);
	}
	
	@Override
	public Auftrag findByDateAndMitarbeiterAndZeitslot(GregorianCalendar datum,
			Mitarbeiter mitarbeiter, int zeitSlot) throws Exception {
		return auftragManager.findByDateAndMitarbeiterAndZeitslot(datum, mitarbeiter, zeitSlot);
	}

	@Override
	public List<Auftrag> findByKontakt(Kontakt kontakt) throws Exception {
		return auftragManager.findByKontakt(kontakt);
	}

	@Override
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft)
			throws Exception {
		return auftragManager.findByLiegenschaft(liegenschaft);
		
	}
		
	}
