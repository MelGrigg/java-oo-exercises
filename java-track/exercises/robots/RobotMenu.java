package robots;

import java.util.ArrayList;
import java.util.Scanner;

public class RobotMenu {
	
	private ArrayList<Robot> robots;
	private Scanner s;
	
	public RobotMenu() {
		s = new Scanner(System.in);
		robots = new ArrayList<Robot>();
	}
	
	public void displayMenu() {
		System.out.println("1. Show status.");
		System.out.println("2. Automate move.");
		System.out.println("3. Make a robot.");
	}

}
