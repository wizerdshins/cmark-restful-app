package com.wizerdshins.adminpanel.controller;

import com.wizerdshins.adminpanel.domain.User;
import com.wizerdshins.adminpanel.domain.dto.UserDto;
import com.wizerdshins.adminpanel.repository.UserRepository;
import com.wizerdshins.adminpanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/panel")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<UserDto> getAll() {
        return userService.findAllUsers();
    }

    @GetMapping("{id}")
    public UserDto getById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    /*
    add validation
     */
    @PostMapping("/add")
    public User create(@RequestBody User newUser) {
        return userService.create(newUser);
    }

    /*
    add validation
     */

    @PutMapping("update/{id}")
    public User update(@PathVariable("id") User persistUser,
                       @RequestBody User updatedUser) {
        return userService.update(persistUser, updatedUser);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") User deletedUser) {
        userService.delete(deletedUser);
    }

}
