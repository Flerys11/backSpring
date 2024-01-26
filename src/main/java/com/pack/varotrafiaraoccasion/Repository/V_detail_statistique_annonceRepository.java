package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.V_detail_statistique_annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface V_detail_statistique_annonceRepository  extends JpaRepository<V_detail_statistique_annonce,Long>{
    
    @Query(value = "select * from v_detail_statistique_annonce where idv_detail_statistique_annonce=:idv_detail_statistique_annonce", nativeQuery = true)
    public java.util.Optional<V_detail_statistique_annonce> findOne(@Param("idv_detail_statistique_annonce") Long idv_detail_statistique_annonce);
}
