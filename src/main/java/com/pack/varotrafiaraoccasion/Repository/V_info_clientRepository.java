package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.V_info_client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface V_info_clientRepository  extends JpaRepository<V_info_client,Long>{
    
    @Query(value = "select * from v_info_client where idv_info_client=:idv_info_client", nativeQuery = true)
    public java.util.Optional<V_info_client> findOne(@Param("idv_info_client") Long idv_info_client);

    @Query(value = "select * from v_info_client where idclient=:idclient", nativeQuery = true)
    public java.util.Optional<V_info_client> findByIdclient(@Param("idclient") Long idv_info_client);
}
