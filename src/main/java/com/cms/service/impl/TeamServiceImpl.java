package com.cms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.beans.DepartmentDTO;
import com.cms.beans.UserDTO;
import com.cms.beans.TeamDTO;
import com.cms.dao.TeamRepository;
import com.cms.model.Department;
import com.cms.model.User;
import com.cms.model.Team;
import com.cms.service.TeamService;
import com.cms.utils.CmsUtility;

/**
 * Created by raviagrawal on 23/03/17.
 */
@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team findByName(String name) {
        return teamRepository.findByName(name);
    }

    @Override
    public TeamDTO findById(Long teamId) {
        Team team = teamRepository.findOne(teamId);
        TeamDTO teamDTO = TeamDTO.getDtoFromTeam(team);
        return teamDTO;
    }

    @Override
    public Map<String, Object> update(TeamDTO teamDTO) {
        Team team = teamRepository.findOne(teamDTO.getId());
        TeamDTO.updateTeamFromDto(team, teamDTO);
        teamRepository.save(team);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public Map<String, Object> delete(Long teamId) {
        teamRepository.delete(teamId);
        return CmsUtility.getSuccessResultMap();
    }

    @Override
    public TeamDTO findByIdWithCompany(Long teamId) {
        Team team = teamRepository.findOne(teamId);
        TeamDTO teamDTO = TeamDTO.getDtoFromTeam(team);

        Department department = team.getDepartment();
        DepartmentDTO departmentDTO = DepartmentDTO.getDtoFromDepartment(department);

        teamDTO.setDepartmentDTO(departmentDTO);
        return teamDTO;
    }

    @Override
    public Map<String, Object> addEmployee(Long teamId, UserDTO userDTO) {
        Team team = teamRepository.findOne(teamId);
        User user = UserDTO.getUserFromDto(userDTO);
        team.addEmployee(user);
        teamRepository.save(team);
        return CmsUtility.getSuccessResultMap();
    }
}
