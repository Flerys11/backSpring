package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface ModelRepository  extends JpaRepository<Model,Long>{
    
    @Query(value = "select * from model where idmodel=:idmodel", nativeQuery = true)
    public java.util.Optional<Model> findOne(@Param("idmodel") Long idmodel);
}
