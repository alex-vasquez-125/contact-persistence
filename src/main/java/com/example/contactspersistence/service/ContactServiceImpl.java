package com.example.contactspersistence.service;

import com.example.contactspersistence.domain.entity.Contact;
import com.example.contactspersistence.repository.ContactRepository;
import org.example.contact.dto.ContactDto;
import org.example.contact.dto.NewContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    private ContactRepository contactRepository;
    private ContactDtoEntityConverter contactDtoEntityConverter;

    @Autowired
    ContactServiceImpl(ContactRepository contactRepository, ContactDtoEntityConverter contactDtoEntityConverter) {
        this.contactRepository = contactRepository;
        this.contactDtoEntityConverter = contactDtoEntityConverter;
    }

    @Override
    @Transactional
    public ContactDto create(NewContactDto newContactDto) {
        Contact newContact = contactDtoEntityConverter.newContactDtoToContactEntity(newContactDto);
        newContact.setAge(30L);
        newContact.setDateOfBirth("31-12-9999");
        newContact.setSalary(1000000000L);

        // todo .save throws Illegal arg exception - need to handle
        Contact createdContact = contactRepository.save(newContact);

        return contactDtoEntityConverter.contactEntityToContactDto(createdContact);
    }

    @Override
    public ContactDto findById(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);

        return contact.map(value -> contactDtoEntityConverter.contactEntityToContactDto(value)).orElse(null);
    }
}
