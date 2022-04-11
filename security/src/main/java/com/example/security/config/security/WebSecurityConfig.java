package com.example.security.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsService() {
        var admin = new User("admin",
                passwordEncoder().encode("admin"),
                Arrays.asList(new SimpleGrantedAuthority("ADMIN")));

        var support = new User("support",
                passwordEncoder().encode("support"),
                Arrays.asList(new SimpleGrantedAuthority("SUPPORT")));

        return new InMemoryUserDetailsManager(admin, support);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**")
                    .hasAuthority("ADMIN")
                .antMatchers("/support/**")
                    .hasAuthority("SUPPORT")
                .anyRequest().permitAll()
                .and().httpBasic();
    }
}
