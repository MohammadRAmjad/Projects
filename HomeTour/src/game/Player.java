package game;
import java.util.*;
import fixtures.Room;

public class Player {
	Stack<Room> visitedRoomList;
	
	private String name;
	
	public Player() {
		visitedRoomList = new Stack<Room>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addRoomToList(Room current) {
		visitedRoomList.add(current);
	}
	
	public String getCurrentRoom() {
		Room curr = visitedRoomList.peek();
		return curr.getName();	
	}
}
