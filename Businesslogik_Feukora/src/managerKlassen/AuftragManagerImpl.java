package managerKlassen;

import entitys.Auftrag;
import entitys.Kontakt;
import entitys.Liegenschaft;
//import entitys.Messung;
import entitys.Mitarbeiter;
import gruppeB.feukora.interfaces.AuftragDAO;
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

	//private GrenzwerteManagerImpl grenzwerteManager = new GrenzwerteManagerImpl();

	private AuftragDAO auftragDAO = new AuftragDAOImpl();

	@Override
	public Auftrag add(Auftrag entity) throws Exception {

		if (entity.getAuftragsNummer() == null) {

			/*
			 * Werte werden in der Datenbank nicht aktualisiert, aus Zeitgr�nden
			 * musste diese Methode im Umfang des Projektes ausgeklammert werden
			 * und durch eine Manuelle setzung der Beurteilung ersetzt werden.
			 *
			 * checkMessungByGrenzwerte(entity);
			 */
			checkTerminProMitarbeiter(entity);

			auftragDAO.saveAuftrag(entity);

			return entity;

		} else {
			throw new Exception("Entity ist bereits in der Datenbank vorhanden (Id = "
					+ entity.getAuftragsNummer().intValue() + ")");
		}
	}

	private void checkTerminProMitarbeiter(Auftrag entity) throws Exception {
		Auftrag auftrag = auftragDAO.findAuftragByDateAndMitarbeiterAndZeitslot(entity.getTermin(),
				entity.getMitarbeiter(), entity.getZeitSlot());
		if (auftrag == null) {
			return;
		} else if (entity.getAuftragsNummer().equals(auftrag.getAuftragsNummer())) {
			return;
		} else {
			throw new Exception("Der gew�nschte Termin ist bereits erfasst. (Id = " + entity.getAuftragsNummer());
		}
	}

	@Override
	public Auftrag update(Auftrag entity) throws Exception {

		if (entity.getAuftragsNummer() == null) {
			return add(entity);
		}
		checkTerminProMitarbeiter(entity);
		/*
		 * Werte werden in der Datenbank nicht aktualisiert, aus Zeitgr�nden
		 * musste diese Methode im Umfang des PRojektes ausgeklammert werden
		 * und durch eine Manuelle setzung der Beurteilung ersetzt werden.
		 *
		 * checkMessungByGrenzwerte(entity);
		 */

		return auftragDAO.updateAuftrag(entity);
	}

	/**
	 * �berpr�ft die einzelnen Messungen mithilfe der zutreffenden Grenzwerte.
	 * @param auftrag
	 * @throws Exception
	 */
//	private void checkMessungByGrenzwerte(Auftrag auftrag) throws Exception {
//		int brennerArt = auftrag.getLiegenschaft().getFeuerungsanlage().getBrenner().getBrennerArt();
//
//		Messung messung1 = auftrag.getMessung1stufe1();
//		grenzwerteManager.checkGrenzwerte(messung1, brennerArt, 1);
//
//		Messung messung2 = auftrag.getMessung1stufe2();
//		grenzwerteManager.checkGrenzwerte(messung2, brennerArt, 2);
//
//		Messung messung3 = auftrag.getMessung2stufe1();
//		grenzwerteManager.checkGrenzwerte(messung3, brennerArt, 3);
//
//		Messung messung4 = auftrag.getMessung2stufe2();
//		grenzwerteManager.checkGrenzwerte(messung4, brennerArt, 4);
//	}

	@Override
	public void delete(Auftrag entity) throws Exception {
		auftragDAO.deleteAuftrag(entity);

	}

	@Override
	public void deleteById(Integer auftragsNummer) throws Exception {
		auftragDAO.deleteAuftragById(auftragsNummer);

	}

	@Override
	public Auftrag findById(Integer idAuftrag) throws Exception {
		return auftragDAO.findAuftragById(idAuftrag);
	}

	@Override
	public List<Auftrag> findAll() throws Exception {
		return auftragDAO.findAllAuftrag();
	}

	@Override
	public List<Auftrag> findByDatum(GregorianCalendar datum) throws Exception {
		return auftragDAO.findByDatum(datum);
	}

	@Override
	public List<Auftrag> findByMitarbeiter(Mitarbeiter mitarbeiter) throws Exception {
		return auftragDAO.findByMitarbeiter(mitarbeiter);
	}

	@Override
	public List<Auftrag> findByDateAndMitarbeiter(GregorianCalendar startdatum, GregorianCalendar enddatum,
			Mitarbeiter mitarbeiter) throws Exception {
		return auftragDAO.findByDatumAndMitarbeiter(startdatum, enddatum, mitarbeiter);
	}

	@Override
	public Auftrag findByDateAndMitarbeiterAndZeitslot(GregorianCalendar datum, Mitarbeiter mitarbeiter, int zeitSlot)
			throws Exception {
		return auftragDAO.findAuftragByDateAndMitarbeiterAndZeitslot(datum, mitarbeiter, zeitSlot);
	}

	@Override
	public List<Auftrag> findByKontakt(Kontakt kontakt) throws Exception {
		return auftragDAO.findByKontakt(kontakt);
	}

	@Override
	public List<Auftrag> findByLiegenschaft(Liegenschaft liegenschaft) throws Exception {
		return auftragDAO.findByLiegenschaft(liegenschaft);
	}

}
