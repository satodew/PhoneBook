package org.phonebook;

import java.util.Scanner;
import java.sql.SQLException;

public class PhoneBook {
	
	private Scanner scan;
	private DB db;
	
	public static void main(String[] args) throws SQLException{
		PhoneBook main = new PhoneBook();
	}

	public PhoneBook() throws SQLException{
		scan = new Scanner(System.in);
		
		db = new DB();
		db.Start();
		db.CreateTable();
		db.Close();
		
		System.out.println("PhoneBook v0.01\n");
		Menu();
	}
	
	
	//displaying a list with a choice of actions
	private void Menu() throws SQLException{
		System.out.println("1 Search");
		System.out.println("2 Add");
		System.out.println("3 Show all");
		System.out.println("4 Exit");
		
		//running methods depending on user selection
		SelectMenuItem();
	}
	
	private void SelectMenuItem() throws SQLException{
		String read = scan.nextLine();
		if(read.equals("1")){
			//search
			Search();
		}else if(read.equals("2")){
			//add
			AddContact();
		}else if(read.equals("3")){
			//show all
			ReadFull();
		}else if(read.equals("4")){
			//exit
			return;
		}else{
			System.out.println("Error!");
			SelectMenuItem();
		}
	}
	
	private void Search() throws SQLException{
		System.out.println("Name:");
		String text = InputString();
		db.Start();
		String res = db.Search(text);
		db.Close();
		System.out.println(res);
		
		//go to the beginning
		Menu();
	}
	
	private void ReadFull() throws SQLException{
		db.Start();
		String res = db.ReadFull();
		db.Close();
		System.out.println(res);
		
		//go to the beginning
		Menu();
	}
	
	private void AddContact() throws SQLException{
		System.out.println("Name:");
		String name = "";
		name = InputString();
		System.out.println("Phone:");
		String phone = InputString();
		db.Start();
		db.Write(name, phone);
		db.Close();
		System.out.println("Added!\n");
		
		//go to the beginning
		Menu();

	}
	
	private String InputString(){
		String read = "";
		while(read.equals("")){
			read = scan.nextLine();
			if(read.equals(""))
				System.out.println("Error! Try again.");
		}
		return read;
	}
}
