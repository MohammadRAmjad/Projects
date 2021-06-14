package fixtures;
import java.util.*;
public class Room extends Fixture {
	
	//private Room [] exits;
	private Hashtable<String, Room > directionRoom;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		//this.exits = new Room [2];
		directionRoom = new Hashtable <String , Room>();
		
	}
	
	
/*	public void setExits(Room ex) {
		if(this.exits[0] == null) {
			exits[0] = ex;
		}else {
			exits[1] = ex;
		}
	} 
	
	public Room[] getExits() {
		return exits;
		
	} */
		
	public void setExits(String direction, Room a) {
		directionRoom.put(direction, a);
		
	}
	
	public Room getExit(String direction) {
		return directionRoom.get(direction);
	}
	
	
	public void displayExits() {
		Set<String> directionSet = directionRoom.keySet();
		for(String key: directionSet) {

            System.out.println("Direction : "  + key 
                    + "\t\t Room : "  + directionRoom.get(key).getName());
		}
	}


}
