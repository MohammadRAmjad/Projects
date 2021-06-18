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
	
	@Override
	public String toString() {
		return "Fixture [name=" + name + ", description=" + description + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fixture other = (Fixture) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}




	public String getName() {
		return name;
	}
}
