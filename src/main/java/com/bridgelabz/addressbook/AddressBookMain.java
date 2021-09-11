package com.bridgelabz.addressbook;

import java.util.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class AddressBookMain {

    public static void main(String[] args) {

      //Welcome to Address Book Collection program

        newUserInterface();

    }

    //UC6 REFACTOR TO ADD MULTIPLE ADDRESS BOOK TO THE SYSTEM

    String bookName;

    AddressBookMain(String name) {
        this.bookName = name;
    }

    String getName() {
        return this.bookName;
    }

    public static void newUserInterface() {
        ArrayList<AddressBookMain> book = new ArrayList<>();
        HashMap<Integer, ArrayList<Contact>> data = new HashMap<>();

        int count = 1;
        boolean flag = true;
        while (flag) {

            System.out.println("**************** WELCOME *****************");
            System.out.println("SELECT ANY ONE OPTION");
            System.out.println(" 1.CREATE NEW ADDRESS BOOK \n 2.DISPLAY ALL ADDRESS BOOK \n 3.EDIT ADDRESS BOOK  \n 4.EXIT");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option) {

                case 1:
                    sc.nextLine();
                    ArrayList<Contact> records = new ArrayList<>();
                    data.put(count, records);
                    System.out.println("NAME OF ADDRESS BOOK: ");
                    String bookName = sc.nextLine();
                    book.add(new AddressBookMain(bookName));
                    userInterface(data.get(count));
                    count += 1;
                    break;
                case 2:
                    printBook(book);
                    break;
                case 3:
                    System.out.println("NAME OF THE ADDRESS BOOK: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    int index = serchKey(name, book);
                    userInterface(data.get(index));
                    break;
                case 4:
                    System.out.println("************************Thank You**********************");
                    flag = false;
                    break;


            }
        }
    }

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

    public static void printBook(ArrayList<AddressBookMain> book) {
        for (AddressBookMain b : book) {
            System.out.println(b.bookName);
        }
    }

    public static int serchKey(String name, ArrayList<AddressBookMain> books) {
        int count = 1;
        for (AddressBookMain book : books) {
            if (Objects.equals(name, book.getName())) {
                return count;
            }
            count++;
        }
        System.out.println("PLEASE PROVIDE VALID INPUT.");
        return 0;
    }



}