package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Clientdateinscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface ClientdateinscriptionRepository  extends JpaRepository<Clientdateinscription,Long>{
    
    @Query(value = "select * from clientdateinscription where idclientdateinscription=:idclientdateinscription", nativeQuery = true)
    public java.util.Optional<Clientdateinscription> findOne(@Param("idclientdateinscription") Long idclientdateinscription);
}
