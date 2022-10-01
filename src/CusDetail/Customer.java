package CusDetail;

public class Customer {

	private int actNo;
	private String name;
	private String email;
	private int pass;
	private int balance;
	
	
	
	Customer(){
		
	}
	public Customer(int actNo, String name, String email, int pass, int balance) {
		super();
		this.actNo = actNo;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.balance = balance;
	}
	public int getActNo() {
		return actNo;
	}
	public void setActNo(int actNo) {
		this.actNo = actNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
