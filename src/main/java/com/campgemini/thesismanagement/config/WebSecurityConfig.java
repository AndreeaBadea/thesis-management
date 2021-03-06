package com.campgemini.thesismanagement.config;

import com.campgemini.thesismanagement.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    private UserDetailsServiceImplementation jwtUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/users/authenticate",
                        "/users/register",
                        "/students",
                        "/teachers",
                        "/projects",
                        "/students/{idUserAccount}",
                        "/teachers/{idUserAccount}",
                        "/teachers/{idTeacher}/projects",
                        "/teachers/{idTeacher}/project",
                        "/teachers/{id}/projects/{idProject}",
                        "/teachers/projects/{idProject}",
                        "/teachers//{idTeacher}/skills",
                        "/teachers/{idTeacher}/skills/{idTeacherSkill}",
                        "/admin/register",
                        "/admin/{idUserAccount}/teachers",
                        "/admin/users",
                        "/projects/allocated",
                        "/admin/{idUserAccount}/role/admin",
                        "/admin/{idUserAccount}/role/teacher",
                        "/students/{id}",
                        "/students/{idStudent}/skills",
                        "/students/{idStudent}/skills/{idStudentSkill}",
                        "/students//{idStudent}/projects/request"
                )
                .permitAll()
                .anyRequest().authenticated().and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
