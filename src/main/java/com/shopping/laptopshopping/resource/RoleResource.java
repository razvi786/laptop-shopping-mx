package com.shopping.laptopshopping.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.laptopshopping.entity.Role;
import com.shopping.laptopshopping.service.RoleService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class RoleResource {

  @Autowired RoleService roleService;

  @GetMapping("role")
  public List<Role> getRoles() {
    return roleService.getAllRoles();
  }

  @GetMapping("role/{id}")
  public Role getRoleById(@PathVariable("id") Integer id) {
    return roleService.getRoleById(id);
  }

  @PostMapping("role")
  public Role saveRole(@RequestBody Role role) {
    return roleService.saveOrUpdateRole(role);
  }

  @PutMapping("role")
  public Role updateRole(@RequestBody Role role) {
    return roleService.saveOrUpdateRole(role);
  }

  @DeleteMapping("role/{id}")
  public void deleteRole(@PathVariable("id") Integer id) {
    roleService.deleteRoleById(id);
  }
}
