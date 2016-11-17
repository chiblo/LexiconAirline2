package domain;

import enumeration.*;

public class Passenger {
    private static int idCounter = 19830916;
    private String name = "No Name";
    private String id;
    private Meal meal;
    private String seatNumber;
    private TicketClass ticketClass;
    private double ticketPrice;
    private City departure;
    private City destination;
    private String reservationNumber;


    public Passenger() {
        String id = "PAS" + idCounter;
        switch ((int) (Math.random() * 3.99)) {
            case 0:
                meal = Meal.MEAL_PACKAGE_1;
                break;
            case 1:
                meal = Meal.MEAL_PACKAGE_2;
                break;
            case 2:
                meal = Meal.MEAL_PACKAGE_3;
                break;
            case 3:
                meal = Meal.NO_MEAL;
        }
    }

    public void setTicketPrice(int baseTicketPrice) {
        this.ticketPrice = baseTicketPrice + FoodPrice.getFoodPrice(this);
    }

    public double getTicketPrice() {
        setTicketPrice();
        return ticketPrice;
    }

    public Meal getMeal() {
        return meal;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getId() {
        return id;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
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
}
