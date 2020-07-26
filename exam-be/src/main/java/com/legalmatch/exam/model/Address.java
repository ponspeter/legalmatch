package com.legalmatch.exam.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADDRESS", schema = "APP_EXAM")
@EntityListeners(AuditingEntityListener.class)
public class Address {

    @Id
    @GeneratedValue(generator = "ADDRESS_GEN", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_ADDRESS", nullable = false, unique = true, updatable = false)
    private long id;

    @Column(name = "HOUSE_NUMBER")
    private Long houseNumber;

    @Size(max = 50)
    @Column(name = "STREET", length = 50)
    private String street;

    @Size(max = 50)
    @Column(name = "TOWN", length = 50)
    private String town;

    @Size(max = 50)
    @Column(name = "PROVINCE", length = 50)
    private String province;

    @Column(name = "POSTAL_CODE")
    private Long postalCode;

    @NotNull
    @Column(name = "IS_PRIMARY")
    private boolean isPrimary;

    @Column(name = "ID_PERSONAL_INFORMATION", updatable = false,insertable = false)
    private long personalInformationId;
}
