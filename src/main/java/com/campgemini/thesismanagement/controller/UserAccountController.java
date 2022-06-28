package com.campgemini.thesismanagement.controller;

import com.campgemini.thesismanagement.config.JwtUtils;
import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.dto.request.AuthRequest;
import com.campgemini.thesismanagement.domain.dto.response.JwtResponse;
import com.campgemini.thesismanagement.domain.dto.request.UserAccountDto;
import com.campgemini.thesismanagement.domain.dto.response.MessageResponse;
import com.campgemini.thesismanagement.repository.UserAccountRepository;
import com.campgemini.thesismanagement.service.UserDetailsImplementation;
import com.campgemini.thesismanagement.service.UserDetailsServiceImplementation;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/users")
public class UserAccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Autowired
    private UserAccountRepository userAccountRepository;



    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authenticationRequest){
           final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
          SecurityContextHolder.getContext().setAuthentication(authentication);
          final String token = jwtUtils.generateToken(authentication);

          UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();
        //  List<String> roles = UserDetailsImplementation.authoritiesToRolesList(userDetails);
          //userDetails.setFirstLoginFlag(0);
          UserAccountDto userAccountDto = new UserAccountDto();
          userAccountDto.setIdUserAccount(userDetails.getIdUserAccount());
          userAccountDto.setUsername(userDetails.getUsername());
          userAccountDto.setPassword(userDetails.getPassword());
          userAccountDto.setEmail(userDetails.getEmail());
          userAccountDto.setRoles(UserDetailsImplementation.authoritiesToRolesList(userDetails));
          userAccountDto.setToken(token);
          userAccountDto.setFirstLoginFlag(userDetails.getFirstLoginFlag());
          userAccountDto.setCreatedAt(userDetails.getCreatedAt());
          userAccountRepository.getByIdUserAccount(userDetails.getIdUserAccount()).setFirstLoginFlag(0);
          return ResponseEntity.ok(userAccountDto);
        }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserAccountDto userAccountDto){
      if(userDetailsServiceImplementation.checkIfUsernameExist(userAccountDto.getUsername())){
          return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
      }
        System.out.println(userAccountDto.getEmail());
      if(userDetailsServiceImplementation.checkIfEmailExist(userAccountDto.getEmail())){
          return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
      }
      return new ResponseEntity<>(userDetailsServiceImplementation.addUserAccount(userAccountDto),
                            HttpStatus.CREATED)
              ;


    }

}




