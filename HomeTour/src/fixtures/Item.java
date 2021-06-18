package fixtures;

public class Item extends Fixture {
	//private String name;
	private Room currLocation;
	private Room actualLocation;


	public Item(String name, String description, Room currLoction, Room actualLocation){
		super(name, description);
		this.currLocation = currLoction;
		this.actualLocation = actualLocation;
	}
	
	
	
	public Room getCurrLocation() {
		return currLocation;
	}

	public void setCurrLocation(Room currLocation) {
		this.currLocation = currLocation;
	}

	public Room getActualLocation() {
		return actualLocation;
	}

	public void setActualLocation(Room actualLocation) {
		this.actualLocation = actualLocation;
	}


	public void setLocation(Room location) {
		this.currLocation = location;
	}
	
	public void displayCurrentLocation() {
		System.out.println(super.getName() + " is inside the: " + currLocation.getName());
	}
	
}
