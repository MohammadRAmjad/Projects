package fixtures;
import java.util.*;
public class Room extends Fixture {
	
	private ArrayList<Room> exits;
	
	private Room innerRoom;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		exits = new ArrayList<Room>();
		
	}	
	
	public Room(String name, String shortDescription, String longDescription, Room inner) {
		this(name, shortDescription, longDescription);
		
	
		this.innerRoom = inner;
		
	}	
		
	public void setExits( Room a) {
		exits.add(a);
		
	}
	
	public Room getExit(int index) {
		
		return exits.get( index - 1);
		
	}
	
	
	public void displayExits() {
		
		for(Room r : exits) {

            System.out.println("Option: "  + (exits.indexOf(r) +1) 
                    + "\t"  + r.getName());
		}
		System.out.println();
	}
	
	


}
