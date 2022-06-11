package com.campgemini.thesismanagement.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDto {

    private Long idUserAccount;

    private String username;

    private String password;

    private String email;
}
