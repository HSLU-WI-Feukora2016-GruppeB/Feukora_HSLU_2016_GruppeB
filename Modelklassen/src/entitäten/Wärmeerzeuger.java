package entit�ten;

/**
 * W�rmeerzeuger erzeugt W�rme f�r Feuerungsanlage, zusammen mit Brenner
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class W�rmeerzeuger {
	@Id
	@GeneratedValue
	private int id;
	private Brennstoff brennstofftyp;
	private W�rmeerzeugertyp w�rmeerzeugerTyp;

}
