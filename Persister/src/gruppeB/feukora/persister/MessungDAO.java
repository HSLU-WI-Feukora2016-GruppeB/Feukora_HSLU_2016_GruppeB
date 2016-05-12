/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.GregorianCalendar;
import java.util.List;

import entitäten.Liegenschaft;
import entitäten.Messung;
import entitäten.Mitarbeiter;

/**
 * Interface für Persistierung von Messung-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface MessungDAO {

		/**
		 * Speichert die übergebene Messung-Entity.
		 * 
		 * @param entity
		 * @throws Exception
		 */
		public void saveMessung(Messung entity) throws Exception;
		
		/**
		 * Updatet die übergebene Messung-Entity.
		 * 
		 * @param entity
		 * @return
		 * @throws Exception
		 */
		public Messung updateMessung(Messung entity) throws Exception;
		
		/**
		 * Löscht die übergebene Messung-Entity.
		 * 
		 * @param entity
		 * @throws Exception
		 */
		public void deleteMessung(Messung entity) throws Exception;
		
		/**
		 * Liefert die Messung-Entity für den übergebenen Id-Wert zurück.
		 * 
		 * @param id
		 * @return
		 */
		public Messung findMessungById(Integer id);
		
		/**
		 * Liefert alle Messung-Objekte zurück.
		 * 
		 * @return
		 */
		public List<Messung> findAllMessung();
		
		/**
		 * Liefert die Liste mit Messungen für die übergebenen Daten zurück, falls
		 * welche gefunden werden. Sonst eine leere Liste.
		 * 
		 * @param messDatum
		 * @return
		 */
		public List<Messung> findByMessDatum(GregorianCalendar messDatum);
		
		/**
		 * Liefert die Liste mit Messungen für die übergebenen Liegenschaften zurück, falls
		 * welche gefunden werden. Sonst eine leere Liste.
		 * 
		 * @param liegenschaft
		 * @return
		 */
		public List<Messung> findByLiegenschaft(Liegenschaft liegenschaft);
				
}
