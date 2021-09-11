package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class AddressBookMain {

    public static void main(String[] args) {

      //Welcome to Address Book Collection program

        ArrayList<Contact> records = new ArrayList<>();
        userInterface(records);

    }

    // UC5 ABILITY TO ADD MULTIPLE PERSON TO ADDRESS BOOK
    public static void userInterface(ArrayList<Contact> records) {

        boolean flag = true;
        while (flag) {

            System.out.println("**************** WELCOME *****************");
            System.out.println("SELECT ANY ONE OPTION");
            System.out.println(" 1.CREATE NEW RECORD \n 2.DISPLAY ALL RECORDS \n 3.EDIT RECORDS \n 4.EXIT");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    getInput(records);
                    continue;
                case 2:
                    view(records);
                    continue;
                case 3:
                    System.out.println("PLEASE ENTER FIRST NAME:");
                    sc.nextLine();
                    String firstName = sc.nextLine();
                    edit(firstName, records);
                    continue;

                case 4:
                    System.out.println("***************THANK YOU***************");
                    flag = false;
                    break;
            }
        }
    }

    public static void getInput(ArrayList<Contact> records) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF RECORDS: ");
        int numOfRecords = sc.nextInt();
        System.out.println("ENTER INPUTS:");

        for (int i = 0; i < numOfRecords; i++) {
            Scanner input = new Scanner(System.in);
            System.out.print("ENTER THE FIRST NAME: ");
            String firstName = input.nextLine();
            System.out.print("ENTER THE LAST NAME: ");
            String lastName = input.nextLine();
            System.out.print("ENTER THE ADDRESS: ");
            String address = input.nextLine();
            System.out.print("ENTER THE CITY: ");
            String city = input.nextLine();
            System.out.print("ENTER THE STATE: ");
            String state = input.nextLine();
            System.out.print("ENTER THE EMAIL ID: ");
            String email = input.nextLine();
            System.out.print("ENTER THE ZIPCODE: ");
            Long zipcode = input.nextLong();
            System.out.print("ENTER THE PHONE NUMBER: ");
            Long phoneNumber = input.nextLong();

            records.add(new Contact(firstName, lastName, address, city, state, email, zipcode, phoneNumber));

        }
    }

    public static void edit(String firstName, ArrayList<Contact> records) {
        for (Contact person : records) {
            if (Objects.equals(person.getFirstName(), firstName)) {
                person.editDetails();
                person.display();
            } else {
                System.out.println("PLEASE PROVIDE VALID NAME.");
            }
        }
    }

    public static void view(ArrayList<Contact> records) {
        for (Contact person : records) {
            person.display();
        }
    }


  }