package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Detaillecaequipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface DetaillecaequipementRepository  extends JpaRepository<Detaillecaequipement,Long>{
    
    @Query(value = "select * from detaillecaequipement where iddetaillecaequipement=:iddetaillecaequipement", nativeQuery = true)
    public java.util.Optional<Detaillecaequipement> findOne(@Param("iddetaillecaequipement") Long iddetaillecaequipement);
}
