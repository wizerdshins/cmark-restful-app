package com.wizerdshins.adminpanel.util;

import com.wizerdshins.adminpanel.domain.Role;
import lombok.Data;

import java.util.*;

@Data
public class RoleCheck {

    private final Map<Integer, String> rolesIdentification = new HashMap<>();

    public RoleCheck() {
        rolesIdentification.put(1, "admin");
        rolesIdentification.put(2, "programmer");
        rolesIdentification.put(3, "user");
    }

    public boolean isCorrectRoleName(Role role) {

        for (Map.Entry<Integer, String> roles : rolesIdentification.entrySet()) {
            if (role.getName().equalsIgnoreCase(roles.getValue())) return true;
        }
        return false;
    }

    public boolean isCorrectRoleId(Role role) {
        for (Map.Entry<Integer, String> roles : rolesIdentification.entrySet()) {
            if (role.getId().equals(roles.getKey())) return true;
        }
        return false;
    }

    public boolean isCorrectInput(Role role) {
        for (Map.Entry<Integer, String> roles : rolesIdentification.entrySet()) {
            if (role.getId().equals(roles.getKey())
                    && role.getName().equalsIgnoreCase(roles.getValue()))
                return true;
        }
        return false;
    }

}

