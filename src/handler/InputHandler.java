package handler;

import java.util.Scanner;

import models.Reservation;

public abstract class InputHandler {
	protected InputHandler next;
	
	Scanner sc = new Scanner(System.in);
	
	public InputHandler(InputHandler next){
		this.next = next;
	}

	public Reservation handle(Reservation reservation) {
		return next != null ? next.handle(reservation) : reservation;
	}
	
    abstract protected boolean validate();

}
