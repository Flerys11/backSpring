package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface EquipementRepository  extends JpaRepository<Equipement,Long>{
    
    @Query(value = "select * from equipement where idequipement=:idequipement", nativeQuery = true)
    public java.util.Optional<Equipement> findOne(@Param("idequipement") Long idequipement);
}
