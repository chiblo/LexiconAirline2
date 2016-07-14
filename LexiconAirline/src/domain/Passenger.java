package domain;

import enumeration.Meal;
import enumeration.TicketClass;

public class Passenger {
    private static int idCounter = 19830916;
    private String name = "No Name";
    private String id;
    private Meal meal;
    private String seatNumber;
    private TicketClass ticketClass;
    private double ticketPrice;

    public Passenger(TicketClass ticketClass) {
        String id = "PAS" + idCounter;
        this.ticketClass = ticketClass;
        switch ((int) (Math.random() * 3.99)) {
            case 0:
                meal = Meal.MEAL_PACKAGE_1;
            case 1:
                meal = Meal.MEAL_PACKAGE_2;
            case 2:
                meal = Meal.MEAL_PACKAGE_3;
            case 3:
                meal = Meal.NO_MEAL;
        }
        setTicketPrice();
    }

    public void setTicketPrice() {


    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getId() {
        return id;
    }
}
