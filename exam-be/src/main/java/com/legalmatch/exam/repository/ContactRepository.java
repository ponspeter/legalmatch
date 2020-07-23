package com.legalmatch.exam.repository;

import com.legalmatch.exam.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByPersonalInformationId (long personalInformationId);
}
