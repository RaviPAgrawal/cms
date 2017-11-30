package com.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Team;

/**
 * Created by raviagrawal on 17/03/17.
 */
public interface TeamRepository extends JpaRepository<Team, Long>, TeamDao {
}
