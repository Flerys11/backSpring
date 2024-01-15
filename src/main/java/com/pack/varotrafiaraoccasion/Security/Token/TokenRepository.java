package  com.pack.varotrafiaraoccasion.Security.Token;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TokenRepository extends JpaRepository<Token, Integer> {
    @Query(value = "select * from Token t inner join Utilisateur u on t.id = u.id\swhere u.id = :id and (t.expired = false or t.revoked = false) ", nativeQuery = true)
  List<Token> findAllValidTokenByUser(Integer id);

  Optional<Token> findByToken(String token);
}
