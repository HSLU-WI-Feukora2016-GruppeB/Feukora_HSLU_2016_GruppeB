/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//import User Modell-Klasse.
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(User entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(User entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserByVorname(String nachname) {
		// TODO Auto-generated method stub
		return null;
	}

}
