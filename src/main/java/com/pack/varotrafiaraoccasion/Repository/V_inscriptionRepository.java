package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.V_inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface V_inscriptionRepository  extends JpaRepository<V_inscription,Long>{
    
    @Query(value = "select * from v_inscription where idv_inscription=:idv_inscription", nativeQuery = true)
    public java.util.Optional<V_inscription> findOne(@Param("idv_inscription") Long idv_inscription);
}
