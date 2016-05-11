package managerKlassen;

import java.util.List;

import entitäten.Liegenschaft;
import gruppeB.feukora.persister.LiegenschaftDAO;
import gruppeB.feukora.persister.LiegenschaftDAOImpl;
import managerInterfaces.LiegenschaftManager;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle LiegenschaftManager zur Verfügung.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */

public class LiegenschaftManagerImpl implements LiegenschaftManager {

	private LiegenschaftDAO liegenschaftDAO = new LiegenschaftDAOImpl();
	
	@Override
	public Liegenschaft add(Liegenschaft entity) throws Exception {
		
		if (entity.getIdLiegenschaft() == null) {
			liegenschaftDAO.addLiegenschaft(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getIdLiegenschaft().intValue() + ")");
		}
	}

	@Override
	public Liegenschaft update(Liegenschaft entity) throws Exception {
		
		if (entity.getIdLiegenschaft() == null) {
			return add(entity);
		}

		return liegenschaftDAO.updateLiegenschaft(entity);
	}

	@Override
	public void delete(Liegenschaft entity) throws Exception {
		liegenschaftDAO.deleteLiegenschaft(entity);
		
	}

	@Override
	public Liegenschaft findById(Integer id) {
		return liegenschaftDAO.findLiegenschaftById(id);
	}

	@Override
	public List<Liegenschaft> findAllLiegenschaft() {
		return liegenschaftDAO.findAllLiegenschaft();
	}

	@Override
	public List<Liegenschaft> findByKontakt(String kontakt) {
		return liegenschaftDAO.findByKontakt(kontakt);
	}

	@Override
	public List<Liegenschaft> findByOrt(String ort) {
		return liegenschaftDAO.findByOrt(ort);
	}

	@Override
	public List<Liegenschaft> findByStrasse(String strasseInklNr) {
		return liegenschaftDAO.findByStrasse(strasseInklNr);
	}

}
