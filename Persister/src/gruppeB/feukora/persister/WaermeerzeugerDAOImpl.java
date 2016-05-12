/**
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitäten.Waermeerzeuger;

import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * WaermeerzeugerDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class WaermeerzeugerDAOImpl implements WaermeerzeugerDAO{

	@Override
	public void saveWaermeerzeuger(Waermeerzeuger entity) throws Exception {
		new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).save(entity);
	}

	@Override
	public Waermeerzeuger updateWaermeerzeuger(Waermeerzeuger entity) throws Exception {
		return new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).update(entity);
	}

	@Override
	public void deleteWaermeerzeuger(Waermeerzeuger entity) throws Exception {
		new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).delete(entity);
	}

	@Override
	public Waermeerzeuger findWaermeerzeugerById(Integer id) {
		return new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).findById(id);
	}

	@Override
	public List<Waermeerzeuger> findAllWaermeerzeuger() {
		return new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).findAll();
	}

	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByBezeichnung(String bezeichnung) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByBaujahr(Integer baujahr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(String brennstoff) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp) {
		// TODO Auto-generated method stub
		return null;
	}

}
