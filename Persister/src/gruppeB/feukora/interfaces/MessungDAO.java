/*
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.interfaces;

import java.util.GregorianCalendar;
import java.util.List;

import entitys.Messung;

/**
 * Interface f�r Persistierung von Messung-Entities.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface MessungDAO {

		/**
		 * Speichert die �bergebene Messung-Entity.
		 * 
		 * @param entity
		 * @throws Exception
		 */
		public void saveMessung(Messung entity) throws Exception;
		
		/**
		 * Updatet die �bergebene Messung-Entity.
		 * 
		 * @param entity
		 * @return
		 * @throws Exception
		 */
		public Messung updateMessung(Messung entity) throws Exception;
		
		/**
		 * L�scht die �bergebene Messung-Entity.
		 * 
		 * @param entity
		 * @throws Exception
		 */
		public void deleteMessung(Messung entity) throws Exception;
		
		/**
		 * Liefert die Messung-Entity f�r den �bergebenen Id-Wert zur�ck.
		 * 
		 * @param id
		 * @return
		 */
		public Messung findMessungById(Integer id);
		
		/**
		 * L�scht die Messung-Entity f�r den uebergebenen Id-Wert.
		 * 
		 * @param id
		 * @throws Exception
		 */
		public void deleteMessungById(Integer id) throws Exception;
		
		/**
		 * Liefert alle Messung-Objekte zur�ck.
		 * 
		 * @return
		 */
		public List<Messung> findAllMessung();
		
		/**
		 * Liefert die Liste mit Messungen f�r die �bergebenen Daten zur�ck, falls
		 * welche gefunden werden. Sonst eine leere Liste.
		 * 
		 * @param messDatum
		 * @return
		 */
		public List<Messung> findByMessDatum(GregorianCalendar messDatum);
		
		/**
		 * Liefert die Liste mit Messungen wessen Beurteilungen nicht ok sind, falls
		 * welche gefunden werden. Sonst eine leere Liste.
		 * 
		 * @param beurteilungNotOk
		 * @return
		 */
		public List<Messung> findByBeurteilungNotOk(boolean beurteilungNotOk);
				
}
