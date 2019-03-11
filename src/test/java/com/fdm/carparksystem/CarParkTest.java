package com.fdm.carparksystem;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CarParkTest {
	
	private final CarPark carPark = new CarPark(20, 2, 2, 3);
	
	@Test
	public void when_call_getter_method_should_return_correct_values() {
		assertEquals(carPark.getNumOfSpaces(),20);
		assertEquals(carPark.getOneTruckSpace(),2);
		assertEquals(carPark.getCarHourlyRate(), 2, 0);
		assertEquals(carPark.getTruckHourlyRate(), 3, 0);
		assertEquals(carPark.getParkingCars(), 0);
		assertEquals(carPark.getParkingTrucks(), 0);
		assertEquals(carPark.getEnteredCars(), 0);
		assertEquals(carPark.getEnteredTrucks(), 0);
		assertEquals(carPark.getExitedCars(), 0);
		assertEquals(carPark.getTotalFees(), 0, 0);
	}
	
	@Test
	public void when_2_cars_enters_should_return_corresponding_value() {
		carPark.addCar();
		carPark.addCar();
		
		assertEquals(carPark.getParkingCars(), 2);
		assertEquals(carPark.getParkingTrucks(), 0);
		assertEquals(carPark.getEnteredCars(), 2);
	}
	
	@Test
	public void when_2_trucks_enter_should_return_correct_values() {
		carPark.addTruck();
		carPark.addTruck();
		
		assertEquals(carPark.getParkingTrucks(), 2);
		assertEquals(carPark.getEnteredTrucks(), 2);
	}
	
	@Test
	public void when_3cars_enters_2_truck_enters_2_cars_exit_1_truck_exits() {
		CarPark carPark2 = new CarPark(20, 2, 2, 3);
		
		carPark2.addCar();
		carPark2.addCar();
		carPark2.addCar();
		carPark2.addTruck();
		carPark2.addTruck();
		carPark2.removeCar(2);
		carPark2.removeCar(1);
		carPark2.removeTruck(2);
		
		assertEquals(carPark2.getEnteredCars(), 3);
		assertEquals(carPark2.getEnteredTrucks(), 2);
		assertEquals(carPark2.getParkingCars(), 1);
		assertEquals(carPark2.getParkingTrucks(), 1);
		assertEquals(carPark2.getExitedCars(), 2);
		assertEquals(carPark2.getExitedTrucks(), 1);
		assertEquals(carPark2.getExitedTrucks(), 1);
		assertEquals(carPark2.getTotalFees(), 12, 0);
	}
	
}
