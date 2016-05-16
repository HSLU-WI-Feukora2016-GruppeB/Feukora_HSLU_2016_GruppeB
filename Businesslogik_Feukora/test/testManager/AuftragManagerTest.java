package testManager;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import managerInterfaces.AuftragManager;
import managerInterfaces.OrtManager;
import managerKlassen.AuftragManagerImpl;
import managerKlassen.OrtManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entitys.*;


public class AuftragManagerTest {
	
	AuftragManager auftragManager = new AuftragManagerImpl();

	@Before
	public void setUp() throws Exception{
		
		List<Auftrag> aListe = auftragManager.findAll();

		for (Auftrag a : aListe) {
			auftragManager.delete(a);
		}
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void testAdd() throws Exception{
		Ort ort = new Ort(6003, "Luzern");
		Kontakt kontakt = new Kontakt("Olivia", "Wassmer", "Hirschengraben 40", ort, "0448817585", "olivia.wassmer@stud.hslu.ch", 1);
		
		Brenner brenner = new Brenner(1, "abc123", 2014);
		Waermeerzeuger waermeerzeuger = new Waermeerzeuger(2, "cba321", 2003);
		Feuerungsanlage feuerungsanlage = new Feuerungsanlage(brenner, waermeerzeuger);
		Liegenschaft liegenschaft = new Liegenschaft(kontakt, "Hausmeister bei Müller klingeln", "Teststrasse 123", ort, feuerungsanlage);

		Messung messung1 = new Messung();
		Messung messung2 = new Messung();
		Messung messung3 = new Messung();
		Messung messung4 = new Messung();
		
		Benutzer benutzer = new Benutzer("dstirni", "abc123");
		GregorianCalendar seit = new GregorianCalendar(2016, 01, 15);
		GregorianCalendar bis = null;
		Mitarbeiter mitarbeiter = new Mitarbeiter("Stirnimann", "Dominik", "Testibusstrasse 456", ort, "0441234567", "dominik.stirnimann@stud.hslu.ch", 3, benutzer, 1500, seit, bis);		
		
		GregorianCalendar datum = new GregorianCalendar(2016, 11, 12);
		int zeitSlot = 3;
		int terminArt = 2;
		Auftrag auftrag = new Auftrag(kontakt, liegenschaft, mitarbeiter, datum, zeitSlot, terminArt);

		auftragManager.add(auftrag);

		//check ist nun 1 auftrag in auftragliste?
		assertTrue(auftragManager.findAll().size() == 1);

	}
	

}
