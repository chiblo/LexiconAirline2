package domain;

import java.util.ArrayList;

import enumeration.PlaneStatus;
import exceptions.PassengerNotFoundException;

public class Plane {

	private ArrayList<Passenger> passengers;
	private String flightNumber;
	private PlaneStatus status;
	private ArrayList<Integer> firstClassSeats;
	private ArrayList<Integer> economyClassSeats;

	public Plane(ArrayList<Passenger> passengers, String flightNumber, PlaneStatus status) {
		this.passengers = passengers;
		this.flightNumber = flightNumber;
		this.status = status;
	}

	public Passenger findPassengerById(int id) throws PassengerNotFoundException {
		for (Passenger passenger : passengers) {
			if (passenger.getId() == id) {
				return passenger;
			} else {
				System.out.println("passenger with id: " + id + " not found");
			}
		}
		
		throw new PassengerNotFoundException();
	}
	

	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(ArrayList<Passenger> passengers) {
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
