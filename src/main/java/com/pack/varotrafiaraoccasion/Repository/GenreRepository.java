package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface GenreRepository  extends JpaRepository<Genre,Long>{
    
    @Query(value = "select * from genre where idgenre=:idgenre", nativeQuery = true)
    public java.util.Optional<Genre> findOne(@Param("idgenre") Long idgenre);
}
