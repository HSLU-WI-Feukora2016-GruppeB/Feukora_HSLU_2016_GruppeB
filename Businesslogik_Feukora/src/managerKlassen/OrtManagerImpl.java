package managerKlassen;

import java.util.List;

import entitys.Ort;
import gruppeB.feukora.interfaces.OrtDAO;
import gruppeB.feukora.persister.OrtDAOImpl;
import managerInterfaces.OrtManager;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle OrtManager zur Verfügung.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class OrtManagerImpl implements OrtManager {
	
	private OrtDAO ortDAO = new OrtDAOImpl();

	@Override
	public Ort add(Ort entity) throws Exception {

		if (entity.getPlz() == 0) {
			ortDAO.saveOrt(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getPlz() + ")");
		}
	}

	@Override
	public Ort update(Ort entity) throws Exception {

		if (entity.getPlz() == 0) {
			return add(entity);
		}

		return ortDAO.updateOrt(entity);
	}

	@Override
	public void delete(Ort entity) throws Exception {
		ortDAO.deleteOrt(entity);		
	}

	@Override
	public void deleteById(Integer plz) throws Exception {
		ortDAO.deleteOrtById(plz);
	}

	@Override
	public List<Ort> findAll() {
		return ortDAO.findAllOrt();
	}

	@Override
	public Ort findById(Integer idOrt) {
		return ortDAO.findOrtById(idOrt);
	}

	@Override
	public List<Ort> findByOrtBez(String ortBez) {
		return ortDAO.findOrtByBezeichnung(ortBez);
	}

	@Override
	public List<Ort> findByPlz(int plz) throws Exception {
		return ortDAO.findOrtByPlz(plz);
	}

}
