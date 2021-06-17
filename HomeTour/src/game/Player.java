package game;
import java.util.*;

import fixtures.Item;
import fixtures.Room;


public class Player {
	
	private Room currentRoom;
	//private ArrayList<Item> toCarry;
	private Item item;
	
	public Player() {
		//toCarry = new ArrayList<Item>();
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
		currentRoom.addItem(item);
		
	}
	
}
