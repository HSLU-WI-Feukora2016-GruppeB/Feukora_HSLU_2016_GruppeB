package testManager;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AuftragManagerTest.class, BenutzerManagerTest.class,
		BrennerManagerTest.class, FeuerungsanlageManagerTest.class,
		KontaktManagerTest.class, LiegenschaftManagerTest.class,
		MessungManagerTest.class, MitarbeiterManagerTest.class,
		OrtManagerTest.class, WaermeerzeugerManagerTest.class })
public class AllTests {

}
