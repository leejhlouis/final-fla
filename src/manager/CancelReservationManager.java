package manager;

import database.Database;
import models.Reservation;

public class CancelReservationManager extends ReservationManager {

	public CancelReservationManager(Reservation reservation, int index) {
		super(reservation, index);
	}

	@Override
	protected void manageReservation() {
		System.out.println("Cancelling reservation...");
		Database.getInstance().get().remove(index);
	}

	@Override
	protected String generatePDFFile() {
		System.out.println("Generating PDF file for the reservation cancellation for Mr./Ms. " + reservation.getName() + "...");
	
		return "CANCELLATION--MR/MS_" + reservation.getName().toUpperCase() + ".pdf";
	}

}
