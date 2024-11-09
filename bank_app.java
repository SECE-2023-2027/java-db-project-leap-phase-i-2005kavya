package com.org.bank;

import java.util.Scanner;
import bank.dao.AccountDAO;
import bank.dao.AccountDaoImpl;
import bank.model.Account;


public class bank_app {
	public static void main(String args[]) {
		AccountDAO accountDAO = new AccountDaoImpl();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n=== Banking Application Menu ===");
			System.out.println("1.Create a new Account");
			System.out.println("2.View Account Details");
			System.out.println("3.Update Account Information");
			System.out.println("4.Deposit Money");
			System.out.println("5.Withdraw Money");
			System.out.println("6.Transfer Money");
			System.out.println("7.View Transaction");
			System.out.println("8.Check Balance");
			System.out.println("9.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Account Holder Name: ");
				String accountholder = sc.nextLine();
				System.out.println("Enter account type (Savings/Current):");
				String accountType = sc.nextLine();
				System.out.println("Enter Initial balance");
				double balance = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter address: ");
				String address = sc.nextLine();
				System.out.println("Enter conrtact number: ");
				String contactNumber = sc.nextLine();
				Account newAccount = new Account(0,accountholder, accountType,balance,address,contactNumber);
				try {
					accountDAO.createAccount(newAccount);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			}
			}
	}

}
