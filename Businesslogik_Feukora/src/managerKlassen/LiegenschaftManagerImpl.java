package managerKlassen;

import java.util.List;

import entitys.Kontakt;
import entitys.Liegenschaft;
import entitys.Ort;
import gruppeB.feukora.interfaces.LiegenschaftDAO;
import gruppeB.feukora.persister.LiegenschaftDAOImpl;
import managerInterfaces.LiegenschaftManager;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle LiegenschaftManager zur Verfügung.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class LiegenschaftManagerImpl implements LiegenschaftManager {

	private LiegenschaftDAO liegenschaftDAO = new LiegenschaftDAOImpl();
	
	@Override
	public Liegenschaft add(Liegenschaft entity) throws Exception {
		
		if (entity.getIdLiegenschaft() == null) {
			liegenschaftDAO.saveLiegenschaft(entity);
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
	public void deleteById(Integer idLiegenschaft) throws Exception {
		liegenschaftDAO.deleteLiegenschaftById(idLiegenschaft);
	}

	@Override
	public Liegenschaft findById(Integer id) {
		return liegenschaftDAO.findLiegenschaftById(id);
	}

	@Override
	public List<Liegenschaft> findAll() {
		return liegenschaftDAO.findAllLiegenschaft();
	}

	@Override
	public List<Liegenschaft> findByStrasse(String strasse) {
		return liegenschaftDAO.findLiegenschaftByStrasse(strasse);
	}

	@Override
	public List<Liegenschaft> findByKontakt(Kontakt kontakt) {
		return liegenschaftDAO.findLiegenschaftByKontakt(kontakt);
	}

	@Override
	public List<Liegenschaft> findByOrt(Ort ort) {
		return liegenschaftDAO.findLiegenschaftByOrt(ort);
	}

}
