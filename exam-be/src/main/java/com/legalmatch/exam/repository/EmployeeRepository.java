package com.legalmatch.exam.repository;

import com.legalmatch.exam.enums.EmployeeStatusEnum;
import com.legalmatch.exam.model.Employee;
import com.legalmatch.exam.model.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    List<Employee> findEmployeeByStatus(EmployeeStatusEnum statusEnum);
    Optional<Employee> findByIdAndStatus(long id, EmployeeStatusEnum statusEnum);
}
