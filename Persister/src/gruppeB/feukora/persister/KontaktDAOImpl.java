package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitys.Kontakt;
import entitys.Ort;
import gruppeB.feukora.interfaces.KontaktDAO;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * KontaktDAO zur Verf�gung.
 * @since 1.0
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
	public void deleteKontaktById(Integer idKontakt) throws Exception {
		new GenericPersisterImpl<Kontakt>(Kontakt.class).deleteById(idKontakt);
	}

	@Override
	public Kontakt findKontaktById(Integer idKontakt) throws Exception{
		return new GenericPersisterImpl<Kontakt>(Kontakt.class).findById(idKontakt);
	}

	@Override
	public List<Kontakt> findAllKontakte() throws Exception{
		return new GenericPersisterImpl<Kontakt>(Kontakt.class).findAll();
	}

	@Override
	public List<Kontakt> findKontaktByName(String name) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Kontakt> tQuery = em.createNamedQuery("Kontakt.findByName",
				Kontakt.class);

		tQuery.setParameter("name", name);

		List<Kontakt> kontaktListe = tQuery.getResultList();

		em.close();

		return kontaktListe != null ? kontaktListe : new ArrayList<Kontakt>();
	}

	@Override
	public List<Kontakt> findKontaktByNameVorname(String name, String vorname) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Kontakt> tQuery = em.createNamedQuery(
				"Kontakt.findByNameVorname", Kontakt.class);

		tQuery.setParameter("name", name);
		tQuery.setParameter("vorname", vorname);

		List<Kontakt> kontaktListe = tQuery.getResultList();

		em.close();

		return kontaktListe != null ? kontaktListe : new ArrayList<Kontakt>();
	}

	@Override
	public List<Kontakt> findKontaktByVorname(String vorname) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Kontakt> tQuery = em.createNamedQuery("Kontakt.findByVorname",
				Kontakt.class);

		tQuery.setParameter("vorname", vorname);

		List<Kontakt> kontaktListe = tQuery.getResultList();

		em.close();

		return kontaktListe != null ? kontaktListe : new ArrayList<Kontakt>();
	}

	@Override
	public List<Kontakt> findKontaktByOrt(Ort ort) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Kontakt> tQuery = em.createNamedQuery("Kontakt.findByOrt",
				Kontakt.class);

		tQuery.setParameter("ort", ort);

		List<Kontakt> kontaktListe = tQuery.getResultList();

		em.close();

		return kontaktListe != null ? kontaktListe : new ArrayList<Kontakt>();
	}

	@Override
	public List<Kontakt> findKontaktByRolleExtern(int rolleExtern) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Kontakt> tQuery = em.createNamedQuery("Kontakt.findByRolleExtern",
				Kontakt.class);

		tQuery.setParameter("rolleExtern", rolleExtern);

		List<Kontakt> kontaktListe = tQuery.getResultList();

		em.close();

		return kontaktListe != null ? kontaktListe : new ArrayList<Kontakt>();
	}

	@Override
	public List<Kontakt> findKontaktByStrasse(String strasse) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Kontakt> tQuery = em.createNamedQuery("Kontakt.findByStrasse",
				Kontakt.class);

		tQuery.setParameter("strasse", strasse);

		List<Kontakt> kontaktListe = tQuery.getResultList();

		em.close();

		return kontaktListe != null ? kontaktListe : new ArrayList<Kontakt>();
	}

}
