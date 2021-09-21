package com.bridgelabz.addressbook;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class AddressBookGsonService {
    String filePath = "AddressBook.gson";

    public void writeInAddressBook(HashMap<String, LinkedList<Contact>> data) {
        Gson gson = new Gson();
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            gson.toJson(data, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromAddressBook(HashMap<String, LinkedList<Contact>> data) {
        Gson gson = new Gson();
        try {
            data = gson.fromJson(new FileReader(filePath), null);
            System.out.println(data.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
