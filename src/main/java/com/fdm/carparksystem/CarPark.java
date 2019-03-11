package com.fdm.carparksystem;

public class CarPark {

	private final int numOfSpaces;
	private final int oneTruckSpace;
	private final float carHourlyRate;
	private final float truckHourlyRate;
	
	private int parkingCars;
	private int parkingTrucks;
	private int enteredCars;
	private int enteredTrucks;
	private int exitedCars; 
	private int exitedTrucks;
	private double totalFees;
	
	public CarPark(int numOfSpaces, int oneTruckSpace, float carHourlyRate, float truckHourlyRate) {
		this.numOfSpaces = numOfSpaces;
		this.oneTruckSpace = oneTruckSpace;
		this.carHourlyRate = carHourlyRate;
		this.truckHourlyRate = truckHourlyRate;
		parkingCars = 0 ;
		parkingTrucks = 0;
		enteredCars = 0;
		enteredTrucks = 0;
		exitedCars = 0;
		exitedTrucks = 0; 
		totalFees = 0.0;
		
	}

	public int getNumOfSpaces() {
		return numOfSpaces;
	}

	public int getOneTruckSpace() {
		return oneTruckSpace;
	}

	public float getCarHourlyRate() {
		return carHourlyRate;
	}

	public float getTruckHourlyRate() {
		return truckHourlyRate;
	}

	public int getParkingCars() {
		return parkingCars;
	}

	public int getParkingTrucks() {
		return parkingTrucks;
	}

	public int getEnteredCars() {
		return enteredCars;
	}

	public int getEnteredTrucks() {
		return enteredTrucks;
	}

	public int getExitedCars() {
		return exitedCars;
	}

	public int getExitedTrucks() {
		return exitedTrucks;
	}

	public double getTotalFees() {
		return totalFees;
	}

	public void addCar() {
		parkingCars++;
		enteredCars++;
	}

	public void addTruck() {
		parkingTrucks++;
		enteredTrucks++;
	}

	public void removeCar(int hours) {
		parkingCars--;
		exitedCars++;
		totalFees += carHourlyRate * hours;
	}

	public void removeTruck(int hours) {
		parkingTrucks--;
		exitedTrucks++;
		totalFees += truckHourlyRate * hours;
	}
}
