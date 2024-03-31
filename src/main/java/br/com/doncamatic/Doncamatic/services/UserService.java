package br.com.doncamatic.Doncamatic.services;

import br.com.doncamatic.Doncamatic.controllers.requests.CreateUserRequest;
import br.com.doncamatic.Doncamatic.models.enums.Roles;
import br.com.doncamatic.Doncamatic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.doncamatic.Doncamatic.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserRepository userRepository;
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return user;

    }

    public User create(CreateUserRequest createUserRequest) throws Exception{
        User userExists = (User) userRepository.findByEmail(createUserRequest.email());
        if(userExists != null){
            //TODO :  CRIAR CLASSES DE EXCEÇÃO PERSONALIZADA
            throw new Exception("Usuário já existente!");
        }

        User user = new User(createUserRequest.nome(), createUserRequest.email() ); //remover parametro de senha
        user.setRole(Roles.USER);
        String encryptedPassword = new BCryptPasswordEncoder().encode(createUserRequest.senha());
        user.setPassword(encryptedPassword);
        return  userRepository.save(user);
    }
}
