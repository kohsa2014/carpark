package com.fdm.carparksystem;

public class CarParkOperator implements ICarParkOperator{

	private final CarParkFactory carParkFactory;
	private CarPark carPark;
	
	public CarParkOperator(CarParkFactory carParkFactory) {
		this.carParkFactory = carParkFactory;
	}

	public void initializeCarPark(int numOfSpaces, int oneTruckSpace, float carHourlyRate, float truckHourlyRate) {
		carPark = carParkFactory.createCarPark(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}

	@Override
	public String executeCommand(String command) {
		command = command.trim();
		String response="";
		if("REPORT".equals(command)) {
			response = getReport();
		}
		else if("ENTER CAR".equals(command)) {
			response = parkCar();
			
		}else if("ENTER TRUCK".equals(command)) {
			response = parkTruck();
		}else if(command.contains("EXIT CAR")) {
			response = removeCar(getHours(command));
		}else
		{
			response = removeTruck(getHours(command));
		}
		return response;
	}

	private String removeTruck(int hours) {
		if(carPark.getParkingTrucks() > 0) {
			carPark.removeTruck(hours);
			return "";
		}
		else return "No truck parked";
	}

	private String removeCar(int hours) {
		if(carPark.getParkingCars() > 0) {
			carPark.removeCar(hours);
			return "";
		}
		else return "No car parked";
	}

	private String parkTruck() {
		if(isTruckSpaceAvailable()) {
			carPark.addTruck();
			return "";
		}
		else return "space not available";	}

	private String parkCar() {
		if(isCarSpaceAvailable()) {
			carPark.addCar();
			return "";
		}
		else return "space not available";
	}


	private int parkingSpaceAvailable() {
		return carPark.getNumOfSpaces() - carPark.getParkingCars() - (carPark.getParkingTrucks()*carPark.getOneTruckSpace());
	}
	
	private boolean isCarSpaceAvailable() {
		return(parkingSpaceAvailable() >= 1);
	}
	
	private boolean isTruckSpaceAvailable() {
		return(parkingSpaceAvailable() >= carPark.getOneTruckSpace());
	}

	private int getHours(String command) {
		String hours = command.substring(command.lastIndexOf(" ")+1);
		return Integer.parseInt(hours);
	}
	
	private String getReport() {
		return "Cars Entered: " + carPark.getEnteredCars()
				+"\nTrucks Entered: "+ carPark.getEnteredTrucks()
				+"\nCars Exited: "+ carPark.getExitedCars()
				+ "\nTrucks Exited: " + carPark.getExitedTrucks()
				+"\nParking Cars: " + carPark.getParkingCars()
				+"\nParking Trucks: " + carPark.getParkingTrucks()
				+"\nSpaces available: " + parkingSpaceAvailable()
				+"\nFees paid: $" + carPark.getTotalFees();
	}

}
