package FlightControl;

import domain.FlightReservation;

import java.util.ArrayList;
import Enumeration.City;
import static Enumeration.City.STOCKHOLM;


/**
 * Created by Bardia on 2016-07-12.
 */
public class WaitingLists {

    public static ArrayList<FlightReservation> getWaitingList(City departure, City destination) {
        switch (departure) {
            case STOCKHOLM:
                switch (destination) {
                    case ROME: {
                        return waitingListStockholmRome;
                    }
                    case BERLIN: {
                        return waitingListStockholmBerlin;
                    }
                    case PARIS: {
                        return waitingListStockholmParis;
                    }
                }
            case ROME:
                switch (destination) {
                    case STOCKHOLM: {
                        return waitingListRomeStockholm;
                    }
                    case BERLIN: {
                        return waitingListRomeBerlin;
                    }
                    case PARIS: {
                        return waitingListRomeParis;
                    }
                }
            case BERLIN:
                switch (destination) {
                    case ROME: {
                        return waitingListBerlinRome;
                    }
                    case STOCKHOLM: {
                        return waitingListBerlinStockholm;
                    }
                    case PARIS: {
                        return waitingListBerlinParis;
                    }
                }
            case PARIS:
                switch (destination) {
                    case ROME: {
                        return waitingListParisRome;
                    }
                    case BERLIN: {
                        return waitingListParisBerlin;
                    }
                    case STOCKHOLM: {
                        return waitingListParisStockholm;
                    }
                }
        }

        return null;
    }

    static ArrayList<FlightReservation> waitingListRomeParis = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListParisRome = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListRomeBerlin = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListBerlinRome = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListRomeStockholm = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListStockholmRome = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListBerlinParis = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListParisBerlin = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListBerlinStockholm = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListStockholmBerlin = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListStockholmParis = new ArrayList<>();
    static ArrayList<FlightReservation> waitingListParisStockholm = new ArrayList<>();

}