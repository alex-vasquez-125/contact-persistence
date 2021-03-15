package com.example.contactspersistence.repository;

import com.example.contactspersistence.domain.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    List<Contact> findByFirstName(@Param("firstName") String firstName);
    List<Contact> findByLastName(@Param("lastName") String lastName);
}
