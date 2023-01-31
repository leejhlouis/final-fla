package models;

import models.roomTypes.FamilyType;
import models.roomTypes.RegulerType;
import models.roomTypes.RoomType;
import models.roomTypes.RoyalType;

public class Reservation {
	private String name;
	private String email;
	private RoomType roomType;
	private int price;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}
	
	public void setRoomType(String roomType) {
		if (roomType.equals("Royal")) {
			this.roomType = new RoyalType();
		} else if (roomType.equals("Family")) {
			this.roomType = new FamilyType();
		} else {
			this.roomType = new RegulerType();
		}
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void prepare() {
		this.roomType.prepareFacilities();
	}
}
