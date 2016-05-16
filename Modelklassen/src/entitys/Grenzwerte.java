package entitys;

/**
 * Grenzwerte für die einzelnen Brennerarten, können sich ändern wenn die
 * Luftreinhalteverordnung sich ändert. Sind nicht in Datenbank gespeichert.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 *
 */
public class Grenzwerte {
	
	private int maxRusszahl;
	
	private int maxCoGehalt;
	
	private boolean hasOelanteil;
	
	private int maxNo2mg;
	
	private int maxAbgasverluste;

	
	//konstruktor
	public Grenzwerte(){
		
	}
	
	public Grenzwerte(int maxRusszahl, int maxKohlenstoff,
			boolean hasOelanteil, int maxNo2mg, int maxAbgasverluste) {
		this.maxRusszahl = maxRusszahl;
		this.maxCoGehalt = maxKohlenstoff;
		this.hasOelanteil = hasOelanteil;
		this.maxNo2mg = maxNo2mg;
		this.maxAbgasverluste = maxAbgasverluste;
	}

	public int getMaxRusszahl() {
		return maxRusszahl;
	}

	public void setMaxRusszahl(int maxRusszahl) {
		this.maxRusszahl = maxRusszahl; 
	}

	public int getMaxCoGehalt() {
		return maxCoGehalt;
	}

	public void setMaxCoGehalt(int coGehalt) {
		this.maxCoGehalt = coGehalt;
	}

	public boolean isHasOelanteil() {
		return hasOelanteil;
	}

	public void setHasOelanteil(boolean hasOelanteil) {
		this.hasOelanteil = hasOelanteil;
	}

	public int getMaxNo2mg() {
		return maxNo2mg;
	}

	public void setMaxNo2mg(int maxNo2mg) {
		this.maxNo2mg = maxNo2mg;
	}

	public int getMaxAbgasverluste() {
		return maxAbgasverluste;
	}

	public void setMaxAbgasverluste(int maxAbgasverluste) {
		this.maxAbgasverluste = maxAbgasverluste;
	}

}
