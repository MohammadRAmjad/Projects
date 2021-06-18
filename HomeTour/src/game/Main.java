package game;

import java.util.Scanner;

public class Main {
	
	private static Scanner input = new Scanner(System.in);
	static RoomManager rm ;
	public static void main(String[] args) {
		rm = new RoomManager();
		Player p = new Player();
		rm.init();

		System.out.println("To sellect your next room type in the option");
				
		
		p.SetCurrentRoom(rm.getStartingRoom());
		System.out.println("Lets get started");
		System.out.println();
		
		printRoom(p);
		rm.visitedRooms(p.getCurrentRoom());
		
	
		
		
		while(true) {
			if (rm.isThereAnItem())
				System.out.println("Please select the room that you want to go to!");
			else 
				System.out.println("Type in 'YES' to put it or select another room to go to!");
			String[] comm = collectInput();
			parse(comm,  p);
			printRoom(p);	
		}	
	}
	
	private static void printRoom(Player player) {
		System.out.println("Your are in: " + player.getCurrentRoom().getName());
		System.out.println();
		rm.displayExits(player.getCurrentRoom());
		
	}

	private static String[] collectInput() {
		
		System.out.print(">> ");
		String s = input.nextLine();
		String[] result = s.split(" ");
		return result;
	}
		
	private static void parse(String[] command, Player player) {
		 int choice = parseOptions(command);
		 	
		 	
		 	
		 	if (choice > 0) {
		
		 		if (choice <= player.getCurrentRoom().getExits().size()) {
		 			player.SetCurrentRoom(player.getCurrentRoom().getExit(choice));
					rm.visitedRooms(player.getCurrentRoom());
					if(!player.isEmpty()) {		
				 			if(player.getCurrentRoom().equals(player.getcarryingItem().getActualLocation())) {	
						 		System.out.println("Here is the place to put " + player.getcarryingItem().getName());
						 		System.out.println("Here is a prize for your hard work!!");
						 		player.getCurrentRoom().setExits(rm.getManCave());
				 			}	
				 	}	
					
		 		}else if(choice == player.getCurrentRoom().getExits().size() + 1) {
		 			System.out.println("Goodbye");
					System.exit(0);
				}
		 	}
		 	else {
		 		if(command[0].equalsIgnoreCase("yes")) {
		 			player.pickUp(rm.getMisplacedObject());
		 			rm.removeItem(player.getcarryingItem(), player.getCurrentRoom());
		 			rm.setMisplacedItem(null);
		 			rm.getMisplacedObject();
		 			}
		 		}	
		 		
		
	}
	
	private static int parseOptions(String[] command) {
		int option = 0;
		for(int i = 0; i < command.length; i++) {
			try {
				option = Integer.parseInt(command[i]);
				break;
				
			} catch(NumberFormatException e) {
				option = 0;
				continue;
			}			
		}
		return option;
	}
	
}
