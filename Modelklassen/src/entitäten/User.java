package entitäten;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Enthält Benutzerdaten für die Anmeldung.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
@Entity
public class User implements Serializable{

	private static final long serialVersionUID = -7225618836803933212L;
	
	@Id
	@GeneratedValue
	private Integer idUser;
	
	private String username;
	private String password;
	
	//Standardkonstruktor
	public User(){
		
	}

	//getter&setter
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
