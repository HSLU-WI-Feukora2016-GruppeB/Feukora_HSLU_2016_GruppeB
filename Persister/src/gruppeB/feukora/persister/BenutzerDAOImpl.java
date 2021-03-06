package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitys.Benutzer;
import gruppeB.feukora.interfaces.BenutzerDAO;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * BenutzerDAO zur Verf�gung.
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class BenutzerDAOImpl implements BenutzerDAO{
	
	@Override
	public void saveBenutzer(Benutzer entity) throws Exception {
		new GenericPersisterImpl<Benutzer>(Benutzer.class).save(entity);
	}

	@Override
	public Benutzer updateBenutzer(Benutzer entity) throws Exception {
		return new GenericPersisterImpl<Benutzer>(Benutzer.class).update(entity);
	}

	@Override
	public void deleteBenutzer(Benutzer entity) throws Exception {
		new GenericPersisterImpl<Benutzer>(Benutzer.class).delete(entity);
	}

	@Override
	public void deleteBenutzerById(Integer id) throws Exception {
		new GenericPersisterImpl<Benutzer>(Benutzer.class).deleteById(id);
	}

	@Override
	public Benutzer findBenutzerById(Integer id) throws Exception{
		return new GenericPersisterImpl<Benutzer>(Benutzer.class).findById(id);
	}

	@Override
	public List<Benutzer> findAllBenutzer() throws Exception{
		return new GenericPersisterImpl<Benutzer>(Benutzer.class).findAll();
	}

	@Override
	public List<Benutzer> findBenutzerByUsernamePassword(String username, String password) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Benutzer> tQuery = em.createNamedQuery("Benutzer.findByUsernamePassword",
				Benutzer.class);

		tQuery.setParameter("username", username);
		tQuery.setParameter("password", password);

		List<Benutzer> userListe = tQuery.getResultList();

		em.close();

		return userListe != null ? userListe : new ArrayList<Benutzer>();
	}

	@Override
	public List<Benutzer> findBenutzerByUsername(String username) throws Exception{
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Benutzer> tQuery = em.createNamedQuery("Benutzer.findByUsername",
				Benutzer.class);

		tQuery.setParameter("username", username);

		List<Benutzer> userListe = tQuery.getResultList();

		em.close();

		return userListe != null ? userListe : new ArrayList<Benutzer>();
	}
	
}