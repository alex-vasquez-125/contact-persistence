package com.example.contactspersistence.repository;

import com.example.contactspersistence.entity.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
    // Contact findById(long id);
    List<Contact> findByFirstName(@Param("firstName") String firstName);
    List<Contact> findByLastName(@Param("lastName") String lastName);
}
