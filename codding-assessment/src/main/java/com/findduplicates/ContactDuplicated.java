package com.findduplicates;

public class ContactDuplicated {
    private Integer contactIDSource;
    private Integer contactIDMatch;
    private String accuracy;

    public ContactDuplicated(Integer contactIDSource, Integer contactIDMatch, String accuracy) {
        this.setContactIDSource(contactIDSource);
        this.setContactIDMatch(contactIDMatch);
        this.setAccuracy(accuracy);
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


	public int getContactIDSource() {
		return contactIDSource;
	}


	public void setContactIDSource(Integer contactIDSource) {
		this.contactIDSource = contactIDSource;
	}


	public int getContactIDMatch() {
		return contactIDMatch;
	}


	public void setContactIDMatch(Integer contactIDMatch) {
		this.contactIDMatch = contactIDMatch;
	}


	public String getAccuracy() {
		return accuracy;
	}


	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
}
