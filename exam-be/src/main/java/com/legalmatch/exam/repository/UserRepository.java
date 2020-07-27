package com.legalmatch.exam.repository;

import com.legalmatch.exam.enums.EmployeeStatusEnum;
import com.legalmatch.exam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndStatus(String username, EmployeeStatusEnum status);

}
