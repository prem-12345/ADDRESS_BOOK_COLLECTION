package com.bridgelabz.addressbook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;

public class AddressBookFileIoService {
    String filePath = "addessBook.txt";

    public void writeInAddressBook(HashMap<String, LinkedList<Contact>> data) {
        StringBuffer personBuffer = new StringBuffer();
        data.forEach((bookName, records) -> {
            personBuffer.append(bookName)
                    .append("\n");
            personBuffer.append(records.toString().concat("\n"));
        });
        try {
            Files.write(Paths.get(filePath), personBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readAddressBook() {
        try {
            Files.lines(new File(filePath).toPath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
