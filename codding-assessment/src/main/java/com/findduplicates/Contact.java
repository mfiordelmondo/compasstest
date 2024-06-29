package com.findduplicates;

public class Contact {
    private Integer contactID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String zipCode;
    private String address;

    public Contact(Integer contactID, String firstName, String lastName, String emailAddress, String zipCode, String address) {
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.zipCode = zipCode;
        this.address = address;
    }

    public Integer getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress() {
        return address;
    }

//    @Override
//    public String toString() {
//        return "Contact{" +
//                "contactID=" + contactID +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", emailAddress='" + emailAddress + '\'' +
//                ", zipCode='" + zipCode + '\'' +
//                ", address='" + address + '\'' +
//                '}';
//    }
}
