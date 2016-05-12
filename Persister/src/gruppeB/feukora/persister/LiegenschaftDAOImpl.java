/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitäten.Kontakt;
import entitäten.Liegenschaft;

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
	public List<Liegenschaft> findByKontakt(String kontakt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liegenschaft> findByOrt(String ort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liegenschaft> findByStrasse(String strasseInklNr) {
		// TODO Auto-generated method stub
		return null;
	}
}
