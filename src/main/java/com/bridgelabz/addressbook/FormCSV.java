package com.bridgelabz.addressbook;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import main.java.com.bridgelabz.addressbook.Contacts;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static main.java.com.bridgelabz.addressbook.AddressBook.contactList;

public class FormCSV implements ReadingWriting {

    MultipleAddressBook addressBook = new MultipleAddressBook();
    String st = AddressBookFile.Location;


    @Override
    public void write(List<Contacts> contactsList) throws IOException {

        String FileWriter = url + "\\" + MultipleAddressBook.BookName + "\\" + MultipleAddressBook.bookName + ".csv";
        Path bookPath = Paths.get(FileWriter);
        Files.createFile(bookPath);

        try(Writer writer = Files.newBufferedWriter(Paths.get(FileWriter));
            CSVWriter csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);){

            String[] List = { "firstName", "lastName", "address", "city", "state", "zip", "phoneNumber",
                    "email" };

            csvWriter.writeNext(List);
            contactList.stream()
                    .forEach(contact -> csvWriter.writeNext(new String[] { contact.getFirstName(),
                            contact.getLastName(), contact.getAddress(), contact.getCity(), contact.getState(),
                            contact.getZip(), contact.getPhoneNumber(), contact.getEmail() }));
        }
    }

    @Override
    public void read(String name) throws IOException {
        try(Reader reader = Files.newBufferedReader(Paths.get(url + "\\" +  name + "\\" + name + "\\" + ".csv"));){
            CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(Contact.class).withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<Contact> csvUserIterator = csvToBean.iterator();
            System.out.println(name + ":-");
            while (csvUserIterator.hasNext()) {
                Contact csvUser = csvUserIterator.next();
                System.out.println("First Name : " + csvUser.getFirstName());
                System.out.println("Last Name: " + csvUser.getLastName());
                System.out.println("Address: " + csvUser.getAddress());
                System.out.println("city : " + csvUser.getCity());
                System.out.println("zip : " + csvUser.getZip());
                System.out.println("PhoneNo : " + csvUser.getPhoneNumber());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("************************");
            }
        }


        }
}
