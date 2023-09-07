package com.fcwebapp.mediaproducts.controller.interfaces;

import com.fcwebapp.mediaproducts.dto.RoleToUserDTO;
import com.fcwebapp.mediaproducts.model.Role;

public interface RoleControllerInterface {
    void saveRole(Role role);

    void addRoleToUser(RoleToUserDTO roleToUserDTO);
}
