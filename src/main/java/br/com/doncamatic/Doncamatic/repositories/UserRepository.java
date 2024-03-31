package br.com.doncamatic.Doncamatic.repositories;

import br.com.doncamatic.Doncamatic.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByEmail(String email);
    User findByUsername(String username);

    //User findByEmail(String email);


}
