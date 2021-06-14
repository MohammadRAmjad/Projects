package fixtures;
import java.util.*;
public class Room extends Fixture {
	
	private Room [] exits;
	private Hashtable<Integer, String > directionSet;
	
	public Room(String name, String shortDescription, String longDescription) {
		super(name, shortDescription, longDescription);
		//this.exits = new Room [2];
		directionSet = new Hashtable <Integer, String>();
		
	}
	
	
	public void setExits(Room ex) {
		if(this.exits[0] == null) {
			exits[0] = ex;
		}else {
			exits[1] = ex;
		}
	} 
	
	public Room[] getExits() {
		return exits;
		
	} 
		
	public void setExits(int index, String direction) {
		directionSet.put(index, direction);
		
	}
	


}
