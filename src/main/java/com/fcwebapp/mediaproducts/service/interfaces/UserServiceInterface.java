package com.fcwebapp.mediaproducts.service.interfaces;

import com.fcwebapp.mediaproducts.model.Role;
import com.fcwebapp.mediaproducts.model.User;

import java.util.List;

public interface UserServiceInterface {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}