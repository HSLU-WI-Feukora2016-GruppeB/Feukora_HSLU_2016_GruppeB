/**
 * ZWECK: Praxisprojekt Feukora
 * MODUL: Softwarekomponenten, HSLU - Wirtschaft
 */

package gruppeB.feukora.persister;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * Diese Klasse stellt die Implementierung von Methoden der Schnittstelle
 * W�rmeerzeugerDAO zur Verf�gung.
 * 
 * @version 1.0
 * @author Luca Raneri
 * 
 */
public class W�rmeerzeugerDAOImpl implements W�rmeerzeugerDAO{

	@Override
	public void saveW�rmeerzeuger(W�rmeerzeuger entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public W�rmeerzeuger updateW�rmeerzeuger(W�rmeerzeuger entity)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteW�rmeerzeuger(W�rmeerzeuger entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteW�rmeerzeugerById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public W�rmeerzeuger findW�rmeerzeugerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<W�rmeerzeuger> findAllW�rmeerzeuger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<W�rmeerzeuger> findW�rmeerzeugerByBezeichnung(String bezeichnung) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<W�rmeerzeuger> findW�rmeerzeugerByBaujahr(Integer baujahr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<W�rmeerzeuger> findW�rmeerzeugerByBrennstoff(String brennstoff) {
		// TODO Auto-generated method stub
		return null;
	}

}
