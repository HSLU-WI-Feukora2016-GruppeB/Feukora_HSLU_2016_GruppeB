package gruppeB.feukora.interfaces;

import java.util.List;

import entitys.Kontakt;
import entitys.Ort;

/**
 * Interface f�r Persistierung von Kontakt-Entities.
 * @since 1.0
 * @version 1.0
 * @author Luca Raneri
 *
 */
public interface KontaktDAO {

	/**
	 * Speichert die �bergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void saveKontakt(Kontakt entity) throws Exception;
	
	/**
	 * Updatet die �bergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @return Kontakt
	 * @throws Exception
	 */
	public Kontakt updateKontakt(Kontakt entity) throws Exception;
	
	/**
	 * L�scht die �bergebene Kontakt-Entity.
	 * 
	 * @param entity
	 * @throws Exception
	 */
	public void deleteKontakt(Kontakt entity) throws Exception;
	
	/**
	 * L�scht die Kontakt-Entity f�r den �bergebenen Id-Wert.
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void deleteKontaktById(Integer id) throws Exception;
	
	/**
	 * Liefert die Kontakt-Entity f�r den �bergebenen Id-Wert zur�ck.
	 * 
	 * @param idKontakt
	 * @return Kontakt
	 * @throws Exception
	 */
	public Kontakt findKontaktById(Integer idKontakt) throws Exception;
	
	/**
	 * Liefert alle Kontakt-Objekte zur�ck.
	 * 
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findAllKontakte() throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten f�r die �bergebene Namen zur�ck, falls
	 * welche gefunden werden. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByName(String name) throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten f�r den �bergebenen Vornamen zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param vorname
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByVorname(String vorname) throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten f�r den �bergebenen Namen und Vornamen zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param name
	 * @param vorname
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByNameVorname(String name, String vorname) throws Exception;

	/**
	 * Liefert die Liste mit den Kontakten f�r den �bergebenen Ort zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param ort
	 * @return List<Kontakt>
	 * @throws Exception
	 */	
	public List<Kontakt> findKontaktByOrt(Ort ort) throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten f�r die �bergebene Rolle zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param rolleExtern
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByRolleExtern(int rolleExtern) throws Exception;
	
	/**
	 * Liefert die Liste mit den Kontakten f�r die �bergebene Strasse zur�ck,
	 * falls es welche gibt. Sonst eine leere Liste.
	 * 
	 * @param strasse
	 * @return List<Kontakt>
	 * @throws Exception
	 */
	public List<Kontakt> findKontaktByStrasse(String strasse) throws Exception;
}
