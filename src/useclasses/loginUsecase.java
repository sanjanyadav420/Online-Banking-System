package useclasses;

import java.util.Scanner;

import AllBeanClass.Accountantbean;
import DatabasesConcetivity.Accountimpl;
import Exception.AccountantbeanException;
import utilityClasses.Accountant;

public class loginUsecase {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter username");
		String unameString=scanner.next();
		
		System.out.println("Enter password");
		
		String passwordString=scanner.next();
		
		Accountant dao=new Accountimpl();
		try {
			Accountantbean accountant=dao.Accountant(unameString, passwordString);
			System.out.println("Welcome :"+ accountant.getUsername());
		} catch (AccountantbeanException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}