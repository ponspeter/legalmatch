package com.legalmatch.exam.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.legalmatch.exam.enums.EmployeeStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Size(min = 1, max = 250)
    @NotNull
    @Column(name = "POSITION", length = 250)
    private String position;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATE_HIRED")
    private LocalDate dateHired;

    @NotNull
    @Column(name = "YEARS_IN_SERVICE")
    private int yearsInService;

    @NotNull
    @Column(name = "STATUS")
    private EmployeeStatusEnum status;
}
