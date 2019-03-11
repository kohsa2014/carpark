package com.fdm.carparksystem;

import java.util.Properties;
import java.util.Scanner;

public class CarParkView implements IView {
	private Properties prop;
	private Scanner scanner;
	private Console console;

	public CarParkView(Properties prop, Scanner scanner, Console console) {
		this.prop = prop;
		this.scanner = scanner;
		this.console = console;
	}
 
	@Override 
	public String getNumOfSpaces() {
		console.print("How many spaces does the car park have? ");
		return scanner.nextLine();
	}

	@Override
	public String getCarHourlyRate() {
		return prop.getProperty("car-hourly-rate");
	}

	@Override
	public String getTruckHourlyRate() {
		return prop.getProperty("truck-hourly-rate");
	}

	@Override
	public String getOneTruckSpace() {
		return prop.getProperty("one-truck-space");
	}

	@Override
	public void display(String message) {
		console.print(message);
	}

	@Override
	public String getCommand() {
		console.printSameLine("USER: ");
		return scanner.nextLine();
	}

}
