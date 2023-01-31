package models.roomTypes;

public class FamilyType extends RoomType {

	public FamilyType() {
		super("Family", 2000000);
	}

	@Override
	public void prepareFacilities() {
		System.out.println("Preparing...");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("- Private Jacuzzi");
		System.out.println("- Free breakfast for 3");
		System.out.println("- Eligible to request menu (dinner only)");
	}

}
