package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddressBookFile {

    public static final String Location = "C:\\Users\\shiv\\IdeaProjects\\ADDRESS-BOOK\\AddressBook.txt";

    public void readingAddressBook() throws FileNotFoundException{
        File file = new File(Location);
        Scanner sc = new Scanner(file);

        String Data = null;
        while (sc.hasNextLine())
            Data = sc.nextLine();
        System.out.println("ADDRESSBOOK : \n"+Data);
    }

    public void writingAddressBook(List<main.java.com.bridgelabz.addressbook.Contacts> contactsList) throws IOException {

        File file = new File(Location);
        FileWriter output = new FileWriter(Location);
        StringBuffer sb = new StringBuffer();
        contactsList.forEach(contacts -> {String data = contacts.toString().concat("\n");
        sb.append(data);});
        output.write(sb.toString());
        System.out.println("FILE");

        output.close();
    }
}
