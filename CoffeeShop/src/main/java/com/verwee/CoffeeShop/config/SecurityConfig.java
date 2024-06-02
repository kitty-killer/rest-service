package com.verwee.CoffeeShop.config;

import com.verwee.CoffeeShop.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/menus","/api/v1/goods").permitAll()
                        .requestMatchers("/api/v1/baristas/**","/api/v1/menus/**","/api/v1/goods/**","/api/v1/menus/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/orders/**","/api/v1/buyers/**").hasAnyRole("USER","ADMIN")
                        .anyRequest().authenticated())
                .httpBasic(withDefaults()) // Enable Basic Authentication
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(response.SC_UNAUTHORIZED);
                            response.getWriter().write("Authentication failed: " + authException.getMessage());
                        })
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setStatus(response.SC_FORBIDDEN);
                            response.getWriter().write("Access denied: " + accessDeniedException.getMessage());
                        }))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
                        .permitAll());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}