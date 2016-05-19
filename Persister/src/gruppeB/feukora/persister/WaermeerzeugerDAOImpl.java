/**
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitys.Waermeerzeuger;
import gruppeB.feukora.interfaces.WaermeerzeugerDAO;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * WaermeerzeugerDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class WaermeerzeugerDAOImpl implements WaermeerzeugerDAO{

	@Override
	public void saveWaermeerzeuger(Waermeerzeuger entity) throws Exception {
		new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).save(entity);
	}

	@Override
	public Waermeerzeuger updateWaermeerzeuger(Waermeerzeuger entity) throws Exception {
		return new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).update(entity);
	}

	@Override
	public void deleteWaermeerzeuger(Waermeerzeuger entity) throws Exception {
		new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).delete(entity);
	}
	
	@Override
	public void deleteWaermeerzeugerById(Integer id) throws Exception {
		new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).deleteById(id);
	}

	@Override
	public Waermeerzeuger findWaermeerzeugerById(Integer id) {
		return new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).findById(id);
	}

	@Override
	public List<Waermeerzeuger> findAllWaermeerzeuger() {
		return new GenericPersisterImpl<Waermeerzeuger>(Waermeerzeuger.class).findAll();
	}

	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByBaujahr(int baujahr) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Waermeerzeuger> tQuery = em.createNamedQuery("Waermeerzeuger.findByBaujahr",
				Waermeerzeuger.class);

		tQuery.setParameter("baujahr", baujahr);

		List<Waermeerzeuger> waermeerzeugerListe = tQuery.getResultList();

		em.close();

		return waermeerzeugerListe != null ? waermeerzeugerListe : new ArrayList<Waermeerzeuger>();
	}

	@Override
	public List<Waermeerzeuger> findWaermeerzeugerByBrennstoff(int brennstoff) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Waermeerzeuger> tQuery = em.createNamedQuery("Waermeerzeuger.findByBrennstoff",
				Waermeerzeuger.class);

		tQuery.setParameter("brennstoff", brennstoff);

		List<Waermeerzeuger> waermeerzeugerListe = tQuery.getResultList();

		em.close();

		return waermeerzeugerListe != null ? waermeerzeugerListe : new ArrayList<Waermeerzeuger>();
	}

	@Override
	public List<Waermeerzeuger> findByTyp(String waermeerzeugerTyp) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Waermeerzeuger> tQuery = em.createNamedQuery("Waermeerzeuger.findByTyp",
				Waermeerzeuger.class);

		tQuery.setParameter("waermeerzeugerTyp", waermeerzeugerTyp);

		List<Waermeerzeuger> waermeerzeugerListe = tQuery.getResultList();

		em.close();

		return waermeerzeugerListe != null ? waermeerzeugerListe : new ArrayList<Waermeerzeuger>();

	}

}