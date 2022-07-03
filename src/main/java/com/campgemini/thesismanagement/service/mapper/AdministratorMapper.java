package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.Administrator;
import com.campgemini.thesismanagement.domain.dto.AdministratorDto;

public class AdministratorMapper {

    public static AdministratorDto administratorToAdministratorDto(Administrator administrator){
        AdministratorDto administratorDto = new AdministratorDto();
        administratorDto.setIdAdministrator(administrator.getIdAdministrator());
        administratorDto.setFirstName(administrator.getFirstName());
        administratorDto.setLastName(administrator.getLastName());
        administratorDto.setCNP(administrator.getCNP());
        return administratorDto;
    }

    public static Administrator administratorDtoToAdministrator(AdministratorDto administratorDto){
        Administrator administrator = new Administrator();
        administrator.setIdAdministrator(administratorDto.getIdAdministrator());
        administrator.setFirstName(administratorDto.getFirstName());
        administrator.setLastName(administratorDto.getLastName());
        administrator.setCNP(administrator.getCNP());
        return administrator;
    }

}
