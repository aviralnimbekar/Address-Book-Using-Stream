package com.bridgelabz;

import java.util.Scanner;

public class ContactCreation {
    static Scanner scanner = new Scanner(System.in);
    ContactInfo contactInfo = new ContactInfo();

    public void addContact() {
        try {
            System.out.println("Enter following details \n" +
                    "First Name :");
            String firstName = scanner.nextLine();
            System.out.println("Last Name :");
            String lastName = scanner.nextLine();
            System.out.println("Address :");
            String address = scanner.nextLine();
            System.out.println("City :");
            String city = scanner.nextLine();
            System.out.println("State :");
            String state = scanner.nextLine();
            System.out.println("Zip Code :");
            int zip = scanner.nextInt();
            System.out.println("Phone Number :");
            long phoneNo = scanner.nextLong();
            System.out.println("Email :");
            String email = scanner.next();

            contactInfo.setFirstName(firstName);
            contactInfo.setLastName(lastName);
            contactInfo.setAddress(address);
            contactInfo.setCity(city);
            contactInfo.setState(state);
            contactInfo.setZip(zip);
            contactInfo.setPhoneNo(phoneNo);
            contactInfo.setEmail(email);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}