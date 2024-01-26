package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Administrateur;
import com.pack.varotrafiaraoccasion.Entity.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface AdministrateurRepository  extends JpaRepository<Administrateur,Long>{
    
    @Query(value = "select * from administrateur where idadministrateur=:idadministrateur", nativeQuery = true)
    public java.util.Optional<Administrateur> findOne(@Param("idadministrateur") Long idadministrateur);

    @Query(value = "select * from administrateur where email=:email and motdepasse=:motdepasse", nativeQuery = true)
    public java.util.Optional<Administrateur> findUser(@Param("email")String email,@Param("motdepasse") String password);
}

