package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.V_liste_annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface V_liste_annonceRepository  extends JpaRepository<V_liste_annonce,Long>{
    
    @Query(value = "select * from v_liste_annonce where idv_liste_annonce=:idv_liste_annonce", nativeQuery = true)
    public java.util.Optional<V_liste_annonce> findOne(@Param("idv_liste_annonce") Long idv_liste_annonce);


    @Query(value = "select * from v_liste_annonce", nativeQuery = true)
    public java.util.List<V_liste_annonce> findAllin();

    @Query(value = "select * from v_liste_annonce where idcaracteristique=:id", nativeQuery = true)
    public java.util.List<V_liste_annonce> findAllin(@Param("id") Long id);


    @Query(value = "select idequipement from v_liste_annonce order by idcaracteristique,idequipement", nativeQuery = true)
    public java.util.List<V_liste_annonce> test();



}
