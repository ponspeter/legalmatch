package com.legalmatch.exam.repository;

import com.legalmatch.exam.model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {
}
