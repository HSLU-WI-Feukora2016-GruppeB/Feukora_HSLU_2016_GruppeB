package managerKlassen;

import java.util.List;

import entitäten.Kontakt;
import entitäten.RolleExtern;
import gruppeB.feukora.persister.KontaktDAO;
import gruppeB.feukora.persister.KontaktDAOImpl;
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
			kontaktDAO.addKontakt(entity);
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
	public List<Kontakt> findKontaktById(Integer id){
		return kontaktDAO.findKontaktById(id);
	}
	
	@Override
	public List<Kontakt> findAll() {
		return kontaktDAO.findAll();
	}

	@Override
	public List<Kontakt> findKontaktByName(String name) {
		return kontaktDAO.findKontaktByName(name);
	}

	@Override
	public List<Kontakt> findKontaktByVorname(String vorname) {
		return kontaktDAO.findKontaktByVorname(vorname);
	}

	@Override
	public List<Kontakt> findKontaktByOrt(String ort) {
		return kontaktDAO.findKontaktByOrt(ort);
	}

	@Override
	public List<Kontakt> findKontaktByRolleExtern(RolleExtern rolleExtern) {
		return kontaktDAO.findKontaktByRolle(rolleExtern);
	}

}
