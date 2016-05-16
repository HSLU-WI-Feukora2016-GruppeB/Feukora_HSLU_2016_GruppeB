package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitäten.Kontakt;
import entitäten.Liegenschaft;
import entitäten.Ort;
import gruppeB.feukora.interfaces.LiegenschaftDAO;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * LiegenschaftDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class LiegenschaftDAOImpl implements LiegenschaftDAO{

	@Override
	public void saveLiegenschaft(Liegenschaft entity) throws Exception {
		new GenericPersisterImpl<Liegenschaft>(Liegenschaft.class).save(entity);
	}

	@Override
	public Liegenschaft updateLiegenschaft(Liegenschaft entity) throws Exception {
		return new GenericPersisterImpl<Liegenschaft>(Liegenschaft.class).update(entity);
	}

	@Override
	public void deleteLiegenschaft(Liegenschaft entity) throws Exception {
		new GenericPersisterImpl<Liegenschaft>(Liegenschaft.class).delete(entity);
	}

	@Override
	public Liegenschaft findLiegenschaftById(Integer id) {
		return new GenericPersisterImpl<Liegenschaft>(Liegenschaft.class).findById(id);
	}

	@Override
	public List<Liegenschaft> findAllLiegenschaft() {
		return new GenericPersisterImpl<Liegenschaft>(Liegenschaft.class).findAll();
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByStrasse(String strasse) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Liegenschaft> tQuery = em.createNamedQuery("Liegenschaft.findByStrasse",
				Liegenschaft.class);

		tQuery.setParameter("strasse", strasse);

		List<Liegenschaft> liegenschaftsListe = tQuery.getResultList();

		em.close();

		return liegenschaftsListe != null ? liegenschaftsListe : new ArrayList<Liegenschaft>();
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByKontakt(Kontakt kontakt) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Liegenschaft> tQuery = em.createNamedQuery("Liegenschaft.findByKontakt",
				Liegenschaft.class);

		tQuery.setParameter("kontakt", kontakt);

		List<Liegenschaft> liegenschaftsListe = tQuery.getResultList();

		em.close();

		return liegenschaftsListe != null ? liegenschaftsListe : new ArrayList<Liegenschaft>();
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByOrt(Ort ort) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Liegenschaft> tQuery = em.createNamedQuery("Liegenschaft.findByOrt",
				Liegenschaft.class);

		tQuery.setParameter("ort", ort);

		List<Liegenschaft> liegenschaftsListe = tQuery.getResultList();

		em.close();

		return liegenschaftsListe != null ? liegenschaftsListe : new ArrayList<Liegenschaft>();
	}

	@Override
	public void deleteLiegenschaftById(Integer id) throws Exception {
		new GenericPersisterImpl<Liegenschaft>(Liegenschaft.class).deleteById(id);
	}
}	
	