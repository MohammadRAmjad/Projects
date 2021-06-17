package fixtures;

public class Item extends Fixture {
	private String name;
	private Room currLocation;
	private Room actualLocation;


	public Item(String name, String description, Room currLoction, Room actualLocation){
		super(name, description);
		this.currLocation = currLoction;
		this.actualLocation = actualLocation;
	}
	
	public String getName() {
		return name;
	}
	
	public Room getLocation() {
		return currLocation;
	}
	public void setLocation(Room location) {
		this.currLocation = location;
	}
	
	public void displayCurrentLocation() {
		System.out.println(name + " is inside the: " + currLocation.getName());
	}
	
	public boolean moveable() {
		if (currLocation != actualLocation)
			return true;
		return false;
	}
	
	
}
