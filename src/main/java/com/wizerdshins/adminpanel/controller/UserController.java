package com.wizerdshins.adminpanel.controller;

import com.wizerdshins.adminpanel.domain.Role;
import com.wizerdshins.adminpanel.domain.User;
import com.wizerdshins.adminpanel.util.ResultValidation;
import com.wizerdshins.adminpanel.util.RoleCheck;
import com.wizerdshins.adminpanel.domain.dto.UserDto;
import com.wizerdshins.adminpanel.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/panel")
public class UserController {

    private UserService userService;

    private RoleCheck roleCheck;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        roleCheck = new RoleCheck();
    }

    @GetMapping("/list")
    public List<UserDto> getAll() {
        return userService.findAllUsers();
    }

    @GetMapping("{id}")
    public UserDto getById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResultValidation> create(@Valid @RequestBody User newUser,
                                                   BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ResultValidation(
                    false, bindingResult.getFieldErrors()),
                    HttpStatus.BAD_REQUEST);
        }

        if (!newUser.getRoles().isEmpty()) {
            for (Role item : newUser.getRoles()) {
                if (!roleCheck.isCorrectRoleId(item)) {
                    return new ResponseEntity<>(new ResultValidation(
                            false, "Role ID must be between in 1-3 numbers!"),
                            HttpStatus.BAD_REQUEST);
                } else if (item.getName() != null && !roleCheck.isCorrectInput(item)) {
                    return new ResponseEntity<>(new ResultValidation(
                            false, "Role ID " + item.getId() +
                            " doesn't match with role name!"),
                            HttpStatus.BAD_REQUEST);
                }
            }
        }

        userService.create(newUser);
        return new ResponseEntity<>(new ResultValidation(true),
                HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResultValidation> update(
            @PathVariable("id") User persistUser,
            @Valid @RequestBody User updatedUser,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new ResultValidation(
                    false, bindingResult.getFieldErrors()),
                    HttpStatus.BAD_REQUEST);
        }

        if (!updatedUser.getRoles().isEmpty()) {
            for (Role item : updatedUser.getRoles()) {
                if (!roleCheck.isCorrectRoleId(item)) {
                    return new ResponseEntity<>(new ResultValidation(
                            false, "Role ID must be between in 1-3 numbers!"),
                            HttpStatus.BAD_REQUEST);
                } else if (item.getName() == null || !roleCheck.isCorrectRoleName(item)) {
                    return new ResponseEntity<>(new ResultValidation(
                            false, "Please, enter a correct role's name!"),
                            HttpStatus.BAD_REQUEST);
                } else if (!roleCheck.isCorrectInput(item)) {
                    return new ResponseEntity<>(new ResultValidation(
                            false, "Role ID " + item.getId() +
                            " doesn't match with role name!"),
                            HttpStatus.BAD_REQUEST);
                }
            }
        }

        userService.update(persistUser, updatedUser);
        return new ResponseEntity<>(new ResultValidation(true),
                HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") User deletedUser) {
        userService.delete(deletedUser);
    }

}
