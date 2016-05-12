/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitäten.Mitarbeiter;
import entitäten.Auftrag;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MitarbeiterDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class AuftragDAOImpl implements AuftragDAO{

	@Override
	public void saveAuftrag(Auftrag entity) throws Exception {
		new GenericPersisterImpl<Mitarbeiter>(Mitarbeiter.class).save(entity);
	}

	@Override
	public Auftrag updateAuftrag(Auftrag entity) throws Exception {
		return new GenericPersisterImpl<Auftrag>(Auftrag.class).update(entity);
	}

	@Override
	public void deleteAuftrag(Auftrag entity) throws Exception {
		new GenericPersisterImpl<Auftrag>(Auftrag.class).delete(entity);
	}

	@Override
	public void deleteAuftragById(Integer id) throws Exception {
		new GenericPersisterImpl<Auftrag>(Auftrag.class).deleteById(id);
	}

	@Override
	public Auftrag findAuftragById(Integer id) {
		return new GenericPersisterImpl<Auftrag>(Auftrag.class).findById(id);
	}

	@Override
	public List<Auftrag> findAllAuftrag() {
		return new GenericPersisterImpl<Auftrag>(Auftrag.class).findAll();
	}

	@Override
	public List<Auftrag> findByMitarbeiter(String mitarbeiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByDatum(GregorianCalendar datum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByKontakt(String kontakt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByLiegenschaft(String liegenschaft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByAuftragsNummer(int auftragsNummer) {
		// TODO Auto-generated method stub
		return null;
	}

}
