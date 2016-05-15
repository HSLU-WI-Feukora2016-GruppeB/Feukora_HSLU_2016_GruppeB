package managerKlassen;

import entitäten.Auftrag;
import entitäten.Kontakt;
import entitäten.Liegenschaft;
import entitäten.Mitarbeiter;
import gruppeB.feukora.persister.AuftragDAO;
import gruppeB.feukora.persister.AuftragDAOImpl;

import java.util.GregorianCalendar;
import java.util.List;

import managerInterfaces.AuftragManager;


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
	public Auftrag update(Auftrag entity) throws Exception {

		if (entity.getAuftragsNummer() == null) {
			return add(entity);
		}

		return auftragDAO.updateAuftrag(entity);
	}
	
	@Override
	public void delete(Auftrag entity) throws Exception {
		auftragDAO.deleteAuftrag(entity);

	}

	@Override
	public void deleteById(Integer auftragsNummer) throws Exception {
		auftragDAO.deleteAuftragById(auftragsNummer);
		
	}

	@Override
	public Auftrag findByAuftragsNummer(Integer auftragsNummer) {
		return auftragDAO.findAuftragByAuftragsNummer(auftragsNummer);
	}
	
	@Override
	public List<Auftrag> findAll() {
		return auftragDAO.findAllAuftrag();
	}

	@Override
	public List<Auftrag> findByDatum(GregorianCalendar datum) {
		return auftragDAO.findByDatum(datum);
	}

	@Override
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter) {
		return auftragDAO.findByMitarbeiter(mitarbeiter);
	}

	@Override
	public List<Auftrag> findByKontakt(Kontakt kontakt) {
		return auftragDAO.findByKontakt(kontakt);
	}

	@Override
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft) {
		return auftragDAO.findByLiegenschaft(liegenschaft);
	}

	


}
