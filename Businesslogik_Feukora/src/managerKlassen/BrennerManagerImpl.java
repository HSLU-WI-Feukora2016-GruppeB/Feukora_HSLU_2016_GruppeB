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
			brennerDAO.saveBrenner(entity);
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId().intValue() + ")");
		}
		return entity;
	}

	@Override
	public Brenner update(Brenner entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		} else {
			return brennerDAO.updateBrenner(entity);
		}
	}

	@Override
	public void delete(Brenner entity) throws Exception {
		brennerDAO.deleteBrenner(entity);
	}

	@Override
	public List<Brenner> findAll() {
		return brennerDAO.findAllBrenner();
	}

	@Override
	public List<Brenner> findByTyp(String brennerTyp) {
		return brennerDAO.findBrennerByBrennertyp(brennerTyp);
	}

	@Override
	public List<Brenner> findByArt(String brennerArt) {
		return brennerDAO.findBrennerByBrennart(brennerArt);
	}

}
