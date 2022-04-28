package com.fokin.pp_3_1_3.dao;

import com.fokin.pp_3_1_3.model.Role;
import com.fokin.pp_3_1_3.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    void add(User user);

    void delete(long id);

    User change(User user, Set<Role> roles);

    List<User> listUsers();

    User findUserById(long id);

    public User findUserByEmail(String email);
}
