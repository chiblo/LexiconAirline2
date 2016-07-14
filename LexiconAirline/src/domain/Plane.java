package domain;

import enumeration.City;
import enumeration.Distance;
import enumeration.PlaneStatus;
import enumeration.TicketClass;
import exceptions.PassengerNotFoundException;
import flightControl.FlightListCreator;
import flightControl.WaitingLists;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Plane implements Runnable {

    private City destination;
    private City startingPoint;
    private String flightNumber;
    private PlaneStatus status;
    private ArrayList<Passenger> firstClass = new ArrayList<>();
    private ArrayList<Passenger> economyClass = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private ExecutorService pool = Executors.newFixedThreadPool(2);


    public Plane(String flightNumber, City startingPoint) {
        this.startingPoint = startingPoint;
        this.flightNumber = flightNumber;
        this.status = PlaneStatus.ON_GROUND;

    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Flight " + flightNumber + " " + status + " at " + startingPoint);
                destination = WaitingLists.takeDestination(startingPoint, flightNumber);
                Thread.sleep(1500);


                synchronized (this) {
                    try {
                        firstClass = pool.submit(new FlightListCreator(this, TicketClass.FIRST_CLASS)).get();
                        economyClass = pool.submit(new FlightListCreator(this, TicketClass.ECONOMY_CLASS)).get();
                        Thread.sleep(1500);

                    } catch (NullPointerException e) {
                    }

                }
                Thread.sleep(1500);

                giveSitNumber(firstClass, TicketClass.FIRST_CLASS);
                giveSitNumber(economyClass, TicketClass.ECONOMY_CLASS);


                status = PlaneStatus.BOARDING;
                System.out.println("Flight " + flightNumber + " " + status + " for " + destination);

                Thread.sleep(1500);

                status = PlaneStatus.IN_FLIGHT;
                System.out.println("Flight " + flightNumber + " " + status + " from "
                        + startingPoint + " to " + destination);

                Thread.sleep(Distance.takeDistance(startingPoint, destination));


                startingPoint = destination;
                status = PlaneStatus.ON_GROUND;

            } catch (InterruptedException e) {
                e.printStackTrace();

            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
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
		sb.append(startingPoint);
		sb.append(" to ");
		sb.append(destination);
		
		if(status == PlaneStatus.ON_GROUND){
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


    static void giveSitNumber(ArrayList<Passenger> passengers, TicketClass ticketClass) {
        int j = 1;

        if (ticketClass == TicketClass.ECONOMY_CLASS) j = 3;

        for (int i = 0; i < passengers.size(); i++) {
            switch (i % 5) {

                case 0:
                    passengers.get(i).setSeatNumber(((i / 5) + j) + "A");
                case 1:
                    passengers.get(i).setSeatNumber(((i / 5) + j) + "B");
                case 2:
                    passengers.get(i).setSeatNumber(((i / 5) + j) + "C");
                case 3:
                    passengers.get(i).setSeatNumber(((i / 5) + j) + "D");
                case 4:
                    passengers.get(i).setSeatNumber(((i / 5) + j) + "E");

            }
        }

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

    public City getDestination() {
        return destination;
    }

    public City getStartingPoint() {
        return startingPoint;
    }
}
