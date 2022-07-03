package com.campgemini.thesismanagement.domain.dto;

import com.campgemini.thesismanagement.domain.UserAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministratorDto {

    private Integer idAdministrator;

    @JsonIgnore
    private UserAccount userAccount;

    private Integer idUserAccount;

    private String firstName;

    private String lastName;

    private String CNP;
}
