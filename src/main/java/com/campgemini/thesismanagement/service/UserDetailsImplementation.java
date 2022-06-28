package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.UserAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserDetailsImplementation implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Integer idUserAccount;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private LocalDateTime createdAt;

    private int firstLoginFlag;

    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImplementation(Integer idUserAccount, String username, String email, String password, Collection<? extends GrantedAuthority> authorities,
                                     LocalDateTime createdAt, int firstLoginFlag) {
        this.idUserAccount = idUserAccount;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.createdAt = createdAt;
        this.firstLoginFlag = firstLoginFlag;
    }


    public static UserDetailsImplementation buildUserDetails(UserAccount userAccount){
        List<GrantedAuthority> authorities = userAccount.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());

        return new UserDetailsImplementation(
                userAccount.getIdUserAccount(),
                userAccount.getUsername(),
                userAccount.getEmail(),
                userAccount.getPassword(),
                authorities,
                userAccount.getCreatedAt(),
                userAccount.getFirstLoginFlag());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImplementation userAccount = (UserDetailsImplementation) o;
        return Objects.equals(idUserAccount, userAccount.idUserAccount);
    }

    public static Set<String> authoritiesToRolesList(UserDetailsImplementation userDetails){
        return userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
    }
}
