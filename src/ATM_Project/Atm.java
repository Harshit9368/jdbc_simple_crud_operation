package ATM_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Atm {
	
	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/atm";
			String user = "root";
			String pass = "harshit";
			
			Connection con = DriverManager.getConnection(url,user,pass);
			
			Statement st = con.createStatement();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Hey Welcome to All in One ATM");
			System.out.println("Enter your pin number");
			int pin = sc.nextInt();
			
			String retrieveStudentQuery = "select * from accountholder where ac_no = "+pin;
			ResultSet a = st.executeQuery(retrieveStudentQuery);
			String name = null;
			int balance = 0;
			int count=0;
			while(a.next()) {
				name=a.getString(name);
				balance= a.getInt(balance);
				count++;
			}
			
			
			
			int choice;
			int amount = 0;
			int take_amount=0;
			
			if(count>0)
				
				
			{
				System.out.println("Hello :"+ name);
				while(true) {
					System.out.println("Press 1 to check balance");
					System.out.println("Press 2 to Add Amount");
					System.out.println("Press 3 to take Amount");
					System.out.println("Press 4 to print the recipt ");
					System.out.println("Press 5 to Exit");
					
					System.out.println();
					System.out.println("Enter your choice");
					
					choice=sc.nextInt();
					switch(choice) {
					case 1:
						System.out.println("Your balance is : "+balance);
						break;
					case 2:
						System.out.println("How much amount did you want to add");
						amount=sc.nextInt();
						balance = balance+amount;
						int  bal = st.executeUpdate("update  accountholder set balance : "+balance+ " where ac_no= "+pin);
						System.out.println("Successfully added , now your current balance is : "+bal);
						break;
					case 3:
						System.out.println("How much amount did you want to take");
						take_amount=sc.nextInt();
						if(take_amount>balance) {
							System.out.println("Insufficient fund");
						}
						else
						{
							balance = balance-take_amount;
							int sum = st.executeUpdate("update  accountholder set balance : "+balance+ " where ac_no= "+pin);
							System.out.println("Successfully taken , now your current balance is : "+sum);
						}
						
						break;
					case 4:
						System.out.println("Thanks for coming");
						System.out.println("your current balance is : "+balance);
						System.out.println("Amount added : "+amount);
						System.out.println("Amount taken : "+take_amount);
						break;
						
					}
					if(choice==5) {
						break;
					}
				}
				
			}
			}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
