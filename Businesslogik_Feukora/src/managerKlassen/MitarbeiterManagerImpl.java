package managerKlassen;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Benutzer;
import entitys.Mitarbeiter;
import entitys.Ort;
import gruppeB.feukora.interfaces.MitarbeiterDAO;
import gruppeB.feukora.persister.MitarbeiterDAOImpl;
import managerInterfaces.MitarbeiterManager;

/**
 * Stellt die Implementierung von Methoden der Schnittstelle MitarbeiterManager zur Verfügung.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */

public class MitarbeiterManagerImpl implements MitarbeiterManager {
	
	private MitarbeiterDAO mitarbeiterDAO = new MitarbeiterDAOImpl();

	@Override
	public Mitarbeiter add(Mitarbeiter entity) throws Exception {
		
		if (entity.getIdMitarbeiter() == null) {
			mitarbeiterDAO.saveMitarbeiter(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getIdMitarbeiter().intValue() + ")");
		}
	}

	@Override
	public Mitarbeiter update(Mitarbeiter entity) throws Exception {
		
		if (entity.getIdMitarbeiter() == null) {
			return add(entity);
		}

		return mitarbeiterDAO.updateMitarbeiter(entity);
	}

	@Override
	public void delete(Mitarbeiter entity) throws Exception {
		mitarbeiterDAO.deleteMitarbeiter(entity);
		
	}

	@Override
	public void deleteById(Integer idMessung) throws Exception {
		mitarbeiterDAO.deleteMitarbeiterById(idMessung);
	}

	@Override
	public Mitarbeiter findById(Integer idMitarbeiter) {
		return mitarbeiterDAO.findMitarbeiterById(idMitarbeiter);
	}

	@Override
	public List<Mitarbeiter> findAllMitarbeiter() {
		return mitarbeiterDAO.findAllMitarbeiter();
	}

	@Override
	public List<Mitarbeiter> findByName(String name) {
		return mitarbeiterDAO.findMitarbeiterByName(name);
	}

	@Override
	public List<Mitarbeiter> findByVorname(String vorname) {
		return mitarbeiterDAO.findMitarbeiterByVorname(vorname);
	}

	@Override
	public List<Mitarbeiter> findByNameVorname(String name,
			String vorname) {
		return mitarbeiterDAO.findMitarbeiterByNameVorname(name, vorname);
	}

	@Override
	public List<Mitarbeiter> findByRolleIntern(int rolleIntern) {
		return mitarbeiterDAO.findMitarbeiterByRolleIntern(rolleIntern);
	}

	@Override
	public List<Mitarbeiter> findByStrasse(String strasse) {
		return mitarbeiterDAO.findMitarbeiterByStrasse(strasse);
	}

	@Override
	public List<Mitarbeiter> findByOrt(Ort ort) {
		return mitarbeiterDAO.findMitarbeiterByOrt(ort);
	}

	@Override
	public List<Mitarbeiter> findByBenutzer(Benutzer user) {
		return mitarbeiterDAO.findMitarbeiterByBenutzer(user);
	}

	@Override
	public List<Mitarbeiter> findByArbeitetSeit(GregorianCalendar arbeitetSeit) {
		return mitarbeiterDAO.findMitarbeiterByArbeitetSeit(arbeitetSeit);
	}

	@Override
	public List<Mitarbeiter> findByArbeitetBis(GregorianCalendar arbeitetBis) {
		return mitarbeiterDAO.findMitarbeiterByArbeitetBis(arbeitetBis);
	}

}
