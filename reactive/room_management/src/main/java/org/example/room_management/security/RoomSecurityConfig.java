package org.example.room_management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class RoomSecurityConfig {

    private final static String API_ROOT = "api/rooms";

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1234")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("4321")
                .roles("ADMIN")
                .build();

        return new MapReactiveUserDetailsService(user,admin);
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
       return http
               .authorizeExchange()
               .pathMatchers(HttpMethod.POST,API_ROOT).hasRole("ADMIN")
               .pathMatchers(HttpMethod.DELETE,API_ROOT + "/**").hasRole("ADMIN")
               .anyExchange().authenticated()
               .and()
               .httpBasic()
               .and()
               .csrf()
               .disable()
               .build();
    }
}
