package handler;

import java.util.ArrayList;
import java.util.Arrays;

import models.Reservation;

public class RoomTypeInputHandler extends InputHandler {
	private String roomType;

	public RoomTypeInputHandler(InputHandler next) {
		super(next);
	}

	@Override
	public Reservation handle(Reservation reservation) {
		do {
			System.out.print("Input room type [Royal | Family | Reguler]: ");
			roomType = sc.nextLine();
		} while (!validate());
		
		reservation.setRoomType(roomType);

	    return super.handle(reservation);
	}
	
	@Override
	protected boolean validate() {
		ArrayList<String> roomTypeList = new ArrayList<String>(Arrays.asList("Royal", "Family", "Reguler"));
		
		return roomTypeList.contains(roomType);
	}

}
