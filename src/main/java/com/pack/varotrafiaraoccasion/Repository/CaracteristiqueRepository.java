package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Caracteristique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface CaracteristiqueRepository  extends JpaRepository<Caracteristique,Long>{
    
    @Query(value = "select * from caracteristique where idcaracteristique=:idcaracteristique", nativeQuery = true)
    public java.util.Optional<Caracteristique> findOne(@Param("idcaracteristique") Long idcaracteristique);
}
