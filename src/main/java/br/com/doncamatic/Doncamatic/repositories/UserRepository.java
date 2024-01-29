package br.com.doncamatic.Doncamatic.repositories;

import br.com.doncamatic.Doncamatic.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    @Query("SELECT u FROM User u JOIN FETCH u.roles where u.username = :username")
    User findByUsernameFetchRoles(@Param("username") String username);
}
