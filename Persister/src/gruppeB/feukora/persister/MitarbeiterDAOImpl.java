/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


//import Mitarbeiter Modell-Klasse.
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MitarbeiterDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class MitarbeiterDAOImpl implements MitarbeiterDAO{

	@Override
	public void saveMitarbeiter(Mitarbeiter entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mitarbeiter updateMitarbeiter(Mitarbeiter entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMitarbeiter(Mitarbeiter entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMitarbeiterById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mitarbeiter findMitarbeiterById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mitarbeiter> findAllMitarbeiter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByGanzerName(String name,
			String vorname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mitarbeiter> findActiveMitarbeiterByVorname(String vorname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mitarbeiter> findActiveMitarbeiterByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mitarbeiter> findActiveMitarbeiterByGanzerName(String name,
			String vorname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mitarbeiter> findAllActiveMitarbeiter() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
