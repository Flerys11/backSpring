package com.pack.varotrafiaraoccasion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.varotrafiaraoccasion.Entity.Utilisateur;



public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{

    java.util.Optional<Utilisateur> findByPseudo(String pseudo);
    
}
