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
			"An entryway that opens up to a hallway " + "\n"
			+ "It .");
	    
	    Room livingRoom = new Room(
	    		"The LivingRoom",
	    		"The living room.",
	    		" Kitchen and the dining room are on the right hand side."
	    	+ "\n" + "Accross you is the padio."
	    		);
	    Room kitchen = new Room(
	    		"The Kitchen",
	    		"This is the cooking area.",
	    		" The kitchen is connected to the garage and the dining room."
	    		);
	    
	    Room library = new Room(
	    		"The Library",
	    		"This Room full of surprises.",
	    		" This room is connected to the hallway. "
	    		+ "\n" + "There are few books missing come back here when you found them."
	    	
	    		);
	    
	    Room diningRoom = new Room(
	    		"The DiningRoom",
	    		"The Dining Room",
	    		"A great dining area to enjoy meals with the family." + "\n"+
	    		" This place is connected to the kitchen and the living room."
	    		);
	    
	    Room padio = new Room(
	    		"The Padio",
	    		"The place to have BBQ.",
	    		" This is the place to have a dirink and relax and enjoy the sunset. "
	    		);
	    
	    Room garage = new Room(
	    		"The garage",
	    		"Double space parking.",
	    		" The garage is connected to the kitchen."
	    		);
	    
	    Room stairs = new Room(
	    		"Staircase",
	    		"The upper level stair case.",
	    		" A circular shape set of stairs that connects first and second floor."
	    		);
	    
	    Room bathRoom = new Room(
	    		"bathRoom",
	    		"Down stairs bath room",
	    		" Just a bath room"
	    		);
	    
	    Room guestBathRoom = new Room(
	    		"The GuestBathRoom",
	    		"Guest room bath",
	    		""
	    		);
	    Room masterBathRoom = new Room(
	    		"The Masterbathroom",
	    		"Master bedroom bad.",
	    		" Hi "
	    		);
	    Room upperFloorBathRoom = new Room(
	    		"BathRoom",
	    		"upper floor bath room.",
	    		" but in the upper floor."
	    		);
	    Room guestRoom = new Room(
	    		"The GuestRoom",
	    		"The Guest Room",
	    		"This Room is for guests who stay the night."
	    		, guestBathRoom
	    		);
	    Room masterBedRoom = new Room(
	    		"The MasterBedRoom",
	    		"The Master Bed Room",
	    		"The place for a good night sleep." + "\n" +
	    		" it is connected to the hallway. ", masterBathRoom
	    		);
	    Room bedRoom1 = new Room(
	    		"The Bedroom",
	    		"This is one bed room.",
	    		" Hi"
	    		);
	    Room bedRoom2 = new Room(
	    		"The Bedroom",
	    		"This is another bed room.",
	    		" Hi "
	    		);
	    
	    Room laundry = new Room(
	    		"The laundry",
	    		"This Room is for guests who stay the night.",
	    		" Hi "
	    		);
	    
	    Room downStairsHallway = new Room(
	    		"The Hallway",
	    		"Connects foyer to the living room.",
	    		" As soon as you enter the hallway the library is on you left side. " 
	    		+ "\n" + "Further down on the left side is the staircase to the second floor."
	    		+ "\n" + "Further down on the left side is the staircase to the second floor."
	    		+ "\n" + "Accross the staircase is the bath room. and at the end of the hallway is the living room"
	    		);
	    
	    Room upStairsHallway = new Room(
	    		"TupStairsHallway",
	    		"This Room is for guests who stay the night.",
	    		" Hi "
	    		);
	    
	    
	    
	    //first floor rooms
			this.rooms.add(foyer);
			this.rooms.add(livingRoom);
			this.rooms.add(kitchen);
			this.rooms.add(library);
			this.rooms.add(diningRoom);
			this.rooms.add(padio);
			this.rooms.add(bathRoom);
			this.rooms.add(stairs);
			this.rooms.add(garage);
			this.rooms.add(downStairsHallway);
			
			// Second floor rooms
			this.rooms.add(guestRoom);
			this.rooms.add(bedRoom1);
			this.rooms.add(bedRoom2);
			this.rooms.add(masterBedRoom);
			this.rooms.add(upperFloorBathRoom);
			this.rooms.add(laundry);
			this.rooms.add(guestBathRoom);
			this.rooms.add(masterBathRoom);
			
			
			foyer.setExits(downStairsHallway);
			downStairsHallway.setExits(foyer);
			downStairsHallway.setExits(library);
			downStairsHallway.setExits(stairs);
			downStairsHallway.setExits(bathRoom);
			downStairsHallway.setExits(livingRoom);
			
			livingRoom.setExits(kitchen);
			livingRoom.setExits(diningRoom);
			livingRoom.setExits(padio);
			livingRoom.setExits(downStairsHallway);
			
			kitchen.setExits(livingRoom);
			kitchen.setExits(diningRoom);
			kitchen.setExits(garage);
			
			diningRoom.setExits(kitchen);
			diningRoom.setExits(livingRoom);
			
			bathRoom.setExits(downStairsHallway);
			library.setExits(downStairsHallway);
			stairs.setExits(downStairsHallway);
			stairs.setExits(upStairsHallway);
			garage.setExits(kitchen);
			padio.setExits(upStairsHallway);
			
			
			upStairsHallway.setExits(stairs);
			upStairsHallway.setExits(laundry);
			upStairsHallway.setExits(masterBedRoom);
			upStairsHallway.setExits(guestRoom);
			upStairsHallway.setExits(bedRoom1);
			upStairsHallway.setExits(bedRoom2);
			upStairsHallway.setExits(upperFloorBathRoom);
			
			laundry.setExits(upStairsHallway);
			masterBedRoom.setExits(upStairsHallway);
			masterBedRoom.setExits(masterBathRoom);
			masterBathRoom.setExits(masterBathRoom);
			guestRoom.setExits(upStairsHallway);
			guestRoom.setExits(guestBathRoom);
			guestBathRoom.setExits(guestRoom);
			bedRoom1.setExits(upStairsHallway);
			bedRoom2.setExits(upStairsHallway);
			upperFloorBathRoom.setExits(upStairsHallway);
			
			
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
	
	public boolean allRoomVisited() {
		if(rooms.size() == visitedRoomList.size()) {
			return true;
		}
		return false;
	}

}
