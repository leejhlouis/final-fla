package handler;

import models.Reservation;

public class NameInputHandler extends InputHandler {
	private String name;

	public NameInputHandler(InputHandler next) {
		super(next);
	}

	@Override
	public Reservation handle(Reservation reservation) {
		do {
			System.out.print("Input customer's name [must be filled]: ");
			name = sc.nextLine();
		} while (!validate());
		
		reservation.setName(name);

	    return super.handle(reservation);
	}
	
	@Override
	protected boolean validate() {
		return !name.isEmpty();
	}

}
