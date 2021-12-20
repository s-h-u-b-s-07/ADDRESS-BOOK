package com.bridgelabz.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class AddressBookFile {

    public static final String Location = "C:\\Users\\shiv\\IdeaProjects\\ADDRESS-BOOK\\AddressBook.txt";

    public void readAddressBook(String name) throws FileNotFoundException {
        File file = new File(Location + "\\" +name+ "\\" +name+ ".txt");
        Scanner sc = new Scanner(file);

        System.out.println(name+":-\n");
        while(sc.hasNextLine())
            System.out.println("AddressBook:-\n"+sc.nextLine());
        sc.close();
    }

    public void writeAddressBook(List<Contact> contactList) throws IOException {
        String url = Location+"\\"+MultipleAddressBook.bookName;
        Path bookPath = Paths.get(url);
        Files.createDirectories(bookPath);
        String bookFileWrite = url + "\\" + MultipleAddressBook.bookName + ".txt";
        Path bookFile = Paths.get(bookFileWrite);
        Files.createFile(bookFile);

        FileWriter output = new FileWriter(bookFileWrite);
        StringBuffer addressBuffer = new StringBuffer();
        contactList.forEach(contact -> {
            String employeeDataString = contact.toString().concat("\n");
            addressBuffer.append(employeeDataString);
        });

        output.write(addressBuffer.toString());
        System.out.println("Data added in file.");
        output.close();
    }

}
