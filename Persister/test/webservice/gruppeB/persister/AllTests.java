package webservice.gruppeB.persister;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * AllTests
 * @version 1.0
 * @author Luca Raneri
 */
@RunWith(Suite.class)
@SuiteClasses({ AuftragDAOTest.class, BenutzerDAOTest.class,
		BrennerDAOTest.class, FeuerungsanlageDAOTest.class,
		KontaktDAOTest.class, LiegenschaftDAOTest.class, MessungDAOTest.class,
		MitarbeiterDAOTest.class, OrtDAOTest.class, WaermeerzeugerDAOTest.class })
public class AllTests {

}
