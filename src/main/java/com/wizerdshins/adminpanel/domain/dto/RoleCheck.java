package com.wizerdshins.adminpanel.domain.dto;

import lombok.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Data
public class RoleCheck {

    private Set<Long> rolesIdentification;

    public RoleCheck() {
        rolesIdentification = new HashSet<>(Arrays.asList(1L, 2L, 3L));
    }



}

