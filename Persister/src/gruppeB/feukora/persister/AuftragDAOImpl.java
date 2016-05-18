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

import entitys.Auftrag;
import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Mitarbeiter;
import gruppeB.feukora.interfaces.AuftragDAO;
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
public class AuftragDAOImpl implements AuftragDAO {

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
	public void deleteAuftragById(Integer idAuftrag) throws Exception {
		new GenericPersisterImpl<Auftrag>(Auftrag.class).deleteById(idAuftrag);
	}

	@Override
	public Auftrag findAuftragById(Integer idAuftrag) throws Exception {
		return new GenericPersisterImpl<Auftrag>(Auftrag.class)
				.findById(idAuftrag);
	}

	@Override
	public List<Auftrag> findAllAuftrag() {
		return new GenericPersisterImpl<Auftrag>(Auftrag.class).findAll();
	}

	@Override
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter) throws Exception {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery(
				"Auftrag.findByMitarbeiter", Auftrag.class);

		tQuery.setParameter("mitarbeiter", mitarbeiter);

		List<Auftrag> auftragsListe = tQuery.getResultList();

		em.close();

		return auftragsListe != null ? auftragsListe : new ArrayList<Auftrag>();
	}

	@Override
	public List<Auftrag> findByDatum(GregorianCalendar datum) throws Exception {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery("Auftrag.findByDatum",
				Auftrag.class);

		tQuery.setParameter("datum", datum);

		List<Auftrag> auftragsListe = tQuery.getResultList();

		em.close();

		return auftragsListe != null ? auftragsListe : new ArrayList<Auftrag>();
	}

	@Override
	public List<Auftrag> findByKontakt(Kontakt kontakt)  throws Exception{

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery(
				"Auftrag.findByKontakt", Auftrag.class);

		tQuery.setParameter("kontakt", kontakt);

		List<Auftrag> auftragsListe = tQuery.getResultList();

		em.close();

		return auftragsListe != null ? auftragsListe : new ArrayList<Auftrag>();
	}

	@Override
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft)  throws Exception{

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery(
				"Auftrag.findByLiegenschaft", Auftrag.class);

		tQuery.setParameter("liegenschaft", liegenschaft);

		List<Auftrag> auftragsListe = tQuery.getResultList();

		em.close();

		return auftragsListe != null ? auftragsListe : new ArrayList<Auftrag>();
	}

	@Override
	public List<Auftrag> findByDatumAndMitarbeiter(
			GregorianCalendar startdatum, GregorianCalendar enddatum,
			Mitarbeiter mitarbeiter)  throws Exception{

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery(
				"Auftrag.findByDatumAndMitarbeiter", Auftrag.class);

		tQuery.setParameter("startdatum", startdatum.getTime());
		tQuery.setParameter("enddatum", enddatum.getTime());
		tQuery.setParameter("mitarbeiter", mitarbeiter);

		List<Auftrag> auftragsListe = tQuery.getResultList();

		em.close();

		return auftragsListe != null ? auftragsListe : new ArrayList<Auftrag>();
	}

	@Override
	public Auftrag findAuftragByDateAndMitarbeiterAndZeitslot(
			GregorianCalendar datum, Mitarbeiter mitarbeiter, int zeitSlot)  throws Exception{

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Auftrag> tQuery = em.createNamedQuery(
				"Auftrag.findAuftragByDateAndMitarbeiterAndZeitslot", Auftrag.class);

		tQuery.setParameter("datum", datum);
		tQuery.setParameter("mitarbeiter", mitarbeiter);
		tQuery.setParameter("zeitSlot", zeitSlot);

		Auftrag auftrag = tQuery.getSingleResult();
		
		em.close();
		
		if(auftrag==null){
			return null;
		} else {
			return auftrag;
		}
	}

}
