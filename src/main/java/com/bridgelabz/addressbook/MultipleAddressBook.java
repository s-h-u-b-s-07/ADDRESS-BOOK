package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MultipleAddressBook {

    Map<String, List> book = new HashMap();
    Scanner sc = new Scanner(System.in);
    static String bookName;

    public void newAddressBook() throws IOException {
        System.out.println("Enter Book name");
        bookName = sc.next();
        if (book.containsKey(bookName)) {
            System.out.println("Address book name exists");
        } else {
            addAddressBook();
            book.put(bookName, AddressBook.getContactList());
        }
    }


    public void addAddressBook() throws IOException {

        AddressBook addressBook = new AddressBook();
        int act;
        System.out.println("Welcome to Address Book");
        List<Contact> contactList = new ArrayList<Contact>();
        do {
            System.out.println("Enter\n1.Add\n2.Update\n3.Delete\n4.Print\n5.City Name\n7.State\n8.Exit");
            act = sc.nextInt();
            int index = -1;
            String fName;
            switch (act) {
                case 1:
                    contactList = addressBook.addContact();
                    break;
                case 2:
                    System.out.println("Enter your First name to update");
                    fName = sc.next();
                    index = addressBook.getIndex(fName);
                    if (index < 0) {
                        break;
                    }
                    addressBook.updateContact(index);
                    break;
                case 3:
                    System.out.println("Enter your First name to delete");
                    fName = sc.next();
                    index = addressBook.getIndex(fName);
                    addressBook.removeContact(index);
                    break;

                case 4:
                    addressBook.display();
                    break;

                case 5:
                    addressBook.searchByCityName();
                    break;
                case 6:
                    addressBook.searchByStateName();
                    break;

                case 7:
                    addressBook.viewCityName();
                    addressBook.viewStateName();
                    break;

                case 8:
                    System.out.println("exit " + bookName);
                    act = 0;
            }
        } while (act > 0 || act > 9);
        AddressBookFile fileIO = new AddressBookFile();
        System.out.println(contactList);
        fileIO.writeAddressBook(contactList);
        CSV csv = new CSV();
        csv.write(contactList);
    }

    public void displayBook() {
        book.entrySet().stream().forEach(el -> System.out.println(el));//STREAM
    }


}
