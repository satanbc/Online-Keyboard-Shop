package com.ecommerce.year2_sem2_project.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails matvii = User.builder()
                .username("matvii")
                .password("{noop}1234")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(matvii);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                    configurer
                            .requestMatchers("/admin/**").authenticated()
                            .anyRequest().permitAll()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                );

        return http.build();
    }
}
