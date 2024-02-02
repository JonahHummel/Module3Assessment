package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rentals")
public class Rental {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="MAKE")
	private String make;
	@Column(name="MODEL")
	private String model;
	@Column(name="YEAR")
	private int year;
	
	public Rental() {
		super();
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public String rentalDetails() {
		return this.year + " " + this.make + " " + this.model;
	}
	public Rental(String make, String model, int year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	
	
}
