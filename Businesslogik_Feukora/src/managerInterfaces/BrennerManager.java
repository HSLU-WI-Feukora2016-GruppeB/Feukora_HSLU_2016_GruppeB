package managerInterfaces;

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
