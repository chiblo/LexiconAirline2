package domain;

import java.util.Map;

import exceptions.PassengerNotFoundException;



public class Plane {

	private Map<Integer, Customer> passengers;
	private String flightNumber;
	
	
	
	public Plane(Map<Integer, Customer> passengers, String flightNumber) {
		this.passengers = passengers;
		this.flightNumber = flightNumber;
	}

	public Passenger findById(int id) throws PassengerNotFoundException {
		
		return (Passenger)passengers.entrySet()
									.stream()
									.filter(p -> p.getKey() == id);
		
		}

	
	public void addPassenger(Passenger passenger){
		passengers.put(passenger.getId(), passenger);
	}



	public Map<Integer, Customer> getPassengers() {
		return passengers;
	}



	public void setPassengers(Map<Integer, Customer> passengers) {
		this.passengers = passengers;
	}



	public String getFlightNumber() {
		return flightNumber;
	}



	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	
	
	
	
	
}
