package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface CommissionRepository  extends JpaRepository<Commission,Long>{
    
    @Query(value = "select * from commission where idcommission=:idcommission", nativeQuery = true)
    public java.util.Optional<Commission> findOne(@Param("idcommission") Long idcommission);
}
