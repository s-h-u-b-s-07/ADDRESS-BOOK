package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.List;

public interface ReadingWriting {

    void write(List<main.java.com.bridgelabz.addressbook.Contacts> contactsList) throws IOException;
    void read(String name) throws IOException;
}
