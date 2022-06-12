package com.campgemini.thesismanagement.controller;

import com.campgemini.thesismanagement.config.JwtTokenUtil;
import com.campgemini.thesismanagement.domain.JwtRequest;
import com.campgemini.thesismanagement.domain.JwtResponse;
import com.campgemini.thesismanagement.domain.dto.UserAccountDto;
import com.campgemini.thesismanagement.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserAccountController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest){
           final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
          SecurityContextHolder.getContext().setAuthentication(authentication);
          final String token = jwtTokenUtil.generateToken(authentication);
          return ResponseEntity.ok(new JwtResponse(token));
        }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserAccountDto userAccountDto){
        System.out.println("Hello");
        System.out.println(userAccountDto.getUsername());
          return ResponseEntity.ok(userAccountService.save(userAccountDto));
    }

//    private void authenticate(String username, String password) throws Exception {
//    try {
//    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//    } catch (DisabledException e) {
//    throw new Exception("USER_DISABLED", e);
//     } catch (BadCredentialsException e) {
//      throw new Exception("INVALID_CREDENTIALS", e);
//         }
//      }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any User Can Read This";
    }

}




