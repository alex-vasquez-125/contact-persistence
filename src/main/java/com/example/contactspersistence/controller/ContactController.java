package com.example.contactspersistence.controller;

import com.example.contactspersistence.service.ContactServiceImpl;
import org.example.contact.dto.ContactDto;
import org.example.contact.dto.NewContactDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

// TODO: null/empty checks
@RestController
@RequestMapping("/api")
public class ContactController {
    ContactServiceImpl contactService;

    @Autowired
    ContactController(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/v1/contact")
    public ResponseEntity<ContactDto> postContact(@RequestBody NewContactDto newContactDto) {
        System.out.println("Got a new contact!");
        System.out.println(newContactDto);

        ContactDto createdContactDto = contactService.create(newContactDto);

        URI uri = URI.create("/contact/" + createdContactDto.getContactId());
        return ResponseEntity.created(uri).body(createdContactDto);
    }

    @GetMapping("/v1/contact")
    public ResponseEntity<List<ContactDto>> getAllContacts() {
        return null;
    }

    @GetMapping("/v1/contact/{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Long id) {
        ContactDto contactDto = contactService.findById(id);

        System.out.println("Found a contact!");
        System.out.println(contactDto);

        return ResponseEntity.ok().body(contactDto);
    }
}
