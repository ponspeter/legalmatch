package com.legalmatch.exam.model;

import com.legalmatch.exam.enums.GenderEnum;
import com.legalmatch.exam.enums.MaritalStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PERSONAL_INFORMATION", schema = "APP_EXAM")
@EntityListeners(AuditingEntityListener.class)
public class PersonalInformation {

    @Id
    @GeneratedValue(generator = "PERSONAL_INFORMATION_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PERSONAL_INFORMATION_GEN", allocationSize = 1, sequenceName = "PERSONAL_INFORMATION_SEQ")
    @Column(name = "ID_PERSONAL_INFORMATION", nullable = false, unique = true, updatable = false)
    private long id;

    @NotNull
    @Column(name = "FIRST_NAME", length = 50)
    private String firstName;

    @NotNull
    @Column(name = "LAST_NAME", length = 50)
    private String lastName;

    @Column(name = "MIDDLE_NAME", length = 50)
    private String middleName;

    @NotNull
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", length = 6)
    private GenderEnum gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "MARITAL_STATUS", length = 10)
    private MaritalStatusEnum maritalStatus;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ID_PERSONAL_INFORMATION")
    private Set<Address> addresses;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "ID_PERSONAL_INFORMATION")
    private Set<Contact> contacts;
}
