package classes;

public class BaseballPlayer {
	
	private String name, dexterity;
	private Integer number, runs, rbis, gamesPlayed;
	
	public BaseballPlayer(String name, Integer number, String dexterity) {
		this.name = name;
		this.number = number;
		this.dexterity = dexterity;
		this.runs = 0;
		this.rbis = 0;
		this.gamesPlayed = 0;
	}
	
	public void finishGame(Integer runs, Integer rbis) {
		this.runs += runs;
		this.rbis += rbis;
		this.gamesPlayed++;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Integer getNumber() {
		return this.number;
	}
	
	public String getDexterity() {
		return this.dexterity;
	}
	
	public Integer getRuns() {
		return this.runs;
	}
	
	public Integer getRbis() {
		return this.rbis;
	}
	
	public Integer getGamesPlayed() {
		return this.gamesPlayed;
	}

	public static void main(String[] args) {
		BaseballPlayer p1 = new BaseballPlayer("Timmy", 3, "Left-Handed");
		System.out.println("Name: " + p1.getName());
		System.out.println("Number: " + p1.getNumber());
		System.out.println("Dexterity: " + p1.getDexterity());
		System.out.println("Runs: " + p1.getRuns());
		System.out.println("RBIs: " + p1.getRbis());
		System.out.println("Games Played: " + p1.getGamesPlayed());
		p1.finishGame(3, 4);
		System.out.println("Runs: " + p1.getRuns());
		System.out.println("RBIs: " + p1.getRbis());
		System.out.println("Games Played: " + p1.getGamesPlayed());
		p1.finishGame(2, 5);
		System.out.println("Runs: " + p1.getRuns());
		System.out.println("RBIs: " + p1.getRbis());
		System.out.println("Games Played: " + p1.getGamesPlayed());
	}
}
