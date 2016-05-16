package managerKlassen;

import java.util.List;

import entitäten.Waermeerzeuger;
import gruppeB.feukora.persister.WaermeerzeugerDAO;
import gruppeB.feukora.persister.WaermeerzeugerDAOImpl;
import managerInterfaces.WaermeerzeugerManager;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle Waermeerzeuger zur Verfügung.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */

public class WaermeerzeugerManagerImpl implements WaermeerzeugerManager {

	private WaermeerzeugerDAO waermeerzeugerDAO = new WaermeerzeugerDAOImpl();
	
	@Override
	public Waermeerzeuger add(Waermeerzeuger entity) throws Exception {
		
		if (entity.getIdWaermeerzeuger() == null) {
			waermeerzeugerDAO.saveWaermeerzeuger(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getIdWaermeerzeuger().intValue() + ")");
		}
	}

	@Override
	public Waermeerzeuger update(Waermeerzeuger entity) throws Exception {
		
		if (entity.getIdWaermeerzeuger() == null) {
			return add(entity);
		}

		return waermeerzeugerDAO.updateWaermeerzeuger(entity);
	}

	@Override
	public void delete(Waermeerzeuger entity) throws Exception {
		waermeerzeugerDAO.deleteWaermeerzeuger(entity);
	}

	@Override
	public void deleteById(Integer idWaermeerzeuger) throws Exception {
		waermeerzeugerDAO.deleteWaermeerzeugerById(idWaermeerzeuger);
	}

	@Override
	public Waermeerzeuger findById(Integer id) {
		return waermeerzeugerDAO.findWaermeerzeugerById(id);
	}

	@Override
	public List<Waermeerzeuger> findAllWaermeerzeuger() {
		return waermeerzeugerDAO.findAllWaermeerzeuger();
	}

	@Override
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp) {
		return waermeerzeugerDAO.findByTyp(waermeerzeugerTyp);
	}

	@Override
	public List<Waermeerzeuger> findByBrennstoff(int brennstoff) {
		return waermeerzeugerDAO.findWaermeerzeugerByBrennstoff(brennstoff);
	}

	@Override
	public List<Waermeerzeuger> findByBaujahr(int baujahr) {
		return waermeerzeugerDAO.findWaermeerzeugerByBaujahr(baujahr);
	}

}
