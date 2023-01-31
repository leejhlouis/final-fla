package models.roomTypes;

public class RoyalType extends RoomType {

	public RoyalType() {
		super("Royal", 4000000);
	}

	@Override
	public void prepareFacilities() {
		System.out.println("Preparing...");
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("- Private Jacuzzi");
		System.out.println("- Private Pool");
		System.out.println("- Free breakfast for 4");
		System.out.println("- Eligible to request menu (all day serve)");
	}

}
