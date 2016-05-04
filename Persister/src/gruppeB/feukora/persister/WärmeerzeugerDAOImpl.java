/**
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * WärmeerzeugerDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class WärmeerzeugerDAOImpl implements WärmeerzeugerDAO{

	@Override
	public void saveWärmeerzeuger(Wärmeerzeuger entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Wärmeerzeuger updateWärmeerzeuger(Wärmeerzeuger entity)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteWärmeerzeuger(Wärmeerzeuger entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteWärmeerzeugerById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Wärmeerzeuger findWärmeerzeugerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wärmeerzeuger> findAllWärmeerzeuger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wärmeerzeuger> findWärmeerzeugerByBezeichnung(String bezeichnung) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wärmeerzeuger> findWärmeerzeugerByBaujahr(Integer baujahr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Wärmeerzeuger> findWärmeerzeugerByBrennstoff(String brennstoff) {
		// TODO Auto-generated method stub
		return null;
	}

}
