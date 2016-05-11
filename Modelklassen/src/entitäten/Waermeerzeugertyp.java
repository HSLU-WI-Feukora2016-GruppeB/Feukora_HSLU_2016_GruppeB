package entit�ten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * W�rmeerzeugertyp beschreibt W�rmerzeuger.
 * @author Olivia
 * @version 1.0
 * @since 1.0
**/
@Entity
public class Waermeerzeugertyp implements Serializable{
	
	private static final long serialVersionUID = -1297911003197604574L;
	
	@Id
	@GeneratedValue
	private int idW�rmeerzeugertyp;
	
	private String w�rmeerzeugertypBezeichnung;

	//standardkonstruktor
	public W�rmeerzeugertyp(){
		
	}

	//getter&setter
	public int getIdW�rmeerzeugertyp() {
		return idW�rmeerzeugertyp;
	}

	public void setIdW�rmeerzeugertyp(int idW�rmeerzeugertyp) {
		this.idW�rmeerzeugertyp = idW�rmeerzeugertyp;
	}

	public String getW�rmeerzeugertypBezeichnung() {
		return w�rmeerzeugertypBezeichnung;
	}

	public void setW�rmeerzeugertypBezeichnung(String w�rmeerzeugertypBezeichnung) {
		this.w�rmeerzeugertypBezeichnung = w�rmeerzeugertypBezeichnung;
	}
	
	
}
