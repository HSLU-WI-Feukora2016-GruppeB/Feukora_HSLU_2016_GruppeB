/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU-Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

//import Adresse Modell-Klasse.
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * AdresseDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class AdresseDAOImpl implements AdresseDAO{

	@Override
	public void saveAdresse(Adresse entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Adresse updateAdresse(Adresse entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAdresse(Adresse entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdresseById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Adresse findAdresseById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adresse> findAllAdresse() {
		// TODO Auto-generated method stub
		return null;
	}

}
