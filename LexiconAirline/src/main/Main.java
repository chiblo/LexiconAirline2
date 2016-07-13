package Main;

import Domain.Company;
import FlightControl.OrderGenerator;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(new OrderGenerator()).start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Company company = new Company(10);
//       WaitingLists.printList(City.STOCKHOLM,City.ROME);
//        System.out.println("asd");

    }
}
