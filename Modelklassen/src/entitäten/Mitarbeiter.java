package entitäten;

/**
 * Ein Mitarbeiter ist eine Person welche nur Firmenintern zu tun hat,
 * sie ist entweder Sachbearbeiter oder Feuerungskontrolleur.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class Mitarbeiter{
	@Id
	@GeneratedValue
	private int id;
	private String vorname;
	private String nachname;
	private Adresse adresse;
	private int tel;
	private String email;
	private RolleIntern rolleIntern;
	private int lohn;
	private GregorianCalendar arbeitetSeit;
	private GregorianCalendar arbeitetBis;
	
	

}
