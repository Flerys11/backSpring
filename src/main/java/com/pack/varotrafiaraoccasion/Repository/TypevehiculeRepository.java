package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Typevehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface TypevehiculeRepository  extends JpaRepository<Typevehicule,Long>{
    
    @Query(value = "select * from typevehicule where idtypevehicule=:idtypevehicule", nativeQuery = true)
    public java.util.Optional<Typevehicule> findOne(@Param("idtypevehicule") Long idtypevehicule);
}
