package com.campgemini.thesismanagement.domain.dto;


import com.campgemini.thesismanagement.domain.UserAccount;
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


    public UserAccount getUserFromDto(){
        UserAccount user = new UserAccount();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }
}
