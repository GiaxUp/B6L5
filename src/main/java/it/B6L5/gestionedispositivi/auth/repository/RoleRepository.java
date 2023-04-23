package it.B6L5.gestionedispositivi.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.B6L5.gestionedispositivi.auth.entity.ERole;
import it.B6L5.gestionedispositivi.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
