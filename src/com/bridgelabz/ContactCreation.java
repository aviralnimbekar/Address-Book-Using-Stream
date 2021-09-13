package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

public class ContactCreation {
    static Scanner scanner = new Scanner(System.in);
    Map<String, List<ContactInfo>> addressBooks = new HashMap<>();

    protected void MultipleAddressBook() {
        try {
            while (true) {
                System.out.println("What would you like to do? \n" +
                        "1. Crate new address book \n" +
                        "2. Continue with existing address book \n" +
                        "3. All books \n" +
                        "4. search contact in city \n" +
                        "5. search contact in state \n" +
                        "0. EXIT");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter name for Address book");
                        String newBookName = scanner.next();
                        List<ContactInfo> contactList = new LinkedList<>();
                        if (addressBooks.containsKey(newBookName))
                            System.out.println("Book already exists");
                        else
                            MultipleContact(contactList, addressBooks, newBookName);
                        break;
                    case 2:
                        System.out.println(addressBooks.keySet());
                        System.out.println("Which address book do you want to access?");
                        String existingBook = scanner.next();
                        if (addressBooks.containsKey(existingBook)) {
                            contactList = addressBooks.get(existingBook);
                            MultipleContact(contactList, addressBooks, existingBook);
                        } else
                            System.out.println("Book not found");
                        break;
                    case 3:
                        int serialNo = 1;
                        for (String book : addressBooks.keySet()) {
                            System.out.println(serialNo + ". " + book);
                            serialNo++;
                        }
                        System.out.println("\n" + addressBooks);
                        break;
                    case 4:
                        System.out.println("Enter Name for City");
                        String nameForCity = scanner.next();
                        searchAcrossCity(nameForCity);
                        break;
                    case 5:
                        System.out.println("Enter Name for State");
                        String nameForState = scanner.next();
                        searchAcrossState(nameForState);
                        break;
                    default:
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void MultipleContact(List<ContactInfo> contactList, Map<String, List<ContactInfo>> addressBook, String newBook) {
        try {
            boolean run = true;
            while (run) {
                System.out.println("What would u like to do with contacts? \n" +
                        "1. ADD     \n" +
                        "2. DISPLAY \n" +
                        "3. EDIT    \n" +
                        "4. REMOVE  \n" +
                        "0. EXIT    ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        List<ContactInfo> multiContactInBook = addContact(contactList);
                        addressBook.put(newBook, multiContactInBook);
                        break;
                    case 2:
                        displayContact(contactList);
                        break;
                    case 3:
                        editContact(contactList);
                        break;
                    case 4:
                        deleteContact(contactList);
                        break;
                    default:
                        run = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private List<ContactInfo> addContact(List<ContactInfo> contactList) {
        try {
            System.out.println("Enter following details \n" +
                    "First Name :");
            String firstName = scanner.next();
            int existingName = searchName(contactList, firstName);
            if (existingName == -1) {
                System.out.println("Last Name :");
                String lastName = scanner.next();
                System.out.println("Address :");
                String address = scanner.next();
                System.out.println("City :");
                String city = scanner.next();
                System.out.println("State :");
                String state = scanner.next();
                System.out.println("Zip Code :");
                int zip = scanner.nextInt();
                System.out.println("Phone Number :");
                long phoneNo = scanner.nextLong();
                System.out.println("Email :");
                String email = scanner.next();
                ContactInfo contactInfo = new ContactInfo(firstName,
                        lastName, address, city, state, zip, phoneNo, email);
                contactList.add(contactInfo);
                contactList = contactList
                        .stream()
                        .sorted(Comparator.comparing(ContactInfo::getFirstName))
                        .collect(Collectors.toList());
            } else
                System.out.println("Name already exists");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return contactList;
    }

    private void displayContact(List<ContactInfo> contactList) {
        System.out.println("All contact =  " + contactList.size());
        System.out.println(contactList);
    }

    private void editContact(List<ContactInfo> contactList) {
        try {
            System.out.println("Enter a name you want to edit...");
            String searchName = scanner.next();
            int editName = searchName(contactList, searchName);
            if (editName == -1)
                System.out.println("Name not found");
            else {
                ContactInfo contactInfo = contactList.get(editName);
                System.out.println(contactInfo);
                System.out.println("What do you want to edit \n" +
                        "1. First Name / 2. Last Name / 3. Address / 4. City / 5. State " +
                        "/ 6. Zip code / 7. Phone Number / 8. Email");
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
                System.out.println("SUCCESSFUL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void deleteContact(List<ContactInfo> contactList) {
        try {
            System.out.println("Enter a name you want to delete...");
            String searchName = scanner.next();
            int deleteName = searchName(contactList, searchName);
            if (deleteName == -1)
                System.out.println("Name not found");
            else {
                contactList.remove(deleteName);
                System.out.println("SUCCESSFUL");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private int searchName(List<ContactInfo> contactList, String searchName) {
        try {
            for (int index = 0; index < contactList.size(); index++) {
                if (contactList.get(index).getFirstName().equals(searchName))
                    return index;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    private void searchAcrossCity(String contactsInCity) {
        try {
            for (String keyOfBook : addressBooks.keySet()) {
                long noOfContactsInCity = addressBooks.get(keyOfBook)
                        .stream()
                        .filter(contactInfo -> contactsInCity.equals(contactInfo.getCity()))
                        .count();
                System.out.println("Number of contact in city = " + noOfContactsInCity);
                addressBooks.get(keyOfBook)
                        .stream()
                        .filter(contactInfo -> contactsInCity.equals(contactInfo.getCity()))
                        .forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void searchAcrossState(String contactsInState) {
        try {
            for (String keyOfBook : addressBooks.keySet()) {
                long noOfContactsInState = addressBooks.get(keyOfBook)
                        .stream()
                        .filter(contactInfo -> contactsInState.equals(contactInfo.getState()))
                        .count();
                System.out.println("Number of contact in city = " + noOfContactsInState);
                addressBooks.get(keyOfBook)
                        .stream()
                        .filter(contactInfo -> contactsInState.equals(contactInfo.getState()))
                        .forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}