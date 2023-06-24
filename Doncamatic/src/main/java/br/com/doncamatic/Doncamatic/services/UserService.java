package br.com.doncamatic.Doncamatic.services;

import br.com.doncamatic.Doncamatic.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.doncamatic.Doncamatic.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
}
