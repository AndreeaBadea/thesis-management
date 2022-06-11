package com.campgemini.thesismanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users_accounts")
public class UserAccount {

    @Id
    @Column(name = "id_user_account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUserAccount;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "email")
    private String email;

//    @Column(name = "enabled")
//    private Boolean enabled;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "id_user_account"),
//            inverseJoinColumns = @JoinColumn(name = "id_role")
//    )
//    private Set<Role> roles = new HashSet<>();

}
