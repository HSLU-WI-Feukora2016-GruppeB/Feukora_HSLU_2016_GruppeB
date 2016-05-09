package entit�ten;

/**
 * Eine Feuerungsanlage besteht aus einem Brenner 
 * und einem W�rmeerzeuger sie erzeugt W�rme f�r eine bestimmt Liegenschaft.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
@Entity
@Data
public class Feuerungsanlage {
	
	@Id
	@GeneratedValue
	private int id;
	private Liegenschaft liegenschaft;
	private Brenner brenner;
	private W�rmeerzeuger w�rmeerzeuger;
	

}
