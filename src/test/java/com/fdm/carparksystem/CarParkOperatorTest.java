package com.fdm.carparksystem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class CarParkOperatorTest {
	private CarPark carPark = mock(CarPark.class);
	private CarParkFactory factory = mock(CarParkFactory.class);
	
	private final CarParkOperator operator = new CarParkOperator(factory);
	
	@Test 
	public void when_carPark_initialized_with_correct_properties() {
		operator.initializeCarPark(12, 2, 2, 3);
		
		verify(factory).createCarPark(12, 2, 2, 3);
	} 
	
	@Test
	public void when_command_is_ENTER_CAR() {
		when(factory.createCarPark(12, 2, 2, 3)).thenReturn(carPark);
		when(carPark.getNumOfSpaces()).thenReturn(12);
		when(carPark.getParkingCars()).thenReturn(0);
		when(carPark.getParkingTrucks()).thenReturn(0);
		when(carPark.getOneTruckSpace()).thenReturn(2);
		
		operator.initializeCarPark(12, 2, 2, 3);
		String response = operator.executeCommand("ENTER CAR");
		
		verify(carPark).addCar();
		assertEquals("", response);
	}
	
	@Test
	public void when_command_is_ENTER_CAR_but_no_carSpace() {
		when(factory.createCarPark(12, 2, 2, 3)).thenReturn(carPark);
		when(carPark.getNumOfSpaces()).thenReturn(12);
		when(carPark.getParkingCars()).thenReturn(12);
		when(carPark.getParkingTrucks()).thenReturn(0);
		when(carPark.getOneTruckSpace()).thenReturn(2);
		
		operator.initializeCarPark(12, 2, 2, 3);
		String response = operator.executeCommand("ENTER CAR");
		
		assertTrue("space not available".equals(response));
	}
	
	@Test
	public void when_command_is_ENTER_TRUCK() {
		when(factory.createCarPark(12, 2, 2, 3)).thenReturn(carPark);
		when(carPark.getNumOfSpaces()).thenReturn(12);
		when(carPark.getParkingCars()).thenReturn(0);
		when(carPark.getParkingTrucks()).thenReturn(0);
		when(carPark.getOneTruckSpace()).thenReturn(2);
		
		operator.initializeCarPark(12, 2, 2, 3);
		String response = operator.executeCommand("ENTER TRUCK");
		
		verify(carPark).addTruck();
		assertEquals("", response);
	}
	
	@Test
	public void when_command_is_ENTER_TRUCK_but_no_carSpace() {
		when(factory.createCarPark(12, 2, 2, 3)).thenReturn(carPark);
		when(carPark.getNumOfSpaces()).thenReturn(12);
		when(carPark.getParkingCars()).thenReturn(12);
		when(carPark.getParkingTrucks()).thenReturn(0);
		when(carPark.getOneTruckSpace()).thenReturn(2);
		
		operator.initializeCarPark(12, 2, 2, 3);
		String response = operator.executeCommand("ENTER TRUCK");
		
		assertTrue("space not available".equals(response));
		verify(carPark, never()).addTruck();
	}
	
	@Test
	public void when_command_is_EXIT_CAR_but_no_carParked() {
		when(factory.createCarPark(12, 2, 2, 3)).thenReturn(carPark);
		when(carPark.getNumOfSpaces()).thenReturn(12);
		when(carPark.getParkingCars()).thenReturn(0);
		when(carPark.getParkingTrucks()).thenReturn(0);
		when(carPark.getOneTruckSpace()).thenReturn(2);
		
		operator.initializeCarPark(12, 2, 2, 3);
		String response = operator.executeCommand("EXIT CAR 2");
		
		assertTrue("No car parked".equals(response));
		verify(carPark, never()).removeCar(2);
	}
	
	@Test
	public void when_command_is_EXIT_CAR_2Hrs_and_lastCar() {
		when(factory.createCarPark(12, 2, 2, 3)).thenReturn(carPark);
		when(carPark.getNumOfSpaces()).thenReturn(12);
		when(carPark.getParkingCars()).thenReturn(1);
		when(carPark.getParkingTrucks()).thenReturn(0);
		when(carPark.getOneTruckSpace()).thenReturn(2);
		
		operator.initializeCarPark(12, 2, 2, 3);
		String response = operator.executeCommand("EXIT CAR 2");
		
		assertTrue("".equals(response));
		verify(carPark).removeCar(2); 
	}
	
	
	@Test
	public void when_command_is_EXIT_TRUCK_but_no_truckParked() {
		when(factory.createCarPark(12, 2, 2, 3)).thenReturn(carPark);
		when(carPark.getNumOfSpaces()).thenReturn(12);
		when(carPark.getParkingCars()).thenReturn(0);
		when(carPark.getParkingTrucks()).thenReturn(0);
		when(carPark.getOneTruckSpace()).thenReturn(2);
		
		operator.initializeCarPark(12, 2, 2, 3);
		String response = operator.executeCommand("EXIT TRUCK 2");
		
		assertTrue("No truck parked".equals(response));
		verify(carPark, never()).removeTruck(2);
	} 
	
	@Test
	public void when_command_is_EXIT_Truck_2Hrs_and_lastTruck() {
		when(factory.createCarPark(12, 2, 2, 3)).thenReturn(carPark);
		when(carPark.getNumOfSpaces()).thenReturn(12);
		when(carPark.getParkingCars()).thenReturn(0);
		when(carPark.getParkingTrucks()).thenReturn(1);
		when(carPark.getOneTruckSpace()).thenReturn(2);
		
		operator.initializeCarPark(12, 2, 2, 3);
		String response = operator.executeCommand("EXIT TRUCK 2");
		
		assertTrue("".equals(response));
		verify(carPark).removeTruck(2); 
	}
	
	
	@Test
	public void when_command_is_REPORT() {
		when(factory.createCarPark(12, 2, 2, 3)).thenReturn(carPark);
		when(carPark.getNumOfSpaces()).thenReturn(12);
		when(carPark.getParkingCars()).thenReturn(0);
		when(carPark.getParkingTrucks()).thenReturn(1);
		when(carPark.getOneTruckSpace()).thenReturn(2);
		when(carPark.getEnteredTrucks()).thenReturn(1);
		when(carPark.getEnteredCars()).thenReturn(3);
		when(carPark.getExitedCars()).thenReturn(3);
		when(carPark.getExitedTrucks()).thenReturn(0);
		when(carPark.getTotalFees()).thenReturn(6.0);
		
		operator.initializeCarPark(12, 2, 2, 3);
		String response2 = operator.executeCommand("REPORT");
		String expetedReport = 
					"Cars Entered: 3" 
					+"\nTrucks Entered: 1"
					+"\nCars Exited: 3"
					+ "\nTrucks Exited: 0" 
					+"\nParking Cars: 0" 
					+"\nParking Trucks: 1" 
					+"\nSpaces available: 10" 
					+"\nFees paid: $6.0";
		assertTrue(expetedReport.equals(response2));
	}
}

