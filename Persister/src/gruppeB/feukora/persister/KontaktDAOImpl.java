/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//import Kontakt Modell-Klasse.
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * KontaktDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class KontaktDAOImpl implements KontaktDAO{

	@Override
	public void saveKontakt(Kontakt entity) throws Exception {
		new GenericPersisterImpl<Kontakt>(Kontakt.class).save(entity);
	}

	@Override
	public Kontakt updateKontakt(Kontakt entity) throws Exception {
		return new GenericPersisterImpl<Kontakt>(Kontakt.class).update(entity);
	}

	@Override
	public void deleteKontakt(Kontakt entity) throws Exception {
		new GenericPersisterImpl<Kontakt>(Kontakt.class).delete(entity);
	}

	@Override
	public void deleteKontaktById(Integer id) throws Exception {
		new GenericPersisterImpl<Kontakt>(Kontakt.class).deleteById(id);
	}

	@Override
	public Kontakt findKontaktById(Integer id) {
		return new GenericPersisterImpl<Kontakt>(Kontakt.class).findById(id);
	}

	@Override
	public List<Kontakt> findAllKontakte() {
		return new GenericPersisterImpl<Kontakt>(Kontakt.class).findAll();
	}

	@Override
	public List<Kontakt> findKontaktByName(String name) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Kontakt> tQuery = em.createNamedQuery("Kontakt.findByName",
				Kontakt.class);

		tQuery.setParameter("name", name);

		List<Kontakt> kontaktListe = tQuery.getResultList();

		em.close();

		return kontaktListe != null ? kontaktListe : new ArrayList<Kontakt>();
	}

	@Override
	public List<Kontakt> findKontaktByNameUndVorname(String name, String vorname) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Kontakt> tQuery = em.createNamedQuery(
				"Kontakt.findByNameUndVorname", Kontakt.class);

		tQuery.setParameter("name", name);
		tQuery.setParameter("vorname", vorname);

		List<Kontakt> kontaktListe = tQuery.getResultList();

		em.close();

		return kontaktListe != null ? kontaktListe : new ArrayList<Kontakt>();
	}

	@Override
	public List<Kontakt> findKontaktByVorname(String vorname) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Kontakt> tQuery = em.createNamedQuery("Kontakt.findByVorname",
				Kontakt.class);

		tQuery.setParameter("vorname", vorname);

		List<Kontakt> kontaktListe = tQuery.getResultList();

		em.close();

		return kontaktListe != null ? kontaktListe : new ArrayList<Kontakt>();
	}

}
