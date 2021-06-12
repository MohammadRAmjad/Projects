package fixtures;

public abstract class Fixture {
	private String name;
	private String shortDescription;
	private String longDescription;
	
	
	public Fixture(String name, String shortDescription, String longDescription) {
		this .name = name;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	public String getLongDescription() {
		return longDescription;
	}
	
	public String getName() {
		return name;
	}
}
