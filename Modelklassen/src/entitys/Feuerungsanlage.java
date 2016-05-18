package entitys;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.eclipse.persistence.internal.descriptors.CascadeLockingPolicy;
import org.eclipse.persistence.internal.descriptors.DescriptorIterator.CascadeCondition;

/**
 * Eine Feuerungsanlage besteht aus einem Brenner 
 * und einem Wärmeerzeuger sie erzeugt Wärme für eine bestimmt Liegenschaft.
 * @author Olivia
 * @version 1.0
 * @since 1.0
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Feuerungsanlage.findByBrenner", query = "SELECT f FROM Feuerungsanlage f WHERE f.brenner=:brenner"),
	@NamedQuery(name = "Feuerungsanlage.findByWaermeerzeuger", query = "SELECT f FROM Feuerungsanlage f WHERE f.waermeerzeuger=:waermeerzeuger"),
	@NamedQuery(name = "Feuerungsanlage.findById", query = "SELECT f FROM Feuerungsanlage f WHERE f.id=:id")
})
public class Feuerungsanlage implements Serializable{
	
	private static final long serialVersionUID = -4675827977388169401L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Brenner brenner;
	
	@ManyToOne
	private Waermeerzeuger waermeerzeuger;
	
	//konstruktor**************************************************
	public Feuerungsanlage(){
		
	}
	
	public Feuerungsanlage(Brenner brenner, Waermeerzeuger waermeerzeuger){
		this.brenner = brenner;
		this.waermeerzeuger = waermeerzeuger;
	}

	//getter&setter********************************************************
	public Integer getIdFeuerungsanlage() {
		return id;
	}

	public void setIdFeuerungsanlage(Integer idFeuerungsanlage) {
		this.id = idFeuerungsanlage;
	}

	public Brenner getBrenner() {
		return brenner;
	}

	public void setBrenner(Brenner brenner) {
		this.brenner = brenner;
	}

	public Waermeerzeuger getWaermeerzeuger() {
		return waermeerzeuger;
	}

	public void setWaermeerzeuger(Waermeerzeuger waermeerzeuger) {
		this.waermeerzeuger = waermeerzeuger;
	}
	
	@Override
	public String toString() {
		return "Feuerungsanlage: " + "\n"
				+ "Brenner: \t \t \t" + brenner + "\n"
				+ "Waermeerzeuger: \t \t \t" + waermeerzeuger + "\n";
	}

}
