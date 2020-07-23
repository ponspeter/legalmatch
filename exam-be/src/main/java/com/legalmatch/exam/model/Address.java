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
@Table(name = "ADDRESS", schema = "APP_EXAM")
@EntityListeners(AuditingEntityListener.class)
public class Address {

    @Id
    @GeneratedValue(generator = "ADDRESS_GEN", strategy = GenerationType.SEQUENCE)
    //@SequenceGenerator(name = "ADDRESS_GEN", allocationSize = 1, sequenceName = "ADDRESS_SEQ")
    @Column(name = "ID_ADDRESS", nullable = false, unique = true, updatable = false)
    private long id;

    @Column(name = "HOUSE_NUMBER", length = 10)
    private Long houseNumber;

    @Column(name = "STREET", length = 50)
    private String street;

    @Column(name = "TOWN", length = 50)
    private String town;

    @Column(name = "PROVINCE", length = 50)
    private String province;

    @Column(name = "POSTAL_CODE", length = 10)
    private Long postalCode;

    @Column(name = "IS_PRIMARY")
    private boolean isPrimary;

    @Column(name = "ID_PERSONAL_INFORMATION", updatable = false,insertable = false)
    private long personalInformationId;
}
