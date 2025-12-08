package com.hardware.warehouse.controller;


import com.hardware.warehouse.model.User;
import com.hardware.warehouse.service.PermissionService;
import com.hardware.warehouse.service.RoleService;
import com.hardware.warehouse.service.UserRoleService;
import com.hardware.warehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserRoleService userRoleService;



    @GetMapping("/users")
    public String listOfAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "/user/index";
    }

    @GetMapping("user/create")
    public String createUser(Model model) {
        model.addAttribute("roles",roleService.findAllRoles());
        return "/user/create";
    }

    @PostMapping("/user/store")
    public String storage(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String showUser(@PathVariable("id") Long id, Model model) {

        Optional<User> userOptional = userService.findUserById(id);
        // Si el Optional tiene un valor (isPresent), lo obtiene.
        // Si no (isEmpty), lanza una excepción ResponseStatusException con código 404.
        User user = userOptional.orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado con ID: " + id)
        );

        model.addAttribute("user", user);
        model.addAttribute("roles",roleService.findAllRoles());
        model.addAttribute("permissions",permissionService.findAllPermissions());
        return "/user/show";
    }


    @PostMapping("/user/change-status/{id}")
    public String changeStatus(@PathVariable("id") Long id,@RequestParam("is_active") String status ){

        userService.changeStatus(id,status);
        return "redirect:/user/"+ id;
    }

    @PostMapping("/user/role/{id}")
    public String updateRole(@PathVariable("id") Long id, @RequestParam("role_id[]") Long [] roleIds){
        userRoleService.saveUserRole(id,roleIds);
        return "redirect:/user/"+id;
    }

}
