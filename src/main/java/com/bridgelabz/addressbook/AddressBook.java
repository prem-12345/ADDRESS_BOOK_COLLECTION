package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    AddressBookFileIoService addressBookFileIoService = new AddressBookFileIoService();
    static HashMap<String, LinkedList<Contact>> data = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public void newUserInterface() {
        try {
            boolean flag = true;
            while (flag) {
                System.out.println("**************** WELCOME *****************");
                System.out.println("SELECT ANY ONE OPTION");
                System.out.println(" 1.CREATE NEW ADDRESS BOOK \n 2.DISPLAY ALL ADDRESS BOOK \n 3.EDIT ADDRESS BOOK \n 4.FILTER RECORDS \n 5.SORT BY NAME \n 6.SORT BY CITY \n 7.SORT BY STATE \n 8.EXIT");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        sc.nextLine();
                        LinkedList<Contact> records = new LinkedList<>();
                        System.out.println("NAME OF ADDRESS BOOK: ");
                        String bookName = sc.nextLine();
                        if (data.isEmpty() || !data.containsKey(bookName)) {
                            data.put(bookName, records);
                            userInterface(data.get(bookName));
                            addressBookFileIoService.writeInAddressBook(data);
                            break;
                        } else {
                            System.out.println("NAME ALREADY EXIST.");
                            break;
                        }
                    case 2:
                        printBook(data);
                        addressBookFileIoService.readAddressBook();
                        break;
                    case 3:
                        System.out.println("NAME OF THE ADDRESS BOOK: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        if (data.containsKey(name)) {
                            userInterface(data.get(name));
                        } else {
                            System.out.println("PLEASE PROVIDE VALID INPUT.");
                        }
                        break;
                    case 4:
                        boolean run = true;
                        while (run) {
                            System.out.println("SELECT ANY ONE OPTION: \n 1.CITY \n 2.STATE \n 3.GET PHONE NUMBER \n 4.EXIT");
                            sc.nextLine();
                            int num = sc.nextInt();
                            switch (num) {
                                case 1:
                                    fetchRecordsForCity(data);
                                    break;
                                case 2:
                                    fetchRecordsForState(data);
                                    break;
                                case 3:
                                    getPhoneNumber(data);
                                    break;
                                case 4:
                                    run = false;
                            }
                        }
                        break;
                    case 5:
                        sortPersonByName(data);
                        break;
                    case 6:
                        sortPersonByCity(data);
                        break;
                    case 7:
                        sortPersonByState(data);
                        break;
                    case 8:
                        System.out.println("************************Thank You**********************");
                        flag = false;
                        break;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void userInterface(LinkedList<Contact> records) {
        try {
            boolean flag = true;
            while (flag) {
                System.out.println("**************** WELCOME *****************");
                System.out.println("SELECT ANY ONE OPTION");
                System.out.println(" 1.CREATE NEW RECORD \n 2.DISPLAY ALL RECORDS \n 3.EDIT RECORDS \n 4.EXIT");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        getInput(records);
                        continue;
                    case 2:
                        view(records);
                        continue;
                    case 3:
                        edit(records);
                        continue;
                    case 4:
                        System.out.println("***************THANK YOU***************");
                        flag = false;
                        break;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void getInput(LinkedList<Contact> records) {
        try {
            System.out.println("ENTER THE NUMBER OF RECORDS: ");
            int numOfRecords = sc.nextInt();
            System.out.println("ENTER INPUTS:");
            for (int i = 0; i < numOfRecords; i++) {
                Scanner input = new Scanner(System.in);
                System.out.print("ENTER THE FIRST NAME: ");
                String firstName = input.nextLine();
                if (records.isEmpty() || searchPerson(records, firstName)) {
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
                } else {
                    System.out.println("PERSON ALREADY IN RECORDS.");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printBook(HashMap<String, LinkedList<Contact>> data) {
        for (String book : data.keySet()) {
            System.out.println(book);
        }
    }

    public static void edit(LinkedList<Contact> records) {
        try {
            System.out.println("PLEASE ENTER FIRST NAME:");
            String firstName = sc.next();
            records.stream().filter(person -> person.getFirstName().equals(firstName)).forEach(person -> {
                editDetails(person);
                person.display();
            });
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void view(LinkedList<Contact> records) {
        records.forEach(Contact::display);
    }

    public static void fetchRecordsForCity(HashMap<String, LinkedList<Contact>> data) {
        try {
            System.out.println("ENTER NAME OF CITY: ");
            String city = sc.next();
            List<String> list = new ArrayList<>();
            for (String key : data.keySet()) {
                data.get(key)
                        .stream().filter(person -> person.getCity().equals(city)).map(Contact::getFirstName).forEach(list::add);
                System.out.println("LIST:\n FIRST NAME " + list);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void fetchRecordsForState(HashMap<String, LinkedList<Contact>> data) {
        try {
            System.out.println("ENTER NAME OF STATE: ");
            String state = sc.next();
            List<String> list = new ArrayList<>();
            for (String key : data.keySet()) {
                data.get(key)
                        .stream().filter(person -> person.getState().equals(state)).map(Contact::getFirstName).forEach(list::add);
                System.out.println("LIST:\n FIRST NAME " + list);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void getPhoneNumber(HashMap<String, LinkedList<Contact>> data) {
        try {
            System.out.println("ENTER FIRST NAME: ");
            String firstname = sc.next();
            List<Long> list = new ArrayList<>();
            for (String key : data.keySet()) {
                data.get(key)
                        .stream().filter(person -> person.getFirstName().equals(firstname)).map(Contact::getPhoneNumber).forEach(list::add);
                System.out.println("LIST:\n PHONE NUMBER " + list);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void sortPersonByName(HashMap<String, LinkedList<Contact>> data) {
        for (String person : data.keySet()) {
            List<Contact> list = new ArrayList<>();
            list.addAll(data.get(person));
            list = list.stream().sorted(Comparator.comparing(Contact::getFirstName)).collect(Collectors.toList());
            list.stream().forEach(n -> {
                System.out.println(n.getFirstName());
            });
        }
    }

    public static void sortPersonByCity(HashMap<String, LinkedList<Contact>> data) {
        for (String person : data.keySet()) {
            List<Contact> list = new ArrayList<>();
            list.addAll(data.get(person));
            list = list.stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
            list.stream().forEach(n -> {
                System.out.println(n.getFirstName());
            });
        }
    }

    public static void sortPersonByState(HashMap<String, LinkedList<Contact>> data) {
        for (String person : data.keySet()) {
            List<Contact> list = new ArrayList<>();
            list.addAll(data.get(person));
            list = list.stream().sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());
            list.stream().forEach(n -> {
                System.out.println(n.getFirstName());
            });
        }
    }

    public static boolean searchPerson(LinkedList<Contact> records, String firstName) {
        for (Contact name : records) {
            if (name.getFirstName().equals(firstName)) {
                return false;
            }
        }
        return true;
    }

    public static void editDetails(Contact Person) {
        try {
            System.out.println(" SELECT THE OPTION YOU WANT TO EDIT : ");
            System.out.println(" A.FIRST NAME\n B.LAST NAME\n C.ADDRESS\n D.CITY\n E.STATE\n F.EMAIL ID\n G.ZIPCODE\n H.PHONE NUMBER\n I.DELETE CONTACT ");
            char option;
            option = sc.next().charAt(0);
            sc.nextLine();
            switch (option) {
                case 'A':
                    System.out.println("ENTER FIRST NAME: ");
                    String firstName = sc.nextLine();
                    Person.setFirstName(firstName);
                    break;
                case 'B':
                    System.out.println("ENTER LAST NAME: ");
                    String lastName = sc.nextLine();
                    Person.setLastName(lastName);
                    break;
                case 'C':
                    System.out.println("ENTER ADDRESS: ");
                    String address = sc.nextLine();
                    Person.setAddress(address);
                    break;
                case 'D':
                    System.out.println("ENTER CITY: ");
                    String city = sc.nextLine();
                    Person.setCity(city);
                    break;
                case 'E':
                    System.out.println("ENTER STATE: ");
                    String state = sc.nextLine();
                    Person.setState(state);
                    break;
                case 'F':
                    System.out.println("ENTER EMAIL ID: ");
                    String email = sc.nextLine();
                    Person.setEmail(email);
                    break;
                case 'G':
                    System.out.println("ENTER ZIPCODE: ");
                    Long zipcode = sc.nextLong();
                    Person.setZipCode(zipcode);
                    break;
                case 'H':
                    System.out.println("ENTER PHONE NUMBER: ");
                    Long phoneNumber = sc.nextLong();
                    Person.setPhoneNumber(phoneNumber);
                    break;
                case 'I':
                    Person.setFirstName(null);
                    Person.setLastName(null);
                    Person.setAddress(null);
                    Person.setCity(null);
                    Person.setState(null);
                    Person.setEmail(null);
                    Person.setZipCode(null);
                    Person.setPhoneNumber(null);
                    break;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
