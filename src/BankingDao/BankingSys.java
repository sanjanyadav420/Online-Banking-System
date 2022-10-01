package BankingDao;

public interface BankingSys {

	//boolean flag=false;
	abstract void insertCus(int cusId,String name,String cusEmail,int pass,int bal);
	abstract void deleteRecord(int actNo);
	abstract void displayPerticular(int actNo);
	abstract void displayAll();
	abstract void editName(int actNo,String name);
	abstract void editEmail(int actNo,String email);
	abstract void editpass(int actNo,int pass);
	abstract void deposit(int actNo,int rs);
	abstract void withdrwal(int actNo,int rs);
	abstract void loginCus(String email,int pass);
	abstract void showhis(int act);
	
	
	
}
