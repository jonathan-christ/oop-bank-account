/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classchallenge;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BankAccount Account = new BankAccount(1, 100000, "Matthew Cedric D. Calaycay", "rufgier@gmail.com", "09696969696");

        Account.setAccountNo(1);
        Account.setBal(0);
        Account.setName("Matthew Cedric D. Calaycay");
        Account.setEmail("rufgier@gmail.com");
        Account.setPhoneNo("123123123123"); //changes if not valid phone number (not implemented well)

        System.out.println(Account.getPhoneNo());
        System.out.println(Account.depositFunds(0) ? Account.getBal() : "Error");
        System.out.println(Account.withdrawFunds(0) ? Account.getBal() : "Error");

        System.out.println(Account.withdrawFunds(-100) ? Account.getBal() : "Error");
        System.out.println(Account.depositFunds(-100) ? Account.getBal() : "Error");

        System.out.println(Account.withdrawFunds(100) ? Account.getBal() : "Error");
        System.out.println(Account.depositFunds(100) ? Account.getBal() : "Error");
        System.out.println(Account.withdrawFunds(50) ? Account.getBal() : "Error");

        BankAccount Account2 = new BankAccount(2, 0, "Bruh", "asdiajs@gm.com", "09696969696");

        System.out.println("Account balance: " + Account.getBal());
        System.out.println("Account2 balance: " + Account2.getBal());
        Account.transfer(Account2, 5);

        System.out.println("Account balance: " + Account.getBal());
        System.out.println("Account2 balance: " + Account2.getBal());

    }
}
