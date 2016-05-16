package managerKlassen;

import entit�ten.Auftrag;
import entit�ten.Kontakt;
import entit�ten.Liegenschaft;
import entit�ten.Messung;
import entit�ten.Mitarbeiter;
import gruppeB.feukora.persister.AuftragDAO;
import gruppeB.feukora.persister.AuftragDAOImpl;

import java.util.GregorianCalendar;
import java.util.List;

import managerInterfaces.AuftragManager;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle AuftragManager zur
 * Verf�gung.
 * 
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class AuftragManagerImpl implements AuftragManager {

	private GrenzwerteManagerImpl grenzwerteManager = new GrenzwerteManagerImpl();

	private AuftragDAO auftragDAO = new AuftragDAOImpl();

	@Override
	public Auftrag add(Auftrag entity) throws Exception {

		if (entity.getAuftragsNummer() == null) {

			checkMessungByGrenzwerte(entity);

			// nach check Grenzwert wird das Auftragsobjekt gespeichert, und
			// weil Messungen Cascade die auch gleich. Messungen m�ssen nicht
			// nochmal separat gespeicheret werden.
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
		checkMessungByGrenzwerte(entity);
		return auftragDAO.updateAuftrag(entity);
	}

	private void checkMessungByGrenzwerte(Auftrag auftrag) {
		Messung messung1 = auftrag.getMessung1stufe1();
		int brennerArt = auftrag.getLiegenschaft().getFeuerungsanlage()
				.getBrenner().getBrennerArt();
	
		grenzwerteManager.checkGrenzwerte(messung1, brennerArt, 1);
	
		Messung messung2 = auftrag.getMessung1stufe2();
		grenzwerteManager.checkGrenzwerte(messung2, brennerArt, 2);
	
		Messung messung3 = auftrag.getMessung2stufe1();
		grenzwerteManager.checkGrenzwerte(messung3, brennerArt, 3);
	
		Messung messung4 = auftrag.getMessung2stufe2();
		grenzwerteManager.checkGrenzwerte(messung4, brennerArt, 4);
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
	public List<Auftrag> findByDateAndMitarbeiter(GregorianCalendar startdatum,
			GregorianCalendar enddatum, Mitarbeiter mitarbeiter) {
		return auftragDAO.findByDatumAndMitarbeiter(startdatum, enddatum, mitarbeiter);
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
