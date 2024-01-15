package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface LocalisationRepository  extends JpaRepository<Localisation,Long>{
    
    @Query(value = "select * from localisation where idlocalisation=:idlocalisation", nativeQuery = true)
    public java.util.Optional<Localisation> findOne(@Param("idlocalisation") Long idlocalisation);
}
