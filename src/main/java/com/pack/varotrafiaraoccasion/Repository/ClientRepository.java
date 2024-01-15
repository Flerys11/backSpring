package com.pack.varotrafiaraoccasion.Repository;
import com.pack.varotrafiaraoccasion.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface ClientRepository  extends JpaRepository<Client,Long>{
    
    @Query(value = "select * from client where idclient=:idclient", nativeQuery = true)
    public java.util.Optional<Client> findOne(@Param("idclient") Long idclient);

    @Query(value = "select * from client where email=:email and motdepasse=:motdepasse", nativeQuery = true)
    public java.util.Optional<Client> findUser(@Param("email")String email,@Param("motdepasse") String password);
}
