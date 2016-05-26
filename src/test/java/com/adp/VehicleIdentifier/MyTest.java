package com.adp.VehicleIdentifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author Lalit Patil
 */
public class MyTest {

	
	/*
	 * 
	 * Vehicle type is Big Wheel because It has plastic frame, 3 wheels and power train by human
	 */
	@Test
	public void isVehicleTypeBigWheel(){
    	Vehicle vehicle = new Vehicle();
    	vehicle.setFrameMaterial("plastic");
    	vehicle.setNumberOfWheels(3);
    	vehicle.setPowerTrain("Human");
    	
    	String typeAndId  = VehicleIdentifier.determineVehicleTypeFromThereProperties(vehicle);
		String type = typeAndId.split("~")[0];
		assertEquals("Big Wheel", type);
    	
    }
    
	/*
	 * 
	 * Vehicle type is Car because It has metal frame, 4 wheels and power train by Internal Combustion
	 */
	@Test
    public void isVehicleTypeCar(){
    	Vehicle vehicle = new Vehicle();
    	vehicle.setFrameMaterial("metal");
    	vehicle.setNumberOfWheels(4);
    	vehicle.setPowerTrain("Internal Combustion");
    	
    	String typeAndId  = VehicleIdentifier.determineVehicleTypeFromThereProperties(vehicle);
		String type = typeAndId.split("~")[0];
		assertEquals("Car", type);
    	
    }
    
	
	/*
	 * 
	 * Vehicle type is HangGlider because It has plastic frame, no wheels and power train by Bernoulli
	 */
	@Test
    public void isVehicleTypeHangGlider(){
    	Vehicle vehicle = new Vehicle();
    	vehicle.setFrameMaterial("plastic");
    	vehicle.setNumberOfWheels(0);
    	vehicle.setPowerTrain("Bernoulli");
    	
    	String typeAndId  = VehicleIdentifier.determineVehicleTypeFromThereProperties(vehicle);
		String type = typeAndId.split("~")[0];
		assertEquals("Hang Glider", type);
    	
    }
    
	/*
	 * 
	 * Vehicle type is Motor  Cycle because It has metal frame, 2 wheels and power train by Internal Combustion
	 */
	@Test
    public void isVehicleTypeMotorCycle(){
    	Vehicle vehicle = new Vehicle();
    	vehicle.setFrameMaterial("metal");
    	vehicle.setNumberOfWheels(2);
    	vehicle.setPowerTrain("Internal Combustion");
    	
    	String typeAndId  = VehicleIdentifier.determineVehicleTypeFromThereProperties(vehicle);
		String type = typeAndId.split("~")[0];
		assertEquals("Motor Cycle", type);
    	
    }
    
	/*
	 * 
	 * Vehicle type is Bicycle because It has metal frame, 2 wheels and power train by human
	 */
	@Test
    public void isVehicleTypeBiCycle(){
    	Vehicle vehicle = new Vehicle();
    	vehicle.setFrameMaterial("metal");
    	vehicle.setNumberOfWheels(2);
    	vehicle.setPowerTrain("Human");
    	
    	String typeAndId  = VehicleIdentifier.determineVehicleTypeFromThereProperties(vehicle);
		String type = typeAndId.split("~")[0];
		assertEquals("Bicycle", type);
    	
    }
	
	/*
	 * 
	 * Vehicle type is Invalid because we pass invalid property value for power train
	 */
	@Test
    public void isVehicleTypeInvalid(){
    	Vehicle vehicle = new Vehicle();
    	vehicle.setFrameMaterial("metal");
    	vehicle.setNumberOfWheels(1);      // Invalid property
    	vehicle.setPowerTrain("machine");  // Invalid property
    	
    	String typeAndId  = VehicleIdentifier.determineVehicleTypeFromThereProperties(vehicle);
		String type = typeAndId.split("~")[0];
		assertEquals("Invalid Type", type);
    	
    }
	
	
	

}
