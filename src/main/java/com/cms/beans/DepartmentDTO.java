package com.cms.beans;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import com.cms.model.Department;

/**
 * Created by raviagrawal on 06/04/17.
 */
@Getter @Setter
public class DepartmentDTO {
    private Long id;
    private String name;
    private Set<TeamDTO> teams;
    private CompanyDTO company;

    public static Department getDepartmentFromDTO(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        return department;
    }

    public static DepartmentDTO getDtoFromDepartment(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        return departmentDTO;
    }

    public static void updateDepartmentFromDto(Department department, DepartmentDTO departmentDTO) {
        department.setName(departmentDTO.getName());
    }
}
