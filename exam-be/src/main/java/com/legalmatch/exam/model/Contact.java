package com.legalmatch.exam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTACT", schema = "APP_EXAM")
@EntityListeners(AuditingEntityListener.class)
public class Contact {

    @Id
    @GeneratedValue(generator = "CONTACT_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_CONTACT", nullable = false, unique = true, updatable = false)
    private long id;

    @Size(max = 30)
    @Column(name = "PHONE", length = 30)
    private String phone;

    @Size(max = 30)
    @Column(name = "MOBILE", length = 30)
    private String mobile;

    @Size(max = 100)
    @Email
    @Column(name = "EMAIL", length = 100)
    private String email;

    @NotNull
    @Column(name = "IS_PRIMARY")
    private boolean isPrimary;

    @Column(name = "ID_PERSONAL_INFORMATION", updatable = false,insertable = false)
    private long personalInformationId;
}
