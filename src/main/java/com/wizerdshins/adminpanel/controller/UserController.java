package com.wizerdshins.adminpanel.controller;

import com.wizerdshins.adminpanel.domain.User;
import com.wizerdshins.adminpanel.domain.dto.UserDto;
import com.wizerdshins.adminpanel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
//    @PostMapping("/add")
//    public User create(@RequestBody User newUser) {
//        return userService.create(newUser);
//    }

    @PostMapping("/add")
    public Map<Boolean, List<FieldError>> create(@Valid @RequestBody User newUser,
                                 BindingResult bindingResult) {

        Map<Boolean, List<FieldError>> validationResult = new LinkedHashMap<>();
        boolean status = false;
        if (bindingResult.hasErrors()) {
            validationResult.put(status, bindingResult.getFieldErrors());
            return validationResult;
        }
        status = true;
        validationResult.put(status, null);
        userService.create(newUser);
        return validationResult;
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
