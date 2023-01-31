package handler;

import models.Reservation;
import models.roomTypes.RoomType;

public class PriceInputHandler extends InputHandler {
	private Integer price;
	private RoomType roomType;

	public PriceInputHandler(InputHandler next) {
		super(next);
	}

	@Override
	public Reservation handle(Reservation reservation) {
		this.roomType = reservation.getRoomType();
		
		do {
			System.out.println("You must pay min. IDR " + roomType.getMinPrice() + " for the " + roomType.getName() + " type");
			System.out.print("Input price: ");
			
			try {
				price = sc.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
			}
			sc.nextLine();
		} while (!validate());
		
		reservation.setPrice(price);

	    return super.handle(reservation);
	}
	
	@Override
	protected boolean validate() {
		return price >= roomType.getMinPrice();
	}

}
