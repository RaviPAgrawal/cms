package com.cms.dao;

import com.cms.model.Department;

/**
 * Created by raviagrawal on 23/03/17.
 */
public interface DepartmentDao {

    Department findByName(String name);
}
