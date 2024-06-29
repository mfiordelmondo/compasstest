package com.findduplicates;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testReadContactsFromFile() {
        List<Contact> contacts = App.readContactsFromFile("src/test/resources/contacts-test.txt");
        assertEquals(3, contacts.size());

        Contact firstContact = contacts.get(1);
        assertEquals(Integer.valueOf(1002), firstContact.getContactID());
        assertEquals("C", firstContact.getFirstName());
        assertEquals("French", firstContact.getLastName());
        assertEquals("mollis.lectus.pede@outlook.net", firstContact.getEmailAddress());
        assertEquals("39746", firstContact.getZipCode());
        assertEquals("449-6990 Tellus. Rd.", firstContact.getAddress());
    }

    public void testSetAccuracy() {
        assertEquals("No Duplicates", App.setAccuracy(0));
        assertEquals("Very Low", App.setAccuracy(1));
        assertEquals("Low", App.setAccuracy(2));
        assertEquals("Medium", App.setAccuracy(3));
        assertEquals("High", App.setAccuracy(4));
        assertEquals("Very High", App.setAccuracy(5));
        assertEquals("Out of range", App.setAccuracy(6));
    }

    public void testFindDuplicates() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(1, "John", "Doe", "john.doe@example.com", "12345", "123 Main St"));
        contacts.add(new Contact(2, "Jane", "Smith", "jane.smith@example.com", "54321", "456 Oak Ave"));
        contacts.add(new Contact(3, "John", "Doe", "john.doe@example.com", "12345", "123 Main St"));

        List<ContactDuplicated> contactDuplicatedList = App.findDuplicates(contacts);

        assertEquals(2, contactDuplicatedList.size());
        ContactDuplicated cd = contactDuplicatedList.get(0);
        assertEquals(1, cd.getContactIDSource());
        assertEquals(3, cd.getContactIDMatch());
        assertEquals("Very High", cd.getAccuracy());
    }
}
