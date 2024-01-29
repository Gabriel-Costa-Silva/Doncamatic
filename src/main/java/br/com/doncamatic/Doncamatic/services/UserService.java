package br.com.doncamatic.Doncamatic.services;

import br.com.doncamatic.Doncamatic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.doncamatic.Doncamatic.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

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

    public User create(User user) throws Exception{
        User userExists = userRepository.findByEmail(user.getEmail());
        if(userExists != null){
            //TODO :  CRIAR CLASSES DE EXCEÇÃO PERSONALIZADA
            throw new Exception("Usuário já existente!");
        }
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        return  userRepository.save(user);
    }
}
