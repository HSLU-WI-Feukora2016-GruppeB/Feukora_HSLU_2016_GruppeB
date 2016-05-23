package managerInterfaces;

import java.util.List;

import entitys.Ort;

/**
 * Verwaltet einen Ort und alle Funktionen.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public interface OrtManager {

/**
 * Speichert einen Ort.
 * 
 * @param entity
 * @return
 * @throws Exception
 */
public Ort add(Ort entity) throws Exception;

/**
 * Passt den übergebenen Ort an.
 * 
 * @param entity
 * @return
 * @throws Exception
 */
public Ort update(Ort entity) throws Exception;

/**
 * Löscht den übergebenen Ort.
 * 
 * @param entity
 * @return
 * @throws Exception
 */
public void delete(Ort entity) throws Exception;

/**
 * Löscht den übergebenen Ort mithilfe seiner Id.
 * 
 * @param plz
 * @return
 * @throws Exception
 */
public void deleteById(Integer plz) throws Exception;

/**
 * Liefert einen Ort anhand der gesuchten Id.
 * 
 * @param plz
 * @return
 */
public Ort findById(Integer idOrt) throws Exception;

/**
 * Liefert einen Ort anhand der gesuchten Ortsbezeichnung.
 * 
 * @param ortBez
 * @return
 */
public List<Ort> findByOrtBez(String ortBez) throws Exception;

/**
 * Liefert einen Ort anhand der gesuchten Ortsbezeichnung.
 * 
 * @param plz
 * @return
 */
public List<Ort> findByPlz(int plz) throws Exception;

/**
 * Liefert alle Benutzer zurück.
 * 
 * @return
 */
public List<Ort> findAll() throws Exception;

}
