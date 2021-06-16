package fixtures;

public abstract class Item {
	private String name;
	private String location;
	public Item(String name) {
		this.name = name;
	}
	public Item(String name, String location){
		this(name);
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
