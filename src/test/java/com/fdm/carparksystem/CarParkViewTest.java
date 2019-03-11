package com.fdm.carparksystem;

import java.io.ByteArrayInputStream;
import java.util.Properties;
import java.util.Scanner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CarParkViewTest {

	private final Properties prop = mock(Properties.class);
	private final Console console = mock(Console.class);
	private Scanner scanner = new Scanner(new ByteArrayInputStream("".getBytes()));
	private CarParkView view = new CarParkView(prop, scanner, console);

	@Test
	public void get_num_of_spaces_from_user() {
		String sampleInput = "12";
		Scanner scanner = new Scanner(new ByteArrayInputStream(sampleInput.getBytes()));
		CarParkView view2 = new CarParkView(prop, scanner, console);

		String userInput = view2.getNumOfSpaces();

		verify(console).print("How many spaces does the car park have? ");
		assertEquals(userInput, sampleInput); 
	}

	@Test
	public void get_correct_car_hourly_rate_from_file() {
		when(prop.getProperty("car-hourly-rate")).thenReturn("hourlyrate");

		String carHourlyRate = view.getCarHourlyRate();

		assertEquals(carHourlyRate, "hourlyrate");
	}

	@Test
	public void get_correct_truck_hourly_rate_from_file() {
		when(prop.getProperty("truck-hourly-rate")).thenReturn("hourlyrate");

		String carHourlyRate = view.getTruckHourlyRate();

		assertEquals(carHourlyRate, "hourlyrate");
	}

	@Test
	public void get_correct_one_truck_space_from_file() {
		when(prop.getProperty("one-truck-space")).thenReturn("anystring");

		String carHourlyRate = view.getOneTruckSpace();

		assertEquals(carHourlyRate, "anystring");
	}
	
	@Test
	public void get_command_from_console() {
		String sampleInput = "ENTER CAR";
		Scanner scanner = new Scanner(new ByteArrayInputStream(sampleInput.getBytes()));
		CarParkView view2 = new CarParkView(prop, scanner, console);

		String userInput = view2.getCommand();

		verify(console).printSameLine("USER: ");
		assertEquals(userInput, sampleInput);
	}
	
	@Test
	public void display_any_string_to_console() {
		view.display("any string");
		
		verify(console).print("any string");
	}
}
