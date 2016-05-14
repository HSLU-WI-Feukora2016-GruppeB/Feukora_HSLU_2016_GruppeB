package managerKlassen;

import java.util.List;

import entitäten.Benutzer;
import gruppeB.feukora.persister.BenutzerDAO;
import gruppeB.feukora.persister.BenutzerDAOImpl;
import managerInterfaces.BenutzerManager;

public class BenutzerManagerImpl implements BenutzerManager {

	private BenutzerDAO benutzerDAO = new BenutzerDAOImpl();
	
	@Override
	public Benutzer add(Benutzer entity) throws Exception {

		if (entity.getAuftragsNummer() == null) {
			auftragDAO.saveAuftrag(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity ist bereits in der Datenbank vorhanden (Id = "
							+ entity.getAuftragsNummer().intValue() + ")");
		}
	}

	@Override
	public Benutzer update(Benutzer entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Benutzer entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Benutzer> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Benutzer> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
