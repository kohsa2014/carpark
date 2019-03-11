package com.fdm.carparksystem;

public class CarParkFactory {

	public CarPark createCarPark(int numOfSpaces, int oneTruckSpace, float carHourlyRate, float truckHourlyRate) {
		return new CarPark(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
}
