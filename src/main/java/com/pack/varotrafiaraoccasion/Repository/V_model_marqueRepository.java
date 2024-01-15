package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.V_model_marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface V_model_marqueRepository  extends JpaRepository<V_model_marque,Long>{
    
    @Query(value = "select * from v_model_marque where idv_model_marque=:idv_model_marque", nativeQuery = true)
    public java.util.Optional<V_model_marque> findOne(@Param("idv_model_marque") Long idv_model_marque);
}
