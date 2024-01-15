package com.pack.varotrafiaraoccasion.Security.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.util.function.Function;


import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
//cette une interface qui  possede les functions pour obtenir les informations sur l'utilisateur
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.beans.factory.annotation.Value;

//iti class ity dia responsable na Token fa tsy responsable httreauest
@Service
public class TokenService {

    @Value("${jwt.secret}") // Vous pouvez externaliser cette valeur dans votre application.properties ou application.yml
    private String secretKey;

    private static final String SECRET_KEY="DB5F64269E6533A5E46B38C47ED48";
   
    public String extractUsername(String token){
        return extractClaims(token,Claims::getSubject);
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username= extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new java.util.Date());
    }

    public java.util.Date  extractExpiration(String token ){
        return extractClaims(token, Claims::getExpiration);
    }

    // function pour cree un Token
    public String generateToken(Map<String,Object> extraClaims,org.springframework.security.core.userdetails.UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)// Cette méthode est utilisée pour ajouter des revendications personnalisées au jeton JWT
                .setSubject(userDetails.getUsername())
                .setIssuedAt( new java.util.Date(System.currentTimeMillis()))
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 1000 *60 *24))
                // .signWith(getSignInKey(),SignatureAlgorithm.HS256)
                .signWith(Keys.hmacShaKeyFor(secretKey.getBytes()), SignatureAlgorithm.HS512)
                .compact();//Cette méthode est utilisée pour finaliser la construction d'un jeton JWT et le transformer en une chaîne compacte.
    }

    //fonction qui va extracter les donnes d'une token
    private Claims extractAllClaims(String token){
        //Jwts Cette classe offre des méthodes statiques pour créer et manipuler des objets liés aux JSON Web Tokens (JWT). Elle fait partie de la famille de classes de JWT du framework Spring Security et est principalement utilisée pour la création, la validation et la manipulation de jetons JWT.
        return Jwts
                .parserBuilder()//Elle est utilisée pour créer un parseur qui peut être utilisé pour extraire les informations d'un jeton JWT
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))// Cette méthode est utilisée pour spécifier la clé secrète utilisée pour signer et vérifier la signature du jeton JWT
                .build()
                .parseClaimsJws(token)//Cette méthode est utilisée pour parser un jeton JWT et retourner un objet Jws (JSON Web Signature) qui contient les revendications (claims).
                .getBody();
    }
    // //fonction qui vas cree la clee responsable de la verification du token et de ca signature
    // private Key getSignInKey(){
    //     // Decoders.BASE64.decode(SECRET_KEY);
    //     byte[] keyBytes = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256).getEncoded();
        
    //     return Keys.hmacShaKeyFor(keyBytes);//créer une clé HMAC-SHA (Hash-based Message Authentication Code - Secure Hash Algorithm) à partir du tableau de bytes obtenu après le décodage.La clé générée est utilisée pour la signature et la vérification des jetons JWT. si la variable SECRET_KEY reste constante, alors à chaque appel de la fonction getSignInKey(), la même clé HMAC-SHA sera générée.
    // }

    //cette function est responsable de donner les informations voulu dans le clams
    public <T> T extractClaims(String token,Function<Claims,T>  claimsResolver){
        final Claims clains = extractAllClaims(token);
        return claimsResolver.apply(clains);
    }

}
