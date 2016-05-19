/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entitys.Messung;
import gruppeB.feukora.interfaces.MessungDAO;
import gruppeB.feukora.persister.generic.GenericPersisterImpl;
import gruppeB.feukora.persister.util.JpaUtil;


/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * MessungDAO zur Verfügung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class MessungDAOImpl implements MessungDAO {

	@Override
	public void saveMessung(Messung entity) throws Exception {
		new GenericPersisterImpl<Messung>(Messung.class).save(entity);
	}

	@Override
	public Messung updateMessung(Messung entity) throws Exception {
		return new GenericPersisterImpl<Messung>(Messung.class).update(entity);
	}

	@Override
	public void deleteMessung(Messung entity) throws Exception {
		new GenericPersisterImpl<Messung>(Messung.class).delete(entity);
	}

	@Override
	public Messung findMessungById(Integer id) {
		return new GenericPersisterImpl<Messung>(Messung.class).findById(id);
	}

	@Override
	public List<Messung> findAllMessung() {
		return new GenericPersisterImpl<Messung>(Messung.class).findAll();
	}

	@Override
	public List<Messung> findByMessDatum(GregorianCalendar messDatum) {
		
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Messung> tQuery = em.createNamedQuery("Messung.findByMessDatum",
				Messung.class);

		tQuery.setParameter("messDatum", messDatum);

		List<Messung> messungsListe = tQuery.getResultList();

		em.close();

		return messungsListe != null ? messungsListe : new ArrayList<Messung>();
	}

	@Override
	public void deleteMessungById(Integer id) throws Exception {
		new GenericPersisterImpl<Messung>(Messung.class).deleteById(id);
	}

	@Override
	public List<Messung> findByBeurteilungNotOk(boolean beurteilungNotOk) {
		EntityManager em = JpaUtil.createEntityManager();

		TypedQuery<Messung> tQuery = em.createNamedQuery("Messung.findByBeurteilungNotOk",
				Messung.class);

		tQuery.setParameter("beurteilungNotOk", beurteilungNotOk);

		List<Messung> messungsListe = tQuery.getResultList();

		em.close();

		return messungsListe != null ? messungsListe : new ArrayList<Messung>();
	}

}
