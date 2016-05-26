package com.adp.VehicleIdentifier;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * 
 * 
 * @author Lalit Patil
 *
 */
public class VehicleIdentifier 
{
    public static void main( String[] args )
    {
    	String fileName="input.xml";
    	List<Vehicle> listOfVehicleNodes = parseXMLFile(fileName);
    	if(!listOfVehicleNodes.isEmpty()){
    	System.out.println("Vehicle Id\tVehicle Type");
        System.out.println("----------------------------");
    	
	    	for(Vehicle vehicle : listOfVehicleNodes){        // Iterating over list to find type of vehicle
	    		
	    		String typeAndId  = determineVehicleTypeFromThereProperties(vehicle);
	    		String[] typeAndIdArray = typeAndId.split("~");
	    		String type = typeAndIdArray[0];
	    		String id = typeAndIdArray[1];
	    		
	    		System.out.println(id+"\t"+type);
	    		
	    		
	    	}
    	}
    }
    
    
    /*
     *  Parameter: This method take parameter as a String : FileName which is the path for our input file.
     *  Output: This method parse the xml inputed file and returns a list of vehicle
     *   objects. Based on those vehicle object we will determine it's type.
     */
    public static List<Vehicle> parseXMLFile(String fileName){
    	
        List<Vehicle> listOfVehicleNodes = new ArrayList<Vehicle>();

        
    	try {	
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory 
               = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            
            NodeList nList = doc.getElementsByTagName("vehicle");
            for (int temp = 0; temp < nList.getLength(); temp++) {
               Node nNode = nList.item(temp);
            
               if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                  Element eElement = (Element) nNode;
                  
         
                  
                  String vehicleId = eElement .getElementsByTagName("id")    .item(0) .getTextContent();
             
                  String frameMaterial = eElement     .getElementsByTagName("frame")   .item(0).getChildNodes().item(1).getTextContent();
                  
                  Integer numberOfWheels =  eElement .getElementsByTagName("wheel").getLength();
               
               
                  String powerTrain = eElement .getElementsByTagName("powertrain").item(0).getChildNodes().item(1).getNodeName();
                  
                 
                 
                  
                  Vehicle  vehicle = new Vehicle();
                  vehicle.setFrameMaterial(frameMaterial);
                  vehicle.setNumberOfWheels(numberOfWheels);
                  vehicle.setPowerTrain(powerTrain);
                  vehicle.setVehicleId(vehicleId);
                  listOfVehicleNodes.add(vehicle);
               }
            }
         } catch (Exception e) {
           System.out.println("Some error occured while parsing input file.");
           System.out.println("Please ensure that in file, all opening tag<> has it's closing tag</>");
         }
    	return listOfVehicleNodes;
    }
    
    
    /*
     * Parameter : Vehicle vehicle : This object we will get it from parseXML methods list.
     * Output: Vehicle Type based on vehicle properties.
     */
    public static String determineVehicleTypeFromThereProperties(Vehicle vehicle){
    	
    	String vehicleType = "";
    	Boolean isInvalidVehicleType = false;
    	
    	
    	String frameMaterial = vehicle.getFrameMaterial();
    	Integer numberOfWheels = vehicle.getNumberOfWheels();
    	String powerTrain = vehicle.getPowerTrain();
    	
    	if(frameMaterial.equalsIgnoreCase("plastic")){
    		
    		if(numberOfWheels==3 && powerTrain.equalsIgnoreCase("Human")){
    			vehicleType = "Big Wheel";
    		}else if(numberOfWheels==0 && powerTrain.equalsIgnoreCase("Bernoulli")){
    			vehicleType = "Hang Glider";
    		}else{
    			isInvalidVehicleType = true;
    		}
    		
    	}else if(frameMaterial.equalsIgnoreCase("metal")){
    		
    		if(numberOfWheels==2 && powerTrain.equalsIgnoreCase("Human")){
    			vehicleType = "Bicycle";
    		}else if(numberOfWheels==2 && powerTrain.equalsIgnoreCase("Internal Combustion")){
    			vehicleType = "Motor Cycle";
    		}else if(numberOfWheels==4 && powerTrain.equalsIgnoreCase("Internal Combustion")){
    			vehicleType = "Car";
    		}else{
    			isInvalidVehicleType = true;
    		}
    	}else{
    		isInvalidVehicleType = true;
    	}
    	
    	if(isInvalidVehicleType){
    		vehicleType =  "Invalid Type";
    	}
    	
    	
    		return vehicleType+"~"+vehicle.getVehicleId();
    	
    	
    	
    }
}
