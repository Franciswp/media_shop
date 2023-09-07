package com.fcwebapp.mediaproducts.dto;

import lombok.Data;

@Data
public class RoleToUserDTO {
    /**
     * The username of the user
     */
    private String username;
    /**
     * The name of the role
     */
    private String roleName;
}
