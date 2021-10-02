package com.bridgelabz.addressbook;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AddressBookDataBaseServiceTest {

    @Test
    public void givenInsertIntoAddressBookMethod_whenUpdate_shouldMatch_updatedRowCount() {
        AddressBookDataBaseService addressBookDataBaseService = new AddressBookDataBaseService();
        int updatedRecord = addressBookDataBaseService.insertIntoAddressBook();
        Assertions.assertEquals(1, updatedRecord);
    }

    @Test
    public void givenAddressBookDataBase_whenRetrieved_shouldMatch_personCount() {
        AddressBookDataBaseService addressBookDataBaseService = new AddressBookDataBaseService();
        List<Person> personList = addressBookDataBaseService.getAllPersonsDetails();
        Assertions.assertEquals(2, personList.size());
    }

    @Test
    public void givenPersonDetails_whenUpdated_shouldReturn_updatedRowCount() {
        AddressBookDataBaseService addressBookDataBaseService = new AddressBookDataBaseService();
        int updatedRecord = addressBookDataBaseService.updatePersonDetails("KALPESH", "DELHI");
        Assertions.assertEquals(1, updatedRecord);
    }
}



