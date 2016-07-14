package flightControl;

import domain.FlightReservation;
import domain.Passenger;
import enumeration.City;
import enumeration.TicketClass;

import java.util.ArrayList;

/**
 * Created by Bardia on 2016-07-11.
 */
public class OrderGenerator implements Runnable {


    @Override
    public void run() {
        for (int j = 0; j < 100; j++) {
            ArrayList<Passenger> passengers = new ArrayList<>();
            FlightReservation order = new FlightReservation();
            order.setTicketClass(TicketClass.ECONOMY_CLASS);
            int randomize = (int) (Math.random() * 1.5);
            if (randomize == 1) {
                order.setTicketClass(TicketClass.FIRST_CLASS);
            }

            for (int i = 0; i < ((int) (Math.random() * 4.99) + 1); i++) {

                Passenger p = new Passenger(order.getTicketClass());
                passengers.add(p);
            }
            order.setPassenger(passengers);
            randomize = (int) ((Math.random()) * 11.99);

            switch (randomize) {
                case 1: {
                    order.setDeparture(City.ROME);
                    order.setDestination(City.PARIS);
                    break;
                }
                case 2: {
                    order.setDeparture(City.PARIS);
                    order.setDestination(City.ROME);
                    break;

                }
                case 3: {
                    order.setDeparture(City.ROME);
                    order.setDestination(City.BERLIN);
                    break;

                }
                case 4: {
                    order.setDeparture(City.BERLIN);
                    order.setDestination(City.ROME);
                    break;

                }
                case 5: {
                    order.setDeparture(City.ROME);
                    order.setDestination(City.STOCKHOLM);
                    break;

                }
                case 6: {
                    order.setDeparture(City.STOCKHOLM);
                    order.setDestination(City.ROME);
                    break;

                }
                case 7: {
                    order.setDeparture(City.BERLIN);
                    order.setDestination(City.PARIS);
                    break;

                }
                case 8: {
                    order.setDeparture(City.PARIS);
                    order.setDestination(City.BERLIN);
                    break;

                }
                case 9: {
                    order.setDeparture(City.BERLIN);
                    order.setDestination(City.STOCKHOLM);
                    break;

                }
                case 10: {
                    order.setDeparture(City.STOCKHOLM);
                    order.setDestination(City.BERLIN);
                    break;

                }
                case 11: {
                    order.setDeparture(City.PARIS);
                    order.setDestination(City.STOCKHOLM);
                    break;

                }

                default: {
                    order.setDeparture(City.STOCKHOLM);
                    order.setDestination(City.PARIS);
                    break;
                }

            }
            synchronized (this) {
                WaitingLists.addToList(order);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}