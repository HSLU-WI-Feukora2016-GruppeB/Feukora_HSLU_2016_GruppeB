package managerKlassen;

import java.util.List;

import entitäten.Benutzer;
import gruppeB.feukora.persister.BenutzerDAO;
import gruppeB.feukora.persister.BenutzerDAOImpl;
import managerInterfaces.BenutzerManager;
/**
 * Stellt die Implementierung von Methoden der Schnittstelle BenutzerManager zur Verfügung.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class BenutzerManagerImpl implements BenutzerManager {

	private BenutzerDAO benutzerDAO = new BenutzerDAOImpl();
	
	@Override
	public Benutzer add(Benutzer entity) throws Exception {

		if (entity.getIdUser() == null) {
			benutzerDAO.saveBenutzer(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity ist bereits in der Datenbank vorhanden (Id = "
							+ entity.getIdUser().intValue() + ")");
		}
	}

	@Override
	public Benutzer update(Benutzer entity) throws Exception {

		if(entity.getIdUser() == null){
			return add(entity);
		}
		
		return benutzerDAO.updateBenutzer(entity);	
	}

	@Override
	public void delete(Benutzer entity) throws Exception {
		benutzerDAO.deleteBenutzer(entity);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		benutzerDAO.deleteBenutzerById(id);
		
	}

	@Override
	public Benutzer findById(Integer id) {
		return benutzerDAO.findBenutzerById(id);
	}

	@Override
	public List<Benutzer> findAll() {
		return benutzerDAO.findAllBenutzer();
	}

	@Override
	public List<Benutzer> findByUsername(String username) {
		return benutzerDAO.findBenutzerByUsername(username);
	}

	@Override
	public List<Benutzer> findByPassword(String password) {
		return benutzerDAO.findBenutzerByPassword(password);
	}

}
