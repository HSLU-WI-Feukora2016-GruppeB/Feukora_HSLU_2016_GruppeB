package gruppeB.feukora.persister.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Diese Klasse bildet eine Hilfsklasse ab, die sich um die Erstellung der
 * EntityManager-Instanz kümmert.
 * 
 * @version 1.0
 * @author Luca Raneri
 *
 */
public class JpaUtil {

	private static EntityManagerFactory entityManagerFactory = null;
	
	static {
		try {
			/* EntityManagerFactory erzeugen */
			entityManagerFactory = Persistence
					.createEntityManagerFactory("Feukora");
		} catch (Throwable e) {
			/* TODO - Fehlerbehandlung … */
			e.printStackTrace();
		}
	}

	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

}
