package com.bridgelabz.addressbook;

public class Contact {             //UC1 ABILITY TO CREATE CONTACTS IN ADDRESS BOOK

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


}
