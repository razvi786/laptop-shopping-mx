package com.shopping.laptopshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.Role;
import com.shopping.laptopshopping.repository.RoleRepository;

@Service
public class RoleService {

  @Autowired RoleRepository roleRepo;

  public List<Role> getAllRoles() {
    List<Role> roles = new ArrayList<>();
    try {
      roles = roleRepo.findAll();
    } catch (Exception exception) {
      System.out.println("Exception while finding all Roles: " + exception);
    }
    return roles;
  }

  public Role getRoleById(Integer id) {
    Role role = null;
    try {
      Optional<Role> roleOptional = roleRepo.findById(id);
      if (roleOptional.isPresent()) {
        role = roleOptional.get();
      } else {
        System.out.println("Role not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception while finding Role: " + exception);
    }
    return role;
  }

  public Role saveOrUpdateRole(Role role) {
    Role savedRole = null;
    try {
      savedRole = roleRepo.save(role);
    } catch (Exception exception) {
      System.out.println("Exception while saving/updating Role: " + exception);
    }
    return savedRole;
  }

  public boolean deleteRoleById(Integer id) {
    try {
      roleRepo.deleteById(id);
      return true;
    } catch (Exception exception) {
      System.out.println("Exception while deleting Role: " + exception);
      return false;
    }
  }
}
