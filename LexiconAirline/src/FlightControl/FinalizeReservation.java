package FlightControl;

import Domain.FlightReservation;
import Enumeration.City;
import Enumeration.TicketClass;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by User on 2016-07-12.
 */
public class FinalizeReservation {

    static ExecutorService pool = Executors.newFixedThreadPool(30);

    public static void run(){
        generate();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WaitingLists.getWaitingList(City.BERLIN, City.PARIS).forEach(i -> System.out.println(i));

    FlightListCreator task = new FlightListCreator(City.BERLIN, City.PARIS, TicketClass.ECOMOMY_CLASS);
    FlightListCreator task2 = new FlightListCreator(City.BERLIN, City.PARIS, TicketClass.FIRST_CLASS);


    Future<ArrayList<FlightReservation>> result = pool.submit(task);
    Future<ArrayList<FlightReservation>> result2 = pool.submit(task2);
    Future<ArrayList<FlightReservation>> result3 = pool.submit(task);
    Future<ArrayList<FlightReservation>> result4 = pool.submit(task2);


    System.out.println("sada");


    try {
        result.get().forEach(i -> System.out.println("Econ class first plane " + i.getNumberOfPassengers()));
        result2.get().forEach(i -> System.out.println("First class first plane " + i.getNumberOfPassengers()));
        result3.get().forEach(i -> System.out.println("Econ class second plane " + i.getNumberOfPassengers()));
        result4.get().forEach(i -> System.out.println("First class second plane " + i.getNumberOfPassengers()));
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }

    pool.shutdown();

}

    static void generate(){
        OrderGenerator generator = new OrderGenerator();
        for (int i = 0; i < 10; i++) {
            pool.submit(generator);
        }

    }
}
