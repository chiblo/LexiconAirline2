package FlightControl;

import com.company.Enum.City;
import com.company.Enum.TicketClass;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by User on 2016-07-12.
 */
public class FlightListCreator implements Callable<ArrayList<FlightReservation>> {
    City departure;
    City destination;
    TicketClass ticketClass;

    public FlightListCreator(City departure, City destination, TicketClass ticketClass) {
        this.departure = departure;
        this.destination = destination;
        this.ticketClass = ticketClass;
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

    boolean addFirst(ArrayList<FlightReservation> list) {
        int capacity = 0;
        for (FlightReservation o : list) {
            capacity += o.getNumberOfPassengers();
        }

        for (FlightReservation i : WaitingLists.getWaitingList(departure, destination)) {
            if ((!i.isInFlight()) && (i.getTicketClass() == ticketClass) && (i.getNumberOfPassengers() + capacity == 20)) {
                list.add(i);
                i.setInFlight(true);
                return false;
            }

        }
        return true;
    }


    void addSecond(ArrayList<FlightReservation> list) {
        int capacity = 0;
        for (FlightReservation o : list) {
            capacity += o.getNumberOfPassengers();
        }

        for (FlightReservation i : WaitingLists.getWaitingList(departure, destination)) {
            if ((!i.isInFlight()) && (i.getTicketClass() == ticketClass) && ((i.getNumberOfPassengers() + capacity) < 20)) {
                list.add(i);
                i.setInFlight(true);
                break;
            }

        }
    }
}