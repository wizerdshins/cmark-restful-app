package com.wizerdshins.adminpanel.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wizerdshins.adminpanel.domain.Role;
import com.wizerdshins.adminpanel.domain.User;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private Long id;
    private String name;
    private String login;
    private String password;

    private Set<Role> roles;

    public UserDto(Long id, String name,
                   String login, String password) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

        public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.login = user.getLogin();
        this.password = user.getPassword();
        this.roles = user.getRoles();
    }

}
