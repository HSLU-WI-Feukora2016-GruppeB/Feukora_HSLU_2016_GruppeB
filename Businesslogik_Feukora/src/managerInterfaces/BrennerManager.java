package managerInterfaces;

import java.util.List;

import entitys.Brenner;


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
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Brenner add(Brenner entity) throws Exception;
	
	/**
	 * Passt einen Brenner an.
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Brenner update(Brenner entity) throws Exception;
	
	/**
	 * Löscht den mitgegebenen Brenner.
	 * @param entity
	 * @throws Exception
	 */
	public void delete(Brenner entity) throws Exception;
	
	/**
	 * Löscht den Brenner mithilfe seiner Id.
	 * @param entity
	 * @throws Exception
	 */
	public void deleteById(Integer idBrenner) throws Exception;
	
	/**
	 * Liefert Brenner mithilfe seiner Id.
	 * @return
	 * @throws Exception
	 */
	public Brenner findById(Integer id);
	
	/**
	 * Liefert Liste aller Brenner.
	 * @return
	 * @throws Exception
	 */
	public List<Brenner> findAll();
	
	/**
	 * Liefert alle Brenner des angefragten Typs.
	 * @param brennerTyp
	 * @return
	 * @throws Exception
	 */
	public List<Brenner> findByTyp(String brennerTyp);
	
	/**
	 * Liefert alle Brenner der angefragten Art.
	 * @param brennerArt
	 * @return
	 * @throws Exception
	 */
	public List<Brenner> findByArt(int brennerArt);
	
	/**
	 * Liefert alle Brenner mit angefragtem Baujahr.
	 * @param baujahr
	 * @return
	 * @throws Exception
	 */
	public List<Brenner> findByBaujahr(int baujahr);
	
}
