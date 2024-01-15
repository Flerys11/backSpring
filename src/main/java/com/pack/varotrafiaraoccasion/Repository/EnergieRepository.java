package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Energie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface EnergieRepository  extends JpaRepository<Energie,Long>{
    
    @Query(value = "select * from energie where idenergie=:idenergie", nativeQuery = true)
    public java.util.Optional<Energie> findOne(@Param("idenergie") Long idenergie);
}
