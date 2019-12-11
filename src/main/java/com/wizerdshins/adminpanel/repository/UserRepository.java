package com.wizerdshins.adminpanel.repository;

import com.wizerdshins.adminpanel.domain.User;
import com.wizerdshins.adminpanel.domain.dto.UserDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
//
    @Query("select new com.wizerdshins.adminpanel.domain.dto.UserDto(" +
            "u.id, u.name, u.login, u.password) " +
            "from User u")
    List<UserDto> findAllUsers();

//    @Query("select new com.wizerdshins.adminpanel.domain.dto.UserDto(" +
//            "u.id, u.name, u.login, u.password, u.roles) " +
//            "from User u where u.id = :id")
//    UserDto findUserById(@Param("id") Long id);

    @Query("select new com.wizerdshins.adminpanel.domain.dto.UserDto(u) " +
            "from User u where u.id = :id")
    UserDto findUserById(@Param("id") Long id);
}
