package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Liegenschaft;
import entitys.Waermeerzeuger;
import gruppeB.feukora.interfaces.FeuerungsanlageDAO;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * FeuerungsanlageDAO zur Verfügung.
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class FeuerungsanlageDAOImpl implements FeuerungsanlageDAO{

	@Override
	public void saveFeuerungsanlage(Feuerungsanlage entity) throws Exception {
		new GenericPersisterImpl<Feuerungsanlage>(Feuerungsanlage.class).save(entity);
	}

	@Override
	public Feuerungsanlage updateFeuerungsanlage(Feuerungsanlage entity) throws Exception {
		return new GenericPersisterImpl<Feuerungsanlage>(Feuerungsanlage.class).update(entity);
	}

	@Override
	public void deleteFeuerungsanlage(Feuerungsanlage entity) throws Exception {
		new GenericPersisterImpl<Feuerungsanlage>(Feuerungsanlage.class).delete(entity);
	}

	@Override
	public Feuerungsanlage findFeuerungsanlageById(Integer id) throws Exception{
		return new GenericPersisterImpl<Feuerungsanlage>(Feuerungsanlage.class).findById(id);
	}

	@Override
	public List<Feuerungsanlage> findAllFeuerungsanlage() throws Exception{
		return new GenericPersisterImpl<Feuerungsanlage>(Feuerungsanlage.class).findAll();
	}

	@Override
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Feuerungsanlage> tQuery = em.createNamedQuery("Feuerungsanlage.findByLiegenschaft",
				Feuerungsanlage.class);

		tQuery.setParameter("liegenschaft", liegenschaft);

		List<Feuerungsanlage> feuerungsanlageListe = tQuery.getResultList();

		em.close();

		return feuerungsanlageListe != null ? feuerungsanlageListe : new ArrayList<Feuerungsanlage>();
	}

	@Override
	public List<Feuerungsanlage> findByBrenner(Brenner brenner) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Feuerungsanlage> tQuery = em.createNamedQuery("Feuerungsanlage.findByBrenner",
				Feuerungsanlage.class);

		tQuery.setParameter("brenner", brenner);

		List<Feuerungsanlage> feuerungsanlageListe = tQuery.getResultList();

		em.close();

		return feuerungsanlageListe != null ? feuerungsanlageListe : new ArrayList<Feuerungsanlage>();
	}

	@Override
	public List<Feuerungsanlage> findByWaermeerzeuger(Waermeerzeuger waermeerzeuger) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Feuerungsanlage> tQuery = em.createNamedQuery("Feuerungsanlage.findByWaermeerzeuger",
				Feuerungsanlage.class);

		tQuery.setParameter("waermeerzeuger", waermeerzeuger);

		List<Feuerungsanlage> feuerungsanlageListe = tQuery.getResultList();

		em.close();

		return feuerungsanlageListe != null ? feuerungsanlageListe : new ArrayList<Feuerungsanlage>();
	}

	@Override
	public void deleteFeuerungsanlageById(Integer id) throws Exception {
		new GenericPersisterImpl<Feuerungsanlage>(Feuerungsanlage.class).deleteById(id);
	}
	
}
