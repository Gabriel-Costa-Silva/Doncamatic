package br.com.doncamatic.Doncamatic.security;

import br.com.doncamatic.Doncamatic.models.User;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

//@Service
public class TokenService {

    public String generateToken(User user){
        String token = null;
        try{

        }catch(JWTCreationException e ) {
            throw new RuntimeException("Erro de autenticação");
        }
        return token;
    }

}
