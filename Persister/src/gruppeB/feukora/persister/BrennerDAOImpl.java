package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitys.Brenner;
import gruppeB.feukora.interfaces.BrennerDAO;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * BrennerDAO zur Verfügung.
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class BrennerDAOImpl implements BrennerDAO{

	@Override
	public void saveBrenner(Brenner entity) throws Exception {
		new GenericPersisterImpl<Brenner>(Brenner.class).save(entity);
	}

	@Override
	public Brenner updateBrenner(Brenner entity) throws Exception {
		return new GenericPersisterImpl<Brenner>(Brenner.class).update(entity);
	}

	@Override
	public void deleteBrenner(Brenner entity) throws Exception {
		new GenericPersisterImpl<Brenner>(Brenner.class).delete(entity);
	}

	@Override
	public void deleteBrennerById(Integer id) throws Exception {
		new GenericPersisterImpl<Brenner>(Brenner.class).deleteById(id);
	}

	@Override
	public Brenner findBrennerById(Integer id) throws Exception{
		return new GenericPersisterImpl<Brenner>(Brenner.class).findById(id);
	}

	@Override
	public List<Brenner> findAllBrenner() throws Exception{
		return new GenericPersisterImpl<Brenner>(Brenner.class).findAll();
	}

	@Override
	public List<Brenner> findBrennerByBaujahr(int baujahr) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Brenner> tQuery = em.createNamedQuery("Brenner.findByBaujahr",
				Brenner.class);

		tQuery.setParameter("baujahr", baujahr);

		List<Brenner> brennerListe = tQuery.getResultList();

		em.close();

		return brennerListe != null ? brennerListe : new ArrayList<Brenner>();
	}

	@Override
	public List<Brenner> findBrennerByBrennerart(int brennerArt) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Brenner> tQuery = em.createNamedQuery("Brenner.findByArt",
				Brenner.class);

		tQuery.setParameter("brennerArt", brennerArt);

		List<Brenner> brennerListe = tQuery.getResultList();

		em.close();

		return brennerListe != null ? brennerListe : new ArrayList<Brenner>();
	}

	@Override
	public List<Brenner> findBrennerByBrennertyp(String brennerTyp) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Brenner> tQuery = em.createNamedQuery("Brenner.findByTyp",
				Brenner.class);

		tQuery.setParameter("brennerTyp", brennerTyp);

		List<Brenner> brennerListe = tQuery.getResultList();

		em.close();

		return brennerListe != null ? brennerListe : new ArrayList<Brenner>();
	}
}
