package com.campgemini.thesismanagement.domain.dto.request;


import com.campgemini.thesismanagement.domain.Role;
import com.campgemini.thesismanagement.domain.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto {

    private Integer idUserAccount;

    private String username;

    private String password;

    private String email;

    private String token;

    private Set<String> roles;

    private LocalDateTime createdAt;

    private int firstLoginFlag;

}
