package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.List;

public interface ReadandWrite {

    void write(List<Contact> contactList) throws IOException;
    void read(String name) throws IOException;
}
