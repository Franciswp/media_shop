package com.fcwebapp.mediaproducts.service.impl;

import com.fcwebapp.mediaproducts.model.Role;
import com.fcwebapp.mediaproducts.model.User;
import com.fcwebapp.mediaproducts.repository.RoleRepository;
import com.fcwebapp.mediaproducts.repository.UserRepository;
import com.fcwebapp.mediaproducts.service.interfaces.UserServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserServiceInterface {
    @Autowired private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to the database", user.getName());
        // Encode the user's password for security before saving
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to user {}", roleName, username);

        // Retrieve the user and role objects from the repository
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);

        // Add the role to the user's role collection
        user.getRoles().add(role);

        // Save the user to persist the changes
        userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    public User findById(long userId){
        return userRepository.findById(userId).orElseThrow(
                ()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Customer with id " + userId + " not found.")
        );
    }

    @Transactional
    public ResponseEntity<User> updateCustomer(Long id, User userDetails)
            throws EntityNotFoundException {
        User user =
                userRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new EntityNotFoundException(
                                        "Customer not found on :: " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPermanentAddress(userDetails.getPermanentAddress());
        user.setUpdatedAt(userDetails.modifyDate());
        final User updatedCustomer = userRepository.save(user);
        return ResponseEntity.ok(updatedCustomer);
    }

    public void updateCustomerPWD(Long id, String password) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Password not found")
        );
        //user.getId();
        user.setPassword(password);
        user.setUpdatedAt(user.modifyDate());
        userRepository.save(user);
    }

    public Map<String, Boolean> deleteCustomerById(Long id) throws Exception {
        User customer =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Customer not found on :: " + id));

        userRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Customer deleted !", Boolean.TRUE);
        return response;
    }

    @Transactional
    public ResponseEntity<User> addProductToCustomer(Long id, User customerDetails)
            throws EntityNotFoundException {
        User user =
                userRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new EntityNotFoundException(
                                        "CustomerToProduct not found on :: " + id));

        user.setProducts(customerDetails.getProducts());
        user.setUpdatedAt(customerDetails.modifyDate());
        final User updatedProduct = userRepository.save(user);
        return ResponseEntity.ok(updatedProduct);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

}