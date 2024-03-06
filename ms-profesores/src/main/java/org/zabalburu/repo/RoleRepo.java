package org.zabalburu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zabalburu.modelo.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{
	Role findByRoleName(String roleName);
}
