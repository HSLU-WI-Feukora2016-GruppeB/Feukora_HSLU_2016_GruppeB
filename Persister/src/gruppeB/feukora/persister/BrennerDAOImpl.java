/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//import Brenner Modell-Klasse.
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Brenner updateBrenner(Brenner entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBrenner(Brenner entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBrennerById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Brenner findBrennerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brenner> findAllBrenner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brenner> findBrennerByBezeichnung(String bezeichnung) {
		// TODO Auto-generated method stub
		return null;
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

}
