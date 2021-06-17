package fixtures;
import java.util.*;
public class Room extends Fixture {
	
	private ArrayList<Room> exits;
	private ArrayList<Item> items;
	
	private Room innerRoom;
	
	public Room(String name, String description) {
		super(name, description);
		exits = new ArrayList<Room>();
		items = new ArrayList<Item>();
		this.innerRoom = null;
		
	}	
	
	public Room(String name, String description, Room inner) {
		this(name, description);
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
	
	public void addItem(Item stuff) {
		items.add(stuff);
	}
	public void removeItem(Item stuff) {
		
		for(Item i : items) {
			if(i == stuff)
				items.remove(stuff);
		}
	}
	
	public void displayItems() {
		for(Item r : items) {

            System.out.println("Item: "  + (items.indexOf(r) +1) 
                    + "\t"  + r.getName());
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
			
	}
	
	public boolean notInItsPlace() {
		boolean r = false;
		for(Item item : items) {
			if(item.moveable()) {
				r = true;	
			}
		}
		return r;
		
	}
	
	public Item misplacedItem() {
		for(Item item : items) {
			if(item.moveable()) {
				return item;	
			}
		}
		return null;
		
	}


}
