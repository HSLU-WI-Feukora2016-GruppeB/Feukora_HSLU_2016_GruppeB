package managerKlassen;

import entitäten.Kontakt;
import entitäten.Ort;
import gruppeB.feukora.persister.KontaktDAO;
import gruppeB.feukora.persister.KontaktDAOImpl;

import java.util.List;

import managerInterfaces.KontaktManager;


/**
 * Stellt die Implementierung von Methoden der Schnittstelle KontaktManager zur Verfügung.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 *
 */
public class KontaktManagerImpl implements KontaktManager{

	private KontaktDAO kontaktDAO = new KontaktDAOImpl();	
	
	@Override
	public Kontakt add(Kontakt entity) throws Exception {
		
		if (entity.getId() == null) {
			kontaktDAO.saveKontakt(entity);
			return entity;
		} else {
			throw new Exception(
					"Entity im Datenbestand bereits vorhanden (Id = "
							+ entity.getId().intValue() + ")");
		}
	}

	@Override
	public Kontakt update(Kontakt entity) throws Exception {
		
		if (entity.getId() == null) {
			return add(entity);
		}

		return kontaktDAO.updateKontakt(entity);
	}

	@Override
	public void delete(Kontakt entity) throws Exception {
		kontaktDAO.deleteKontakt(entity);
	}

	@Override
	public void deleteById(Integer idKontakt) throws Exception {
		kontaktDAO.deleteKontaktById(idKontakt);
		
	}

	@Override
	public Kontakt findById(Integer id) {
		return kontaktDAO.findKontaktById(id);
	}

	@Override
	public List<Kontakt> findAll() {
		return kontaktDAO.findAllKontakte();
	}

	@Override
	public List<Kontakt> findByVorname(String vorname) {
		return kontaktDAO.findKontaktByVorname(vorname);
	}

	@Override
	public List<Kontakt> findByName(String name) {
		return kontaktDAO.findKontaktByName(name);
	}

	@Override
	public List<Kontakt> findByNameVorname(String name, String vorname) {
		return kontaktDAO.findKontaktByNameVorname(name, vorname);
	}

	@Override
	public List<Kontakt> findByOrt(Ort ort) {
		return kontaktDAO.findKontaktByOrt(ort);
	}

	@Override
	public List<Kontakt> findByRolleExtern(int rolleExtern) {
		return kontaktDAO.findKontaktByRolleExtern(rolleExtern);
	}

	@Override
	public List<Kontakt> findByStrasse(String strasse) {
		return kontaktDAO.findKontaktByStrasse(strasse);
	}

}
