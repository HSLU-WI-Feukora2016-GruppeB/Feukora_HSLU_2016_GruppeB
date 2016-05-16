package managerKlassen;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Messung;
import gruppeB.feukora.interfaces.MessungDAO;
import gruppeB.feukora.persister.MessungDAOImpl;
import managerInterfaces.MessungsManager;
/**
 * Stellt die Implementierung von Methoden der Schnittstelle MessungManager zur Verfügung.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class MessungManagerImpl implements MessungsManager {
	
	private MessungDAO messungDAO = new MessungDAOImpl();

	@Override
	public Messung add(Messung entity) throws Exception {
		if (entity.getIdMessung() == null) {
			messungDAO.saveMessung(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity. getIdMessung().intValue() + ")");
		}
	}

	@Override
	public Messung update(Messung entity) throws Exception {

		if (entity.getIdMessung() == null) {
			return add(entity);
		}

		return messungDAO.updateMessung(entity);
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
	public List<Messung> findByBeurteilungNotOk(boolean beurteilungNotOk) {
		return messungDAO.findByBeurteilungNotOk(beurteilungNotOk);
	}
	
}
