package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.V_commision_vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface V_commision_venteRepository  extends JpaRepository<V_commision_vente,Long>{
    
    @Query(value = "select * from v_commision_vente where idv_commision_vente=:idv_commision_vente", nativeQuery = true)
    public java.util.Optional<V_commision_vente> findOne(@Param("idv_commision_vente") Long idv_commision_vente);
}
