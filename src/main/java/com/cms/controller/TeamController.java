package com.cms.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.beans.UserDTO;
import com.cms.beans.TeamDTO;
import com.cms.service.TeamService;

/**
 * Created by raviagrawal on 15/03/17.
 */
@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/{teamId}", method = RequestMethod.GET)
    @ResponseBody
    public TeamDTO getTeam(@PathVariable Long teamId) {
        return teamService.findById(teamId);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> updateTeam(@RequestBody TeamDTO teamDTO) {
        return teamService.update(teamDTO);
    }

    @RequestMapping(value = "/{teamId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteTeam(@PathVariable Long teamId) {
        return teamService.delete(teamId);
    }

    @RequestMapping(value = "/{teamId}/department", method = RequestMethod.GET)
    @ResponseBody
    public TeamDTO getTeamWithDepartment(@PathVariable Long teamId) {
        return teamService.findByIdWithCompany(teamId);
    }

    @RequestMapping(value = "/{teamId}/employees", method = RequestMethod.PUT)
    @ResponseBody
    public Map<String, Object> addEmployee(@PathVariable Long teamId, @RequestBody UserDTO userDTO) {
        return teamService.addEmployee(teamId, userDTO);
    }
}
