package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;


public class AddressBook {

    private static final String String = null;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    long phoneNumber;
    String email;

    public AddressBook() {
        contactList = new ArrayList<>();
    }

    MultipleAddressBook mbooks = new MultipleAddressBook();

    public static List<Contacts> contactList = new ArrayList<>();

    public List<Contacts> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contacts> contactList) {
        AddressBook.contactList = contactList;
    }

    Scanner sc = new Scanner(System.in);

    public void addContact() {

        Contacts person = new Contacts();
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
            zip = sc.nextInt();
            person.setZip(zip);
            System.out.println("Enter your Phone Number");
            phoneNumber = sc.nextInt();
            person.setPhoneNumber(phoneNumber);
            System.out.println("Enter your E-mail");
            email = sc.next();
            person.setEmail(email);
            contactList.add(new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email));
        } else {
            System.out.println("Duplicate value cant be add");
        }

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
        zip = sc.nextInt();
        System.out.println("Enter your Phone Number");
        phoneNumber = sc.nextLong();
        System.out.println("Enter your E-mail");
        email = sc.next();

        contactList.set(i, (new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, email)));

    }

    public void removeContact(int index) {
        contactList.remove(index);

    }

    public void searchByCity_or_State_Name() {

        System.out.println("Enter City Name  or State Name ");
        String searchText = sc.next();
        Long countContacts = contactList.stream()
                .filter(c -> (c.getCity().equals(searchText) || c.getState().equals(searchText)))
                .peek(System.out::println).count();
        System.out.println("The number of Contacts in City or State :" + searchText + " = " + countContacts);

    }

    public void view_By_City_or_State_Name() {

        System.out.println("Enter City Name  or State Name ");
        String searchText = sc.next();
        contactList.stream().filter(c -> (c.getCity().equals(searchText) || c.getState().equals(searchText))).forEach(
                p -> System.out.println("First Name : " + p.getFirstName() + "  Last Name : " + p.getLastName()));

    }

    public static void sort_by_PersonName() {

        List<Contacts> sortedContact = contactList.stream().sorted(new compareToFirstName())
                .collect(Collectors.toList());
        System.out.println(sortedContact);
    }

}

class compareToFirstName implements Comparator<Contacts> {

    @Override
    public int compare(Contacts c1, Contacts c2) {

        return c1.getFirstName().compareTo(c2.getFirstName());
    }

}
