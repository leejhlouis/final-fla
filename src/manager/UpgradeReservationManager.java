package manager;

import java.util.Scanner;

import models.Reservation;

public class UpgradeReservationManager extends ReservationManager {
	Scanner sc = new Scanner(System.in);

	public UpgradeReservationManager(Reservation reservation, int index) {
		super(reservation, index);
	}

	@Override
	protected void manageReservation() {
		String roomType = "";
		
		do {			
			System.out.println("Your room type: " + reservation.getRoomType().getName());
			System.out.print("Select new room type [it can't be your current room type]: ");
			roomType = sc.nextLine();
		} while (roomType.equals(reservation.getRoomType().getName()) || (!roomType.equals("Royal") && 
				!roomType.equals("Family") && !roomType.equals("Reguler")));
		
		reservation.setRoomType(roomType);
		
		System.out.println("Upgrading reservation...");
	}

	@Override
	protected String generatePDFFile() {
		System.out.println("Generating PDF file for the reservation upgrade for Mr./Ms. " + reservation.getName() + "...");

		return "UPGRADE--MR/MS_" + reservation.getName().toUpperCase() + ".pdf";
	}

}
