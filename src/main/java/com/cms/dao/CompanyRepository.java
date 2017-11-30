package com.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.model.Company;

/**
 * Created by raviagrawal on 17/03/17.
 */
public interface CompanyRepository
        extends JpaRepository<Company, Long>, CompanyDao {
}
