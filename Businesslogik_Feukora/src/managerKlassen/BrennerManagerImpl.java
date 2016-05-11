package managerKlassen;

import java.util.List;

import entitäten.Brenner;
import gruppeB.feukora.persister.BrennerDAO;
import gruppeB.feukora.persister.BrennerDAOImpl;
import managerInterfaces.BrennerManager;

public class BrennerManagerImpl implements BrennerManager{
	
	private BrennerDAO brennerDAO = new BrennerDAOImpl();

	@Override
	public Brenner add(Brenner entity) throws Exception {
		if (entity.getId() == null) {
			dozentDAO.saveDozent(entity);
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId().intValue() + ")");
		}
		return entity;
	}

	@Override
	public Brenner update(Brenner entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Brenner entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Brenner> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brenner> findByTyp(String brennerTyp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Brenner> findByArt(String brennerArt) {
		// TODO Auto-generated method stub
		return null;
	}

}
