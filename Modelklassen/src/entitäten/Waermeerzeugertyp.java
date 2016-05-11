package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Wärmeerzeugertyp beschreibt Wärmerzeuger.
 * @author Olivia
 * @version 1.0
 * @since 1.0
**/
@Entity
public class Waermeerzeugertyp implements Serializable{
	
	private static final long serialVersionUID = -1297911003197604574L;
	
	@Id
	@GeneratedValue
	private int idWärmeerzeugertyp;
	
	private String wärmeerzeugertypBezeichnung;

	//standardkonstruktor
	public Wärmeerzeugertyp(){
		
	}

	//getter&setter
	public int getIdWärmeerzeugertyp() {
		return idWärmeerzeugertyp;
	}

	public void setIdWärmeerzeugertyp(int idWärmeerzeugertyp) {
		this.idWärmeerzeugertyp = idWärmeerzeugertyp;
	}

	public String getWärmeerzeugertypBezeichnung() {
		return wärmeerzeugertypBezeichnung;
	}

	public void setWärmeerzeugertypBezeichnung(String wärmeerzeugertypBezeichnung) {
		this.wärmeerzeugertypBezeichnung = wärmeerzeugertypBezeichnung;
	}
	
	
}
