package br.com.doncamatic.Doncamatic.repositories;

import br.com.doncamatic.Doncamatic.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
