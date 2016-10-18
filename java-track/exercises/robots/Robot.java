package robots;

import java.util.ArrayList;

public class Robot {
	
	protected String name, orientation;
	protected int[] position;
	protected int speed, health, attackPower;
	private ArrayList<Robot> robots = new ArrayList<Robot>();
	
	public Robot(String name, int speed) {
		this.name = name;
		this.position = new int[] { 0, 0 };
		this.speed = speed;
		this.orientation = "Up";
		this.health = 15;
		this.attackPower = 0;
		this.robots.add(this);
	}
	
	public void move(int amount) {
		int move = amount * this.speed;
		switch (this.orientation) {
		case "Up":
			this.position[1] += move;
			break;
		case "Left":
			this.position[0] -= move;
			break;
		case "Right":
			this.position[0] += move;
			break;
		case "Down":
			this.position[1] -= move;
			break;
		}
	}
	
	public void rotate(char rotate) {
		if (rotate == 'l') {
			switch (this.orientation) {
			case "Up":
				this.orientation = "Left";
				break;
			case "Left":
				this.orientation = "Down";
				break;
			case "Right":
				this.orientation = "Up";
				break;
			case "Down":
				this.orientation = "Right";
				break;
			}
		} else if (rotate == 'r') {
			switch (this.orientation) {
			case "Up":
				this.orientation = "Right";
				break;
			case "Left":
				this.orientation = "Up";
				break;
			case "Right":
				this.orientation = "Down";
				break;
			case "Down":
				this.orientation = "Left";
				break;
			}
		}
	}
	
	public int getXDist(Robot r) {
		return r.getX() - this.position[0];
	}
	
	public int getYDist(Robot r) {
		return r.getY() - this.position[1];
	}
	
	public double getDist(Robot r) {
		int xDist = this.getXDist(r);
		int yDist = this.getYDist(r);
		return Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
	}
	
	public boolean takeDmg(int dmg) {
		if (this.health > dmg) {
			this.health -= dmg;
			return false;
		}
		this.health = 0;
		return true;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getX() {
		return this.position[0];
	}
	
	public int getY() {
		return this.position[1];
	}
	
	public int getSpeed() {
		return this.speed;
	}
	
	public String getOrientation() {
		return this.orientation;
	}
	
	public String toString() {
		String s = "Name: " + this.name + "; ";
		s += "Position: (" + this.position[0] + ", " + this.position[1] + "); ";
		s += "Speed: " + this.speed + "; ";
		s += "Orientation: " + this.orientation;
		return s;
	}

}
