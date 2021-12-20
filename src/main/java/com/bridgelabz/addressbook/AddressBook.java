package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phoneNumber;
    String email;
    public static List<Contact> contactList;


    public AddressBook() {
        super();
        contactList = new ArrayList<>();
    }

    public static List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        AddressBook.contactList = contactList;
    }

    Scanner sc = new Scanner(System.in);

    public List<Contact>addContact() {

        Contact person = new Contact();
        System.out.println("Enter your First Name");
        firstName = sc.next();
        if (checkDuplicate(firstName) == false) {
            person.setFirstName(firstName);
            System.out.println("Enter your Last Name");
            lastName = sc.next();
            person.setLastName(lastName);
            System.out.println("Enter your Address");
            address = sc.next();
            person.setAddress(address);
            System.out.println("Enter your City");
            city = sc.next();
            person.setCity(city);
            System.out.println("Enter your State");
            state = sc.next();
            person.setState(state);
            System.out.println("Enter your ZipCode");
            zip = sc.next();
            person.setZip(zip);
            System.out.println("Enter your Phone Number");
            phoneNumber = sc.next();
            person.setPhoneNumber(phoneNumber);
            System.out.println("Enter your E-mail");
            email = sc.next();
            person.setEmail(email);
            contactList.add(new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
        } else {
            System.out.println("Duplicate value cant be add");
        }

        return contactList;

    }

    public void display() {
        contactList.stream().forEach(System.out::println);

    }

    public int getIndex(String firstName) {
        int index = -1;
        for (int i = 0; i < contactList.size(); i++) {
            if (firstName.equals(contactList.get(i).getFirstName())) {
                return i;
            }
        }
        return index;
    }

    public boolean checkDuplicate(String firstName) {

        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getFirstName().contains(firstName)) {
                return true;
            }
        }
        return false;
    }

    public void searchByCityName() {
        System.out.println("Enter City Name");
        String searchText = sc.next();
        Long count = contactList.stream().filter(el -> el.getCity().equals(searchText))
                .peek(System.out::println)
                .count();
        System.out.println("The number of Contacts in City :" + searchText + " = " + count);

    }

    public void searchByStateName() {
        System.out.println("Enter State Name");
        String searchText = sc.next();
        Long count = contactList.stream().filter(el -> el.getState().equals(searchText))
                .peek(System.out::println)
                .count();
        System.out.println("The number of Contacts in City :" + searchText + " = " + count);
    }

    public void viewCityName() {
        String searchText = sc.next();
        contactList.stream().filter(el -> el.getCity().equals(searchText))
                .forEach(p -> System.out.println("First Name :"+p.getFirstName()+"Last Name:"+p.getLastName()));
    }

    public void viewStateName() {
        String searchText = sc.next();
        contactList.stream().filter(el -> el.getState().equals(searchText))
                .forEach(p -> System.out.println("First Name :"+p.getFirstName()+"Last Name:"+p.getLastName()));
    }

    public void updateContact(int i) {

        System.out.println("Enter your First Name");
        firstName = sc.next();
        System.out.println("Enter your Last Name");
        lastName = sc.next();
        System.out.println("Enter your Address");
        address = sc.next();
        System.out.println("Enter your City");
        city = sc.next();
        System.out.println("Enter your State");
        state = sc.next();
        System.out.println("Enter your ZipCode");
        zip = sc.next();
        System.out.println("Enter your Phone Number");
        phoneNumber = sc.next();
        System.out.println("Enter your E-mail");
        email = sc.next();
        contactList.set(i, new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email));
    }

    public void removeContact(int index) {
        contactList.remove(index);

    }

}
