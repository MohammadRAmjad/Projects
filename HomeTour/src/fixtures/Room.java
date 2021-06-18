package fixtures;
import java.util.*;
public class Room extends Fixture {
	
	private ArrayList<Room> exits;
	private ArrayList<Item> items;
	
	private Room innerRoom;
	
	public Room(String name, String description) {
		super(name, description);
		exits = new ArrayList<Room>();
		items = new ArrayList<Item>();
		this.innerRoom = null;
		
	}	
	
	public Room(String name, String description, Room inner) {
		this(name, description);
		this.innerRoom = inner;
		
	}	
		
	public void setExits( Room a) {
		exits.add(a);
		
	}
	
	public Room getExit(int index) {
		
		return exits.get( index - 1);
		
	}
	
	public ArrayList<Room> getExits(){
		return exits;
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((exits == null) ? 0 : exits.hashCode());
		result = prime * result + ((innerRoom == null) ? 0 : innerRoom.hashCode());
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (exits == null) {
			if (other.exits != null)
				return false;
		} else if (!exits.equals(other.exits))
			return false;
		if (innerRoom == null) {
			if (other.innerRoom != null)
				return false;
		} else if (!innerRoom.equals(other.innerRoom))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

	public boolean isEmpty() {
		return items.isEmpty();
			
	}

}
