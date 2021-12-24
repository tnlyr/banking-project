/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Client implements IClient{
    private int id;
    private String firstName;
    private String lastName;
    private static int counter = 0;
    
    private ArrayList<Account> accountList = new ArrayList<>();
    
    // Constructor
    public Client(String firstName, String lastName){
        counter = counter+1;
        this.firstName = firstName;
        this.id = counter;
        this.lastName = lastName;
    } 
    
    // Getters & setters
    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public static int getCounter() {
        return counter;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public ArrayList<Account> getAccountList() {
        return this.accountList;
    }

    public void setAccountList (ArrayList<Account> listAcc) {
        this.accountList = listAcc;
    }
    
    
    
    @Override
    public void addAccount(Account newAccount) {
        accountList.add(newAccount);
        System.out.println("New account added! " + "\n" + newAccount);
    }

    @Override
    public void displayAccounts(){
        System.out.println("Here's the account's details for " + this.lastName + ", " + this.firstName + "(" + this.id + ")" + ":");
        for(int i = 0; i < accountList.size(); i++){
            System.out.println(accountList.get(i));
        }
    }
    
    @Override
    public Account getAccount(int accountNumber){
        for (int i = 0; i < accountList.size(); i++){
            if (accountList.get(i).getAccountNumber()== id){
                return accountList.get(i);
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return "(" + this.getId() + ")" + " " + this.getLastName() + "," + " " + this.getFirstName();
        
    }
    
}