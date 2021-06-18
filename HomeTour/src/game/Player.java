package game;
import java.util.*;

import fixtures.Item;
import fixtures.Room;


public class Player {
	
	private Room currentRoom;
	
	private Item item;
	
	public Player() {
		currentRoom = null;
		item = null;
	}
	
	
	
	public void SetCurrentRoom(Room current) {
		currentRoom = current;
	}
	
	public Room getCurrentRoom() {
		
		return currentRoom;
	}
	
	public void pickUp(Item a) {
		item = a;
	}
	
	public void putItem() {
		item = null;	
	}
	
	public Item getcarryingItem() {
		return item;
	}
	
public boolean isEmpty () {
		if(item == null)
			return true;
		return false;
	}
	
	
}
