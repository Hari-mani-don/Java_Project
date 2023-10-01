package com.Hari;
import java.util.Scanner;
public class Login{
	 Scanner sc = new Scanner(System.in);
	 
	 String name, password;
     Register register;
	Login(Register register){
		this.register = register;
		System.out.println("\tEnter user name: ");
		name = sc.nextLine();
		System.out.println("\tEnter Password: ");
		password = sc.nextLine();
		
	}
   public void CheckUserAccess() {
	   if(name.equals(register.getUserName()) && password.equals(register.getPassword())) {
			System.out.println("\t\tLogin Successfull");
		}else {
			System.out.println("worng password and username! try again");
		}
	  
   }
   
   
   
}
