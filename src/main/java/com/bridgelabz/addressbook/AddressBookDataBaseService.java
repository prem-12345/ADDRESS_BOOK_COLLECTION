package com.bridgelabz.addressbook;

import com.bridgelabz.dbconfiguration.DataBaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookDataBaseService {
    Connection connection = DataBaseConfiguration.getConnection();
    PreparedStatement preparedStatement;
    Scanner scanner = new Scanner(System.in);

    public void createTableAddressBook() {
        String CREATE_TABLE_QUERY = "create table addressbook(ID int NOT NULL AUTO_INCREMENT UNIQUE,ADDRESSBOOK_NAME varchar(150) NOT NULL,FIRST_NAME varchar(150) NOT NULL,LAST_NAME varchar(150) NOT NULL,GENDER varchar(1) NOT NULL,ADDRESS varchar(150) NOT NULL,CITY varchar(50) NOT NULL,STATE varchar(50) NOT NULL,ZIP_CODE int NOT NULL,PHONE_NUMBER int NOT NULL,START_DATE varchar(50) NOT NULL)";
        try {
            preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
            preparedStatement.executeUpdate();
            System.out.println("QUERY EXECUTED");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int insertIntoAddressBook() {
        String INSERT_QUERY = "insert into addressbook (ID,ADDRESSBOOK_NAME,FIRST_NAME,LAST_NAME,GENDER,ADDRESS,CITY,STATE,ZIP_CODE,PHONE_NUMBER,START_DATE)values(?,?,?,?,?,?,?,?,?,?,?)";
        int row = 0;
        try {
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            System.out.println("ENTER THE ID :");
            int id = scanner.nextInt();
            System.out.println("ENTER THE ADDRESSBOOK NAME :");
            String addressbookName = scanner.next();
            System.out.println("ENTER THE FIRST NAME :");
            String firstName = scanner.next();
            System.out.println("ENTER THE LAST NAME :");
            String lastName = scanner.next();
            System.out.println("ENTER THE GENDER :");
            String gender = scanner.next();
            System.out.println("ENTER THE ADDRESS :");
            String address = scanner.next();
            System.out.println("ENTER THE CITY :");
            String city = scanner.next();
            System.out.println("ENTER THE STATE :");
            String state = scanner.next();
            System.out.println("ENTER THE ZIP CODE :");
            int zipCode = scanner.nextInt();
            System.out.println("ENTER THE PHONE NUMBER :");
            int phone = scanner.nextInt();
            System.out.println("ENTER THE START DATE :");
            String startDate = scanner.next();

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, addressbookName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, gender);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, city);
            preparedStatement.setString(8, state);
            preparedStatement.setInt(9, zipCode);
            preparedStatement.setInt(10, phone);
            preparedStatement.setString(11, startDate);

            row = preparedStatement.executeUpdate();
            System.out.println(row + "row inserted");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }

    public List<Person> getAllPersonsDetails() {
        String FETCH_RECORD_QUERY = "select * from addressbook ";
        Person person;
        List<Person> personList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(FETCH_RECORD_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getInt("ID"));
                person.setAddressbookName(resultSet.getString("ADDRESSBOOK_NAME"));
                person.setFirstName(resultSet.getString("FIRST_NAME"));
                person.setLastName(resultSet.getString("LAST_NAME"));
                person.setGender(resultSet.getString("GENDER"));
                person.setAddress(resultSet.getString("ADDRESS"));
                person.setCity(resultSet.getString("CITY"));
                person.setState(resultSet.getString("STATE"));
                person.setZipcode(resultSet.getInt("ZIP_CODE"));
                person.setPhoneNumber(resultSet.getInt("PHONE_NUMBER"));
                person.setStartDate(resultSet.getString("START_DATE"));
                personList.add(person);
            }
            System.out.println("QUERY EXECUTED");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return personList;
    }
}
