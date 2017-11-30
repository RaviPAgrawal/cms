package com.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.Roles;
import com.cms.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(Roles role);
}
