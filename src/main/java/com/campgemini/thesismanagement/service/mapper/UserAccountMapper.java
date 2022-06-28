package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.dto.request.UserAccountDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAccountMapper {

    public static UserAccountDto userAccountToUserAccountDto(UserAccount userAccount){
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setIdUserAccount(userAccount.getIdUserAccount());
        userAccountDto.setUsername(userAccount.getUsername());
        userAccountDto.setPassword(userAccount.getPassword());
        userAccountDto.setEmail(userAccount.getEmail());
        userAccountDto.setRoles(UserAccount.getRoles(userAccount));
        userAccountDto.setFirstLoginFlag(userAccount.getFirstLoginFlag());
       // userAccountDto.setFirstLoginFlag(1);
        return userAccountDto;
    }

    public static UserAccount userAccountDtoToUserAccount(UserAccountDto userAccountDto){
        UserAccount userAccount = new UserAccount();
        userAccount.setIdUserAccount(userAccountDto.getIdUserAccount());
        userAccount.setUsername(userAccount.getUsername());
        userAccount.setPassword(userAccount.getPassword());
        userAccount.setEmail(userAccount.getEmail());
        userAccount.setRoles(userAccount.getRoles());
        userAccount.setFirstLoginFlag(userAccountDto.getFirstLoginFlag());
        userAccount.setFirstLoginFlag(1);
        return userAccount;
    }



}
