package managerKlassen;

import java.util.List;

import entitäten.Mitarbeiter;
import entitäten.RolleIntern;
import gruppeB.feukora.persister.MitarbeiterDAO;
import gruppeB.feukora.persister.MitarbeiterDAOImpl;
import managerInterfaces.MitarbeiterManager;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle MitarbeiterManager zur Verfügung.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */

public class MitarbeiterManagerImpl implements MitarbeiterManager {
	
	private MitarbeiterDAO mitarbeiterDAO = new MitarbeiterDAOImpl();

	@Override
	public Mitarbeiter add(Mitarbeiter entity) throws Exception {
		
		if (entity.getIdMitarbeiter() == null) {
			mitarbeiterDAO.saveMitarbeiter(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getIdMitarbeiter().intValue() + ")");
		}
	}

	@Override
	public Mitarbeiter update(Mitarbeiter entity) throws Exception {
		
		if (entity.getIdMitarbeiter() == null) {
			return add(entity);
		}

		return mitarbeiterDAO.updateMitarbeiter(entity);
	}

	@Override
	public void delete(Mitarbeiter entity) throws Exception {
		mitarbeiterDAO.deleteMitarbeiter(entity);
		
	}

	@Override
	public List<Mitarbeiter> findAllMitarbeiter() {
		return mitarbeiterDAO.findAllMitarbeiter();
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByName(String name) {
		return mitarbeiterDAO.findMitarbeiterByName(name);
	}

	@Override
	public List<Mitarbeiter> findMitarbeiterByVorname(String vorname) {
		return mitarbeiterDAO.findMitarbeiterByVorname(vorname);
	}

	@Override
	public List<Mitarbeiter> findByRolleIntern(RolleIntern rolleIntern) {
		return mitarbeiterDAO.findByRolleIntern(rolleIntern);
	}

}
