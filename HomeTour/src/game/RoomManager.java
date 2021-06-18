package game;
import fixtures.Room;
import fixtures.Item;
import java.util.*;

public class RoomManager {
	private Room startingRoom;
	private ArrayList <Room> rooms;
	private Stack<Room> visitedRoomList;
	private ArrayList <Item> itemsList; 
	private Item misplacedItem;
	
	
	public RoomManager() {
		rooms = new ArrayList<Room>();
		visitedRoomList = new Stack<Room>();
		itemsList = new ArrayList<Item>();
		misplacedItem = null;
	}
	
	public void init() {
	   
			genMap(rooms);
	        this.startingRoom = rooms.get(0);
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
	
	public void displayExits(Room a) {
		
		 Item t = null;
	     System.out.println("Your Exit Options are:");
		
		for(Room r : a.getExits()) {
	
	        System.out.println("Option: "  + (a.getExits().indexOf(r) +1) 
	                + "\t"  + r.getName());
		}
		System.out.println("Option: " + (a.getExits().size() + 1)  + "\t"  + "Exit");
		System.out.println();
		if(a.getItems().isEmpty()) {
			System.out.println("There is nothing in this room");
		}
		for(Item r : a.getItems()) {
	
	        System.out.println("Item: " + r.getName() 
	                + "\t"  + r.getDescription());
	        if(!(r.getActualLocation().equals(r.getCurrLocation())))
	        	t = r;
		}
		System.out.println();
		
		if(t != null) {
			System.out.println(t.getName() + " Should not be in this room");
			System.out.println();
			misplacedItem  = t;
		}		
	}
	
	public void addItem(Item stuff, Room a) {
		a.getItems().add(stuff);
	}
	
	
	public void removeItem(Item item, Room a) {
		
		if(a.getItems().contains(item))
			a.getItems().remove(item);
	
	}

	public boolean isThereAnItem() {
		boolean m = (misplacedItem == null) ? true : false;
		return m;	
	}
	
	public void setMisplacedItem(Item t) {
		misplacedItem = t;
	}
	
	
	public Item getMisplacedObject() {
		return misplacedItem;
	}
	
	
	public boolean allRoomVisited() {
		return rooms.size() == visitedRoomList.size();
	
	}
	
	public Room getManCave(){
		
		for(Room r : rooms) {
			if(r.getName().equalsIgnoreCase("Hidden Heaven")) {
				return r;
			}
		}
		return null;
	}
		
	
	
	
	private static void genMap(ArrayList <Room> rooms) {
			   Room foyer = new Room(
					"The Foyer",
					"A small foyer that connects to the hallway.,");

			  
			    
			    Room livingRoom = new Room(
			    		"The Living room",
			    		" Kitchen and the dining room are on the right hand side."
			    	+ "\n" + "Accross you is the padio."
			    		);
			    
			    Item lrt1 = new Item("TV", "Sony X90J 65 Inch TV: BRAVIA XR Full Array LED 4K Ultra HD Smart "
			    		+ "\n" + "Google TV with Dolby Vision HDR and Alexa Compatibility", livingRoom, livingRoom);
			    Item lrt2 = new Item("Sound System", "Platin Milan 5.1 with WiSA SoundSend. "
			    		+ "\n" + "Feature 5.1 Channels of Uncompressed 24-bit 48 kHz Sound", livingRoom, livingRoom);
			    livingRoom.getItems().add(lrt1);
			    livingRoom.getItems().add(lrt2);
			    
			    
			    Room kitchen = new Room(
			    		"The Kitchen",
			    		"This is the cooking area."
			    				+ "\n" + " The kitchen is connected to the garage and the dining room."
			    		);
			    
			    Item kt1 = new Item("Microwave", "not good for your health.", kitchen, kitchen);
			    kitchen.getItems().add(kt1);
			    
			    
			    Room library = new Room(
			    		"The Library",
			    		"The library is connected to the hallway!!"
			    		+ "\n" + "This Room full of surprises. There are few books missing come back here when you found them.");
			    Item lt1 = new Item("Bookshelf", "Wooden bookshelf", library, library);
			    Item lt2 = new Item("Chair", "study chair", library, library);
			    library.getItems().add(lt1);
			    library.getItems().add(lt2);
			    
		/*	    Room foyer = new Room(
						"The Foyer",
						"A small foyer that connects to the hallway.,");
			 Item ft1= new Item("Sound System", "Platin Milan 5.1 with WiSA SoundSend. "
			    		+ "\n" + "Feature 5.1 Channels of Uncompressed 24-bit 48 kHz Sound", foyer, library);
			 foyer.getItems().add(ft1);*/
			    
			    Room manCave = new Room(
			    		"Hidden Heaven",
			    		"This is the place that you can enjoy your ftee time."
			    		+ "\n" + "This Room has everything you need.");
			    
			    Item mct1 = new Item("Pool Table", "Brunswick Black Wolf Pro Pool Table", manCave, manCave);
			    Item mct2 = new Item("PS5", "gaming console", manCave, manCave);
			    Item mct3 = new Item("TV", "Samsung - 85\" Class Q950TS Series QLED 8K UHD Smart Tizen TV", manCave, manCave);
			    manCave.getItems().add(mct1);
			    manCave.getItems().add(mct2);
			    manCave.getItems().add(mct3);
		
			    
			    Room diningRoom = new Room(
			    		"The Dining Room",
			    		"A great dining area to enjoy meals with the family." + "\n"+
			    		" This place is connected to the kitchen and the living room.");
			    		
			    Item dt1 = new Item("Dining Table", "8 seat table", diningRoom, diningRoom);
			    diningRoom.getItems().add(dt1);
			    
			    Room padio = new Room(
			    		"The Padio",
			    		"You can only go back to the living room from here."
			    		+ "\n" + " This is the place to have a dirink and relax and enjoy the sunset. ");
			    		
			    Item pt1 = new Item("Dining Table", "8 seat table", padio, padio);
			    padio.getItems().add(pt1);
			    
			    Room garage = new Room(
			    		"The garage",
			    		"Double space parking, which is connected to the kitchen.");
			    		
			    
			    Room stairs = new Room(
			    		"Staircase",
			    		"The upper level stair case.");
			    
			    Room bathRoom = new Room(
			    		"bathroom",
			    		"Down stairs bath room");
			    	
			    	
			    
			    Room guestBathRoom = new Room(
			    		"The Guest Bathroom",
			    		"Guest room bath");
			    		
			    	
			    Room masterBathRoom = new Room(
			    		"The Master bathroom",
			    		"The master bed room is connected to the hallway");
			    		
			    		
			    Room upperFloorBathRoom = new Room(
			    		"Bathroom",
			    		"upper floor bath room.");
			    
			    Room guestRoom = new Room(
			    		"The Guestroom",
			    		"This Room is connected to the hallway.", guestBathRoom);
			    
			    Item gt1 = new Item("Bed", "Queen size", guestRoom, guestRoom);
			    Item gt2 = new Item("Bedside table", "black", guestRoom, guestRoom);
			    Item gt3 = new Item("Another bedside table", "black", guestRoom, guestRoom);
			    Item gt4 = new Item("Java Book", "Core Java version 8", guestRoom, library);
			    guestRoom.getItems().add(gt1);
			    guestRoom.getItems().add(gt2);
			    guestRoom.getItems().add(gt3);
			    guestRoom.getItems().add(gt4);
			    		
			    Room masterBedRoom = new Room(
			    		"The Master Bedroom",
			    		"The place for a good night sleep." + "\n" +
			    		" This room is connected to the hallway. ", masterBathRoom);
			    
			    Item mt1 = new Item("Bed", "Queen size", masterBedRoom, masterBedRoom);
			    Item mt2 = new Item("Bedside table", "black", masterBedRoom, masterBedRoom);
			    Item mt3 = new Item("bedside table", "black", masterBedRoom, masterBedRoom);
			    masterBedRoom.getItems().add(mt1);
			    masterBedRoom.getItems().add(mt2);
			    masterBedRoom.getItems().add(mt3);
			    
			    
			    Room bedRoom1 = new Room(
			    		"The Bedroom",
			    		"This is one bed room. It is connected to the hallway");
			    		
			    		
			    Room bedRoom2 = new Room(
			    		"The Bedroom",
			    		"This is another bed room. It is connected to the hallway.");
			    		
			    		
			    
			    Room laundry = new Room(
			    		"The laundry",
			    		"From here you can go back to the hallway");
			    		
			    	
			    
			    Room downStairsHallway = new Room(
			    		"The Hallway",
			    		"Connects foyer to the living room."
			    		+ "\n" + " As soon as you enter the hallway the library is on you left side. " 
			    		+ "\n" + "Further down on the left side is the staircase to the second floor."
			    		+ "\n" + "Accross the staircase is the bath room. and at the end of the hallway is the living room"
			    		);
			    
			    
			    Room upStairsHallway = new Room(
			    		"The up stairs Hallway",
			    		"Connects foyer to the living room."
					    		+ "\n" + " When you enter the hallway there are 2 bedrooms on the leftside. " 
					    		+ "\n" + "Further down on the left side is the Master bedroom."
					    		+ "\n" + "Down the hallway on the right hand side side is the guest room."
					    		+ "\n" + "Accross is the upstairs bathroom and next to it on the left is the laundry room. "
					    		);
			    		
			    	
			    
			    
			    
			    //first floor rooms
					rooms.add(foyer);
					rooms.add(livingRoom);
					rooms.add(kitchen);
					rooms.add(library);
					rooms.add(manCave);
					rooms.add(diningRoom);
					rooms.add(padio);
					rooms.add(bathRoom);
					rooms.add(stairs);
					rooms.add(garage);
					rooms.add(downStairsHallway);
					
					// Second floor rooms
					rooms.add(guestRoom);
					rooms.add(bedRoom1);
					rooms.add(bedRoom2);
					rooms.add(masterBedRoom);
					rooms.add(upperFloorBathRoom);
					rooms.add(laundry);
					rooms.add(guestBathRoom);
					rooms.add(masterBathRoom);
					rooms.add(guestRoom);
					
					
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
					manCave.setExits(library);
	}
}
