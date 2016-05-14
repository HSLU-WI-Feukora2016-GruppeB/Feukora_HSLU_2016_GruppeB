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
import entitäten.Ort;
import entitäten.Benutzer;
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
public class MitarbeiterDAOImpl implements MitarbeiterDAO{

	@Override
	public void saveMitarbeiter(Mitarbeiter entity) throws Exception {
		new GenericPersisterImpl<Mitarbeiter>(Mitarbeiter.class).save(entity);
	}

	@Override
	public Mitarbeiter updateMitarbeiter(Mitarbeiter entity) throws Exception {
		return new GenericPersisterImpl<Mitarbeiter>(Mitarbeiter.class).update(entity);
	}

	@Override
	public void deleteMitarbeiter(Mitarbeiter entity) throws Exception {
		new GenericPersisterImpl<Mitarbeiter>(Mitarbeiter.class).delete(entity);
	}

	@Override
	public void deleteMitarbeiterById(Integer id) throws Exception {
		new GenericPersisterImpl<Mitarbeiter>(Mitarbeiter.class).deleteById(id);
	}

	@Override
	public Mitarbeiter findMitarbeiterById(Integer id) {
		return new GenericPersisterImpl<Mitarbeiter>(Mitarbeiter.class).findById(id);
	}

	@Override
	public List<Mitarbeiter> findAllMitarbeiter() {
		return new GenericPersisterImpl<Mitarbeiter>(Mitarbeiter.class).findAll();
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByName(String name) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mitarbeiter> tQuery = em.createNamedQuery("Mitarbeiter.findByName",
				Mitarbeiter.class);

		tQuery.setParameter("name", name);

		List<Mitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<Mitarbeiter>();
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByNameVorname(String name,
			String vorname) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mitarbeiter> tQuery = em.createNamedQuery(
				"Mitarbeiter.findByNameUndVorname", Mitarbeiter.class);

		tQuery.setParameter("name", name);
		tQuery.setParameter("vorname", vorname);

		List<Mitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<Mitarbeiter>();
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mitarbeiter> tQuery = em.createNamedQuery("Mitarbeiter.findByVorname",
				Mitarbeiter.class);

		tQuery.setParameter("vorname", vorname);

		List<Mitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<Mitarbeiter>();
	}

	@Override
	public List<Mitarbeiter> findByRolleIntern(int rolleIntern) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mitarbeiter> tQuery = em.createNamedQuery("Mitarbeiter.findByRolleIntern",
				Mitarbeiter.class);

		tQuery.setParameter("rolleIntern", rolleIntern);

		List<Mitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<Mitarbeiter>();
	}

	@Override
	public List<Mitarbeiter> findByStrasse(String strasse) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mitarbeiter> tQuery = em.createNamedQuery("Mitarbeiter.findByStrasse",
				Mitarbeiter.class);

		tQuery.setParameter("strasse", strasse);

		List<Mitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<Mitarbeiter>();
	}

	@Override
	public List<Mitarbeiter> findByOrt(Ort ort) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mitarbeiter> tQuery = em.createNamedQuery("Mitarbeiter.findByOrt",
				Mitarbeiter.class);

		tQuery.setParameter("ort", ort);

		List<Mitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<Mitarbeiter>();
	}

	@Override
	public List<Mitarbeiter> findByBenutzer(Benutzer user) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mitarbeiter> tQuery = em.createNamedQuery("Mitarbeiter.findByUser",
				Mitarbeiter.class);

		tQuery.setParameter("user", user);

		List<Mitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<Mitarbeiter>();
	}

	@Override
	public List<Mitarbeiter> findByArbeitetSeit(GregorianCalendar arbeitetSeit) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mitarbeiter> tQuery = em.createNamedQuery("Mitarbeiter.findByArbeitetSeit",
				Mitarbeiter.class);

		tQuery.setParameter("arbeitetSeit", arbeitetSeit);

		List<Mitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<Mitarbeiter>();
	}

	@Override
	public List<Mitarbeiter> findByArbeitetBis(GregorianCalendar arbeitetBis) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Mitarbeiter> tQuery = em.createNamedQuery("Mitarbeiter.findByArbeitetBis",
				Mitarbeiter.class);

		tQuery.setParameter("arbeitetBis", arbeitetBis);

		List<Mitarbeiter> mitarbeiterListe = tQuery.getResultList();

		em.close();

		return mitarbeiterListe != null ? mitarbeiterListe : new ArrayList<Mitarbeiter>();
	}
}
