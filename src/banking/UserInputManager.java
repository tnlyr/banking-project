/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class UserInputManager implements IUserInputManager{

    public UserInputManager() {
    }
    
    @Override
    public int retrieveAccountNumber() {
        Scanner accNum = new Scanner(System.in);
        System.out.print("Please enter your account number: ");
        int input = accNum.nextInt();
        return input;
        }
        
    @Override
    public Account retrieveAccountType() {
        Scanner accType = new Scanner(System.in);
        System.out.println("""
                           Please enter the desired type of account below:
                           [1] Checkings account
                           [2] Savings account""");
        int input = accType.nextInt();
        
        if(input == 1){
            Account newChk = new CheckingAccount();
            return newChk;
        }
        else if(input == 2){
            Account newSavgs = new SavingsAccount();
            return newSavgs;
        }
        else{
            System.out.println("Invalid choice, please try again!");
            return retrieveAccountType();
        }
    }

    @Override
    public int retrieveClientId() {
        Scanner idClient = new Scanner(System.in);
        System.out.println("Please enter your ID : ");
        int id = idClient.nextInt();
        return id;
    }

    @Override
    public Client retrieveClientInfo() {
        Scanner name = new Scanner(System.in);
        System.out.println("Thank you for choosing us!");
        System.out.print("Please enter your first name: ");
        String firstName = name.nextLine();
        System.out.print("Please enter your last name: ");
        String lastName = name.nextLine();
        Client createdClient = new Client(firstName.trim(), lastName.trim());
        System.out.println("Welcome, " + firstName);
        System.out.println("ID: " + createdClient.getId());
        return createdClient;
    }

    @Override
    public double retrieveTransactionAmount() {
        System.out.print("Please enter the amount of your transaction: ");
        Scanner amt = new Scanner(System.in);
        double input = amt.nextDouble();
        return input;
    }

    @Override
    public int retrieveUserOption() {
        Scanner option = new Scanner(System.in);
        System.out.print("""
                           =================================================
                           [1] To Add a New Client
                           [2] To Create a New Account
                           [3] To Make a Deposit
                           [4] To Make a Withdrawal
                           [5] To List Account Transactions
                           [6] To List Clients
                           [7] To List Client Accounts
                           [8] To Exit
                           =================================================
                           """);
        String input = option.nextLine();
         
        input = input.replaceAll("[^\\d.]", "");
        
        if(input.equals("")){
            System.out.println("Invalid choice! Please try again.");
            return retrieveUserOption();
        }
        Integer intInput = Integer.valueOf(input);
        
        if(intInput <= 8 && intInput >= 1){
            return intInput;
        }
        else{
            System.out.println("Invalid choice! Please try again.");
            return retrieveUserOption();
        }
    }
    
}
