package com.legalmatch.exam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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
    @SequenceGenerator(name = "CONTACT_GEN", allocationSize = 1, sequenceName = "CONTACT_SEQ")
    @Column(name = "ID_CONTACT", nullable = false, unique = true, updatable = false)
    private long id;

    @Column(name = "PHONE", length = 30)
    private String phone;

    @Column(name = "MOBILE", length = 30)
    private String mobile;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "IS_PRIMARY")
    private boolean isPrimary;

    @Column(name = "ID_PERSONAL_INFORMATION", updatable = false,insertable = false)
    private long personalInformationId;
}
