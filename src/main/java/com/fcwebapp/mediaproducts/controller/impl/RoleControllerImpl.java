package com.fcwebapp.mediaproducts.controller.impl;

import com.fcwebapp.mediaproducts.controller.interfaces.RoleControllerInterface;
import com.fcwebapp.mediaproducts.dto.RoleToUserDTO;
import com.fcwebapp.mediaproducts.model.Role;
import com.fcwebapp.mediaproducts.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * RESTful API for Role management
 */
@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public abstract class RoleControllerImpl implements RoleControllerInterface {
    private final UserServiceImpl userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveRole(@RequestBody Role role) {
        userService.saveRole(role);
    }

    @PostMapping("addtouser")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addRoleToUser(@RequestBody RoleToUserDTO roleToUserDTO) {
        userService.addRoleToUser(roleToUserDTO.getUsername(), roleToUserDTO.getRoleName());
    }

}