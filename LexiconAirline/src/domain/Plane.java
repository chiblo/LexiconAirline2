package domain;

import java.util.Map;

import enumeration.PlaneStatus;
import exceptions.PassengerNotFoundException;



public class Plane {

	private Map<Integer, Customer> passengers;
	private String flightNumber;
	private PlaneStatus status;
	
	
	
	public Plane(Map<Integer, Customer> passengers, String flightNumber) {
		this.passengers = passengers;
		this.flightNumber = flightNumber;
	}

	public Passenger findPassengerById(int id) throws PassengerNotFoundException {
		
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

	public PlaneStatus getStatus() {
		return status;
	}

	public void setStatus(PlaneStatus status) {
		this.status = status;
	}
	
	
	
	
	
	
}
