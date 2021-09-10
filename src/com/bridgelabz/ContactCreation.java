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

    public void editPerson() {
        try {
            System.out.println("What do you want to edit \n" +
                    "1. First Name / 2. Last Name / 3. Address / 4. City / " +
                    "5. State / 6. Zip code / 7. Phone Number / 8. Email");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter new First Name");
                    String newFirstName = scanner.next();
                    contactInfo.setFirstName(newFirstName);
                    break;
                case 2:
                    System.out.println("Enter new Last Name");
                    String newLastName = scanner.next();
                    contactInfo.setLastName(newLastName);
                    break;
                case 3:
                    System.out.println("Enter new Address");
                    String newAddress = scanner.next();
                    contactInfo.setAddress(newAddress);
                    break;
                case 4:
                    System.out.println("Enter new City");
                    String newCity = scanner.next();
                    contactInfo.setCity(newCity);
                    break;
                case 5:
                    System.out.println("Enter new State");
                    String newState = scanner.next();
                    contactInfo.setState(newState);
                    break;
                case 6:
                    System.out.println("Enter new Zip code");
                    int newZip = scanner.nextInt();
                    contactInfo.setZip(newZip);
                    break;
                case 7:
                    System.out.println("Enter new Phone Number");
                    long newPhoneNo = scanner.nextLong();
                    contactInfo.setPhoneNo(newPhoneNo);
                    break;
                case 8:
                    System.out.println("Enter new Email");
                    String newEmail = scanner.next();
                    contactInfo.setEmail(newEmail);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteContact() {
        try {
            contactInfo.setFirstName(null);
            contactInfo.setLastName(null);
            contactInfo.setAddress(null);
            contactInfo.setCity(null);
            contactInfo.setState(null);
            contactInfo.setZip(0);
            contactInfo.setPhoneNo(0);
            contactInfo.setEmail(null);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}