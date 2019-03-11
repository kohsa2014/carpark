package com.fdm.carparksystem;

public interface ICarParkOperator {

	void initializeCarPark(int numOfSpaces, int oneTruckSpace, float carHourlyRate, float truckHourlyRate);

	String executeCommand(String command);

}
