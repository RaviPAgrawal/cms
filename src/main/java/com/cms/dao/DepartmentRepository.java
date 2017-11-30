package com.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Department;

/**
 * Created by raviagrawal on 17/03/17.
 */
public interface DepartmentRepository extends JpaRepository<Department, Long>, DepartmentDao {
}
