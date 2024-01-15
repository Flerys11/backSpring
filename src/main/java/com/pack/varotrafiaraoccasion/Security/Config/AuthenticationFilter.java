package com.pack.varotrafiaraoccasion.Security.Config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import  com.pack.varotrafiaraoccasion.Security.Token.TokenRepository;
import  com.pack.varotrafiaraoccasion.Security.Token.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;



@Component
@RequiredArgsConstructor
public class AuthenticationFilter  extends OncePerRequestFilter {
    private final TokenService tokenService;
    private final org.springframework.security.core.userdetails.UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
        // Votre logique de filtre ici
        System.out.println("matricule "+request.getParameter("matricule"));
        final String authHeader = request.getHeader("Authorization");
        final String token;
        final String pseudo;
        if (request.getServletPath().contains("/flotte/authentification")) {
            filterChain.doFilter(request, response);
            return;
        }
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);//cette fonction indique que cette filter est terminer en passe au filter suivant 
            return;
        }
        token=authHeader.substring(7);//fait l'hypothèse que la chaîne authHeader a une longueur d'au moins 7 caractères (pour couvrir le mot "Bearer " et l'espace suivant). Cette ligne extrait le jeton réel en prenant une sous-chaîne à partir du septième caractère de authHeader jusqu'à la fin de la chaîne.
        pseudo = tokenService.extractUsername(token);
        if(pseudo != null && SecurityContextHolder.getContext().getAuthentication()==null){
         UserDetails userDetails = this.userDetailsService.loadUserByUsername(pseudo);
         var isTokenValid = tokenRepository.findByToken(token)
          .map(t -> !t.isExpired() && !t.isRevoked())
          .orElse(false);
        // System.out.println(userDetails.getAuthorities());
         if(tokenService.isTokenValid(token,userDetails) && isTokenValid ){
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
            );
            authToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
            );
            SecurityContextHolder.getContext().setAuthentication(authToken);
         }
         
        }
        filterChain.doFilter(request, response);//cette fonction indique que cette filter est terminer en passe au filter suivant 
    }
}
