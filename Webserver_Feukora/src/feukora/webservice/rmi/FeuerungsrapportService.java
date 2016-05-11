/*
 * ZWECK: Feukora Feuerungsrapport Webservice
 * MODUL: Softwarekompomenten, HSLU-Wirtschaft
 * 
 * Copyright (c)
 */
package feukora.webservice.rmi;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Interface für Feuerungsrapport-System als Webservice.
 * 
 * @author Dominik
 * @version 1.0.0
 * @since 1.0.0
 * 
 */
@WebService
public interface FeuerungsrapportService {
	
	//Liegenschaft
	/**
	 * Speichert die übergebene Entity.
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft addLiegenschaft(
			@WebParam(name = "Liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Updated die übergebene Entity
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft updateiegenschaft(
			@WebParam(name = "Liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Löscht die übergebene Entity.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteLiegenschaft(
			@WebParam(name = "Liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Sucht und liefert die Entity für den übergebenen Id Wert zurück.
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft findLiegenschaftById(
			@WebParam(name = "id") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Sucht und liefert alle Entity-Objekte zurück
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Liegenschaft> findAllLiegenschaft() throws Exception
	
	/**
	 * Liefert die Liste mit Liegenschaften für die übergebenen Postleitzahl und Ort zurück, 
	 * falls welche gefunden wurden, sonst eine leere Liste.
	 * 
	 * @param postleitzahl
	 * @param ort
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Liegenschaft> findLiegenschaftByPostleitzahlUndOrt(
			@WebParam(name = "postleitzahl") int postleitzahl,
			@WebParam(name = "ort")String ort) throws Exception;

	/**
	 * Liefert die Liste mit Liegenschaften für den übergebenen Eigentümer zurück, 
	 * falls welche gefunden wurden, sonst eine leere Liste.
	 * 
	 * @param eigentuemer
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft findLiegenschaftByEigentuemer(
			@WebParam(name = "eigentuemer") String eigentuemer)throws Exception;
	
	

	/**
	 * Liefert die Liste mit Liegenschaften für den übergebenen Brenner zurück, 
	 * falls welche gefunden wurden, sonst eine leere Liste.
	 * 
	 * @param brenner
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft findLiegenschaftByBrenner(
			@WebParam(name = "brenner") String brenner)throws Exception;

	/**
	 * Liefert die Liste mit Liegenschaften für den übergebenen Waermeerzeuger zurück, 
	 * falls welche gefunden wurden, sonst eine leere Liste.
	 * 
	 * @param waermeerzeuger
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	Liegenschaft findLiegenschaftByWaermeerzeuger(
			@WebParam(name = "waermeerzeuger") String waermeerzeuger)throws Exception;
	
	//

}