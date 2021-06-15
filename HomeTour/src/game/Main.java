package game;

import java.util.Scanner;

public class Main {
	
	private static Scanner input = new Scanner(System.in);
	static RoomManager rm ;
	public static void main(String[] args) {
		rm = new RoomManager();
		Player p = new Player();
		rm.init();
		System.out.println("Please Enter ypur name");
		String name = input.nextLine();
		p.setName(name);
		System.out.println("Welcom " + p.getName() + "Lets get started");
		p.SetCurrentRoom(rm.getStartingRoom());
		printRoom(p);
		
		boolean leave = false;
		
		
		while(leave == false) {
			String[] comm = collectInput();
			parse(comm,  p);
			printRoom(p);	
		}
		
		
		
	}
	
	private static void printRoom(Player player) {
		System.out.println("Your are in:");
		rm.roomDescription(player.getCurrentRoom());
		
	}

	private static String[] collectInput() {
		System.out.println("Please select the direction that you want to go!");
		
		System.out.print(">> ");
		String s = input.nextLine();
		String[] result = s.split(" ");
		
		return result;
	}
		
	private static void parse(String[] command, Player player) {
		String cmd = "";
		for(int i = 0; i < command.length; i++) {
			if (command[i].equalsIgnoreCase("north") || command[i].equalsIgnoreCase("south") 
					|| command[i].equalsIgnoreCase("east") || command[i].equalsIgnoreCase("west")){
						cmd += command[i];
						player.SetCurrentRoom(player.getCurrentRoom().getExit(cmd));
					}
		/*	switch(cmd) {
				case "north":
						player.SetCurrentRoom(player.getCurrentRoom().getExit(cmd));
					break;
				case "south":
					break;
				case "east":
					break;
				case "west":
					break;
				case "quit":
					System.out.println("Goodby " + player.getName());
				 
				
			}*/
		
	}
	
	

	}

}
