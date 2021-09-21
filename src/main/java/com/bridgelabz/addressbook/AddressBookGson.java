package com.bridgelabz.addressbook;

import java.util.LinkedList;

public class AddressBookGson extends AddressBook {
    AddressBookGsonService addressBookGsonService = new AddressBookGsonService();

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
                            addressBookGsonService.writeInAddressBook(data);
                            break;
                        } else {
                            System.out.println("NAME ALREADY EXIST.");
                            break;
                        }
                    case 2:
                        addressBookGsonService.readFromAddressBook(data);
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}