package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.V_view_annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface V_view_annonceRepository  extends JpaRepository<V_view_annonce,Long>{
    
    @Query(value = "select * from v_view_annonce where idv_view_annonce=:idv_view_annonce", nativeQuery = true)
    public java.util.Optional<V_view_annonce> findOne(@Param("idv_view_annonce") Long idv_view_annonce);

    @Query(value = "select * from v_view_annonce where idclient=:idclient LIMIT 15 OFFSET :borneb", nativeQuery = true)
    public java.util.List<V_view_annonce>  pagination(@Param("borneb") int borneb,@Param("idclient") Long idclient);

    @Query(value = "select * from v_view_annonce where idclient=:idclient", nativeQuery = true)
    public java.util.List<V_view_annonce>  allValue(@Param("idclient") Long idclient);
}

