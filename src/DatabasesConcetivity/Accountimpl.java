package DatabasesConcetivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import AllBeanClass.Accountantbean;
import Exception.AccountantbeanException;
import utilityClasses.Accountant;
import utilityClasses.DBUtil;


public class Accountimpl implements Accountant{

	@Override
	public Accountantbean Accountant(String username, String password) throws AccountantbeanException {
		// TODO Auto-generated method stub
		Accountantbean accountantbean =null;
		
		try(Connection connection=DBUtil.provideConnection()){
			
			PreparedStatement pStatement=connection.prepareStatement("select * from Accountant where username=? AND password=?");
			pStatement.setString(1, username);
			pStatement.setString(2, password);
			
		   ResultSet rSet=	pStatement.executeQuery();
		   if (rSet.next()) {
			String rString=rSet.getString("username");
			String pString=rSet.getString("password");
			
			accountantbean= new Accountantbean(rString,pString);
			
		}else {
		     throw new AccountantbeanException("Invalid username OR password");
		}
		
			
		}
		catch (SQLException e) {
			// TODO: handle exception
			throw new AccountantbeanException(e.getMessage());
		}
		
		
		
		
		
		
		return accountantbean;
		
	}

	
	

}
