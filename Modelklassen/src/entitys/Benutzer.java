package entitys;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Enthält Benutzerdaten für die Anmeldung.
 * @author Matthias
 * @version 1.0
 * @since 1.0
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Benutzer.findById", query = "SELECT b FROM Benutzer b WHERE b.id=:id"),
	@NamedQuery(name = "Benutzer.findByUsername", query = "SELECT b FROM Benutzer b WHERE b.username=:username"),
	@NamedQuery(name = "Benutzer.findByUsernamePassword", query = "SELECT b FROM Benutzer b WHERE b.username=:username AND b.password=:password")
})
public class Benutzer implements Serializable{

	private static final long serialVersionUID = -7225618836803933212L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String username;
	private String password;
	
	//konstruktor**************************************************
	public Benutzer(){
		
	}
	
	public Benutzer(String username, String password){
		this.username = username;
		this.password = password;
	}

	//getter&setter********************************************************
	public Integer getIdUser() {
		return id;
	}

	public void setIdUser(Integer idUser) {
		this.id = idUser;
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
	
	@Override
	public String toString() {
		return "Benutzerdaten:" + "\n" 
				+ "Benutzername: \n" + username + "\n"
				+ "Password: \t \t \t" + "***" + "\n";
	}
	
	
}
