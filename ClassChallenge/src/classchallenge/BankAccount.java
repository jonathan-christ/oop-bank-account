/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classchallenge;

/**
 *
 * @author User
 */
public class BankAccount {

    private int accountNo;
    private double bal;
    private String name;
    private String email;
    private String phoneNo;

//    CONSTRUCTORS
    BankAccount() {
        accountNo = 0;
        bal = 0;
        name = "Unset";
        email = "Unset";
        phoneNo = "000000000000";
    }

    BankAccount(int accNo, double bal, String name, String email, String phoneNo) {
        this.accountNo = accNo;
        this.bal = bal;
        this.name = name;
        this.email = email;
        if (phoneNo.charAt(0) == '0' && phoneNo.matches("[0-9]+") && phoneNo.length() > 2 && phoneNo.length() <= 11) {
            this.phoneNo = phoneNo;
        } else {
            this.phoneNo = "00000000000";
        }
    }

    //SETTERS
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public void setBal(int bal) {
        if (bal >= 0) {
            this.bal = bal;
        } else {
            this.bal = 0;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        if (phoneNo.charAt(0) == '0' && phoneNo.matches("[0-9]+") && phoneNo.length() > 2 && phoneNo.length() <= 11) {
            this.phoneNo = phoneNo;
        } else {
            this.phoneNo = "00000000000";
        }
    }

    //GETTERS
    public int getAccountNo() {
        return accountNo;
    }

    public double getBal() {
        return bal;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    //REQUIRED METHODS
    public boolean depositFunds(double amount) {
        boolean result = true;

        if (amount <= 0) {
            result = false;
        } else {
            this.bal += amount;
        }

        return result;
    }

    public boolean withdrawFunds(double amount) {
        boolean result = true;

        if (this.bal < amount || amount <= 0) {
            result = false;
        } else {
            this.bal -= amount;
        }

        return result;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        boolean success = false;
        if (this.withdrawFunds(amount)) {
            if (receiver.depositFunds(amount)) {
                System.out.println(String.format("Transfer to Bank Account %d is successful!\n", receiver.getAccountNo()));
                success = true;
            }
        }
        return success;
    }

//    OVERRIDDEN METHODS
    @Override
    public String toString() {
        return "BankAccount{" + "accountNo=" + accountNo + ", bal=" + bal + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + '}';
    }

}
