package com.fdm.carparksystem;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarParkFactoryTest {
	private final CarParkFactory factory = new CarParkFactory();
	Object carpark = factory.createCarPark(12, 2, 2, 3);
	
	@Test
	public void test_carpark_create_carpark_object() {
		assertTrue(carpark instanceof CarPark);
	}
}
