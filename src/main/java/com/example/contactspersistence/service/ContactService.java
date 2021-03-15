package com.example.contactspersistence.service;

import org.example.contact.dto.ContactDto;
import org.example.contact.dto.NewContactDto;

public interface ContactService {
    ContactDto create(NewContactDto newContactDto);
    ContactDto findById(Long id);
}
