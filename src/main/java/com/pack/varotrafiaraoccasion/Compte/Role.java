package com.pack.varotrafiaraoccasion.Compte;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


import static com.pack.varotrafiaraoccasion.Compte.Permission.ADMIN_CREATE;
import static com.pack.varotrafiaraoccasion.Compte.Permission.ADMIN_DELETE;
import static com.pack.varotrafiaraoccasion.Compte.Permission.ADMIN_READ;
import static com.pack.varotrafiaraoccasion.Compte.Permission.ADMIN_UPDATE;



@RequiredArgsConstructor
public enum Role {
    
    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
            ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            ADMIN_CREATE
            )
        )
    ;

    @Getter
    private final Set<Permission> permissions;
    // SimpleGrantedAuthority class qui représente une autorité (par exemple, un rôle ou une permission) accordée à un utilisateur dans un système de sécurité.
    public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
            .stream()//transformation des element de le liste en fkux 
            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
            .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}
