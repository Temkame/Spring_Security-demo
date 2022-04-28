package com.fokin.pp_3_1_3.dao;

import com.fokin.pp_3_1_3.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    public Set<Role> findRoles(List<Long> roles);

    public List<Role> getAllRoles();
}