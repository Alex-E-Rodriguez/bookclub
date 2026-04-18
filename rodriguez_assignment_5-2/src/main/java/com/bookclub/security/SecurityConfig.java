/*
    Walls, C. (2022). Spring in Action (6th ed.).
    Manning Publications Co.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2026
*/

package com.bookclub.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


// Note to professor: WebSecurityConfigurerAdapter has been depreciated in Spring Boot.
// Thus, the below code has a different implementation with the same result.

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.
                withUsername("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();
        UserDetails testuser01 = User.
                withUsername("testuser01")
                .password(encoder.encode("password01"))
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, testuser01);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").permitAll())
                .logout(logout -> logout.logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll());
        return http.build();
    }


}
