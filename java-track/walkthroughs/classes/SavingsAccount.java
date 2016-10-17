package classes;

public class SavingsAccount {
	
	private Integer balance;
	private double interest_rate;
	
	public SavingsAccount(Integer balance, double interest_rate) {
		this.balance = balance;
		this.interest_rate = interest_rate;
	}
	
	public Integer getBalance() {
		return this.balance;
	}
	
	public double getInterestRate() {
		return this.interest_rate;
	}
	
	public Integer add(Integer amount) {
		this.balance += amount;
		return this.balance;
	}
	
	public Integer remove(Integer amount) {
		this.balance -= amount;
		return this.balance;
	}
	
	public Integer accrue() {
		return (this.balance += (int)(this.balance * this.interest_rate));
	}
	
	public String toString() {
		return "balance = " + this.balance + " & interest_rate = " + this.interest_rate;
	}
	
	public void merge(SavingsAccount other) {
		this.balance += other.getBalance();
		other.remove(other.getBalance());
	}
	
	public static void main(String[] args) {
		SavingsAccount my_account = new SavingsAccount(100, 0.5);
		System.out.println(my_account.getBalance());
		System.out.println(my_account.add(10));
		System.out.println(my_account.accrue());
		System.out.println(my_account);
	}

}
