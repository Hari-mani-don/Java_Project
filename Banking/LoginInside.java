package com.Hari;
import java.util.Scanner;
public class LoginInside {
	 Scanner sc = new Scanner(System.in);
	 
	 int  passCheck =1, Pinpassword, repeatPinPassword, oldPinPassword;
     public Scanner getSc() {
		return sc;
	}
	public void setSc(Scanner sc) {
		this.sc = sc;
	}
	public int getPinpassword() {
		return Pinpassword;
	}
	public void setPinpassword(int pinpassword) {
		Pinpassword = pinpassword;
	}

	String password = null, repeatPassword = null;
	 int pinSet =0;
	 public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	  Register register;
	  Double amount;
	  boolean condition = true;
	  
	  LoginInside(Register register){
		  this.register = register;
	  }
      public void icon() {
    	  
    	  while(condition) {
    	  
    	  System.out.println("\t 1.Deposit");
    	  System.out.println("\t 2.Balance Check");
    	  System.out.println("\t 3.Logout");
    	  if(pinSet == 0) {
    	        System.out.println("\t 4.set ATM PIN");
    	  }
    	  else {
    		   System.out.println("\t 4.Change ATM PIN");
    	  }
    	  System.out.println("\t 5.Change Password");
    	  int num;
    	  System.out.print("\nSelect an option: ");
    	  num = sc.nextInt();
    	 
    	    
    	  switch(num) {
    		  case 1:
    			  Deposite();
    			  break;
    		  case 2:
    			  BalanceCheck();
    			  break;
    		  case 3:
    			  condition = false;
    			  break;
    		  case 4:
    			 Pin();
    			  break;
    		  case 5:
    			  changePassword();
    			  break;
    	      default:
    	    	  System.out.println("Invalid option. Please select  valid option.");
    	     }
        }
    	 
    } 
     
      public void Deposite() {
    	   System.out.println("Enter Deposite Amount: ");
		    amount =  sc.nextDouble();   			    
		    register.setAmount(register.getAmount() + amount);
		    System.out.println("Successfully Deposit");
      }
     
      public void BalanceCheck() {
    	  int pin =0;
		  System.out.println("Enter ATM pin");
		  pin = sc.nextInt();
		  if(pinSet == 1) {
		  if(Pinpassword == pin ) {
			  System.out.println("Balance:  rs. "+ register.getAmount());
		  }else {
			  System.out.println("Incorrect Pin");
		  }
		 }else {
			 System.out.println("Please set ATM pin");
		 }
      }
      public void changePassword() {
    	   
    	      int pass =0;
			  System.out.println("Enter old password");
			  sc.nextLine(); 
			  password = sc.nextLine();
			  
			  if(register.getPassword() !=null) {
		             if(register.getPassword().equals(password)) {
			         pass =1;
		            }else {
		    	        System.out.println("password mismatch");
		               }
		    }else {
		    	System.out.println("No set old password.");
		  }
		  
		  if(pass ==1) {
		          while(true) {
		                 System.out.print("Creat password: ");
						  sc.nextLine();
						  password = sc.nextLine();
						 
						  
						  System.out.print("Repeat password: ");
						  repeatPassword = sc.nextLine();
						  
						  
						  if(password.equals(repeatPassword)) {
							  System.out.println("\tSuccessfully password Changed\n");
							 register.setPassword(password);
							  break;
						  }else {
							  System.out.println("\n\tpassword mismatch");
						  }
		       }
	        }
      }
      
      public void Pin() {
    	  if(passCheck != 1) {
			  System.out.println("Enter old PIN");
			  sc.nextLine();
			  oldPinPassword = sc.nextInt();
			  if(oldPinPassword !=0) {
		       if(oldPinPassword == Pinpassword) {
			  passCheck =1;
		    }else {
		    	System.out.println("PINs do not match.");
		   }
		    }else {
		    	System.out.println("No set old PIN.");
		   }
		  }
		  
		  if(passCheck ==1) {
				  while(true) {
				  System.out.print("Creat PIN: ");
				  Pinpassword = sc.nextInt();
				 
				  System.out.print("Repeat PIN: ");
				  repeatPinPassword = sc.nextInt();
				  
				  if(Pinpassword == repeatPinPassword) {
					  System.out.println("\tSuccessfully PIN Changed\n");
					  passCheck =0;
					  pinSet =1;
					  break;
				  }else {
					  System.out.println("\n\tPINs do not match.");
				  }
		    }
	     }
     }
}

