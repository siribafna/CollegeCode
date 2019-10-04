
// ACCOUNT class 
public class Account {
	// fields of account class, id and initial included in constructor
	private int iD;
	private double initialBalance;
	private double currentBalance;
	
	// creating new instance of account through constructor
	public Account(int iD, int initialBalance) {
		this.iD = iD; 
		this.initialBalance = initialBalance;
	}
	
	// methods for calculating/presenting balance
	// adding money
	public double depositMoney(double addBalance) {
		this.currentBalance += addBalance;
		return this.currentBalance;
	}
	
	//subtracting money
	public double withdrawMoney(double takeBalance) {
		this.currentBalance -= takeBalance;
		return this.currentBalance;
	}
	
	//setters and getters for balance
	public void setBalance(double balance) {
		this.currentBalance = balance;
	}
	
	public double getBalance() {
		return this.currentBalance + this.initialBalance;
	}
	
	
	
	
	
	

}
