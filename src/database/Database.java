package database;

import java.util.ArrayList;

import models.Reservation;

public class Database {
	private static Database instance;
	private ArrayList<Reservation> reservations;
	
	private Database() {
		this.reservations = new ArrayList<>();
	}
	
	public synchronized static Database getInstance() {
		return instance = (instance == null) ? new Database() : instance;
	}
	
	public ArrayList<Reservation> get(){
		return reservations;
	}
	
	public void addReservation(Reservation reservation) {
		this.reservations.add(reservation);
	}
	
	public void cancelReservation(Reservation reservation) {
		this.reservations.remove(reservation);
	}
}
