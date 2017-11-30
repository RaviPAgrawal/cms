package com.cms.service;

import java.util.Map;

import com.cms.beans.CompanyDTO;
import com.cms.beans.DepartmentDTO;
import com.cms.model.Company;

/**
 * Created by raviagrawal on 15/03/17.
 */
public interface CompanyService {

    Company findByName(String name);

    CompanyDTO findById(Long companyId);

    Map<String, Object> save(CompanyDTO companyDTO);

    Map<String, Object> update(CompanyDTO companyDTO);

    Map<String, Object> delete(Long companyId);

    Map<String, Object> addDepartment(Long companyId, DepartmentDTO departmentDTO);

    CompanyDTO findByIdWithDepartments(Long companyId);
}
