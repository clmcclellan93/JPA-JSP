package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Christian McClellan
 *
 */

@Entity
@Table(name="cars")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	@Column(name="YEAR")
	private int year;

	/**
	 * Default no arg constructor
	 */
	public Car() {
		super();
	}

	/**
	 * @param make
	 * @param model
	 * @param year
	 */
	public Car(String make, String model, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * @return
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @return object details
	 */
	public String returnCarDetails() {
		return make + " - " + model + " - " + year;
	}
	
}
