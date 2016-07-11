package domain;

import enumeration.Meal;

public class FlightReservation {

		private Passenger passenger;
		private Plane plane;
		private Meal meal;
		private String reservationNumber;
		private int seatNumber;
		
		public FlightReservation(Passenger passenger, Plane plane, Meal meal, String reservationNumber, int seatNumber) {
			this.passenger = passenger;
			this.plane = plane;
			this.meal = meal;
			this.reservationNumber = reservationNumber;
			this.seatNumber = seatNumber;
		}

		public Passenger getPassenger() {
			return passenger;
		}

		public void setPassenger(Passenger passenger) {
			this.passenger = passenger;
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
	
	
				
}
