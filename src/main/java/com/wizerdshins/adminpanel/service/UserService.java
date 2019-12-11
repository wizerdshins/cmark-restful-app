package com.wizerdshins.adminpanel.service;

import com.wizerdshins.adminpanel.domain.Role;
import com.wizerdshins.adminpanel.domain.User;
import com.wizerdshins.adminpanel.domain.dto.UserDto;
import com.wizerdshins.adminpanel.repository.RoleRepository;
import com.wizerdshins.adminpanel.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public UserDto findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User persistUser, User updatedUser) {
        BeanUtils.copyProperties(updatedUser, persistUser, "id");
        return userRepository.save(persistUser);
    }

    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }
}
