package com.bridgelabz.addressbook;

import java.util.Scanner;

public class Contact {
    Scanner sc = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String email;
    private Long zipcode;
    private Long phoneNumber;

    Contact(String firstName, String lastName, String address, String city, String state, String email, Long zipcode, Long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getZipCode() {
        return zipcode;
    }

    public void setZipCode(Long zipcode) {
        this.zipcode = zipcode;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void display() {
        System.out.println(" FIRST NAME: " + getFirstName() + " LAST NAME: " + getLastName() + " ADDRESS: " + getAddress() + " CITY " + getCity()
                + " STATE:" + getState() + " EMAIL ID:" + getEmail() + " ZIP CODE:" + getZipCode() + " PHONE NUMBER:" + getPhoneNumber());
    }

    public void editDetails() {
        System.out.println(" SELECT THE OPTION YOU WANT TO EDIT : ");
        System.out.println(" A.FIRST NAME\n B.LAST NAME\n C.ADDRESS\n D.CITY\n E.STATE\n F.EMAIL ID\n G.ZIPCODE\n H.PHONE NUMBER\n I.DELETE CONTACT ");
        char option;
        option = sc.next().charAt(0);
        sc.nextLine();

        switch (option) {
            case 'A':
                System.out.println("ENTER FIRST NAME: ");
                String firstName = sc.nextLine();
                setFirstName(firstName);
                break;
            case 'B':
                System.out.println("ENTER LAST NAME: ");
                String lastName = sc.nextLine();
                setLastName(lastName);
                break;
            case 'C':
                System.out.println("ENTER ADDRESS: ");
                String address = sc.nextLine();
                setAddress(address);
                break;
            case 'D':
                System.out.println("ENTER CITY: ");
                String city = sc.nextLine();
                setCity(city);
                break;
            case 'E':
                System.out.println("ENTER STATE: ");
                String state = sc.nextLine();
                setState(state);
                break;
            case 'F':
                System.out.println("ENTER EMAIL ID: ");
                String email = sc.nextLine();
                setEmail(email);
                break;
            case 'G':
                System.out.println("ENTER ZIPCODE: ");
                Long zipcode = sc.nextLong();
                setZipCode(zipcode);
                break;
            case 'H':
                System.out.println("ENTER PHONE NUMBER: ");
                Long phoneNumber = sc.nextLong();
                setPhoneNumber(phoneNumber);
                break;
            case 'I':
                setFirstName(null);
                setLastName(null);
                setAddress(null);
                setCity(null);
                setState(null);
                setEmail(null);
                setZipCode(null);
                setPhoneNumber(null);
                break;
        }

    }

}
