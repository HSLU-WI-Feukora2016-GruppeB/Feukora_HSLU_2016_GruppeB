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

import entitäten.Auftrag;
import entitäten.Kontakt;
import entitäten.Liegenschaft;
import entitäten.Mitarbeiter;
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
		new GenericPersisterImpl<Auftrag>(Auftrag.class).save(entity);
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
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery("Auftrag.findByMitarbeiter",
				Auftrag.class);

		tQuery.setParameter("mitarbeiter", mitarbeiter);

		List<Auftrag> auftragsListe = tQuery.getResultList();

		em.close();

		return auftragsListe != null ? auftragsListe : new ArrayList<Auftrag>();
	}

	@Override
	public List<Auftrag> findByDatum(GregorianCalendar datum) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery("Auftrag.findByDatum",
				Auftrag.class);

		tQuery.setParameter("datum", datum);

		List<Auftrag> auftragsListe = tQuery.getResultList();

		em.close();

		return auftragsListe != null ? auftragsListe : new ArrayList<Auftrag>();
	}

	@Override
	public List<Auftrag> findByKontakt(Kontakt kontakt) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery("Auftrag.findByKontakt",
				Auftrag.class);

		tQuery.setParameter("kontakt", kontakt);

		List<Auftrag> auftragsListe = tQuery.getResultList();

		em.close();

		return auftragsListe != null ? auftragsListe : new ArrayList<Auftrag>();
	}

	@Override
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery("Auftrag.findByLiegenschaft",
				Auftrag.class);

		tQuery.setParameter("liegenschaft", liegenschaft);

		List<Auftrag> auftragsListe = tQuery.getResultList();

		em.close();

		return auftragsListe != null ? auftragsListe : new ArrayList<Auftrag>();
	}

	@Override
	public List<Auftrag> findByAuftragsNummer(Integer auftragsNummer) {
		// TODO Auto-generated method stub
		return null;
	}

}
