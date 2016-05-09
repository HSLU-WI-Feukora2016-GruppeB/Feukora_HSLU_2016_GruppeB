package entitäten;

/**
 * Brennstoff treibt Brenner an.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
@Entity
@Data
public class Brennstoff {
	
	@Id
	@GeneratedValue
	private int id;
	private String brennerBezeichnung;

}
