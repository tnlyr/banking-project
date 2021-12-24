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
public class Account implements IAccount{
    protected static int counter = 0;
    protected int accountNumber;
    protected double balance;
    protected Client owner;
    protected String type; 
    
    protected ArrayList<Transaction> transactions = new ArrayList<>();

    public Account() {
        this.balance = 0.0;
        this.owner = null;
        counter = counter + 1;
        this.accountNumber = counter;
    }

    
    public static int getCounter() {
        return Account.counter;
    }

    public static void setCounter(int counter) {
        Account.counter = counter;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return this.owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }   

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    
    @Override
    public double deposit(double d) {
        this.balance = this.balance + d;
        Transaction deposit = new Transaction("Deposit", d);
        this.transactions.add(deposit);
        return this.balance;
    }

    @Override
    public double withdrawal(double w) {
        this.balance = this.balance - w;
        Transaction withdrawal = new Transaction("Withdrawal", w);
        this.transactions.add(withdrawal);
        return this.balance;
    }  
    
    @Override
    public void displayAllTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }
    
    @Override
    public String toString(){
        return this.type + "(" + this.accountNumber + ")" + ": " + this.balance + "$";
    }
   
}

