package webservice.gruppeB.persister;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * AllTests Suite
 * @author Luca Raneri
 * @version 1.0
 * @since 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({ AuftragDAOTest.class, BenutzerDAOTest.class,
		BrennerDAOTest.class, FeuerungsanlageDAOTest.class,
		KontaktDAOTest.class, LiegenschaftDAOTest.class, MessungDAOTest.class,
		MitarbeiterDAOTest.class, OrtDAOTest.class, WaermeerzeugerDAOTest.class })
public class AllTests {

}
