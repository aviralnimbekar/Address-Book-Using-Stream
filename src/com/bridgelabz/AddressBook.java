package com.bridgelabz;

import java.util.Scanner;

public class AddressBook {

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Problem");

        ContactCreation contactCreation = new ContactCreation();
        contactCreation.addContact();
        contactCreation.editPerson();
    }
}
