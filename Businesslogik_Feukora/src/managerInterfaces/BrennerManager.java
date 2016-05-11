package managerInterfaces;

import java.util.List;

import entit�ten.Brenner;


/**
 * Handelt Brenner Funktionalit�t.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface BrennerManager {
	
	/**
	 * Speichert einen Brenner.
	 * @param entit�t
	 * @return
	 * @throws Exception
	 */
	public Brenner add(Brenner entit�t) throws Exception;
	
	/**
	 * Passt einen Brenner an.
	 * @param entit�t
	 * @return
	 * @throws Exception
	 */
	public Brenner update(Brenner entit�t) throws Exception;
	
	/**
	 * L�scht den mitgegebenen Brenner.
	 * @param entit�t
	 * @throws Exception
	 */
	public void delete(Brenner entit�t) throws Exception;
	
	/**
	 * Liefert Liste aller Brenner.
	 * @return
	 */
	public List<Brenner> findAll();
	
	/**
	 * Liefert alle Brenner des angefragten Typs.
	 * @param brennerTyp
	 * @return
	 */
	public List<Brenner> findByTyp(String brennerTyp);
	
	/**
	 * Liefert alle Brenner der angefragten Art.
	 * @param brennerArt
	 * @return
	 */
	public List<Brenner> findByArt(String brennerArt);
	
}
