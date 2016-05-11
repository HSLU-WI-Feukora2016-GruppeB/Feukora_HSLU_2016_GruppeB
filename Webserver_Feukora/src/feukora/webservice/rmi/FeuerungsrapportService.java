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
 * Interface f�r Feuerungsrapport-System als Webservice.
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
	 * Speichert die �bergebene Entity.
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
	 * Updated die �bergebene Entity
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
	 * L�scht die �bergebene Entity.
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	void deleteLiegenschaft(
			@WebParam(name = "Liegenschaft") Liegenschaft liegenschaft)
			throws Exception;

	/**
	 * Sucht und liefert die Entity f�r den �bergebenen Id Wert zur�ck.
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
	 * Sucht und liefert alle Entity-Objekte zur�ck
	 * 
	 * @return
	 * @throws Exception
	 */
	@WebMethod
	List<Liegenschaft> findAllLiegenschaft() throws Exception
	
	/**
	 * Liefert die Liste mit Liegenschaften f�r die �bergebenen Postleitzahl und Ort zur�ck, 
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
	 * Liefert die Liste mit Liegenschaften f�r den �bergebenen Eigent�mer zur�ck, 
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
	 * Liefert die Liste mit Liegenschaften f�r den �bergebenen Brenner zur�ck, 
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
	 * Liefert die Liste mit Liegenschaften f�r den �bergebenen Waermeerzeuger zur�ck, 
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