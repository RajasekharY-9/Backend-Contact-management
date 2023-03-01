package com.contact.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Contact;
import com.contact.service.ContactService;

@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class Controller {

	@Autowired
	private ContactService contactService;
	
	@PostMapping
	public String addContact(@RequestBody Contact contact) {
		contactService.saveContact(contact);
		
		return "Contact Saved!!!";
	}
	
	@GetMapping
	public List<Contact> getAllContact(  ){
		
	return	contactService.getAllContacts();
		
	}
	
	@GetMapping("/{id}")
	public Optional<Contact> getOneContact(@PathVariable int id)
	{
		return contactService.getContact(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteContact(@PathVariable Integer id) {
		
		contactService.deleteConatct(id);
		return "Rey Dorababu data Delete ipoindira";
		
	}
	
	@PutMapping("/{id}")
	public String updateContact(@PathVariable int id,@RequestBody Contact contact) {
		 contactService.updateContact(id, contact);
		 return "Dorababu Details  Update Ayyayira";
	}
	
}
