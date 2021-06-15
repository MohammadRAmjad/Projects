package game;
import java.util.*;
import fixtures.Room;
import fixtures.Room;

public class Player {
	
	
	private String name;
	private Room currentRoom;
	public void setName(String name) {
		this.name = name;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void SetCurrentRoom(Room current) {
		currentRoom = current;
	}
	
	public Room getCurrentRoom() {
		
		return currentRoom;
	}
}
