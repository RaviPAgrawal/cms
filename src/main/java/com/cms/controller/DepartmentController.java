package com.cms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.beans.DepartmentDTO;
import com.cms.beans.TeamDTO;
import com.cms.service.DepartmentService;

/**
 * Created by raviagrawal on 15/03/17.
 */
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
    @ResponseBody
    public DepartmentDTO getDepartment(@PathVariable Long departmentId) {
        return departmentService.findById(departmentId);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.update(departmentDTO);
    }

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteDepartment(@PathVariable Long departmentId) {
        return departmentService.delete(departmentId);
    }

    @RequestMapping(value = "/{departmentId}/company", method = RequestMethod.GET)
    @ResponseBody
    public DepartmentDTO getDepartmentWithCompany(@PathVariable Long departmentId) {
        return departmentService.findByIdWithCompany(departmentId);
    }

    @RequestMapping(value = "/{departmentId}/teams", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> addTeam(@PathVariable Long departmentId, @RequestBody TeamDTO teamDTO) {
        return departmentService.addTeam(departmentId, teamDTO);
    }
}
