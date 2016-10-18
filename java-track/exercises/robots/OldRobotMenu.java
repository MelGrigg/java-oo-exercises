//package robots;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class OldRobotMenu {
//	
//	private ArrayList<Robot> robots;
//	private Scanner s;
//	
//	public OldRobotMenu() {
//		s = new Scanner(System.in);
//		robots = new ArrayList<Robot>();
//	}
//	
//	public void displayMenu() {
//		System.out.println("1. Create a robot.");
//		System.out.println("2. Display the list of available robots.");
//		System.out.println("3. Move a robot.");
//		System.out.println("4. Rotate a robot.");
//		System.out.println("5. Compute the distance between two robots.");
//		System.out.println("6. Exit.");
//	}
//	
//	public int runMenu() {
//		while (true) {
//			this.displayMenu();
//			if (s.hasNextInt()) {
//				int n = s.nextInt();
//				if ((n >= 1) && (n <= 6))
//					return n;
//			}
//		}
//	}
//	
//	public boolean menuDirect(int select) {
//		switch (select) {
//		case 1:
//			// Create a robot.
//			this.createRobot();
//			break;
//		case 2:
//			// Display the list of available robots.
//			this.displayRobots();
//			break;
//		case 3:
//			// Move a robot.
//			this.moveRobot();
//			break;
//		case 4:
//			// Rotate a robot.
//			this.rotateRobot();
//			break;
//		case 5:
//			// Compute the distance between two robots.
//			this.computeDistance();
//			break;
//		case 6:
//			// Exit.
//			// Run to default.
//		default:
//			return false;
//		}
//		return true;
//	}
//	
//	private void createRobot() {
//		// Get robot name.
//		do {
//			System.out.println("Please enter the name of the robot:");
//		} while (!s.hasNext());
//		String name = s.next();
//		
//		// Get robot speed.
//		do {
//			System.out.println("Please enter the speed of the robot:");
//		} while (!s.hasNextInt());
//		int speed = s.nextInt();
//		
//		// Add to robots ArrayList.
//		this.robots.add(new Robot(name, speed));
//	}
//	
//	private void displayRobots() {
//		for (int i = 0; i < this.robots.size(); i++)
//			System.out.println((i + 1) + ".) " + this.robots.get(i));
//	}
//	
//	private void moveRobot() {
//		int select = 0;
//		do {
//			this.displayRobots();
//			System.out.println("Select the robot to move.");
//			if (s.hasNextInt())
//				select = s.nextInt();
//		} while (!((select > 0) && (select <= this.robots.size())));
//		
//		do {
//			System.out.println("Enter how much to move.");
//		} while (!s.hasNextInt());
//		int amount = s.nextInt();
//		
//		(this.robots.get(select - 1)).move(amount);
//		
//		System.out.println("Here is the robot's status after it moved:");
//		System.out.println(this.robots.get(select - 1));
//	}
//	
//	private void rotateRobot() {
//		int select = 0;
//		do {
//			this.displayRobots();
//			System.out.println("Select the robot to move.");
//			if (s.hasNextInt())
//				select = s.nextInt();
//		} while (!((select > 0) && (select <= this.robots.size())));
//		
//		String rotate = "";
//		do {
//			System.out.println("Left or right?  (Enter 'l' or 'r')");
//			if (s.hasNext())
//				rotate = s.next();
//		} while ((rotate != "l") && (rotate != "r"));
//		
//		char rot = rotate.charAt(0);
//		
//		(this.robots.get(select - 1)).rotate(rot);
//		
//		System.out.println("Here is the robot's status after it moved:");
//		System.out.println(this.robots.get(select - 1));
//	}
//	
//	private void computeDistance() {
//		int select1 = 0;
//		do {
//			this.displayRobots();
//			System.out.println("Select a robot.");
//			if (s.hasNextInt())
//				select1 = s.nextInt();
//		} while (!((select1 > 0) && (select1 <= this.robots.size())));
//		
//		int select2 = 0;
//		do {
//			this.displayRobots();
//			System.out.println("Select another robot.");
//			if (s.hasNextInt())
//				select2 = s.nextInt();
//		} while ((select2 > 0) && (select2 <= this.robots.size()));
//		
//		(this.robots.get(select1 - 1)).printDist(this.robots.get(select2 - 1));
//	}
//	
//	public static void main(String[] args) {
//		OldRobotMenu rm = new OldRobotMenu();
//		boolean run = true;
//		do {
//			int n = rm.runMenu();
//			run = rm.menuDirect(n);
//		} while (run);
//	}
//
//}
