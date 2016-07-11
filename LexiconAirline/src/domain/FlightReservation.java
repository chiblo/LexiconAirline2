package domain;

import enumeration.Meal;

public class FlightReservation {

		private Passenger passenger;
		private Plane plane;
		private Meal meal;
		
		public FlightReservation(Passenger passenger, Plane plane, Meal meal) {
			this.passenger = passenger;
			this.plane = plane;
			this.meal = meal;
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
	
	
				
}
