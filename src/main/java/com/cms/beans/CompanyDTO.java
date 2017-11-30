package com.cms.beans;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import com.cms.model.Company;

/**
 * Created by raviagrawal on 06/04/17.
 */
@Getter @Setter
public class CompanyDTO {
    private Long id;
    private String name;
    private Set<DepartmentDTO> departments;

    public static Company getCompanyFromDTO(CompanyDTO companyDTO) {
        Company company = new Company();
        company.setName(companyDTO.getName());
        return company;
    }

    public static void updateCompanyFromDTO(Company company, CompanyDTO companyDTO) {
        company.setName(companyDTO.getName());
    }

    public static CompanyDTO getDtoFromCompany(Company company) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        return companyDTO;
    }
}
