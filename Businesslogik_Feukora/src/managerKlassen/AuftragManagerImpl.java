package managerKlassen;

import java.util.List;

import managerInterfaces.Auftrag;
import managerInterfaces.AuftragManager;
import managerInterfaces.GregorianCalender;


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

	@Override
	public Auftrag add(Auftrag entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auftrag update(Auftrag entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auftrag findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByDatum(GregorianCalender datum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByMitarbeiter(String mitarbeiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByKontakt(String kontakt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByLiegenschaft(String liegenschaft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByAuftragsNummer(String auftragsNummer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> findByMessung(String messung) {
		// TODO Auto-generated method stub
		return null;
	}

}
