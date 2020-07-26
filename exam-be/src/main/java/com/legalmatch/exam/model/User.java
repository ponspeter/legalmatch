package com.legalmatch.exam.model;

import com.legalmatch.exam.enums.EmployeeStatusEnum;
import com.legalmatch.exam.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER", schema = "APP_EXAM")
public class User {

    @Id
    @GeneratedValue(generator = "USER_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_GEN", allocationSize = 1, sequenceName = "USER_SEQ")
    @Column(name = "ID_USER", nullable = false, unique = true, updatable = false)
    private long id;

    @OneToOne
    @JoinColumn(name = "ID_PERSONAL_INFORMATION")
    private PersonalInformation information;

    @Size(min = 1, max = 100)
    @NotNull
    @Column(name = "USERNAME", length = 100)
    private String username;

    @NotNull
    @Size(min = 8)
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", length = 50)
    private RoleEnum role;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 10)
    private EmployeeStatusEnum status;
}
