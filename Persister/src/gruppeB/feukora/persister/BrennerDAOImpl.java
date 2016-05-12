/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitäten.Brenner;
import entitäten.Mitarbeiter;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * BrennerDAO zur Verfügung.
 * 
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
	public Brenner findBrennerById(Integer id) {
		return new GenericPersisterImpl<Brenner>(Brenner.class).findById(id);
	}

	@Override
	public List<Brenner> findAllBrenner() {
		return new GenericPersisterImpl<Brenner>(Brenner.class).findAll();
	}

	@Override
	public List<Brenner> findBrennerByBaujahr(Integer baujahr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brenner> findBrennerByBrennart(String brennart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brenner> findBrennerByBrennertyp(String brennerTyp) {
		// TODO Auto-generated method stub
		return null;
	}

}
