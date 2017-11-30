package com.cms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.beans.CompanyDTO;
import com.cms.beans.DepartmentDTO;
import com.cms.model.Company;
import com.cms.service.CompanyService;

/**
 * Created by raviagrawal on 15/03/17.
 */

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
    @ResponseBody
    public CompanyDTO getCompany(@PathVariable Long companyId) {
        return companyService.findById(companyId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.save(companyDTO);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.update(companyDTO);
    }

    @RequestMapping(value = "/{companyId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteCompany(@PathVariable Long companyId) {
        return companyService.delete(companyId);
    }

    @RequestMapping(value = "/{companyId}/departments", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> addDepartment(@PathVariable Long companyId, @RequestBody DepartmentDTO departmentDTO) {
        return companyService.addDepartment(companyId, departmentDTO);
    }

    @RequestMapping(value = "/{companyId}/departments", method = RequestMethod.GET)
    @ResponseBody
    public CompanyDTO getCompanyWithDepartments(@PathVariable Long companyId) {
        return companyService.findByIdWithDepartments(companyId);
    }
}
