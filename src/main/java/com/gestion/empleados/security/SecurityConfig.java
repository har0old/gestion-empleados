package com.gestion.empleados.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;

    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASWORD;

    @Value("${service.security.secure-key-username-2}")
    private String SECURE_KEY_USERNAME_2;

    @Value("${service.security.secure-key-password-2}")
    private String SECURE_KEY_PASWORD_2;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
            AuthenticationManagerBuilder.class
        );

        authenticationManagerBuilder.inMemoryAuthentication()
            .withUser(SECURE_KEY_USERNAME)
            .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASWORD))
            .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
            .and()
            .withUser(SECURE_KEY_USERNAME_2)
            .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASWORD_2))
            .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DEV"))
            .and()
            .passwordEncoder(new BCryptPasswordEncoder());

        return http.securityMatcher("/**")
            .authorizeHttpRequests()
            .anyRequest()
            .hasRole("ADMIN")
            .and()
            .csrf()
            .disable()
            .httpBasic()
            .and()
            .build();   
    }
    
}
