package com.fdm.carparksystem;

public class InputValidator implements IValidator{
	private final String command1 = "ENTER CAR";
	private final String command2 = "ENTER TRUCK";
	private final String command3 = "REPORT";
	private final String command4 = "(EXIT CAR )\\d+";
	private final String command5 = "(EXIT TRUCK )\\d+";
	private final String command6 = "QUIT";
 	@Override
	public void validateInitialValues(String numOfSpaces, String oneTruckSpace, String carHourlyRate,
			String truckHourlyRate) throws InvalidPropertiesException {
		if( !isValidNumOfSpaces(numOfSpaces) || !isValidOneTruckSpace(oneTruckSpace) ||
				!isFloat(carHourlyRate) || !isFloat(truckHourlyRate)) {
			throw new InvalidPropertiesException("Invalid Carpark Properties");
		}
	}   

	@Override
	public void validateCommand(String command) throws InvalidCommandException {
		if( !command1.equals(command) && !command2.equals(command) && 
				!command3.equals(command) && !command.matches(command4) && 
				!command.matches(command5) && !command6.equals(command)) {
			throw new InvalidCommandException("not valid command");
		}
	}
	
	private boolean isValidNumOfSpaces(String string) {
		return string.matches("[0-9]+") ;
	}
	
	private boolean isValidOneTruckSpace(String string) {
		return string.matches("[1-3]"); 					//In this application one truck can not take more than 3 car parking space
	}
	
	private boolean isFloat(String string) {
		return string.matches("^\\d*\\.?\\d*$") && !string.isEmpty();
	}

}
