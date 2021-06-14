package game;

import java.util.Scanner;

public class Main {
	
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Player p = new Player();
		System.out.println("Please Enter ypur name");
		String name = input.nextLine();
		p.setName(name);
		
		
	}
	
	private static void printRoom(Player player) {
		System.out.println("Your current Room is: " + player.getName());
	}

	private static String[] collectInput() {
		System.out.println("Please select the direction that you wat to go!");
		System.out.print(">> ");
		String s = input.nextLine();
		String[] result = s.split(" ");
		
		return result;
	}
		
	private static void parse(String[] command, Player player) {

	}

}
