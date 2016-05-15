package managerKlassen;

import java.util.GregorianCalendar;
import java.util.List;

import entitäten.Messung;
import gruppeB.feukora.persister.MessungDAO;
import gruppeB.feukora.persister.MessungDAOImpl;
import managerInterfaces.MessungsManager;

public class MessungManagerImpl implements MessungsManager {
	
	private MessungDAO messungDAO = new MessungDAOImpl();

	@Override
	public Messung add(Messung entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Messung update(Messung entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Messung entity) throws Exception {
		messungDAO.deleteMessung(entity);
	}

	@Override
	public void deleteById(Integer idMessung) throws Exception {
		messungDAO.deleteMessungById(idMessung);
	}

	@Override
	public Messung findById(Integer idMessung) {
		return messungDAO.findMessungById(idMessung);
	}

	@Override
	public List<Messung> findAll() {
		return messungDAO.findAllMessung();
	}

	@Override
	public List<Messung> findByDatum(GregorianCalendar messDatum) {
		return messungDAO.findByMessDatum(messDatum);
	}

	@Override
	public List<Messung> findByBeurteilungOk(boolean beurteilungOk) {
		return messungDAO.findByBeurteilungOk(beurteilungOk);
	}

	@Override
	public List<Messung> findByBeurteilungNotOk(boolean beurteilungNotOk) {
		return messungDAO.findByBeurteilungNotOk(beurteilungNotOk);
	}
	
	/**
	 * Kontrolliert ob die einzelnen Messdaten einer Messung den Grenzwerten entsprechen.
	 * @param messung
	 */
	private void checkMessungByGrenzwerte(Messung entity) {
		//TODO
		entity.getAbgasverluste();
		
	}

}
