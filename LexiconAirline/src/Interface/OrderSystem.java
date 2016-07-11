package Interface;

/**
 * Created by User on 2016-07-11.
 */
public interface OrderSystem {
    Airport getStartingAirport();

    Airport getDestination();

    int getNumberOfPassengers();

    TicketClass getTicketClass();

    double getPrice();

    Customer getCustomer();

    List<Passenger> getPassengerList();
}
