package entitäten;

/**
 * Wärmeerzeuger erzeugt Wärme für Feuerungsanlage, zusammen mit Brenner
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class Wärmeerzeuger {
	@Id
	@GeneratedValue
	private int id;
	private Brennstoff brennstofftyp;
	private Wärmeerzeugertyp wärmeerzeugerTyp;

}
