package com.fokin.pp_3_1_3.service;

import com.fokin.pp_3_1_3.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public Set<Role> findRoles(List<Long> roles);

    public List<Role> getAllRoles();
}