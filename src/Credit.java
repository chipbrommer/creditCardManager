/**************************************************************************************
 * @author Chip Brommer
 * @date September 14, 2017
 * 
 * Develop a Java application that determines whether any of several department-store 
 * customers has exceeded the credit limit on a charge account. For each customer, the 
 * following facts are available: account number, balance at the beginning of the 
 * month, total of all items charged by the customer this month, total of all credits 
 * applied to the custoner's account this month, allowed credit limit. The program 
 * should input all these facts as integers, calculate the new balance ( = beginning 
 * balance + charges - credits), display the new balance and determines whether the new
 * balance exceeds the customer's credit limit.  For those customers whose credit limit
 * is exceeded, the program should display the message "Credit limit exceeded".
 * 
 *************************************************************************************/

import java.util.Scanner;

public class Credit {


	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		Scanner reader = new Scanner (System.in);
		
		int accountNumber = -1;			//Holds the account number of the customer
		int beginMonthBalance = -1;		//Holds the balance at the beginning of the month
		int totalItemsCharged = -1;		//Total for items charged to the account
		int totalCredits = -1;			//Total credits paid towards the account
		int creditLimit = -1; 			//Maximum limit for items charged
		int totalNewBalance = -1;		//Holds the beginning balance + items charged - total credits.
		
		char cont = 'A';
		
		//Welcome Message
		System.out.print(" Welcome to Chips Credit Account Information Manager");
		
		/**
		 * While the cont character is not N, the program will run
		 * Program prompts the user at the end, asking for a Y or N to continue.
		 * If N, cancels, It Y, runs again.  
		 */
		
		while (cont != 'N' || cont != 'n')
		{
			//Requesting the account number from the user
			System.out.print("\nPlease enter an account number:  ");
			accountNumber = input.nextInt();
			
				//ERROR MESSAGE IF THE USER DOES NOT INPUT AN ACCOUNT NUMBER
				while (accountNumber <= 0)
				{
					System.out.print("\nERROR: Please input a the users account number.\n");
					accountNumber = input.nextInt();
				}
			
			//Requesting the credit limit on the account
			System.out.print("What is the credit limit on the account?  ");
			creditLimit = input.nextInt();
			
				//ERROR MESSAGE IF THE USER DOES NOT INPUT A POSITIVE CREDIT LIMIT
				while (creditLimit <= 0)
				{
					System.out.print("\nERROR: Please input a the current credit limit.\n");
					creditLimit = input.nextInt();
				}
				
			//Receives the beginning balance
			System.out.print("What was the balance at the beginning of the month?  ");
			beginMonthBalance = input.nextInt();
			
				//ERROR MESSAGE IF USER INPUTS AN INCORRECT NUMBER LESS THAN ZERO
				while (beginMonthBalance < 0)
				{
					System.out.print("\nERROR: Please input a real current balance.\n");
					beginMonthBalance = input.nextInt();
				}
			
			//Receives the total amount for items charged to the account
			System.out.print("What is the total amount of items charged for the month?  ");
			totalItemsCharged = input.nextInt();
			
				//ERROR MESSAGE IF THE USER DOES NOT INPUT A NUMBER FOR CHARGED ITEMS
				while (totalItemsCharged < 0)
				{
					System.out.print("\nERROR: Please input a the current credit limit.\n");
					creditLimit = input.nextInt();
				}
			
			//Receives the amount of credits paid towards the account balance
			System.out.print("What is the amount of credits towards the account for the month?  ");
			totalCredits = input.nextInt();
			
				//ERROR MESSAGE IF THE USER DOES NOT INPUT A POSITIVE CREDIT LIMIT
				while (totalCredits < 0)
				{
					System.out.print("\nERROR: Please input the amount of credits on the account.\n");
					totalCredits = input.nextInt();
				}
			
			//Conducts math for new balance 
			totalNewBalance = ( beginMonthBalance + totalItemsCharged ) - totalCredits;
				
			//Displays info to user. 
			System.out.print("\n\n________________________________________________\n");
			System.out.printf("Account Number: %d\n", accountNumber);
			System.out.printf("Beginning Account Balance: %.2f\n", (double) beginMonthBalance);
			System.out.printf("Total Amount Charged: %.2f\n", (double) totalItemsCharged);
			System.out.printf("Total Credits: %.2f\n", (double) totalCredits);
			
			//If new balance exceeds the credit limit, displays warning! 
			if ( totalNewBalance > creditLimit )
			{
				//WARNING MESSAGE
				System.out.print("--WARNING: CREDIT LIMIT EXCEEDED--\n");
			}
			
			//else prints a spacer line for the total balance. 
			else
			{
				System.out.print("\n");
			}
			
			System.out.printf("The Total Current Balance: %.2f\n", (double) totalNewBalance);
			System.out.print("________________________________________________");
			
			//Continue? If user enters N, program cancels. 
			//If user enters Y, program restarts.
			System.out.print("\n\nWould you like to check another account number?");
			System.out.print("\nPlease enter Y for Yes, or N for No. ");
			cont = reader.next().trim().charAt(0);
			
				//ERROR MESSAGE IF THE USER DOES NOT INPUT Y,y,N,n
				while (cont != 'Y' && cont != 'N' && cont != 'y' && cont != 'n')
				{
					System.out.print("\nERROR: Please only type Y for Yes or N for No: ");
					totalCredits = input.nextInt();
				}
				
			//If user does not was to continue, shows closing message. 	
			if( cont == 'N' || cont == 'n')
			{
				System.out.printf("\n\nThank you for using Chips Credit Account Information Manager!");
				System.out.printf("\nGoodbye!");
				return;
			}
		}

	}

}
