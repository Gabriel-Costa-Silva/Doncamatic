package br.com.doncamatic.Doncamatic.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("{noop}password") // "{noop}" indica que a senha não será codificada neste exemplo (não é recomendado em produção)
                    .roles("ADMIN")
                    .build();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado: " + username);
        }
    }
}
