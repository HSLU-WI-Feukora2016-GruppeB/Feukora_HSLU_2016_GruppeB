package gruppeB.feukora.interfaces;

import java.util.List;

/**
 * Interface f�r CRUD-Basisoperation.
 *
 * @author Luca Raneri
 * @version 1.0
 * @param <T>
 */
public interface GenericPersister<T> {

	/**
	 * Speichert die �bergebene Entity.
	 *
	 * @param entity
	 * @throws Exception
	 */
	void save(T entity) throws Exception;

	/**
	 * Updated die �bergebene Entity.
	 *
	 * @param entity
	 * @return T
	 * @throws Exception
	 */
	T update (T entity) throws Exception;

	/**
	 * L�scht die �bergebene Entity.
	 *
	 * @param entity
	 * @throws Exception
	 */
	void delete (T entity) throws Exception;

	/**
	 * L�scht die Entity f�r den �bergebenen Id-Wert.
	 *
	 * @param id
	 * @throws Exception
	 */
	void deleteById (Integer id) throws Exception;

	/**
	 * Liefert die Entity f�r den �bergebenen Id-Wert.
	 *
	 * @param id
	 * @return T
	 * @throws Exception
	 */
	T findById (Integer id) throws Exception;

	/**
	 * Liefert alle Entity-Objekte zur�ck.
	 *
	 * @return List<T>
	 * @throws Exception
	 */
	List<T> findAll() throws Exception;
}
