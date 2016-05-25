package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitys.Ort;
import gruppeB.feukora.interfaces.OrtDAO;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle OrtDAO
 * zur Verfügung.
 * 
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class OrtDAOImpl implements OrtDAO {

	@Override
	public void saveOrt(Ort entity) throws Exception {
		new GenericPersisterImpl<Ort>(Ort.class).save(entity);
	}

	@Override
	public Ort updateOrt(Ort entity) throws Exception {
		return new GenericPersisterImpl<Ort>(Ort.class).update(entity);
	}

	@Override
	public void deleteOrt(Ort entity) throws Exception {
		new GenericPersisterImpl<Ort>(Ort.class).delete(entity);
	}

	@Override
	public void deleteOrtById(Integer idOrt) throws Exception {
		new GenericPersisterImpl<Ort>(Ort.class).deleteById(idOrt);
	}

	@Override
	public Ort findOrtById(Integer idOrt) throws Exception {
		return new GenericPersisterImpl<Ort>(Ort.class).findById(idOrt);
	}

	@Override
	public List<Ort> findAllOrt() throws Exception {
		return new GenericPersisterImpl<Ort>(Ort.class).findAll();
	}

	@Override
	public List<Ort> findOrtByBezeichnung(String ortBez) throws Exception {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Ort> tQuery = em.createNamedQuery("Ort.findByOrtBez",
				Ort.class);

		tQuery.setParameter("ortBez", ortBez);

		List<Ort> ortsListe = tQuery.getResultList();

		em.close();

		return ortsListe != null ? ortsListe : new ArrayList<Ort>();

	}

	@Override
	public List<Ort> findOrtByPlz(Integer plz) throws Exception {

		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Ort> tQuery = em
				.createNamedQuery("Ort.findByPlz", Ort.class);

		tQuery.setParameter("plz", plz);

		List<Ort> ortsListe = tQuery.getResultList();

		em.close();

		return ortsListe != null ? ortsListe : new ArrayList<Ort>();

	}

}
