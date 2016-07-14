package domain;

import enumeration.City;
import enumeration.TicketClass;

import java.util.ArrayList;

public class FlightReservation {

    private static int resNumber = 1000;

    private ArrayList<Passenger> passenger = new ArrayList<>();
    private Plane plane;
    private String reservationNumber;
    private String flightNumber;
    private double price;
    private TicketClass ticketClass;
    private City destination;
    private City departure;
    private boolean isInFlight = false;

    public FlightReservation() {
        this.reservationNumber = "RES" + resNumber;
        resNumber++;
    }

    public FlightReservation(ArrayList<Passenger> passenger, String reservationNumber, TicketClass ticketClass, City destination, City departure) {
        this.passenger = passenger;
        this.reservationNumber = reservationNumber;
        this.ticketClass = ticketClass;
        this.departure = departure;
        this.destination = destination;
        this.reservationNumber = "RES" + resNumber;
        resNumber++;
        for (Passenger p : passenger) {
            this.price += p.getTicketPrice();
        }

    }


    public ArrayList<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(ArrayList<Passenger> passenger) {
        this.passenger = passenger;
    }

    public double getPrice() {
        return this.price;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public int getNumberOfPassengers() {
        return passenger.size();
    }

    public boolean isInFlight() {
        return isInFlight;
    }

    public void setInFlight(boolean inFlight) {
        isInFlight = inFlight;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public City getDeparture() {
        return departure;
    }

    public void setDeparture(City departure) {
        this.departure = departure;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
