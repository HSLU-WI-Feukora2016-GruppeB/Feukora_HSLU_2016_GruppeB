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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Auftrag updateAuftrag(Auftrag entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAuftrag(Auftrag entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAuftragById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Auftrag findAuftragById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findAllAuftrag() {
		// TODO Auto-generated method stub
		return null;
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
