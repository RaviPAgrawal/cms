package com.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.User;

/**
 * Created by raviagrawal on 17/03/17.
 */
public interface UserRepository extends JpaRepository<User, Long>, UserDao {
    User findByEmail(String email);
}
