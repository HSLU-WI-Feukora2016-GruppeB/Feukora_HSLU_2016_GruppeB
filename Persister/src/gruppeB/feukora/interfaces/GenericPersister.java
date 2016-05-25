package gruppeB.feukora.interfaces;

import java.util.List;

/**
 * Interface für CRUD-Basisoperation.
 *
 * @author Luca Raneri
 * @version 1.0
 * @param <T>
 */
public interface GenericPersister<T> {

	/**
	 * Speichert die übergebene Entity.
	 *
	 * @param entity
	 * @throws Exception
	 */
	void save(T entity) throws Exception;

	/**
	 * Updated die übergebene Entity.
	 *
	 * @param entity
	 * @return T
	 * @throws Exception
	 */
	T update (T entity) throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 *
	 * @param entity
	 * @throws Exception
	 */
	void delete (T entity) throws Exception;

	/**
	 * Löscht die Entity für den übergebenen Id-Wert.
	 *
	 * @param id
	 * @throws Exception
	 */
	void deleteById (Integer id) throws Exception;

	/**
	 * Liefert die Entity für den übergebenen Id-Wert.
	 *
	 * @param id
	 * @return T
	 * @throws Exception
	 */
	T findById (Integer id) throws Exception;

	/**
	 * Liefert alle Entity-Objekte zurück.
	 *
	 * @return List<T>
	 * @throws Exception
	 */
	List<T> findAll() throws Exception;
}
