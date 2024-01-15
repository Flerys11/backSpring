package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Photocaracteristique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface PhotocaracteristiqueRepository  extends JpaRepository<Photocaracteristique,Long>{
    
    @Query(value = "select * from photocaracteristique where idphotocaracteristique=:idphotocaracteristique", nativeQuery = true)
    public java.util.Optional<Photocaracteristique> findOne(@Param("idphotocaracteristique") Long idphotocaracteristique);
}
