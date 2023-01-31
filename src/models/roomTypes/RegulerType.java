package models.roomTypes;

public class RegulerType extends RoomType {

	public RegulerType() {
		super("Reguler", 1000000);
	}

	@Override
	public void prepareFacilities() {
		System.out.println("Preparing...");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("- Mini Fridge inside Bedroom");
		System.out.println("- Free breakfast for 2");
	}

}
