package game;
import fixtures.Room;
import java.util.*;

public class RoomManager {
	private Room startingRoom;
	private ArrayList <Room> rooms;
	private Stack<Room> visitedRoomList;
	
	public RoomManager() {
		rooms = new ArrayList<Room>();
		visitedRoomList = new Stack<Room>();
	}
	
	public void init() {
	    Room foyer = new Room(
			"The Foyer",
			"a small foyer",
			"The small entryway of a neo-colonial house. A dining room is open to the south, where a large table can be seen." + "\n"
			+ "The hardwood floor leads west into doorway, next to a staircase that leads up to a second floor." + "\n"
			+ "To the north is a small room, where you can see a piano.");
	    
	    Room livingRoom = new Room(
	    		"The Living Room",
	    		"This is the main sitting area.",
	    		" Hi "
	    		);
	    Room kitchen = new Room(
	    		"The Kitchen",
	    		"This is the cooking area.",
	    		" Hi "
	    		);
	    Room guestRoom = new Room(
	    		"The Guest Room",
	    		"This Room is for guests who stay the night.",
	    		" Hi "
	    		);
	    Room bounesRoom = new Room(
	    		"The Bounes Room",
	    		"This Room is for guests who stay the night.",
	    		" Hi "
	    		);
	    
	    Room diningRoom = new Room(
	    		"The Dining Room",
	    		"A great dining area to enjoy meals with the family.",
	    		" Hi "
	    		);
	    
	    Room padio = new Room(
	    		"The Padio",
	    		"The place to have BBQ.",
	    		" Hi "
	    		);
	    
	    Room garage = new Room(
	    		"The garage",
	    		"Double space parking.",
	    		" Hi "
	    		);
	    
			this.rooms.add(foyer);
			this.rooms.add(livingRoom);
			this.rooms.add(kitchen);
			this.rooms.add(guestRoom);
			this.rooms.add(bounesRoom);
			this.rooms.add(diningRoom);
			this.rooms.add(padio);
			
			foyer.setExits("north", livingRoom);
			foyer.setExits("south", bounesRoom);
			livingRoom.setExits("west", kitchen);
			livingRoom.setExits("north", padio);
			livingRoom.setExits("south", foyer);
			kitchen.setExits("east", livingRoom);
			kitchen.setExits("North", diningRoom);
			kitchen.setExits("west", garage);
			
	        this.startingRoom = foyer;
	}
	
	public Room getStartingRoom() {
		return startingRoom;
	}
	
	public void visitedRooms(Room current) {
		visitedRoomList.add(current);
	}
	
	public String getCurrentRoom() {
		Room curr = visitedRoomList.peek();
		return curr.getName();	
	}
	
	public void roomDescription(Room a) {
		System.out.println(a.getName() + "\n" + a.getShortDescription()  
		+ "\n" + a.getLongDescription());
		System.out.println();
		a.displayExits();
	}

}
