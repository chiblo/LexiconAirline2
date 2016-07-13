package Domain;

import Enumeration.PlaneStatus;
import Exceptions.PassengerNotFoundException;

import java.util.ArrayList;

public class Plane {

    private Enumeration.City destination;
    private Enumeration.City departure;
    private String flightNumber;
    private PlaneStatus status;
    private ArrayList<Passenger> firstClass;
    private ArrayList<Passenger> economyClass;
    private ArrayList<Passenger> passengers;

    public Plane(String flightNumber) {
        this.flightNumber = flightNumber;
        this.status = PlaneStatus.READY;
    }

    public Plane(ArrayList<Passenger> passengers, String flightNumber, PlaneStatus status) {
        this.passengers = passengers;
        this.flightNumber = flightNumber;
        this.status = status;
    }

    public Passenger findPassengerById(String id) throws PassengerNotFoundException {
        for (Passenger passenger : passengers) {
            if (passenger.getId().equals(id)) {
                return passenger;
            } else {
                System.out.println("passenger with id: " + id + " not found");
            }
        }
        throw new PassengerNotFoundException();
    }


    public void setFirstClass(ArrayList<Passenger> firstClass) {
        this.firstClass.addAll(firstClass);
    }

    public void setEconomyClass(ArrayList<Passenger> economyClass) {
        this.economyClass.addAll(economyClass);
    }


	public void getPlaneInfo(){
		StringBuffer sb = new StringBuffer("Flight ");
		sb.append(flightNumber);
		sb.append(" from ");
		sb.append(departure);
		sb.append(" to ");
		sb.append(destination);
		
		if(status == PlaneStatus.READY){
			sb.append(" is ready for departure");
		}
		if((status == PlaneStatus.IN_FLIGHT)){
			sb.append(" has departed");
		}
		if((status == PlaneStatus.MAINTENANCE)){
			sb.append(" has been canceled due to technical issue");
		}
		System.out.println(sb);
	}


    public ArrayList<Passenger> getPassengers() {
        passengers = this.firstClass;
        passengers.addAll(economyClass);
        return passengers;
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
