package managerKlassen;

import java.util.List;


/**
 * Stellt die Implementierung von Methoden der Schnittstelle AuftragManager zur Verfügung.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */
public class AuftragManagerImpl implements AuftragManager {
	
	private AuftragDAO auftragDAO = new AuftragDAOImpl();

	@Override
	public Auftrag add(Auftrag entity) throws Exception {

		if (entity.getId() == null) {
			auftragDAO.saveAuftrag(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId().intValue() + ")");
		}
	}

	@Override
	public Auftrag update(Auftrag entity) throws Exception {

		if (entity.getId() == null) {
			return add(entity);
		}

		return auftragDAO.updateAuftrag(entity);
	}
	
	@Override
	public void delete(Auftrag entity) throws Exception {
		AuftragDAO.deleteAuftrag(entity);

	}

}
