package com.bridgelabz.addressbook;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AddressBookCsvService {
    String filePath = "AddressBook.csv";

    public void writeInAddressBook(HashMap<String, LinkedList<Contact>> data) {
        File file = new File(filePath);
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, LinkedList<Contact>> entry : data.entrySet()) {
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromAddressBook() {
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(filePath));
            String[] nextLineContent;
            while ((nextLineContent = csvReader.readNext()) != null) {
                for (String string : nextLineContent) {
                    System.out.print(string + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
