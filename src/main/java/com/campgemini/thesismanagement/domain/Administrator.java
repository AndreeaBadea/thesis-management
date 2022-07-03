package com.campgemini.thesismanagement.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="administrators")
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrator")
    private Integer idAdministrator;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_account")
    private UserAccount idUserAccount;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cnp")
    private String CNP;
}
