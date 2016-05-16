package managerInterfaces;

import java.util.List;

import entit�ten.Benutzer;
import entit�ten.Ort;

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
 * Passt den �bergebenen Ort an.
 * 
 * @param entity
 * @return
 * @throws Exception
 */
public Ort update(Ort entity) throws Exception;

/**
 * L�scht den �bergebenen Ort.
 * 
 * @param entity
 * @return
 * @throws Exception
 */
public void delete(Ort entity) throws Exception;

/**
 * L�scht den �bergebenen Ort mithilfe seiner Id.
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
public Ort findById(Integer plz);

/**
 * Liefert einen Ort anhand der gesuchten Ortsbezeichnung.
 * 
 * @param ortBez
 * @return
 */
public List<Ort> findByOrtBez(String ortBez);

/**
 * Liefert alle Benutzer zur�ck.
 * 
 * @return
 */
public List<Ort> findAll();

}
