package com.fdm.carparksystem;

import org.junit.Before;
import org.junit.Test;

public class InputValidatorTest {
	private final InputValidator validator = new InputValidator();
	private String numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate;
	
	@Before
	public void setDefaultInputs() {
		numOfSpaces = "20";
		oneTruckSpace = "2";
		carHourlyRate = "2";
		truckHourlyRate = "3";
	}
	
	@Test
	public void when_all_valid_input_does_not_throw_exception() throws InvalidPropertiesException {
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	 
	@Test(expected = InvalidPropertiesException.class)
	public void when_numOfSpaces_is_minus20_valid_input_does_throw_exception() throws InvalidPropertiesException {
		numOfSpaces = "-20";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_numOfSpaces_is_20point5_valid_input_does_throw_exception() throws InvalidPropertiesException {
		numOfSpaces = "20.5";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test
	public void when_numOfSpaces_is_020_valid_input_does_throw_exception() throws InvalidPropertiesException {
		numOfSpaces = "020";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_numOfSpaces_is_20A_valid_input_does_throw_exception() throws InvalidPropertiesException {
		numOfSpaces = "20A";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_numOfSpaces_is_twenty_does_throw_exception() throws InvalidPropertiesException {
		numOfSpaces = "twenty";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_oneTruckSpace_is_twenty_does_throw_exception() throws InvalidPropertiesException {
		oneTruckSpace = "twenty";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_oneTruckSpace_is_2pint5_valid_input_does_throw_exception() throws InvalidPropertiesException {
		oneTruckSpace = "2.5";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_oneTruckSpace_is_more_than_two_valid_input_does_throw_exception() throws InvalidPropertiesException {
		oneTruckSpace = "10";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_carHourlyRate_is_two_does_throw_exception() throws InvalidPropertiesException {
		carHourlyRate = "two";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test
	public void when_carHourlyRate_is_2_does_throw_exception() throws InvalidPropertiesException {
		carHourlyRate = "2";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test
	public void when_carHourlyRate_is_2point0_does_throw_exception() throws InvalidPropertiesException {
		carHourlyRate = "2.0";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test
	public void when_carHourlyRate_is_2point5_does_throw_exception() throws InvalidPropertiesException {
		carHourlyRate = "2.5";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_carHourlyRate_is_two2_does_throw_exception() throws InvalidPropertiesException {
		carHourlyRate = "two2";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_carHourlyRate_is_50space5_does_throw_exception() throws InvalidPropertiesException {
		carHourlyRate = "50 5";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_carHourlyRate_is_50point5point2_does_throw_exception() throws InvalidPropertiesException {
		carHourlyRate = "50.5.2";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test
	public void when_truckHourlyRate_is_50_does_not_throw_exception() throws InvalidPropertiesException {
		truckHourlyRate = "50";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test
	public void when_truckHourlyRate_is_0point50_does_not_throw_exception() throws InvalidPropertiesException {
		truckHourlyRate = ".50";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test
	public void when_truckHourlyRate_is_2point50_does_not_throw_exception() throws InvalidPropertiesException {
		truckHourlyRate = "2.50";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_truckHourlyRate_is_twopoint50_does_not_throw_exception() throws InvalidPropertiesException {
		truckHourlyRate = "two.50";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_truckHourlyRate_is_twopoint50point2_does_not_throw_exception() throws InvalidPropertiesException {
		truckHourlyRate = "2.50.2";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test(expected = InvalidPropertiesException.class)
	public void when_truckHourlyRate_is_empty_String_throw_exception() throws InvalidPropertiesException {
		truckHourlyRate = "";
		validator.validateInitialValues(numOfSpaces, oneTruckSpace, carHourlyRate, truckHourlyRate);
	}
	
	@Test
	public void when_command_input_is_REPORT() throws InvalidCommandException {
		String command = "REPORT";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_REPORTS() throws InvalidCommandException {
		String command = "REPORTS";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_SPACE_REPORT() throws InvalidCommandException {
		String command = " REPORT";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_ENTERS_CARS() throws InvalidCommandException {
		String command = "ENTERS CARS";
		validator.validateCommand(command);
	}
	
	@Test
	public void when_command_input_is_ENTER_CAR() throws InvalidCommandException {
		String command = "ENTER CAR";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_ENTER_CARS() throws InvalidCommandException {
		String command = "ENTER CARS";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_ENTER_CAR_SPACE() throws InvalidCommandException {
		String command = "ENTER CAR ";
		validator.validateCommand(command);
	}
	
	@Test
	public void when_command_input_is_ENTER_TRUCK() throws InvalidCommandException {
		String command = "ENTER TRUCK";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_ENTER_TRUCKS() throws InvalidCommandException {
		String command = "ENTER TRUCKS";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_EXIT_TRUCK() throws InvalidCommandException {
		String command = "EXIT TRUCK";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_EXIT_TRUCK_minus1() throws InvalidCommandException {
		String command = "EXIT TRUCK -1";
		validator.validateCommand(command);
	}
	
	@Test
	public void when_command_input_is_EXIT_TRUCK_1() throws InvalidCommandException {
		String command = "EXIT TRUCK 1";
		validator.validateCommand(command);
	}
	
	@Test
	public void when_command_input_is_EXIT_TRUCK_5() throws InvalidCommandException {
		String command = "EXIT TRUCK 5";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_EXIT_TRUCK_2point5() throws InvalidCommandException {
		String command = "EXIT TRUCK 2.5";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_EXIT_TRUCK_2space2() throws InvalidCommandException {
		String command = "EXIT TRUCK 2 2";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_EXIT_CAR_2space2() throws InvalidCommandException {
		String command = "EXIT CAR 2 2";
		validator.validateCommand(command);
	}
	
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_EXIT_CAR() throws InvalidCommandException {
		String command = "EXIT CAR";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_EXIT_CAR_minus1() throws InvalidCommandException {
		String command = "EXIT CAR -1";
		validator.validateCommand(command);
	}
	 
	@Test
	public void when_command_input_is_EXIT_CAR_1() throws InvalidCommandException {
		String command = "EXIT CAR 1";
		validator.validateCommand(command);
	}
	
	@Test
	public void when_command_input_is_EXIT_CAR_5() throws InvalidCommandException {
		String command = "EXIT CAR 5";
		validator.validateCommand(command);
	}
	
	@Test(expected = InvalidCommandException.class)
	public void when_command_input_is_EXIT_CAR_2point5() throws InvalidCommandException {
		String command = "EXIT CAR 2.5";
		validator.validateCommand(command);
	}

}
