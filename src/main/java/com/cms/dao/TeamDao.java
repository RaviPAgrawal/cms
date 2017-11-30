package com.cms.dao;

import com.cms.model.Team;

/**
 * Created by raviagrawal on 23/03/17.
 */
public interface TeamDao {

    Team findByName(String name);
}
