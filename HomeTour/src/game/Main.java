package game;

import java.util.Arrays;
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
		
		System.out.println("To sellect your next room type in the roon name "
				+ "\n" + "To leave the house type in quit");
		
		p.SetCurrentRoom(rm.getStartingRoom());
		System.out.println("Lets get started");
		
		printRoom(p);
		rm.visitedRooms(p.getCurrentRoom());
		
		boolean leave = false;
		
		
		while(leave == false) {
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
		System.out.println("Please select the room that you want to go to!");
		
		System.out.print(">> ");
		String s = input.nextLine();
		String[] result = s.split(" ");
		Arrays.toString(result);
		return result;
	}
		
	private static void parse(String[] command, Player player) {
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
		
		if(option > 0) {
			player.SetCurrentRoom(player.getCurrentRoom().getExit(option));
		}
	
	}
	
	
}
