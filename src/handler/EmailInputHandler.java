package handler;

import models.Reservation;

public class EmailInputHandler extends InputHandler {
	private String email;

	public EmailInputHandler(InputHandler next) {
		super(next);
	}

	@Override
	public Reservation handle(Reservation reservation) {
		do {
			System.out.print("Input customer's email [use proper email format]: ");
			email = sc.nextLine();
		} while (!validate());
		
		reservation.setEmail(email);

	    return super.handle(reservation);
	}
	
	@Override
	protected boolean validate() {
		return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
	}

}
