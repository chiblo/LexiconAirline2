package FlightControl;

import com.company.Enum.City;
import com.company.Enum.TicketClass;

/**
 * Created by Bardia on 2016-07-11.
 */
public class OrderGenerator implements Runnable {


    @Override
    public void run() {
        synchronized (this) {
            FlightReservation order = new FlightReservation();
            order.setTicketClass(TicketClass.ECONOMY_CLASS);
            int randomize = (int) (Math.random() * 1.5);
            if (randomize == 1) {
                order.setTicketClass(TicketClass.FIRST_CLASS);
            }

            order.setNumberOfPassengers((int) (Math.random() * 4.99) + 1);
            randomize = (int) ((Math.random()) * 11.99);

            switch (randomize) {
                case 1: {
                    order.setDeparture(City.ROME);
                    order.setDestination(City.PARIS);
                    WaitingLists.waitingListRomeParis.add(order);
                    break;
                }
                case 2: {
                    order.setDeparture(City.PARIS);
                    order.setDestination(City.ROME);
                    WaitingLists.waitingListParisRome.add(order);
                    break;

                }
                case 3: {
                    order.setDeparture(City.ROME);
                    order.setDestination(City.BERLIN);
                    WaitingLists.waitingListRomeBerlin.add(order);
                    break;

                }
                case 4: {
                    order.setDeparture(City.BERLIN);
                    order.setDestination(City.ROME);
                    WaitingLists.waitingListBerlinRome.add(order);
                    break;

                }
                case 5: {
                    order.setDeparture(City.ROME);
                    order.setDestination(City.STOCKHOLM);
                    WaitingLists.waitingListRomeStockholm.add(order);
                    break;

                }
                case 6: {
                    order.setDeparture(City.STOCKHOLM);
                    order.setDestination(City.ROME);
                    WaitingLists.waitingListStockholmRome.add(order);
                    break;

                }
                case 7: {
                    order.setDeparture(City.BERLIN);
                    order.setDestination(City.PARIS);
                    WaitingLists.waitingListBerlinParis.add(order);
                    break;

                }
                case 8: {
                    order.setDeparture(City.PARIS);
                    order.setDestination(City.BERLIN);
                    WaitingLists.waitingListParisBerlin.add(order);
                    break;

                }
                case 9: {
                    order.setDeparture(City.BERLIN);
                    order.setDestination(City.STOCKHOLM);
                    WaitingLists.waitingListBerlinStockholm.add(order);
                    break;

                }
                case 10: {
                    order.setDeparture(City.STOCKHOLM);
                    order.setDestination(City.BERLIN);
                    WaitingLists.waitingListStockholmBerlin.add(order);
                    break;

                }
                case 11: {
                    order.setDeparture(City.PARIS);
                    order.setDestination(City.STOCKHOLM);
                    WaitingLists.waitingListParisStockholm.add(order);
                    break;

                }

                default: {
                    order.setDeparture(City.STOCKHOLM);
                    order.setDestination(City.PARIS);
                    WaitingLists.waitingListStockholmParis.add(order);
                    break;
                }

            }
            System.out.println(order);
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }
}