
public class Student {
	
	private String firstName, lastName;
	private int id, credits;
	private double gpa, cumQualScore;
	
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.credits = 0;
		this.gpa = 0.0;
		this.cumQualScore = 0;
	}
	
	private Student(Student s1, Student s2) {
		this.firstName = s1.getName();
		this.lastName = s2.getName();
		this.id = s1.getStudentID() + s2.getStudentID();
		this.credits = (s1.getCredits() > s2.getCredits()) ? s1.getCredits()
				: s2.getCredits();
		this.gpa = this.roundDec(3, (s1.getGPA() + s2.getGPA()) / 2);
	}
	
	private double roundDec(int places, double d) {
		int m = (int)Math.pow(10, places);
		return ((double)(Math.round(d * m))) / m;
	}
	
	public void submitGrade(double grade, int credits) {
		this.credits += credits;
		this.cumQualScore += credits * grade;
		this.gpa = this.roundDec(3, cumQualScore / this.credits);
	}
	
	public double computeTuition() {
		int avCost = 20000;
		int credPerSem = 15;
		double tuition = (this.credits / credPerSem) * avCost;
		int extra = this.credits % credPerSem;
		tuition += 1333.33 * extra;
		return tuition;
	}
	
	public Student createLegacy(Student s1, Student s2) {
		return new Student(s1, s2);
	}
	
	public String getClassStanding() {
		if (this.credits < 30)
			return "Freshman";
		else if (this.credits < 60)
			return "Sophomore";
		else if (this.credits < 90)
			return "Junior";
		else
			return "Senior";
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int getStudentID() {
		return this.id;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public double getGPA() {
		return this.gpa;
	}
	
	public String toString() {
		return this.getName() + " " + this.id;
	}

}
