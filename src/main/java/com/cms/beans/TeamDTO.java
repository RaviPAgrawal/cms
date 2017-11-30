package com.cms.beans;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import com.cms.model.Team;

/**
 * Created by raviagrawal on 06/04/17.
 */
@Getter @Setter
public class TeamDTO {
    private Long id;
    private String name;
    private Set<UserDTO> users;
    private DepartmentDTO departmentDTO;

    public static Team getTeamFromDto(TeamDTO teamDTO) {
        Team team = new Team();
        team.setName(teamDTO.getName());
        return team;
    }

    public static TeamDTO getDtoFromTeam(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        return teamDTO;
    }

    public static void updateTeamFromDto(Team team, TeamDTO teamDTO) {
        team.setName(teamDTO.getName());
    }
}
