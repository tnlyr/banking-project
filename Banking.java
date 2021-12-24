/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banking;

/**
 *
 * @author 
 */
public class Banking {
    
    public static void main(String[] args) {
        Banking b = new Banking();
        System.out.println("Welcome to your bank! Please choose an option below:");
        b.retrieveOption();
        }
    
    Bank myBank = new Bank("005", "5050 Bank Ave.");
    UserInputManager u = new UserInputManager();
    
    private void retrieveOption(){ // faire fonctions for each case to avoid repetition if possible
        int input = u.retrieveUserOption();
        
        switch (input) {
            case 1:
                addNewClient();
                break;
            case 2:
                createNewAccount();
                break;
            case 3:
                makeDeposit();
                break;
            case 4:
                makeWithdrawal();
                break;
            case 5:
                listAccTransactions();
                break;
            case 6:
                listClients();
                break;
            case 7:
                listClientsAcc();
                break;
            case 8:
                System.out.println("It was great having you today, see you soon!");
                System.exit(0);
            default:
                System.out.println("Your choice appears to be non-valid, please try again");
                retrieveOption();
                break;
        }
    }
    
    private void addNewClient(){
        myBank.addClient(u.retrieveClientInfo());
        retrieveOption();
    }
    
    private void createNewAccount(){
        Client client = myBank.getClient(u.retrieveClientId());
            if (client != null){
                Account account = u.retrieveAccountType();
                account.setOwner(client);
                client.addAccount(account);  
                retrieveOption();
            }
            if (client == null){
                System.out.println("Invalid ID, it appears that you aren't a client among us!");
                retrieveOption();
            }
            System.out.println("");
    }
    
    private void makeDeposit(){
        int z = u.retrieveClientId();
        int accNum = u.retrieveAccountNumber();
        Account a = myBank.getClientAccount(z, accNum);
        
        if (a == null){
           System.out.println("Account doesn't exist, please try again");
           makeDeposit(); 
        }
        else if (a != null){
            double transAmount = u.retrieveTransactionAmount();
            a.deposit(transAmount);
            System.out.println("Deposit of " + transAmount + "$ in your account!");
            System.out.println(a);
            retrieveOption();
        }
    }
    
    private void makeWithdrawal(){
        int n = u.retrieveClientId();
        int accNum = u.retrieveAccountNumber();
        Account a = myBank.getClientAccount(n, accNum);
        
        if (a == null){
            System.out.println("Account does not exist, please try again");
            makeWithdrawal();
        }
        else if (a != null){
           double retrait = u.retrieveTransactionAmount();
            a.withdrawal(retrait);
            System.out.println("Withdrawal of " + retrait + "$ in your account");
            System.out.println(a);
            retrieveOption(); 
        }
    }
    
    private void listAccTransactions(){
        Client c = myBank.getClient(u.retrieveClientId());
            if (c == null){
                System.out.println("Invalid ID, please try again.");
                listAccTransactions();
            }
            if (c != null){
                Account acc = c.getAccount(u.retrieveAccountNumber());
                
                if (acc == null){
                    System.out.println("Account does not exist, please try again.");
                    listAccTransactions();
                }
                if (acc != null){
                    acc.displayAllTransactions();
                    System.out.println(acc);
                    retrieveOption();
                }
            }
    }
    
    private void listClients(){
        System.out.println("List of current clients: ");
        myBank.displayClientList();
        retrieveOption();
    }
    
    private void listClientsAcc(){
        int i = u.retrieveClientId();
        myBank.displayClientAccounts(i);
        retrieveOption();
    }
}