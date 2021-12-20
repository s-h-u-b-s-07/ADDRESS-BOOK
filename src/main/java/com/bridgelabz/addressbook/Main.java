package com.bridgelabz.addressbook;


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        MultipleAddressBook books = new MultipleAddressBook();

        System.out.println("Add new AddressBook \n(Yes/No)");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        while (str.equals("yes")) {
            books.newAddressBook();
            System.out.println("Add new AddressBook \n(Yes/No)");
            str = sc.next();
        }
        books.displayBook();
    }

}
