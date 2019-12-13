package com.wizerdshins.adminpanel.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    private Long id;
    @Column
    private String name;


    @JoinTable(
            name = "user_roles",
            joinColumns = {@JoinColumn(name = "roles_id", nullable = false, updatable = false, insertable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)}
    )

    @Override
    public String toString() {
        return "Id: " + id +
                ", name: " + name;
    }

}
