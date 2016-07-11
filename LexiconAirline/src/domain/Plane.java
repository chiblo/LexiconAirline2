package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import enumeration.PlaneStatus;
import exceptions.PassengerNotFoundException;



public class Plane {

	private HashMap<Integer, Passenger> passengers;
	private String flightNumber;
	private PlaneStatus status;
	private ArrayList<Integer> firstClassSeats;
	private ArrayList<Integer> economyClassSeats;
	
	
	public Plane(HashMap<Integer, Passenger> passengers, String flightNumber, PlaneStatus status) {
		this.passengers = passengers;
		this.flightNumber = flightNumber;
		this.status = status;
	}



	public Passenger findPassengerById(int id) throws PassengerNotFoundException {
		
			return passenger;
		
		}

	
	public void addPassenger(Passenger passenger){
		passengers.put(passenger.getId(), passenger);
	}





	public HashMap<Integer, Passenger> getPassengers() {
		return passengers;
	}



	public void setPassengers(HashMap<Integer, Passenger> passengers) {
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
