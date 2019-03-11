package com.fdm.carparksystem;

public interface IValidator {

	void validateInitialValues(String numOfSpaces, String truckSpace, String carHourlyRate, String truckHourlyRate) throws InvalidPropertiesException;

	void validateCommand(String command) throws InvalidCommandException;

}
