package entitäten;
/**
 * Brennertyp definiert den Brenner.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@Data
public class Brennertyp {
	
	@Id
	@GeneratedValue
	private int id;
	private String brennerTyp;
	
}
