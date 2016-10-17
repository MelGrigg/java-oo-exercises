
public class Course {
	
	private String name;
	private int credits, remainingSeats;
	private Student[] roster;
	
	public Course(String name, int credits, int remainingSeats) {
		this.name = name;
		this.credits = credits;
		this.remainingSeats = remainingSeats;
		this.roster = new Student[remainingSeats];
	}
	
	public boolean addStudent(Student s) {
		if (this.remainingSeats < 1)
			return false;
		for (int i = 0; i < this.roster.length; i++) {
			if (this.roster[i] != null) {
				if (this.roster[i].getName() == s.getName())
					return false;
			}
		}
		this.roster[this.roster.length - this.remainingSeats] = s;
		this.remainingSeats--;
		return true;
	}
	
	public String generateRoster() {
		String s = "";
		for (int i = 0; i < this.roster.length; i++) {
			if (this.roster[i] == null)
				break;
			s += this.roster[i].getName() + "\n";
		}
		return s;
	}
	
	public double averageGPA() {
		double sum = 0;
		for (int i = 0; i < this.roster.length; i++) {
			if (this.roster[i] == null)
				break;
			sum += this.roster[i].getGPA();
		}
		return sum / (this.roster.length - this.remainingSeats);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public int getRemainingSeats() {
		return this.remainingSeats;
	}
	
	public String toString() {
		return this.name + " | " + this.credits;
	}

}
