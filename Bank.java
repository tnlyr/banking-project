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
public class Bank implements IBank{
    private String bankNumber;
    private String address;
    
    private ArrayList<Client> clientList = new ArrayList<>();

    public Bank(String bankNumber, String address) {
        this.bankNumber = bankNumber;
        this.address = address;
    }
    
    public String getBankNumber() {
        return this.bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Client> getClientList() {
        return this.clientList;
    }

    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }
    
    
    @Override
    public void addClient(Client newClient) {
        this.clientList.add(newClient);
    }

    @Override
    public void displayClientAccounts(int clientId) {
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getId() == clientId){
                clientList.get(i).displayAccounts();
                break;
            }
            else if (i == clientList.size() - 1){
                System.out.println("ID does not match");
                break;
            }
        }
    }

    @Override
    public void displayClientList() {
        for(int i = 0; i < clientList.size(); i++){
            System.out.println(clientList.get(i));
        }
    }

    @Override
    public Client getClient(int id) {
        for(int i = 0; i < clientList.size(); i++){
            if(clientList.get(i).getId() == id){
                return clientList.get(i);
            }
        }
        return null;
    } 

    @Override
    public Account getClientAccount(int clientId, int accountNumber) {
        Account acc = null;
        Client clien = getClient(clientId);
        if (clien != null){
            acc = clien.getAccount(accountNumber);
        }
        return acc;
    }
}
