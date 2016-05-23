package entitys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Eine Feuerungsanlage besteht aus einem Brenner
 * und einem W�rmeerzeuger sie erzeugt W�rme f�r eine bestimmt Liegenschaft.
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

	private int feuerungswaermeleistung;

	//konstruktor**************************************************
	public Feuerungsanlage(){

	}

	public Feuerungsanlage(Brenner brenner, Waermeerzeuger waermeerzeuger, int feuerungswaermeleistung){
		this.brenner = brenner;
		this.waermeerzeuger = waermeerzeuger;
		this.feuerungswaermeleistung = feuerungswaermeleistung;
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

	public int getFeuerungswaermeleistung() {
		return feuerungswaermeleistung;
	}

	public void setFeuerungswaermeleistung(int feuerungswaermeleistung) {
		this.feuerungswaermeleistung = feuerungswaermeleistung;
	}

	@Override
	public String toString() {
		return "Feuerungsanlage: " + "\n"
				+ "Feuerungsw�rmeleistung KW: " + feuerungswaermeleistung
				+ "Brenner: " + brenner.toString() + "\n"
				+ "Waermeerzeuger: " + waermeerzeuger.toString() + "\n";
	}



}
