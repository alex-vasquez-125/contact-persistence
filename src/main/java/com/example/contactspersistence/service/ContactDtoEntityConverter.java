package com.example.contactspersistence.service;

import com.example.contactspersistence.entity.Contact;
import org.example.contact.dto.ContactDto;
import org.example.contact.dto.NewContactDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ContactDtoEntityConverter {
    private ModelMapper modelMapper = new ModelMapper();

    public Contact newContactDtoToContactEntity(NewContactDto newContactDto) {
        return modelMapper.map(newContactDto, Contact.class);
    }

    public ContactDto contactEntityToContactDto(Contact contact) {
        return modelMapper.map(contact, ContactDto.class);
    }
}

// todo - extract to the shared dto lib? Would need to make the entity object generic and then do some configuration annotation to make this bean autowirable
