package com.contact.service;

import java.util.List;
import java.util.Optional;

import com.contact.entity.Contact;

public interface ContactService {

	    public Contact saveContact(Contact contact) ;
      	public List<Contact> getAllContacts();
		public Optional<Contact> getContact(int id);
	
		public String deleteConatct(int id);
		
		public Contact updateContact(int id,Contact contact);
}
