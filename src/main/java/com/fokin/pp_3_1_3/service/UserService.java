package com.fokin.pp_3_1_3.service;

import com.fokin.pp_3_1_3.model.Role;
import com.fokin.pp_3_1_3.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    void add(User user, Set<Role> roles);

    void delete(long id);

    void change(User user, Set<Role> roles);

    List<User> listUsers();

    User findUserById(long id);

    public User findUserByEmail(String email);
}