package com.pack.varotrafiaraoccasion.Security.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static com.pack.varotrafiaraoccasion.Compte.Role.ADMIN;
import static com.pack.varotrafiaraoccasion.Compte.Role.USER;
import static com.pack.varotrafiaraoccasion.Compte.Permission.ADMIN_CREATE;
import static com.pack.varotrafiaraoccasion.Compte.Permission.ADMIN_DELETE;
import static com.pack.varotrafiaraoccasion.Compte.Permission.ADMIN_READ;
import static com.pack.varotrafiaraoccasion.Compte.Permission.ADMIN_UPDATE;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    // tout ses url en une acces public il n'ont pas besoin d'authentification
    private static final String[] WHITE_LIST_URL = {
        "/varotrafiaraback/**",
        "/images/**",
    };

    private  final AuthenticationFilter jwtAuthFilter;
    private  final AuthenticationProvider authenticationProvider;
    private final LogoutService logoutService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http
    .csrf(AbstractHttpConfigurer::disable) 
    //configuration des requette authorizer
    .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
    .authenticationProvider(authenticationProvider)
    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
    .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL).permitAll()
                                .requestMatchers("/varotrafia/**")
                                // .requestMatchers(GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name())
                                // .requestMatchers(POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name())
                                // .requestMatchers(PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name())
                                // .requestMatchers(DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name())
                                // .anyRequest()
                                .authenticated()
                )
    .logout(logout ->
                        logout.logoutUrl("/flotte/authentification/logout")
                                .addLogoutHandler(logoutService)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                );
    //    // Dans le contexte de la sécurité Web, une session est généralement utilisée pour maintenir l'état entre les requêtes d'un utilisateur. Cependant, dans le cas des applications RESTful où l'état est généralement géré du côté du client et où les requêtes sont censées être indépendantes, il est parfois souhaitable d'avoir des sessions sans état.
    
   //mon filter personnaliser AuthenticationFilter sera executer avant la filtre UsernamePasswordAuthenticationFilter.class de spring boot
// cette class  UsernamePasswordAuthenticationFilter.class s'attend a avoir un parametre de nom de username et de password elle prendent en charge le casse 

      return  http.build();
    }
}
