package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface MarqueRepository  extends JpaRepository<Marque,Long>{
    
    @Query(value = "select * from marque where idmarque=:idmarque", nativeQuery = true)
    public java.util.Optional<Marque> findOne(@Param("idmarque") Long idmarque);
}
