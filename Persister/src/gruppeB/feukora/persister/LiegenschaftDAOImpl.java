/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


//import Liegenschaft Modell-Klasse.
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Liegenschaft updateLiegenschaft(Liegenschaft entity)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLiegenschaft(Liegenschaft entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLiegenschaftById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Liegenschaft findLiegenschaftById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liegenschaft> findAllLiegenschaft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByHauswart(Kontakt hauswart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByEigentümer(Kontakt eigentümer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Liegenschaft> findLiegenschaftByAdresse(Adresse adresse) {
		// TODO Auto-generated method stub
		return null;
	}
}
