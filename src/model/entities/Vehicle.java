package model.entities;

public class Vehicle {

	private String carModel;
	
	public Vehicle(String carModel) {
		setCarModel(carModel);
	}
	
	public void setCarModel(String car) {
		this.carModel = car;
	}
	
	public String getCarModel() {
		return this.carModel;
	}
	
}
