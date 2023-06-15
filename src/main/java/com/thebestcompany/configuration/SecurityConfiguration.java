package com.thebestcompany.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().disable()
                .authorizeHttpRequests().requestMatchers("/employee/**", "/employee/", "/login_success_handler").hasAnyRole("ADMIN", "USER")// - доступ тільки з певною роллю
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/login_success_handler")
                .and()
                .logout().permitAll();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsServiceSecConfig() {

        //User Role
        UserDetails theUser = User.withUsername("user")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("12345678").roles("USER").build();

        //Admin Role
        UserDetails theAdmin = User.withUsername("admin")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("87654321").roles("ADMIN").build();

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        userDetailsManager.createUser(theUser);
        userDetailsManager.createUser(theAdmin);

        return userDetailsManager;
    }
}
