package Interface;

/**
 * Created by User on 2016-07-11.
 */
public interface AirplaneSystem {
    Airport getDstinationAirport();

    Airport getDepartureAirport();

    int timeOfArrival();

    PlaneStatus planeStatus();

    int numberEmptySeatsEconomy();

    int numberEmptySeatsFirstClass();

}
