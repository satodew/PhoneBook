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
		
		System.out.println("���������� ���������� v0.01");
		System.out.println("����� ������: ������� 1");
		System.out.println("�������� ������: ������� 2");
		System.out.println("������� ��� ������: ������� 3");
		SelectMenuItem();
	}
	
	private void SelectMenuItem(){
		String read = scan.nextLine();
		
		switch(read){
		case "1":
			System.out.println("����");
			break;
		case "2":
			System.out.println("���");
			break;
		case "3":
			System.out.println("���");
			break;
		default:
			System.out.println("������! ���������� ��� ���.");
			SelectMenuItem();
			break;
	}
	}
}
