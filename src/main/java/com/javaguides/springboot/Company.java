package com.javaguides.springboot;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

//import com.javaguides.springboot.Address;

public class Company {
    private Address address;
    private Contact contact;

    public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Company(Address address, Contact contact) {
        this.setAddress(address);
        this.setContact(contact);
        System.out.println(address);
        System.out.println(contact.name+ " "+ contact.phone);
    }

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
