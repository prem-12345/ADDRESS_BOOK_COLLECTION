package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {
    String bookName;

    AddressBookMain(String name) {
        this.bookName = name;
    }

    public static void newUserInterface() {
        HashMap<Integer, LinkedList<Contact>> data = new HashMap<>();
        LinkedList<AddressBookMain> book = new LinkedList<>();
        ArrayList<String> books = new ArrayList<>();
        ArrayList<String> listOfPeople = new ArrayList<>();
        int count = 1;
        boolean flag = true;
        while (flag) {
            System.out.println("**************** WELCOME *****************");
            System.out.println("SELECT ANY ONE OPTION");
            System.out.println(" 1.CREATE NEW ADDRESS BOOK \n 2.DISPLAY ALL ADDRESS BOOK \n 3.EDIT ADDRESS BOOK \n 4.FILTER RECORDS \n 5.SORT BY NAME \n 6.SORT BY CITY \n 7.SORT BY STATE \n 8.EXIT");
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
                        System.out.println("NAME ALREADY EXIST.");
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
        book.stream().forEach(addressbook -> {
            System.out.println(addressbook.bookName);
        });
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
                    edit(records);
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
                System.out.println("PERSON ALREADY IN RECORDS.");
            }
        }
    }

    public static void edit(LinkedList<Contact> records) {
        System.out.println("PLEASE ENTER FIRST NAME:");
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        records.stream().forEach(person -> {
            if (person.getFirstName().equals(firstName)) {
                person.editDetails();
                person.display();
            } else {
                System.out.println("PLEASE PROVIDE VALID NAME.");
            }
        });
    }

    public static void view(LinkedList<Contact> records) {
        records.stream().forEach(person -> {
            person.display();
        });
    }

    public static void fetchRecordsForCity(HashMap<Integer, LinkedList<Contact>> data) {
        System.out.println("ENTER NAME OF CITY: ");
        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();
        List<String> list = new ArrayList<>();
        for (Integer key : data.keySet()) {
            data.get(key)
                    .stream()
                    .forEach(person -> {
                        if (person.getCity().equals(city)) {
                            list.add(person.getFirstName());
                        }
                    });
            System.out.println("LIST:\n FIRST NAME " + list);
        }
    }

    public static void fetchRecordsForState(HashMap<Integer, LinkedList<Contact>> data) {
        System.out.println("ENTER NAME OF STATE: ");
        Scanner sc = new Scanner(System.in);
        String state = sc.nextLine();
        List<String> list = new ArrayList<>();
        for (Integer key : data.keySet()) {
            data.get(key)
                    .stream()
                    .forEach(person -> {
                        if (person.getState().equals(state)) {
                            list.add(person.getFirstName());
                        }
                    });
            System.out.println("LIST:\n FIRST NAME " + list);
        }

    }

    public static void getPhoneNumber(HashMap<Integer, LinkedList<Contact>> data) {
        System.out.println("ENTER FIRST NAME: ");
        Scanner sc = new Scanner(System.in);
        String firstname = sc.nextLine();
        List<Long> list = new ArrayList<>();
        for (Integer key : data.keySet()) {
            data.get(key)
                    .stream()
                    .forEach(person -> {
                        if (person.getFirstName().equals(firstname)) {
                            list.add(person.getPhoneNumber());
                        }
                    });
            System.out.println("LIST:\n PHONE NUMBER " + list);
        }
    }

    public static void sortPersonByName(HashMap<Integer, LinkedList<Contact>> data) {
        for (Integer person : data.keySet()) {
            List<Contact> list = new ArrayList<>();
            for (Contact contact : data.get(person)) {
                list.add(contact);
            }
            list = list.stream().sorted(Comparator.comparing(Contact::getFirstName)).collect(Collectors.toList());
            list.stream().forEach(n -> {
                System.out.println(n.getFirstName());
            });
        }
    }

    public static void sortPersonByCity(HashMap<Integer, LinkedList<Contact>> data) {
        for (Integer person : data.keySet()) {
            List<Contact> list = new ArrayList<>();
            for (Contact contact : data.get(person)) {
                list.add(contact);
            }
            list = list.stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());
            list.stream().forEach(n -> {
                System.out.println(n.getFirstName());
            });
        }
    }

    public static void sortPersonByState(HashMap<Integer, LinkedList<Contact>> data) {
        for (Integer person : data.keySet()) {
            List<Contact> list = new ArrayList<>();
            for (Contact contact : data.get(person)) {
                list.add(contact);
            }
            list = list.stream().sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());
            list.stream().forEach(n -> {
                System.out.println(n.getFirstName());
            });
        }
    }

    public static void main(String[] args) {
        newUserInterface();
    }

    String getName() {
        return this.bookName;
    }

}
