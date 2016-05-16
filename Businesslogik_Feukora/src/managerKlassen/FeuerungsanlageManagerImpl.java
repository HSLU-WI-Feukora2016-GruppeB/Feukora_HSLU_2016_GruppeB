package managerKlassen;

import java.util.List;

import entitys.Brenner;
import entitys.Feuerungsanlage;
import entitys.Liegenschaft;
import entitys.Waermeerzeuger;
import gruppeB.feukora.interfaces.FeuerungsanlageDAO;
import gruppeB.feukora.persister.FeuerungsanlageDAOImpl;
import managerInterfaces.FeuerungsanlageManager;


/**
 * Stellt die Implementierung von Methoden der Schnittstelle Feuerungsanlage zur Verfügung.
 * @author Olivia
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
	public void deleteById(Integer idFeuerungsanlage) throws Exception {
		feuerungsanlageDAO.deleteFeuerungsanlageById(idFeuerungsanlage);
	}

	@Override
	public Feuerungsanlage findById(Integer idFeuerungsanlage) throws Exception {
		return feuerungsanlageDAO.findFeuerungsanlageById(idFeuerungsanlage);
	}

	@Override
	public List<Feuerungsanlage> findAll() {
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
