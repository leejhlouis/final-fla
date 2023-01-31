package manager;

import models.Reservation;

public abstract class ReservationManager {
	protected Reservation reservation;
	protected int index;
	
	protected ReservationManager(Reservation reservation, int index) {
		this.reservation = reservation;
		this.index = index;
	}
	
	public void execute() {
		manageReservation();
		String file = generatePDFFile();
		sendToCustomer(file);
	}

	protected abstract void manageReservation();
	
	protected abstract String generatePDFFile();
	
	protected void sendToCustomer(String file) {
		System.out.println("File " + file + " has been sent to " + reservation.getEmail());
	}

}
