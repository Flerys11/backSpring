package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Boitdevitesse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface BoitdevitesseRepository  extends JpaRepository<Boitdevitesse,Long>{
    
    @Query(value = "select * from boitdevitesse where idboitdevitesse=:idboitdevitesse", nativeQuery = true)
    public java.util.Optional<Boitdevitesse> findOne(@Param("idboitdevitesse") Long idboitdevitesse);
}
