package com.bridgelabz.addressbook;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSV implements ReadandWrite {
    MultipleAddressBook addressBook = new MultipleAddressBook();
    String url = AddressBookFile.Location;

    @Override
    public void write(List<Contact> contactList) throws IOException {

        String bookFileWriter = url + "\\" + MultipleAddressBook.bookName + "\\" + MultipleAddressBook.bookName + ".csv";
        Path bookPath = Paths.get(bookFileWriter);
        Files.createFile(bookPath);

        try(Writer writer = Files.newBufferedWriter(Paths.get(bookFileWriter));
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

            CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(Contact.class).withIgnoreLeadingWhiteSpace(true).build();

            Iterator<Contact> csvUserIterator = csvToBean.iterator();
            System.out.println(name + ":-");
            while (csvUserIterator.hasNext()) {
                Contact csvUser = csvUserIterator.next();
                System.out.println("Name First : " + csvUser.getFirstName());
                System.out.println("Name Last: " + csvUser.getLastName());
                System.out.println("address: " + csvUser.getAddress());
                System.out.println("city : " + csvUser.getCity());
                System.out.println("zip : " + csvUser.getZip());
                System.out.println("PhoneNo : " + csvUser.getPhoneNumber());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("==========================");
            }

        }

    }
}
