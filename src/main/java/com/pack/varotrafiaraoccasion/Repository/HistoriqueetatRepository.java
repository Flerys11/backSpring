package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Historiqueetat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface HistoriqueetatRepository  extends JpaRepository<Historiqueetat,Long>{
    
    @Query(value = "select * from historiqueetat where idhistoriqueetat=:idhistoriqueetat", nativeQuery = true)
    public java.util.Optional<Historiqueetat> findOne(@Param("idhistoriqueetat") Long idhistoriqueetat);
}
