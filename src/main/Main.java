package main;

import java.util.Scanner;

import database.Database;
import handler.EmailInputHandler;
import handler.InputHandler;
import handler.NameInputHandler;
import handler.PriceInputHandler;
import handler.RoomTypeInputHandler;
import manager.CancelReservationManager;
import manager.ReservationManager;
import manager.UpgradeReservationManager;
import models.Reservation;

public class Main {
	private Database db = Database.getInstance();
	private Reservation current;
	Scanner sc = new Scanner(System.in);

	public Main() {
		int menu = 0;
		
		do {
			cls();
			System.out.println("Hotel Indah Berseri Reservation System");
			System.out.println("======================================");
			System.out.println("1. Insert new reservation");
			System.out.println("2. Prepare reservation");
			System.out.println("3. Manage reservations");
			System.out.println("0. Exit");
			System.out.print(">> ");
			
			try {
				menu = sc.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			sc.nextLine();
			
			if (menu == 1) {
				reserve();
			} else if (menu == 2) {
				prepareReservation();
			} else if (menu == 3) {
				manageReservations();
			}
			
		} while (menu != 0);
		
		System.exit(menu);
	}

	private void reserve() {
		InputHandler handler = new NameInputHandler(new EmailInputHandler(new RoomTypeInputHandler(new PriceInputHandler(null))));
		current = handler.handle(new Reservation());
		
		db.addReservation(current);
		
		System.out.println("Reservation success!");
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	private void prepareReservation() {
		int no = chooseReservation();
		
		if (no == 0) {
			return;
		}	
		
		db.get().get(no-1).prepare();
		
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}

	private void manageReservations() {
		int no = chooseReservation(), choose = 0;
		
		if (no == 0) {
			return;
		}	
		
		do {
			System.out.println("Choose: ");
			System.out.println("1. Cancel reservation");
			System.out.println("2. Upgrade reservation");
			System.out.println("0. Exit");
			System.out.print(">> ");
			
			try {
				choose = sc.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sc.nextLine();
			
		} while (choose < 0 || choose > 2);
		
		Reservation reservation = db.get().get(no-1);
		ReservationManager manager = null;
		
		if (choose == 1) {
			manager = new CancelReservationManager(reservation, no-1);
		} else if (choose == 2) {
			manager = new UpgradeReservationManager(reservation, no-1);
		} else if (choose == 0) {
			return;
		}
		
		manager.execute();
		
		System.out.println("Press any key to continue...");
		sc.nextLine();
	}
	
	private int chooseReservation() {
		display();
		
		if (db.get().isEmpty()) {
			return 0;
		}
		
		int no = 0;
		
		do {
			System.out.print("Enter reservation no. [1-" + db.get().size() + "]: ");
			try {
				no = sc.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sc.nextLine();
		} while (no < 1 || no > db.get().size());
		
		return no;
	}
	
	private void display() {
		if (db.get().isEmpty()) {
			System.out.println("Belum ada reservasi");
		} else {
			int i = 1;
			for (Reservation r : db.get()) {
				System.out.println(i++ + "  MR/MS " + r.getName());
				System.out.println("  Email: "+ r.getEmail());
				System.out.println("  Room Type: "+ r.getRoomType().getName());
				System.out.println("  Amount Paid: IDR "+ r.getPrice());
				System.out.println();
			}
		}
	}
	
	private void cls() {
		for(int i = 0; i < 20; i++) {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
