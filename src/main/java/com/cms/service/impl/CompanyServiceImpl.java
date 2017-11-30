package com.cms.service.impl;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.CompanyDTO;
import com.cms.beans.DepartmentDTO;
import com.cms.dao.CompanyRepository;
import com.cms.model.Company;
import com.cms.model.Department;
import com.cms.service.CompanyService;
import com.cms.utils.CmsUtility;

/**
 * Created by raviagrawal on 23/03/17.
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public CompanyDTO findById(Long companyId) {
        Company company = companyRepository.findOne(companyId);
        CompanyDTO companyDTO = CompanyDTO.getDtoFromCompany(company);
        return companyDTO;
    }

    @Override
    public Map<String, Object> save(CompanyDTO companyDTO) {
        Company company = CompanyDTO.getCompanyFromDTO(companyDTO);
        companyRepository.save(company);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public Map<String, Object> update(CompanyDTO companyDTO) {
        Company company = companyRepository.findOne(companyDTO.getId());
        CompanyDTO.updateCompanyFromDTO(company, companyDTO);
        companyRepository.save(company);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public Map<String, Object> delete(Long companyId) {
        companyRepository.delete(companyId);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public Map<String, Object> addDepartment(Long companyId, DepartmentDTO departmentDTO) {
        Company company = companyRepository.findOne(companyId);
        Department department = DepartmentDTO.getDepartmentFromDTO(departmentDTO);
        company.addDepartment(department);
        companyRepository.save(company);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public CompanyDTO findByIdWithDepartments(Long companyId) {
        Company company = companyRepository.findOne(companyId);
        CompanyDTO companyDTO = CompanyDTO.getDtoFromCompany(company);
        Set<Department> departments = company.getDepartments();
        Set<DepartmentDTO> departmentDTOs = departments.stream()
                .map(department -> DepartmentDTO.getDtoFromDepartment(department))
                .collect(Collectors.toSet());
        companyDTO.setDepartments(departmentDTOs);
        return companyDTO;
    }
}
