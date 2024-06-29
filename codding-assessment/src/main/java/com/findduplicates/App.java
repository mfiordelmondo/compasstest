package com.findduplicates;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main(String[] args)
    {
        List<Contact> contacts = readContactsFromFile("./contacts.txt");
        List<ContactDuplicated> contactDuplicatedList = findDuplicates(contacts);

        for (ContactDuplicated cd : contactDuplicatedList) {
            System.out.println(cd.getContactIDSource() + "," + cd.getContactIDMatch() + "," + cd.getAccuracy());
        }
    }

    public static List<Contact> readContactsFromFile(String fileName) {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                Contact contact = new Contact(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        values[5]
                );
                contacts.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public static String setAccuracy(Integer matches) {
        switch (matches) {
            case 0:
                return "No Duplicates";
            case 1:
                return "Very Low";
            case 2:
                return "Low";
            case 3:
                return "Medium";
            case 4:
                return "High";
            case 5:
                return "Very High";
            default:
                return "Out of range";
        }
    }

    public static List<ContactDuplicated> findDuplicates(List<Contact> contacts) {
        List<ContactDuplicated> contactDuplicatedList = new ArrayList<>();

        for (Contact contact : contacts) {
            for (Contact isContactDuplicated : contacts) {
                if (!contact.getContactID().equals(isContactDuplicated.getContactID())) {
                    Integer matches = 0;
                    if (contact.getContactID() == (isContactDuplicated.getContactID())) {
                        matches += 1;
                    }
                    if (contact.getFirstName().equalsIgnoreCase(isContactDuplicated.getFirstName())) {
                        matches += 1;
                    }
                    if (contact.getLastName().equalsIgnoreCase(isContactDuplicated.getLastName())) {
                        matches += 1;
                    }
                    if (contact.getEmailAddress().equalsIgnoreCase(isContactDuplicated.getEmailAddress())) {
                        matches += 1;
                    }
                    if (contact.getZipCode().equalsIgnoreCase(isContactDuplicated.getZipCode())) {
                        matches += 1;
                    }
                    if (contact.getAddress().equalsIgnoreCase(isContactDuplicated.getAddress())) {
                        matches += 1;
                    }
                    if (matches > 0) {
                        String accuracy = setAccuracy(matches);
                        ContactDuplicated contactDuplicated = new ContactDuplicated(contact.getContactID(), isContactDuplicated.getContactID(), accuracy);
                        contactDuplicatedList.add(contactDuplicated);
                    }
                }
            }
        }
        return contactDuplicatedList;
    }
}