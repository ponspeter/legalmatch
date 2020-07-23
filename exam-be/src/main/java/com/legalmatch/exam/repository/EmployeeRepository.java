package com.legalmatch.exam.repository;

import com.legalmatch.exam.enums.EmployeeStatusEnum;
import com.legalmatch.exam.model.Employee;
import com.legalmatch.exam.model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeeByStatus(EmployeeStatusEnum statusEnum);
    Optional<Employee> findByIdAndStatus(long id, EmployeeStatusEnum statusEnum);
}
