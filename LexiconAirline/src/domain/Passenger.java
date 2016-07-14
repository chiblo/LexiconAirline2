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

    public Passenger(City departure, City destination, TicketClass ticketClass) {
        String id = "PAS" + idCounter;
        this.departure =departure;
        this.destination = destination;
        this.ticketClass = ticketClass;
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
        setTicketPrice();
    }

    public void setTicketPrice() {
        this.ticketPrice = ((Distance.takeDistance(departure, destination)) / 10) + 3500;
        if (this.ticketClass == TicketClass.FIRST_CLASS) this.ticketPrice *= 4;
        this.ticketPrice += FoodPrice.getFoodPrice(this);
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public Meal getMeal() {
        return meal;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getId() {
        return id;
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
