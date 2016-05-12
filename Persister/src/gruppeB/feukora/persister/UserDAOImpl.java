/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitäten.Mitarbeiter;
import entitäten.User;
import entitäten.Waermeerzeuger;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * UserDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class UserDAOImpl implements UserDAO{

	@Override
	public void saveUser(User entity) throws Exception {
		new GenericPersisterImpl<User>(User.class).save(entity);
	}

	@Override
	public User updateUser(User entity) throws Exception {
		return new GenericPersisterImpl<User>(User.class).update(entity);
	}

	@Override
	public void deleteUser(User entity) throws Exception {
		new GenericPersisterImpl<User>(User.class).delete(entity);
	}

	@Override
	public void deleteUserById(Integer id) throws Exception {
		new GenericPersisterImpl<User>(User.class).deleteById(id);
	}

	@Override
	public User findUserById(Integer id) {
		return new GenericPersisterImpl<User>(User.class).findById(id);
	}

	@Override
	public List<User> findAllUser() {
		return new GenericPersisterImpl<User>(User.class).findAll();
	}

	@Override
	public List<User> findUserByName(String name) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<User> tQuery = em.createNamedQuery("Mitarbeiter.findByName",
				User.class);

		tQuery.setParameter("name", name);

		List<User> userListe = tQuery.getResultList();

		em.close();

		return userListe != null ? userListe : new ArrayList<User>();
	}

	@Override
	public List<User> findUserByVorname(String vorname) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
