package robots;

import java.util.ArrayList;

public class AttackBot extends Robot implements RobotBehavior {
	
	public AttackBot(String name, int speed) {
		super(name, speed);
		this.health = 10;
		this.attackPower = 5;
	}
	
	private int getSmallestDouble(double[] arr) {
		int element = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[element])
				element = i;
		}
		return element;
	}
	
	private boolean attack(Robot r) {
		boolean isKill = r.takeDmg(this.attackPower);
		return isKill;
	}
	
	private void goTo(Robot r) {
		int xDist = this.getXDist(r);
		if (Math.abs(xDist) > speed) {
			if (xDist < 0) {
				this.moveOrFace("Left");
			} else {
				this.moveOrFace("Right");
			}
		} else {
			int yDist = this.getYDist(r);
			if (yDist < 0) {
				this.moveOrFace("Down"); 
			} else {
				this.moveOrFace("Up");
			}
		}
	}
	
	private void moveOrFace(String dir) {
		boolean facing = this.turnTowards(dir);
		if (facing) {
			this.move(1);
		}
	}
	
	private boolean turnTowards(String dir) {
		switch (dir) {
		case "Up":
			switch (this.orientation) {
			case "Up":
				return true;
			case "Left":
				this.rotate('r');
				return false;
			case "Right":
				this.rotate('l');
				return false;
			case "Down":
				this.rotate('l');
				return false;
			}
		case "Left":
			switch (this.orientation) {
			case "Up":
				this.rotate('l');
				return false;
			case "Left":
				return true;
			case "Right":
				this.rotate('l');
				return false;
			case "Down":
				this.rotate('r');
				return false;
			}
		case "Right":
			switch (this.orientation) {
			case "Up":
				this.rotate('r');
				return false;
			case "Left":
				this.rotate('l');
				return false;
			case "Right":
				return true;
			case "Down":
				this.rotate('l');
				return false;
			}
		case "Down":
			switch (this.orientation) {
			case "Up":
				this.rotate('l');
				return false;
			case "Left":
				this.rotate('l');
				return false;
			case "Right":
				this.rotate('r');
				return false;
			case "Down":
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Robot> doNextMove(ArrayList<Robot> robots) {
		double[] dists = new double[robots.size()];
		for (int i = 0; i < robots.size(); i++) {
			dists[i] = robots.get(i).getDist(this);
		}
		int e = getSmallestDouble(dists); // Get the shortest distance to a robot
		if (robots.get(e).getDist(this) < 5) { // If robot is within attack distance
			boolean isKill = attack(robots.get(e));
			if (isKill)
				robots.remove(e);
		} else { // If it's not, move closer
			this.goTo(robots.get(e));
		}
		return robots;
	}

}
