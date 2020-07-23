package com.legalmatch.exam.repository;

import com.legalmatch.exam.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByPersonalInformationId (long personalInformationId);
}
