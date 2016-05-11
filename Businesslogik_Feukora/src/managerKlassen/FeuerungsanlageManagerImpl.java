package managerKlassen;

import java.util.List;

import entitäten.Brenner;
import entitäten.Feuerungsanlage;
import entitäten.Liegenschaft;
import entitäten.Waermeerzeuger;
import gruppeB.feukora.persister.FeuerungsanlageDAO;
import gruppeB.feukora.persister.FeuerungsanlageDAOImpl;
import managerInterfaces.FeuerungsanlageManager;


/**
 * Stellt die Implementierung von Methoden der Schnittstelle Feuerungsanlage zur Verfügung.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */

public class FeuerungsanlageManagerImpl implements FeuerungsanlageManager {

	private FeuerungsanlageDAO feuerungsanlageDAO = new FeuerungsanlageDAOImpl();
	
	
	@Override
	public Feuerungsanlage add(Feuerungsanlage entity) throws Exception {
		
		if (entity.getIdFeuerungsanlage() == null) {
			feuerungsanlageDAO.saveFeuerungsanlage(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getIdFeuerungsanlage().intValue() + ")");
		}
	}

	@Override
	public Feuerungsanlage update(Feuerungsanlage entity) throws Exception {
		
		if (entity.getIdFeuerungsanlage() == null) {
			return add(entity);
		}

		return feuerungsanlageDAO.updateFeuerungsanlage(entity);
	}

	@Override
	public void delete(Feuerungsanlage entity) throws Exception {
		feuerungsanlageDAO.deleteFeuerungsanlage(entity);
		
	}

	@Override
	public List<Feuerungsanlage> findAllFeuerungsanlage() {
		return feuerungsanlageDAO.findAllFeuerungsanlage();
	}

	@Override
	public List<Feuerungsanlage> findByLiegenschaft(Liegenschaft liegenschaft) {
		return feuerungsanlageDAO.findByLiegenschaft(liegenschaft);
	}

	@Override
	public List<Feuerungsanlage> findByBrenner(Brenner brenner) {
		return feuerungsanlageDAO.findByBrenner(brenner);
	}

	@Override
	public List<Feuerungsanlage> findByWaermeerzeuger(
			Waermeerzeuger waermeerzeuger) {
		return feuerungsanlageDAO.findByWaermeerzeuger(waermeerzeuger);
	}

}
