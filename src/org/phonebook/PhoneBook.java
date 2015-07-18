package org.phonebook;

import java.util.Scanner;

public class PhoneBook {
	private Scanner scan;
	
	public static void main(String[] args) {
		PhoneBook main = new PhoneBook();
		
		//PhoneBook phoneBook = new PhoneBook();
		//phoneBook.Start();
	}

	public PhoneBook(){
		System.out.println("Hello");
		scan = new Scanner(System.in);
		
		System.out.println("Телефонный справочник v0.01");
		System.out.println("Поиск записи: введите 1");
		System.out.println("Добавить запись: введите 2");
		System.out.println("Вывести все записи: введите 3");
		SelectMenuItem();
	}
	
	private void SelectMenuItem(){
		String read = scan.nextLine();
		
		switch(read){
		case "1":
			System.out.println("один");
			break;
		case "2":
			System.out.println("два");
			break;
		case "3":
			System.out.println("два");
			break;
		default:
			System.out.println("Ошибка! Попробуйте еще раз.");
			SelectMenuItem();
			break;
	}
	}
}
