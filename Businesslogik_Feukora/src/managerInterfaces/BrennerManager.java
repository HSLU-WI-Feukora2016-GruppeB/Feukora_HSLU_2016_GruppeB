package managerInterfaces;

import java.util.List;

import entitäten.Brenner;


/**
 * Handelt Brenner Funktionalität.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface BrennerManager {
	
	/**
	 * Speichert einen Brenner.
	 * @param entität
	 * @return
	 * @throws Exception
	 */
	public Brenner add(Brenner entität) throws Exception;
	
	/**
	 * Passt einen Brenner an.
	 * @param entität
	 * @return
	 * @throws Exception
	 */
	public Brenner update(Brenner entität) throws Exception;
	
	/**
	 * Löscht den mitgegebenen Brenner.
	 * @param entität
	 * @throws Exception
	 */
	public void delete(Brenner entität) throws Exception;
	
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
