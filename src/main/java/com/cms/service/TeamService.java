package com.cms.service;

import java.util.Map;

import com.cms.beans.UserDTO;
import com.cms.beans.TeamDTO;
import com.cms.model.Team;

/**
 * Created by raviagrawal on 17/03/17.
 */
public interface TeamService {

    Team findByName(String name);

    TeamDTO findById(Long teamId);

    Map<String, Object> update(TeamDTO teamDTO);

    Map<String, Object> delete(Long teamId);

    TeamDTO findByIdWithCompany(Long teamId);

    Map<String, Object> addEmployee(Long teamId, UserDTO userDTO);
}
