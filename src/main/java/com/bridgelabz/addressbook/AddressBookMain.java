package com.bridgelabz.addressbook;

import java.util.*;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        newUserInterface();

    }


    String bookName;

    AddressBookMain(String name) {
        this.bookName = name;
    }

    String getName() {
        return this.bookName;
    }

    public static void newUserInterface() {
        LinkedList<AddressBookMain> book = new LinkedList<>();
        ArrayList<String> books = new ArrayList<>();
        HashMap<Integer, LinkedList<Contact>> data = new HashMap<>();
        ArrayList<String> listOfPeople = new ArrayList<>();

        int count = 1;
        boolean flag = true;
        while (flag) {

            System.out.println("**************** WELCOME *****************");
            System.out.println("SELECT ANY ONE OPTION");
            System.out.println(" 1.CREATE NEW ADDRESS BOOK \n 2.DISPLAY ALL ADDRESS BOOK \n 3.EDIT ADDRESS BOOK \n 4.Filter Records \n 5.EXIT");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option) {

                case 1:
                    sc.nextLine();
                    LinkedList<Contact> records = new LinkedList<>();
                    data.put(count, records);
                    System.out.println("NAME OF ADDRESS BOOK: ");
                    String bookName = sc.nextLine();

                    if (books.isEmpty() || !books.contains(bookName)) {
                        books.add(bookName);
                        book.add(new AddressBookMain(bookName));
                        userInterface(data.get(count), listOfPeople);
                        count += 1;
                        break;
                    } else {
                        System.out.println("Name already exist.");
                        break;
                    }
                case 2:
                    printBook(book);
                    break;
                case 3:
                    System.out.println("NAME OF THE ADDRESS BOOK: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    int index = serchKey(name, book);
                    userInterface(data.get(index), listOfPeople);
                    break;

                case 4:
                    System.out.println("Select any one option: \n 1.City \n 2.State \n 3.Get Phone Number");
                    sc.nextLine();
                    int num = sc.nextInt();

                    switch (num) {
                        case 1:
                            sc.nextLine();
                            System.out.println("Enter name of City: ");
                            String city = sc.nextLine();
                            fetchRecordsForCity(city, data);
                            break;
                        case 2:
                            sc.nextLine();
                            System.out.println("Enter name of State: ");
                            String state = sc.nextLine();
                            fetchRecordsForCity(state, data);
                            break;
                        case 3:
                            sc.nextLine();
                            System.out.println("Enter Firstname: ");
                            String firstname = sc.nextLine();
                            getPhoneNumber(firstname, data);
                            break;
                    }
                case 5:
                    System.out.println("************************Thank You**********************");
                    flag = false;
                    break;

            }
        }
    }

    public static int serchKey(String name, LinkedList<AddressBookMain> books) {
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

    public static void printBook(LinkedList<AddressBookMain> book) {
        for (AddressBookMain b : book) {
            System.out.println(b.bookName);
        }
    }

    public static void userInterface(LinkedList<Contact> records, ArrayList<String> listOfPeople) {

        boolean flag = true;
        while (flag) {

            System.out.println("**************** WELCOME *****************");
            System.out.println("SELECT ANY ONE OPTION");
            System.out.println(" 1.CREATE NEW RECORD \n 2.DISPLAY ALL RECORDS \n 3.EDIT RECORDS \n 4.EXIT");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    getInput(records, listOfPeople);
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

    public static void getInput(LinkedList<Contact> records, ArrayList<String> person) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF RECORDS: ");
        int numOfRecords = sc.nextInt();
        System.out.println("ENTER INPUTS:");

        for (int i = 0; i < numOfRecords; i++) {

            Scanner input = new Scanner(System.in);
            System.out.print("ENTER THE FIRST NAME: ");
            String firstName = input.nextLine();
            if (person.isEmpty() || !person.contains(firstName)) {
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
                person.add(firstName);
            } else {
                System.out.println("Person already in records.");
            }

        }
    }

    public static void edit(String firstName, LinkedList<Contact> records) {
        for (Contact person : records) {
            if (Objects.equals(person.getFirstName(), firstName)) {
                person.editDetails();
                person.display();
            } else {
                System.out.println("PLEASE PROVIDE VALID NAME.");
            }
        }
    }


    public static void view(LinkedList<Contact> records) {
        for (Contact person : records) {
            person.display();
        }
    }

    public static void fetchRecordsForCity(String city, HashMap<Integer, LinkedList<Contact>> data) {
        for (Map.Entry it : data.entrySet()) {
            LinkedList<Contact> records = (LinkedList<Contact>) it.getValue();

            for (Contact person : records) {
                if (Objects.equals(person.getCity(), city)) {
                    person.display();
                }
            }
        }

    }

    public static void fetchRecordsForState(String state, HashMap<Integer, LinkedList<Contact>> data) {

        for (Map.Entry it : data.entrySet()) {
            LinkedList<Contact> records = (LinkedList<Contact>) it.getValue();

            if (records.size() != 0) {
                for (Contact person : records) {
                    if (Objects.equals(person.getState(), state)) {
                        person.display();
                    }
                }

            }
        }
    }

    public static void getPhoneNumber(String firstname, HashMap<Integer, LinkedList<Contact>> data) {

        for (Map.Entry it : data.entrySet()) {
            LinkedList<Contact> records = (LinkedList<Contact>) it.getValue();

            if (records.size() != 0) {
                for (Contact person : records) {
                    if (Objects.equals(person.getFirstName(), firstname)) {
                        System.out.println(person.getPhoneNumber());
                    }
                }

            }
        }
    }
}