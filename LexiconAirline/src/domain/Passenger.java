package Domain;

import Enumeration.Meal;

public class Passenger {
    private static int idCounter = 19830916;
    private String name = "No Name";
    private String id;
    private Meal meal;
    private String seatNumber;

    public Passenger() {
        String id = "PAS" + idCounter;
        if (Math.random() > .5) meal = Meal.MEAL_PACKAGE_1;
        else meal = Meal.MEAL_PACKAGE_2;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getId() {
        return id;
    }
}
