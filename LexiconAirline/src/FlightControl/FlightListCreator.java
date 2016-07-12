package FlightControl;

import Enumeration.City;
import Enumeration.TicketClass;
import Domain.FlightReservation;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by User on 2016-07-12.
 */
class FlightListCreator implements Callable<ArrayList<FlightReservation>> {
    private City departure;
    private City destination;
    private TicketClass ticketClass;
    private int maxCapacity;

    FlightListCreator(City departure, City destination, TicketClass ticketClass) {
        this.departure = departure;
        this.destination = destination;
        this.ticketClass = ticketClass;
        if(ticketClass == TicketClass.FIRST_CLASS) maxCapacity = 10;
        else maxCapacity = 20;
    }

    @Override
    public ArrayList<FlightReservation> call() throws Exception {
        ArrayList<FlightReservation> flightList = new ArrayList<>();
        boolean notCompleteList = true;
        while (notCompleteList) {
            synchronized (this) {

                notCompleteList = this.addFirst(flightList);
                this.addSecond(flightList);
            }
            Thread.sleep(10);
        }
        return flightList;
    }

    private boolean addFirst(ArrayList<FlightReservation> list) {
        int capacity = 0;
        for (FlightReservation o : list) {
            capacity += o.getNumberOfPassengers();
        }
        for (FlightReservation i : WaitingLists.getWaitingList(departure, destination)) {
            if ((!i.isInFlight()) && (i.getTicketClass() == ticketClass) && (i.getNumberOfPassengers() + capacity == maxCapacity)) {
                list.add(i);
                i.setInFlight(true);
                return false;
            }
        }
        return true;
    }


    private void addSecond(ArrayList<FlightReservation> list) {
        int capacity = 0;
        for (FlightReservation o : list) {
            capacity += o.getNumberOfPassengers();
        }

        for (FlightReservation i : WaitingLists.getWaitingList(departure, destination)) {
            if ((!i.isInFlight()) && (i.getTicketClass() == ticketClass) && ((i.getNumberOfPassengers() + capacity) < maxCapacity)) {
                list.add(i);
                i.setInFlight(true);
                break;
            }

        }
    }
}