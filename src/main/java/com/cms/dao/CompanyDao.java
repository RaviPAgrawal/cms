package com.cms.dao;

import com.cms.model.Company;

/**
 * Created by raviagrawal on 23/03/17.
 */
public interface CompanyDao {

    Company findByName(String name);
}
