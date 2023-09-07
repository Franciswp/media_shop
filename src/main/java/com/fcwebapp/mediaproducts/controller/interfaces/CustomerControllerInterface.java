package com.fcwebapp.mediaproducts.controller.interfaces;


import com.fcwebapp.mediaproducts.model.User;

import java.util.List;

/**
 * Interface for UserController. Contains methods for handling user related operations
 */
public interface CustomerControllerInterface {
    List<User> getUsers();

    User createNewCustomer(User user);
}
