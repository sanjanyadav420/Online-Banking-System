package BankingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;

import Dbc.Connections;

public class BankingSysImp implements BankingSys {
	 boolean flag=false;
	int count=0;
	int act=0;
	
    public int getAct() {
		return act;
	}

	public void setAct(int act) {
		this.act = act;
	}

    public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean getFlag() {
		return flag;
	}
	
	public  void checkAct(String em,int ps) {
		count++;
		
		Connection con=Connections.getConnection();
		try {
			PreparedStatement act=con.prepareStatement("select * from Accountant");
			ResultSet rs= act.executeQuery();
			
			while(rs.next()) {
				
			String email=	rs.getString("email");
			
		int password=	rs.getInt("pass");
		
		
		if(em.equalsIgnoreCase(email)&& password==ps) {
			flag= true;
			System.out.println("login sucessful from accountant id ");
			
		}
		else System.out.println("invalid crediantials!!");
	}
		}
		catch(SQLException ex) {
			ex.getMessage();
	}
	
		
	}

	@Override
	public void insertCus(int cusId,String name, String cusEmail, int pass, int bal) {
		//System.out.println(count);
	 if(flag) {
		 Connection con=Connections.getConnection();
		 try {
			PreparedStatement act=con.prepareStatement("insert into customer values(?,?,?,?,?)");
			act.setString(1, name);
			act.setString(2, cusEmail);
			act.setInt(3, pass);
			act.setInt(4, bal);
			act.setInt(5, cusId);
			
			int x=act.executeUpdate();
			System.out.println(x+"record added successfully");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 else System.out.println("kindly login first!!!!");
	 
		
	}

	@Override
	public void deleteRecord(int actNo) {
	
	Connection con=	Connections.getConnection();
	
	
	
 try {
	PreparedStatement ps= con.prepareStatement("delete from customer where actNo=?");
	ps.setInt(1, actNo);
	int x=ps.executeUpdate();
	System.out.println(x+" record deleted sucessfully");
} catch (SQLException e) {
	System.out.println("Record not found");
}
	
	
		
	}

	@Override
	public void displayPerticular(int actNo) {
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("select * from customer where actNo=?");
			ps.setInt(1, actNo);
		ResultSet rs=	ps.executeQuery();
		display(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void display(ResultSet rs) {
		if(rs==null)System.out.println("No record found");
		try {
			while(rs.next()) {
				System.out.println("customer account number- "+rs.getInt("actNo"));
				System.out.println("customer name- "+rs.getString("name"));
				System.out.println("customer email- "+rs.getString("email"));
				System.out.println("customer password- "+rs.getInt("pass"));
				System.out.println("customer balance - "+rs.getString("bal"));
				System.out.print("==========================================");
			}   
			    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void displayAll() {
		// TODO Auto-generated method stub
		
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("select * from customer ");
			//ps.setInt(1, actNo);
		ResultSet rs=	ps.executeQuery();
		display(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void editName(int actNo, String name) {
		

		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("update customer set name=? where actNo=? ");
			ps.setString(1, name);
			ps.setInt(2, actNo);
		
		int x=ps.executeUpdate();
		if(x>0)System.out.println(x+" row affeted");
		
		} catch (SQLException e) {
		System.out.println("not updated try again");
		}
	}

	@Override
	public void editEmail(int actNo, String email) {
		// TODO Auto-generated method stub

		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("update customer set email=? where actNo=? ");
			ps.setString(1, email);
			ps.setInt(2, actNo);
			int x=ps.executeUpdate();
			if(x>0)System.out.println(x+" row affeted");
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not updated try again");
		}
		
		
	}

	@Override
	public void editpass(int actNo, int pass) {
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps= con.prepareStatement("update customer set pass=? where actNo=? ");
			ps.setInt(1, pass);
			ps.setInt(2, actNo);
			int x=ps.executeUpdate();
			if(x>0)System.out.println(x+" row affeted");
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("not updated try again");
		}
		
	}

	@Override
	public void deposit(int actNo, int rsa) {
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps1= con.prepareStatement("select * from customer where actNo=? ");
			ps1.setInt(1, actNo);
			
			ResultSet rs= ps1.executeQuery();
			//System.out.println(ans.getString("bal"));
			int rup=rsa;
		while(rs.next()) {
			rup=rs.getInt("bal");
			//System.out.println(rup);
			
		}
		
		
			int finalrs=rup+rsa;
			
			//System.out.println(finalrs);
			PreparedStatement ps=con.prepareStatement("update customer set bal=? where ActNo=?");
			ps.setInt(1, finalrs);
			ps.setInt(2, actNo);
			int x=ps.executeUpdate();
			if(x>0) {
				//System.out.println(x+" row affeted");
			pre(actNo, rup+rsa);
		
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		System.out.println("not updated try again");
	}
	}
	
	public void pre(int act,int rs) {
		
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement his=con.prepareStatement("insert into data values(?,?)");
			his.setInt(1, act);
			his.setInt(2, rs);
			int x=his.executeUpdate();
			if(x>0)
				System.out.println("Transaction successful!!");
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	
		}
		
	}

	@Override
	public void withdrwal(int actNo, int rsa) {
		Connection con=	Connections.getConnection();
		try {
			PreparedStatement ps1= con.prepareStatement("select * from customer where actNo=? ");
			ps1.setInt(1, actNo);
			
			ResultSet rs= ps1.executeQuery();
			//System.out.println(ans.getString("bal"));
			int rup=0;
		while(rs.next()) {
			rup=rs.getInt("bal");
			//System.out.println(rup);
			
		}
			if(rup<rsa) {
				System.out.println("Insufficient balance----");
				return;
			}
int finalrs=rup-rsa;
			
			//System.out.println(finalrs);
			PreparedStatement ps=con.prepareStatement("update customer set bal=? where ActNo=?");
			ps.setInt(1, finalrs);
			ps.setInt(2, actNo);
			int x=ps.executeUpdate();
			if(x>0) {
				//System.out.println(x+" row affeted");
			pre(actNo, rup-rsa);
		
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		System.out.println("not updated try again");
	}
			
			
			
			
		
	}
	
	
	

	@Override
	public void loginCus(String em, int ps) {
		count++;
		
		Connection con=Connections.getConnection();
		try {
			PreparedStatement act=con.prepareStatement("select * from customer");
			ResultSet rs= act.executeQuery();
			//System.out.println(rs);
			while(rs.next()) {
				
			String email=	rs.getString("email");
			
		int password=	rs.getInt("pass");
		
		
		if(em.equalsIgnoreCase(email)&& password==ps) {
			flag= true;
			this.act=rs.getInt("actNo");
			System.out.println("login sucessful from customer id ");
			return;
			
		}
		
	}
			if(this.count==0) System.out.println("invalid crediantials!!");
		}
		catch(SQLException ex) {
			ex.getMessage();
	
}
}

	@Override
	public void showhis(int act) {
Connection con=Connections.getConnection();

try {
	PreparedStatement ps= con.prepareStatement("select * from data where custAct=?");
	ps.setInt(1, act);
	
ResultSet rs=	ps.executeQuery();
while(rs.next()) {
	System.out.println("Account number -"+rs.getInt("custAct")+" Transaction amount-"+rs.getInt("balance"));
}



	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	System.out.println("Not recond found----");
}
		
	}
}
