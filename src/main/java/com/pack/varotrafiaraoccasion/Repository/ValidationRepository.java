package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface ValidationRepository  extends JpaRepository<Validation,Long>{
    
    @Query(value = "select * from validation where idvalidation=:idvalidation", nativeQuery = true)
    public java.util.Optional<Validation> findOne(@Param("idvalidation") Long idvalidation);
}
