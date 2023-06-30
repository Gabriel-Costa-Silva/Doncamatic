package br.com.doncamatic.Doncamatic.repositories;

import br.com.doncamatic.Doncamatic.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findUserByEmail(String email);
}
