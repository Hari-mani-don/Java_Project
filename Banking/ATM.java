package com.Hari;
import java.util.Scanner;
public class ATM {
	Scanner scanner = new Scanner(System.in);
	
	Register register;
	LoginInside log;
	double withdrawAmount =0.0;
	boolean condition =true;
	
	ATM(Register register, LoginInside log){
		this.register = register;
		this.log = log;
	}
	      
	   
	
	    public  void AtmInside() {
	    	
		             System.out.println("\t\tWelcome to Hari ATM");
		             while(condition) {
		            	 System.out.println("\t 1.Pin Change");
		            	 System.out.println("\t 2.Deposite");
		            	 System.out.println("\t 3.Balance");
		            	 System.out.println("\t 4.Withdraw");
		            	 System.out.println("\t 5.Receipt");
		            	 System.out.println("\t 6.exit");
		            	 
		            	 int option;
		            	 System.out.print("\nSelect an option: ");
		            	 option = scanner.nextInt();
		            	 
		            	 switch(option) {
		            	          case 1:
		            	        	  log.Pin();
		            	        	  break;
		            	          case 2:
		            	        	  log.Deposite();
		            	        	  break;
		            	          case 3:
		            	        	  if(log.Pinpassword !=0){
		            	        		  log.BalanceCheck();
		            	        	  }else {
		            	        		 System.out.println("Please set pin in App");
		            	        		 condition  = false;
	            	        	     	 break;
		            	        	  }
		            	        	  break;
		            	          case 4:
		            	        	  if(log.Pinpassword !=0){
		            	        	  withdraw();
		            	        	  }else {
			            	        		 System.out.println("Please set pin in App");
			            	        		 condition  = false;
		            	        	     	 break;
			            	        	  }
		            	        	  break;
		            	          case 5:
		            	        	  Receipt();
		            	        	  condition = false;
		            	        	  break;
		            	          case 6:
		            	        	  condition  = false;
	            	        	      break;
		            	          default:
		            	        	  System.out.println("Invalid option. Select an valid option");
		            	 }
		             }
	    }
        
	public void withdraw() {
		int pin =0;
		System.out.println("Enter withdraw amount: ");
		withdrawAmount = scanner.nextDouble();
		if(withdrawAmount <= register.getAmount()) {
			System.out.println("Enter ATM pin");
		     pin = scanner.nextInt();
		     if(pin == log.getPinpassword()) {
		    	 note((int)withdrawAmount);
			  System.out.println("Withdrawal  successfull");
			  register.setAmount(register.getAmount()- withdrawAmount ); 
		     }
		}else {
			System.out.println("Infulience Balance");
		}
	  }
	
	
	public void note(int amount) {
		int count = 0, div =0, amountMod = 0;
		if(amount<=0) {
			System.out.println("please enter amount");
			System.exit(0);
		}
		if(amount >= 500) {
			 amountMod = amount % 500;
			 count =  amount / 500;
			 amount = amountMod;
			System.out.println("\t500    :"+count);
			count =0;
		}
		if(amount >= 200) {
			 amountMod = amount % 200;
			 count =  amount / 200;
			 amount = amountMod;
			System.out.println("\t200    :"+count);
			count =0;
		}
		if(amount >= 100) {
			amountMod = amount % 100;
			 count =  amount / 100;
			 amount = amountMod;
			System.out.println("\t100    :"+count);
			count =0;
		}
		if(amount >= 50) {
			amountMod = amount % 50;
			 count =  amount / 50;
			 amount = amountMod;
			System.out.println("\t50    :"+count);
			count =0;
		}
		if(amount >= 20) {
			amountMod = amount % 20;
			 count =  amount / 20;
			 amount = amountMod;
			System.out.println("\t20    :"+count);
			count =0;
		}
		if(amount >= 10) {
			amountMod = amount % 10;
			 count =  amount / 10;
			 amount = amountMod;
			System.out.println("\t10    :"+count);
			count =0;
		}
		if(amount >= 5) {
			amountMod = amount % 5;
			 count =  amount / 5;
			 amount = amountMod;
			System.out.println("\t5    :"+count);
			count =0;
		}
		if(amount >= 2) {
			amountMod = amount % 2;
			 count =  amount / 2;
			 amount = amountMod;
			System.out.println("\t2    :"+count);
			count =0;
		}
		if(amount >= 1) {
			amountMod = amount % 1;
			 count =  amount / 1;
			 amount = amountMod;
			System.out.println("\t1    :"+count);
			count =0;
		}
	}
 
	
	public void Receipt() {
		if(withdrawAmount != 0.0) {
		System.out.println("Receipt in Hari ATM");
		System.out.println("Name              :"+ register.getUserName());
		System.out.println("Withdraw Amount   :"+ withdrawAmount);
		System.out.println("Total Balance     :"+ register.getAmount());
		System.out.println("\tThank you!");
		}else {
			System.out.println("Withdraw First");
		}
	}
}
