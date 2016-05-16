package managerKlassen;

import java.util.List;

import entitys.Brenner;
import gruppeB.feukora.interfaces.BrennerDAO;
import gruppeB.feukora.persister.BrennerDAOImpl;
import managerInterfaces.BrennerManager;
/**
 * Stellt die Implementierung von Methoden der Schnittstelle BrennerManager zur Verfügung.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
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
		if(entity.getId() == null){
			return add(entity);
		}
		return brennerDAO.updateBrenner(entity);
	}

	@Override
	public void delete(Brenner entity) throws Exception {
		brennerDAO.deleteBrenner(entity);
	}

	@Override
	public void deleteById(Integer idBrenner) throws Exception {
		brennerDAO.deleteBrennerById(idBrenner);
	}

	@Override
	public Brenner findById(Integer id) {
		return brennerDAO.findBrennerById(id);
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
	public List<Brenner> findByArt(int brennerArt) {
		return brennerDAO.findBrennerByBrennerart(brennerArt);
	}

	@Override
	public List<Brenner> findByBaujahr(int baujahr) {
		return brennerDAO.findBrennerByBaujahr(baujahr);
	}

}
