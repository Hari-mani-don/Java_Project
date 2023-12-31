package com.Hari;
import java.util.Scanner;
public class Main {
	      
      public static void main(String args[]) {
    	  Scanner sc = new Scanner(System.in);
    	  Register register = null;
    	  Login login = null;
    	  LoginInside loginInside = null;
    	  ATM atm = null;
    	  
    	  while(true) {
    	  System.out.println("\t 1.Register");
    	  System.out.println("\t 2.Login");
    	  System.out.println("\t 3.profile");
    	  System.out.println("\t 4.ATM");
    	  System.out.println("\t 5.exit");
    	  
    	 
    	  int num;
    	  System.out.print("\nSelect option: ");
    	  num = sc.nextInt();
    	 
    	
    	  switch(num) {
    	       case 1:
    	    	   register = new Register();
    	    	   register.customerDetails();
    	    	  while(true) {
    	    		  register.printDetails();
    	    		   char condition;
    	    	 	   System.out.print("\nIf you want to change Details, Enter (Y/N)");
    	    	 	   condition = sc.next().charAt(0);
    	    		  if(condition == 'y' || condition == 'Y') {
    	    			  register.changeDetail();
    	    		  }
    	    		  else {
    	    			   break;
    	    		   }
    	    	  }
    	    	  System.out.println("Register Successfully\n");
    	    	  
    	    	  break;
    	       case 2:
    	    	   System.out.println("\t\tWelcome to Hari\n");
	    	    	   if(register != null) {
	    	    	    login = new Login(register);
	    	    	    login.CheckUserAccess();
		    	    	    if(login.name.equals(register.getUserName()) && login.password.equals(register.getPassword())) {
		    	    	    loginInside = new LoginInside(register);
		    	    	    loginInside.icon();
		    	    	    }
    	    	  }else {
    	    		   System.out.println("Please Register first");
    	    	   }
    	    	   break;
    	    	   
    	       case 3:
    	    		  if(register != null) {
    	    			  	register.printDetails();
    	    		  }else {
    	    			  System.out.println("No user Details Available. please Login First");
    	    		  }
    	    		  break;
    	       case 4:
    	    	   if(register !=null) {
    	    	   if(register != null && loginInside != null) {
    	    		   atm = new ATM(register, loginInside);
        	    	   atm.AtmInside();
    	    	    }else {
    	    	    	System.out.println("please Login first");
    	    	    }
    	    	   }else {
   			    	System.out.println("please Register first");
    	    	   }
    	    	   break;
    	       case 5:
    		        sc.close();
    		        System.exit(0);	
    		        break;
    	       default:
    	    	   System.out.println("Invalid option. Please select Valid option");
    	     }      
    	  
    	  } 
    	  
    	  
      }

}
