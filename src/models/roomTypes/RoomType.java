package models.roomTypes;

public abstract class RoomType {
	private String name;
	private Integer minPrice;
	
	public RoomType(String name, Integer minPrice) {
		super();
		this.name = name;
		this.minPrice = minPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	
	abstract public void prepareFacilities();
}
