package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface EtatRepository  extends JpaRepository<Etat,Long>{
    
    @Query(value = "select * from etat where idetat=:idetat", nativeQuery = true)
    public java.util.Optional<Etat> findOne(@Param("idetat") Long idetat);
}
