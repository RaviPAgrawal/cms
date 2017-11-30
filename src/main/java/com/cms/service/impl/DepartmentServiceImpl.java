package com.cms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.CompanyDTO;
import com.cms.beans.DepartmentDTO;
import com.cms.beans.TeamDTO;
import com.cms.dao.DepartmentRepository;
import com.cms.model.Company;
import com.cms.model.Department;
import com.cms.model.Team;
import com.cms.service.DepartmentService;
import com.cms.utils.CmsUtility;

/**
 * Created by raviagrawal on 23/03/17.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public DepartmentDTO findById(Long departmentId) {
        Department department = departmentRepository.findOne(departmentId);
        DepartmentDTO departmentDTO = DepartmentDTO.getDtoFromDepartment(department);
        return departmentDTO;
    }

    @Override
    public Map<String, Object> update(DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findOne(departmentDTO.getId());
        DepartmentDTO.updateDepartmentFromDto(department, departmentDTO);
        departmentRepository.save(department);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public Map<String, Object> delete(Long departmentId) {
        departmentRepository.delete(departmentId);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public DepartmentDTO findByIdWithCompany(Long departmentId) {
        Department department = departmentRepository.findOne(departmentId);
        DepartmentDTO departmentDTO = DepartmentDTO.getDtoFromDepartment(department);

        Company company = department.getCompany();
        CompanyDTO companyDTO = CompanyDTO.getDtoFromCompany(company);

        departmentDTO.setCompany(companyDTO);
        return departmentDTO;
    }

    @Override
    public Map<String, Object> addTeam(Long departmentId, TeamDTO teamDTO) {
        Department department = departmentRepository.findOne(departmentId);
        Team team = TeamDTO.getTeamFromDto(teamDTO);
        department.addTeam(team);
        departmentRepository.save(department);
        return CmsUtility.getSuccessResultMap();
    }
}
