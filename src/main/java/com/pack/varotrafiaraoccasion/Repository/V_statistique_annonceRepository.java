package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.V_statistique_annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface V_statistique_annonceRepository  extends JpaRepository<V_statistique_annonce,Long>{
    
    @Query(value = "select * from v_statistique_annonce where idv_statistique_annonce=:idv_statistique_annonce", nativeQuery = true)
    public java.util.Optional<V_statistique_annonce> findOne(@Param("idv_statistique_annonce") Long idv_statistique_annonce);
}
