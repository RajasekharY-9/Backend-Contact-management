package com.contact.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.contact.entity.Contact;
import com.contact.repository.ContactRepository;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	
	
	@Override
	public  Contact saveContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> getAllContacts( ) {
		// TODO Auto-generated method stub
		return	contactRepository.findAll(Sort.by(Sort.Direction.DESC ,"id"));
		
		
		
	}

	@Override
	public Optional<Contact> getContact(int id) {
		// TODO Auto-generated method stub
		return contactRepository.findById(id) ;
	}

	@Override
	public String deleteConatct(int id) {
		// TODO Auto-generated method stub
		 contactRepository.deleteById(id);
		 return "Deleted Successfully";
	}



	@Override
	public Contact updateContact(int id, Contact contact) {
		// TODO Auto-generated method stub
		Contact cv=contactRepository.findById(id).orElseThrow();
		cv.setContactNo(contact.getContactNo());
		cv.setName(contact.getName());
		
		
		
		return contactRepository.save(cv);
	}

}
