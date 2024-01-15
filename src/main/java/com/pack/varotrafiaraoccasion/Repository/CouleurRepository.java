package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Couleur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface CouleurRepository  extends JpaRepository<Couleur,Long>{
    
    @Query(value = "select * from couleur where idcouleur=:idcouleur", nativeQuery = true)
    public java.util.Optional<Couleur> findOne(@Param("idcouleur") Long idcouleur);
}
