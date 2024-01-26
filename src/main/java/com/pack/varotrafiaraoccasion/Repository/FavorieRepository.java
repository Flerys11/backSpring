package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Favorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface FavorieRepository  extends JpaRepository<Favorie,Long>{
    
    @Query(value = "select * from favorie where idfavorie=:idfavorie", nativeQuery = true)
    public java.util.Optional<Favorie> findOne(@Param("idfavorie") Long idfavorie);

    @Query(value = "select * from favorie where idfcaracteristique=:idcaracteristique and idclient=:idclient ", nativeQuery = true)
    public java.util.Optional<Favorie> findfavorie(@Param("idclient") Long idclient,@Param("idcaracteristique") Long idcaracteristique);
}
