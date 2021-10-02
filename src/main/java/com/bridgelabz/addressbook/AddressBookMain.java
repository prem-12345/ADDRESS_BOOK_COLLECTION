package com.bridgelabz.addressbook;

import java.util.List;

public class AddressBookMain {
    public static void main(String[] args) {

        AddressBookDataBaseService addressBookDataBaseService = new AddressBookDataBaseService();

        // CREATE TABLE ADDRESSBOOK
        addressBookDataBaseService.createTableAddressBook();

        // ADD PERSONS TO THE ADDRESSBOOK TABLE
        addressBookDataBaseService.insertIntoAddressBook();

        // FETCH ALL PERSONS FROM ADDRESSBOOK TABLE
        List<Person>personList = addressBookDataBaseService.getAllPersonsDetails();
        for (Person person : personList){
            System.out.println(person);
        }

    }
}
