package com.wizerdshins.adminpanel.service;

import com.wizerdshins.adminpanel.domain.User;
import com.wizerdshins.adminpanel.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    /*
    add ignore properties
     */
    public User update(User persistUser, User updatedUser) {
        BeanUtils.copyProperties(updatedUser, persistUser, "id");
        return userRepository.save(persistUser);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
