package managerInterfaces;

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
	 * Liefert Brenner der gesuchten BrennerId.
	 * @param id
	 * @return
	 */
	public Brenner findById(int id);
	
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
	public Brenner findByBrennertyp(String brennerTyp);
	
	/**
	 * Liefert alle Brenner der angefragten Art.
	 * @param brennerArt
	 * @return
	 */
	public Brenner findByBrennerArt(String brennerArt);
	
}
