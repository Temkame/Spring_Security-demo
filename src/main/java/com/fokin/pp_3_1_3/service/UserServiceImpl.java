package com.fokin.pp_3_1_3.service;

import com.fokin.pp_3_1_3.config.PasswordConfig;
import com.fokin.pp_3_1_3.dao.UserDao;
import com.fokin.pp_3_1_3.model.Role;
import com.fokin.pp_3_1_3.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDao userDao;
    private final PasswordConfig passwordConfig;

    @Autowired
    public UserServiceImpl(UserDao userDao, PasswordConfig passwordConfig) {
        this.userDao = userDao;
        this.passwordConfig = passwordConfig;
    }

    @Transactional
    @Override
    public void add(User user, Set<Role> roles) {
        user.setRoles(roles);
        userDao.add(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void change(User user, Set<Role> roles) {
        user.setPassword(passwordConfig.passwordEncoder().encode(user.getPassword()));
        user.setRoles(roles);
        userDao.change(user, roles);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.findUserByEmail(email);
    }
}