package com.cms.service;

import java.util.Map;
import java.util.Objects;

import com.cms.beans.DepartmentDTO;
import com.cms.beans.TeamDTO;
import com.cms.model.Department;

/**
 * Created by raviagrawal on 15/03/17.
 */
public interface DepartmentService {

    Department findByName(String name);

    DepartmentDTO findById(Long departmentId);

    Map<String, Object> update(DepartmentDTO departmentDTO);

    Map<String, Object> delete(Long departmentId);

    DepartmentDTO findByIdWithCompany(Long departmentId);

    Map<String, Object> addTeam(Long departmentId, TeamDTO teamDTO);
}
