package domain;

import enumeration.Meal;
import enumeration.TicketClass;

public class FlightReservation {

		private Passenger passenger;
		private Plane plane;
		private Meal meal;
		private String reservationNumber;
		private int seatNumber;
		private int price;
		private TicketClass ticketClass;
		
		public FlightReservation(Passenger passenger, Plane plane, Meal meal, String reservationNumber, int seatNumber, TicketClass ticketClass) {
			this.passenger = passenger;
			this.plane = plane;
			this.meal = meal;
			this.reservationNumber = reservationNumber;
			this.seatNumber = seatNumber;
			this.ticketClass = ticketClass;
		}

		public Passenger getPassenger() {
			return passenger;
		}

		public void setPassenger(Passenger passenger) {
			this.passenger = passenger;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public Plane getPlane() {
			return plane;
		}

		public void setPlane(Plane plane) {
			this.plane = plane;
		}

		public Meal getMeal() {
			return meal;
		}

		public void setMeal(Meal meal) {
			this.meal = meal;
		}

		public String getReservationNumber() {
			return reservationNumber;
		}

		public void setReservationNumber(String reservationNumber) {
			this.reservationNumber = reservationNumber;
		}

		public int getSeatNumber() {
			return seatNumber;
		}

		public void setSeatNumber(int seatNumber) {
			this.seatNumber = seatNumber;
		}

		public TicketClass getTicketClass() {
			return ticketClass;
		}

		public void setTicketClass(TicketClass ticketClass) {
			this.ticketClass = ticketClass;
		}
	
	
				
}
