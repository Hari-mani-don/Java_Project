package com.Hari;
import java.util.Scanner;

public class Register {
	Scanner s = new Scanner(System.in);
    private String name, birth, address, email, password;
    private Double amount =0.0;
    private int age;
    private long mobile;
    
      public  void customerDetails() {
      	   System.out.print("Enter your User name: ");
      	   name = s.nextLine();
      	   
      	   System.out.print("Enter your Password: ");
    	   password = s.nextLine();
    	   
      	   System.out.print("Enter your age: ");
      	   age = s.nextInt();
      	   s.nextLine();
      	   System.out.print("Enter your Date of Birth: ");
      	   birth = s.nextLine();
      	   
      	   System.out.print("Enter your mobile: ");
      	   mobile = s.nextLong();
      	   s.nextLine();
      	   System.out.print("Enter your address: ");
      	   address = s.nextLine();
      	    
      	   System.out.print("Enter your email: ");
      	   email = s.nextLine();
      	   
      	   System.out.print("Enter your Deposit amout: ");
      	   amount = s.nextDouble();
      	   
      	   
   	  }
				public Scanner getS() {
					return s;
				}
				public void setS(Scanner s) {
					this.s = s;
				}
				String getUserName() {
					return name;
				}
				public void setUserName(String name) {
					this.name = name;
				}
				public String getBirth() {
					return birth;
				}
				public void setBirth(String birth) {
					this.birth = birth;
				}
				public String getAddress() {
					return address;
				}
				public void setAddress(String address) {
					this.address = address;
				}
				public String getEmail() {
					return email;
				}
				public void setEmail(String email) {
					this.email = email;
				}
				public Double getAmount() {
					return amount;
				}
				public void setAmount(Double amount) {
					this.amount = amount;
				}
				public int getAge() {
					return age;
				}
				public void setAge(int age) {
					this.age = age;
				}
				public long getMobile() {
					return mobile;
				}
				public void setMobile(long mobile) {
					this.mobile = mobile;
				}
				public String getPassword() {
					return password;
				}
				public void setPassword(String password) {
					this.password = password;
				}
       
      
	public void changeDetail() {
	   char changeCharacter;

 	   System.out.print("Enter First Letter to Change like...(Name is N): ");
       changeCharacter = s.next().charAt(0);
 	   switch(changeCharacter) {
 	         case 'N':
 	        	 String name;
 	        	 System.out.print("Enter your User name:");
 	        	 s.nextLine();
 	        	 name  = s.nextLine();
 	        	 setUserName(name);
 	        	 break;
 	        case 'A':
	        	 int age;
	        	 System.out.print("Enter your Age:");
	        	 age = s.nextInt();
	        	 setAge(age);
	        	 break;
 	       case 'D':
	        	 String birth;
	        	 System.out.print("Enter your Date of Birth:");
	        	 s.nextLine();
	        	 birth  = s.nextLine();
	        	 setBirth(birth);
	        	 break;
 	      case 'M':
	        	 long mobile;
	        	 System.out.print("Enter your Mobile:");
	        	 s.nextLine();
	        	 mobile = s.nextLong();
	        	 setMobile(mobile);
	        	 break;
 	     case 'a':
	        	 String address;
	        	 System.out.print("Enter your address:");
	        	 s.nextLine();
	        	 address  = s.nextLine();
	        	 setAddress(address);
	        	 break;
 	     case 'E':
	        	 String email;
	       	     System.out.print("Enter your email:");
	       	     s.nextLine();
	             email  = s.nextLine();
	       	     setEmail(email);
	       	     break;
 	    case 'd':
	 	       	 Double amount;
	 	       	 System.out.print("Enter your amount:");
	 	       	 s.nextLine();
	 	       	 amount  = s.nextDouble();
	 	       	 setAmount(amount);
	 	         break;
 	     
	   case 'P':
		       	 String password;
		       	 System.out.print("Enter your Password:");
		       	 s.nextLine();
		       	 password  = s.nextLine();
		       	 setPassword(password);
		         break;
 	   }
 	   
     }
	  
	
     public void printDetails() {
       System.out.println("\nCheck your Details: ");
  	   System.out.println("User Name        :"+getUserName());
  	   System.out.println("Password         :"+getPassword());
  	   System.out.println("Age              :"+getAge());
  	   System.out.println("Date of Birth    :"+getBirth());
  	   System.out.println("Mobile number    :"+getMobile());
  	   System.out.println("address          :"+getAddress());
  	   System.out.println("Email            :"+getEmail());
  	   System.out.println("depsite Amount   :"+"Rs. "+getAmount());
     }
    
}
