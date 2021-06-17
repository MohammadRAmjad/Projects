package game;

import java.util.Scanner;

public class Main {
	
	private static Scanner input = new Scanner(System.in);
	static RoomManager rm ;
	public static void main(String[] args) {
		rm = new RoomManager();
		Player p = new Player();
		rm.init();
		//System.out.println("Please Enter ypur name");
		//String name = input.nextLine();
		//p.setName(name);
		//System.out.println("Welcom " + p.getName() + "Lets get started");
		
		System.out.println("To sellect your next room type in the option");
				
		
		p.SetCurrentRoom(rm.getStartingRoom());
		System.out.println("Lets get started");
		System.out.println();
		
		printRoom(p);
		rm.visitedRooms(p.getCurrentRoom());
		
	
		
		
		while(true) {
			System.out.println("Please select the room that you want to go to!");
			String[] comm = collectInput();
			parse(comm,  p);
			printRoom(p);	
		}	
	}
	
	private static void printRoom(Player player) {
		System.out.println("Your are in:");
		System.out.println();
		rm.roomDescription(player.getCurrentRoom());
		
	}

	private static String[] collectInput() {
		
		System.out.print(">> ");
		String s = input.nextLine();
		String[] result = s.split(" ");
		return result;
	}
		
	private static void parse(String[] command, Player player) {
		 int choice = parseOptions(command);
		
		
		
		switch(choice) {
			case 0:
				System.out.println("Goodbye");
				System.exit(0);
				break;
			case 1, 2, 3, 4, 5, 6:
				player.SetCurrentRoom(player.getCurrentRoom().getExit(choice));
				rm.visitedRooms(player.getCurrentRoom());
				break;
			case 7:
				if(player.getCurrentRoom().isEmpty())
					System.out.println("There is nothing here");
				else {
					player.getCurrentRoom().displayItems();
					if(player.getCurrentRoom().notInItsPlace()) {
						System.out.println("There is nothing here");
					}
				}
				break;
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
				System.out.println("you did not select any option");
				continue;
			}			
		}
		return option;
	}
	
	
}
