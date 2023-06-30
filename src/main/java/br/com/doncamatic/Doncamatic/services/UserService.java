package br.com.doncamatic.Doncamatic.services;

import br.com.doncamatic.Doncamatic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.doncamatic.Doncamatic.models.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return user;

    }
    public User findUserByEmail(String email) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return user;

    }

    public void saveUser(User user){
        userRepository.save( user );
    }
    public List<User> findAllUsers(){
        List<User> userList = userRepository.findAll();
        if( userList.isEmpty() )
            return null;
        return userList;


    }

}
