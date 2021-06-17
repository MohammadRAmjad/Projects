package fixtures;

public abstract class Fixture {
	private String name;
	private String description;

	
	public Fixture(String name, String description) {
		this .name = name;
		this.description = description;
	}
	
	
	
	
	public String getDescription() {
		return this.description;
	}
	
	public String getName() {
		return name;
	}
}
