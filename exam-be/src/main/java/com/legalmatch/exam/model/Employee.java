package com.legalmatch.exam.model;

import com.legalmatch.exam.enums.EmployeeStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE", schema = "APP_EXAM")
public class Employee {

    @Id
    @GeneratedValue(generator = "EMPLOYEE_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "EMPLOYEE_GEN", allocationSize = 1, sequenceName = "EMPLOYEE_SEQ")
    @Column(name = "ID_EMPLOYEE", nullable = false, unique = true, updatable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "ID_PERSONAL_INFORMATION")
    private PersonalInformation information;

    @Column(name = "POSITION", length = 250)
    private String position;

    @Column(name = "DATE_HIRED")
    private LocalDate dateHired;

    //@Column(name = "DATE_END")
    //private LocalDate dateEnd;

    @Column(name = "STATUS")
    private EmployeeStatusEnum status;
}
